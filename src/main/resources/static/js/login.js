$(document).ready(function () {
    $("#login_box_btn").addClass("btn_selected");
    showBox("#login_box");
    $(".guide").click(function () {
        window.location.href="/music"
    });
});
function login_box_btnClick(){
    $(".box").removeClass("btn_selected");
    $("#login_box_btn").addClass("btn_selected");
    showBox("#login_box");
}
function regist_box_btnClick(){
    $(".box").removeClass("btn_selected");
    $("#regist_box_btn").addClass("btn_selected");
    showBox("#regist_box");
}
function showBox(div){
    $(".login_ctns_box").hide();
    $(div).show();
}
function login(){
    let form={"accounts":$("#login_form_accounts").val(),"password":$("#login_form_password").val()};
    if(form.accounts===""||form.password===""){
        alert("填写完整的帐号密码！");
        return;
    }
    $.ajax({
        type:"POST",
        url:"/user/userLogin.do",
        data:form,
        success:function(data){
            if(data===1)
                top.location.href="/index";
            else {
                alert("登录错误！");
            }
        },
        error:function (data) {
            alert(data);
        }
    });
}
function regist() {
    let form={"accounts":$("#regist_form_accounts").val(),"password":$("#regist_form_password").val(),"password2":$("#regist_form_password2").val()};
    if(form.accounts===""||form.password===""||form.password2===""){
        alert("填写完整的帐号密码！");
        return;
    }else if(form.password!==form.password2){
        alert("密码不一致！");
        return;
    }
    $.ajax({
        type:"POST",
        url:"/user/userRegister.do",
        data:form,
        success:function(data){
            if (data===1) {
                alert("注册成功，请登录！");
                window.location.href="/login";
            }
            else if(data===0)
                alert("注册失败！");
            else
                alert("该账号已注册！");
        },
        error:function (data) {
            alert(data);
        }
    });
}