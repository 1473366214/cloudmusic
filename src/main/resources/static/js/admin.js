$(document).ready(function () {
    $("#login").click(
        function adminLogin() {
            $.ajax({
                type:"POST",
                url:"getAdmin.do",
                data:$("#adminLogin").serialize(),
                error:function () {
                    alert("Connected error");
                },success:function (data) {
                    if(data.adminid!=null){
                        $("#loginMsg").text(data.adminid+" "+data.accounts);
                    }else{
                        $("#loginMsg").text("登录失败！");
                    }
                }
            });
        }
    );

    $("#regist").click(
        function adminLogin() {
            $.ajax({
                type:"POST",
                url:"setAdmin.do",
                data:$("#adminRegist").serialize(),
                error:function () {
                    alert("Connected error");
                },success:function (data) {
                    if(data==1){
                        $("#registMsg").text("注册成功！");
                    }else{
                        $("#registMsg").text("注册失败！");
                    }
                }
            });
        }
    );

    $("#update").click(
        function adminLogin() {
            $.ajax({
                type:"POST",
                url:"updateAdminPassword.do",
                data:$("#updatePassword").serialize(),
                error:function () {
                    alert("Connected error");
                },success:function (data) {
                    if(data==1){
                        $("#updateMsg").text("更改成功！");
                    }else{
                        $("#updateMsg").text("更改失败！");
                    }
                }
            });
        }
    );

});