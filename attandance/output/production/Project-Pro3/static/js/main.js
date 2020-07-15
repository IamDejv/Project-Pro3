function getCookie(name) {
    let value = "; " + document.cookie;
    let parts = value.split("; " + name + "=");
    if(parts.length === 2) return parts.pop().split(";").shift();
}

function prepareDate(date) {
    let dateParts = date.split(".");
    return dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
}

function prepareUsername (username) {
    username = username.replace("ě", "e");
    username = username.replace("š", "s");
    username = username.replace("č", "c");
    username = username.replace("ř", "r");
    username = username.replace("ž", "z");
    username = username.replace("ý", "y");
    username = username.replace("á", "a");
    username = username.replace("í", "i");
    username = username.replace("é", "e");
    username = username.replace("ú", "u");
    username = username.replace("ů", "u");
    return username;
}

function renderJsGrid(items, fields, grid) {
    grid.jsGrid({
        width: "100%",
        height: "100%",

        searching: true,
        sorting: true,

        data: items,

        fields: fields
    });
}
