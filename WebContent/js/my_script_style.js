function toggle(id) { //web display control function
    id = "#" + id;
    $("#home").hide();
    $("#list").hide();
    $("#plan").hide();

    $(id).show();
}
toggle('{$id}');


function check() {
    with(document.all) {
        if (input1.value != input2.value) {
            alert("两次输入密码不同")
            input1.value = "";
            input2.value = "";
        } else document.forms[0].submit();
    }
}
