//记录字数
let comment=$(".myComText");
comment[0].addEventListener("keyup",function () {
    $(".comLength").text(comment.val().length);
});
// 提交评论
function addComment(userId,keyid,type) {
    let myComment=comment.val();
    if(myComment.length===0)
        return;
    if(myComment.length>140)
        myComment=myComment.substring(0,140);
    $.ajax({
        type: "GET",
        url: "/setComment",
        data: {"userid":userId,"keyid":keyid,"type":type,"text":myComment},
        success: function (data) {
            addNewComment(data);
            comment.val("");
        },error:function (data) {
            console.log(data);
            return false;
        }
    })
}
//评论列表添加HTML
function addNewComment(commentNow) {
    let html='<div class="commentItem" >\n' +
        '                <div class="itemLeft">\n' +
        '                    <a href="#"><img src="'+userMsg.cover+'" alt=""></a>\n' +
        '                </div>\n' +
        '                <div class="itemRight">\n' +
        '                    <div class="itemRightTop">\n' +
        '                        <div class="commentText">\n' +
        '                            <a href="#">'+userMsg.name+': </a>\n' +
        '                            <span >'+commentNow.text+'</span>\n' +
        '                        </div>\n' +
        '                    </div>\n' +
        '                    <div class="itemRightBottom">\n' +
        '                        <span class="commentTime">'+commentNow.createtime+'</span>\n' +
        '                        <div class="commentGrate">\n' +
        '                            <div class="grate" id="commentLikeBtn'+commentNow.commentid+'">点赞</div>\n' +
        '                            <span id="commentLikeNum'+commentNow.commentid+'">0赞</span>\n' +
        '                        </div>\n' +
        '                    </div>\n' +
        '                </div>\n' +
        '            </div>';
    $("#newCommentList").prepend(html);
}

//上传点赞数
$(".commentList").on("click",".grate",function () {
    isLoginWin(userMsg.userid);
    let commentId=this.id;
    let id=commentId.substring(14);
    $.ajax({
        type:"PUT",
        url: "/addLikes",
        data: {"commentId":id},
        success:function (data) {
            addLikes(commentId,data);
        },error:function (date) {
            console.log(date);
        }
    });
});
//改变点赞数
function addLikes(commentId,data) {
    let likesTex=$("#"+commentId+"Num");
    let text=likesTex.text();
    let likes=parseInt(text.substring(0,text.length));
    likesTex.text((likes+data)+"赞");
}
