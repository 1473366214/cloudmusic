let frame=$("#my-iframe");
//导航栏点击事件
function indexGdClick(){
    window.location.href="/index/index";
}
function musicGdClick(){
    window.location.href="/index/music";
}
function singerGdClick(){
    window.location.href="/index/singer";
}
function issueGdClick(){
    window.location.href="/index/album";
}
function homeGdClick(){
    window.location.href="/index/home";
}
function gdClick(div){
    $(".guide").removeClass("gdSelect");
    $(div).addClass("gdSelect");
}
function loginBtn(){
    window.location.href="/index/login";
}
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
