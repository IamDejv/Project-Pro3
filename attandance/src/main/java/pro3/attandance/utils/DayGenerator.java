package pro3.attandance.utils;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayGenerator {

    public static List<String> generateDates(String startDate, String endDate) {
        LocalDate firstDate = getDateFromString(startDate);
        LocalDate lastDate = getDateFromString(endDate);

        List<String> dates = new ArrayList<>();
        while(firstDate.isBefore(lastDate)) {
            dates.add(firstDate.toString());
            firstDate = firstDate.plusWeeks(1);
        }
        return dates;
    }

    public static LocalDate getDateFromString(String date){
        String[] dates = date.split("-");
        return LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
    }
}
