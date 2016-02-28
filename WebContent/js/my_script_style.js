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

function time() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth();
    var date = now.getDate();
    document.getElementById("info1").innerHTML = "创建时间:" + year + "年" + (month + 1) + "月" + date + "日";
}

function msgbox(n) {
    document.getElementById('inputbox').style.display = n ? 'block' : 'none';
}
