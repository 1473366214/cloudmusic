let frame=$("#my-iframe");
//导航栏点击事件
function guideClick(id) {
    frame.attr("src",'/'+id);
}
function parentGuide(id) {
    window.location.href=id;
}
function gdClick(div){
    $(".guide").removeClass("gdSelect");
    $(div).addClass("gdSelect");
}
//登录注册按钮
function loginBtn(){
    window.location.href="/index/login";
}
//获取信息
function getUserMsg(auto) {
    $.ajax({
        type:"GET",
        url: "/user/getUserMsg.do",
        error:function (xhr) {
            if(!auto){
                let c=confirm("请先登录");
                if (c===true)
                    frame.attr("src","login");
                else
                    console.log("状态码："+xhr.status+"返回响应信息："+xhr.responseText);
            }
        },success:function (data) {
            if(data.accounts!==null&&data!=="did not login"){
                $("#isLoginBox").show();
                $("#userName").text(data.name);
            }else {
                $("#noLoginBox").show();
            }
        }
    });
}
//退出按钮
function logout() {
    let conf=confirm("确定退出吗？");
    if(conf===false)
        return;
    $.ajax({
        type: "PUT",
        url: "/user/userLogout.do",
        success:function () {
            alert("退出登录！");
            window.location.href="/index";
        },
        error:function () {
            alert("退出失败！");
        }
    });
}
function fillBox(box,cls,data) {
    for(let i=0;i<data.length;i++){
        let name=data[i].name;
        let cover=data[i].cover;
        let musicid=data[i].musicid;
        $(box).append(
            "<div class="+cls+" id='"+musicid+"'>" +
                "<img src=\""+cover+"\">" +
                "<div>"+name+"</div>" +
            "</div>");
    }
}
//搜索框
$("#head2-btn").click(function () {
    let input= $("#head2-contain-right-text");
    let text=input.val();
    if(text==="")
        text=input.attr("placeholder");
    window.location.href="/music/searchMusic?key="+text;
});

//为登录就显示弹窗
function isLoginWin(args) {
    if(args===null){
        let is=window.confirm("您还没有登录，是否登录?");
        if(is){
            window.location.href="/index/login";
        }
        return false;
    }else {
        return true;
    }
}