package pro3.attandance.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class PermissionUtils {

    public static String[] attendeeActions = {"application", "excuse", "simpleAction", "simpleTraining", "pay"};
    public static String[] externActions = {"simpleAttendance", "action", "addAction", "simpleUsers", "training", "actionList", "users"};
    public static String[] trainerActions = {"attendance", "action", "addAction", "action", "users", "attendees", "training", "actionList"};
    public static String[] managerActions = {"attendance", "action", "addAction", "action", "users", "attendees", "addTraining", "training", "actionList"};
    public static String[] adminActions = {"all"};

    public static String id;

    public static boolean isAllowed(HttpServletRequest request, String action, String who) {
        if(!isPerson(request, who)) return false;
        String role = getRole(request);
        if (role == null) return false;
        int roleId = Integer.parseInt(role);
        switch (roleId) {
            case 0 :
                return inArray(action, attendeeActions);
            case 1 :
                return inArray(action, externActions);
            case 2 :
                return inArray(action, trainerActions);
            case 3 :
                return inArray(action, managerActions);
            case 4 :
                return true;
            default:
                return false;
        }
    }

    public static boolean isPerson(HttpServletRequest request, String who) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(who)) {
                    PermissionUtils.id = cookie.getValue();
                    return true;
                }
            }
        }
        return false;
    }

    public static String getRole(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("role")) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static boolean inArray(String action, String[] permissions) {
        for (String permission : permissions) {
            if (permission.equals(action)) return true;
        }
        return false;
    }


}
