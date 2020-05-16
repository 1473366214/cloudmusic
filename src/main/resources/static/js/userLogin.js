function userRegister() {
    $.ajax({
        type:"POST",
        url:"/user/userRegister.do",
        data:$("#userRegisterForm").serialize(),
        error:function () {
            alert("Connect error");
        },success:function (data) {
            if(data===1){
                $("#registerMsg").text("注册成功！");
            }else{
                $("#registerMsg").text("注册失败！");
            }
        }
    });
}

function userLogin() {
    $.ajax({
        type:"POST",
        url:"/user/userLogin.do",
        data:$("#userLoginForm").serialize(),
        error:function () {
            alert("Connect error");
        },success:function (data) {
            if(data===1){
                sessionStorage.setItem("userMsg",JSON.stringify(data));
                window.location.href="/index";
            }else{
                $("#loginMsg").text("登录失败！");
            }
        }
    });
}