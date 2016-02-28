function toggle(id) { //web display control function
    id = "#" + id;
    $("#home").hide();
    $("#list").hide();
    $("#plan").hide();

    $(id).show();
}
toggle('{$id}');