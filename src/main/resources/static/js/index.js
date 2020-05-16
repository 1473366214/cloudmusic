let uMsg=new Object(null);
$(document).ready(function () {
    uMsg=getUserMsg();
    if(uMsg!=null&&uMsg.accounts!=null){
        sessionStorage.setItem("userMsg",JSON.stringify(uMsg));
        $("#userCover").attr("src",uMsg.cover);
        $("#userMsg").text("帐号："+uMsg.accounts+"昵称："+uMsg.name);
    }
    else{
        $("#userCover").attr("src","/userCover/tly.jpeg");
        $("#userMsg").text("未登录");
    }
});
