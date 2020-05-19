$(document).ready(function () {
    commentLength();
})

//获取评论
function getComment(keyId,type) {
    //热门评论
    $.ajax({
        type:"GET",
        url: "/getComment",
        data:{"keyId":keyId ,"type":type ,"types":"likes"},
        success:function (data) {
            for (let i=0;i<data.length;i++){
                let user=data[i].user;
                generalComment(user.userid,user.name,user.cover,data[i].commentid,data[i].text,data[i].createtime,data[i].likes,"#hotCommentList","after");
            }
        },
        error:function (data) {
            alert("连接错误");
            console(data);
        }
    });
    //最新评论
    $.ajax({
        type:"GET",
        url: "/getComment",
        data:{"keyId":keyId ,"type":type ,"types":"createtime"},
        success:function (data) {
            for (let i=0;i<data.length;i++){
                let user=data[i].user;
                generalComment(user.userid,user.name,user.cover,data[i].commentid,data[i].text,data[i].createtime,data[i].likes,"#newCommentList","after");
            }
        },
        error:function (data) {
            alert("连接错误");
            console(data);
        }
    });
}
//生成评论html
function generalComment(userid,name,cover,commentid,text,createtime,likes,box,location) {
    let html= "<div class=\"commentItem\" id='comment"+commentid+"'>\n" +
        "                <div class=\"itemLeft\">\n" +
        "                    <img src=\""+cover+"\" alt=\"\">\n" +
        "                </div>\n" +
        "                <div class=\"itemRight\">\n" +
        "                    <div class=\"itemRightTop\">\n" +
        "                        <span class=\"commentText\">\n" +
        "                            <a href=\"#\">"+name+" :</a> \n" +
                                      text+
        "                        </span>\n" +
        "                    </div>\n" +
        "                    <div class=\"itemRightBottom\">\n" +
        "                        <span class=\"commentTime\">"+createtime+"</span>\n" +
        "                        <div class=\"commentGrate\">\n" +
        "                            <div class=\"grate\" id='commentBtn"+commentid+"'>点赞</div>\n" +
        "                            <span id='commentLikes"+commentid+"'>"+likes+"赞</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>";
    if(location==="after")
        $(box).append(html);
    else if(location==="pre")
        $(box).prepend(html);
}
//点赞
$(".commentList").on("click",".grate",function () {
    let id=this.id;
    id=id.substring(10);
    let likesId="#commentLikes"+id;
    let likesText= $(likesId).text();
    likesText=likesText.substring(0,likesText.length-1);
    $.ajax({
        type:"PUT",
        url: "/addLikes",
        data: {"commentId":id},
        success:function (data) {
            if(data===1){
                $(likesId).text((parseInt(likesText)+1)+"赞");
            }else if(data!==0){
                let conf=confirm("你还没登录，请先登录！");
                if(conf===true){
                    top.location.href="/index/login";
                }
            }
        },error:function (xhl) {
            alert("状态码："+xhr.status+"返回响应信息："+xhr.responseText);
        }
    });
})

//评论字数
function commentLength() {
    $('#myCommentText').on("input",function(){
        let text=$('#myCommentText').val();
        let length=text.length;
        $("#commentLength").text(length+"/100");
    });
}
//添加评论
$("#commentBtn").click(function () {
    let area=$('#myCommentText');
    let text=area.val();
    if(text.length>100){
        alert("字数超过限制");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/setComment",
        data: {"keyId":message.musicid,"type":"music","commentText":text},
        success:function (data) {
            if (data===null||data===""){
                let conf=confirm("你还没登录，请先登录！");
                if(conf===true){
                    top.location.href="/index/login";
                }
            }else{
                let user=data.user;
                generalComment(user.userid,user.name,user.cover,data.commentid,data.text,data.createtime,data.likes,"#newCommentList","pre");
                area.val("");
                alert("发表成功！");
            }
        },error:function (data) {
            console.log(data);
        }
    });
});

