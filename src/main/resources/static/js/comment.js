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