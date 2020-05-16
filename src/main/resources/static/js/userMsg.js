let uMsg=new Object(null);
let newCover;
let musicCover;
let userSongList=new Object(null);
let songList=new Object(null);
$(document).ready(function () {
    uMsg=JSON.parse(sessionStorage.getItem("userMsg"));
    if(uMsg==null||uMsg.accounts==null){
        uMsg=getUserMsg();
    }
    if(uMsg!=null&&uMsg.accounts!=null){
        sessionStorage.setItem("userMsg",JSON.stringify(uMsg));
        $("#userCoverImg").attr("src",uMsg.cover);
        $("input[name='name']").attr("value",uMsg.name);
        $("input[name='introduction']").attr("value",uMsg.introduction);
        $("input[name='age']").attr("value",uMsg.age);
        $("input[name='sex']").attr("value",uMsg.sex);
        $("input[name='address']").attr("value",uMsg.address);
        getUserSongList();
        songListAction();
    }else
        return null;

});
//上传用户图片
function uploadUserCover() {
    newCover = uploadFile("userCover");
    if(!$.isEmptyObject(newCover)){
        $("input[name='cover']").attr("value",newCover);
        $("#userCoverImg").attr("src",newCover);
    }
}
//更新用户信息
function updateUserMessage() {
    $.ajax({
        type: "PUT",
        url: "user/updateUserMsg.do",
        data: $("#UserMsgForm").serialize(),
        error:function () {
            alert("Connect error");
        },success:function (data) {
            if (data!=null) {
                sessionStorage.setItem("userMsg", JSON.stringify(data));
                $("#formMsg1").text("保存成功");
            }
            else
                $("#formMsg1").text("保存失败");
        }
    });
}
//更新用户密码
function updateUserPassword() {
    $.ajax({
        type:"PUT",
        url:"user/updateUserPassword.do",
        data:$("#passwordForm").serialize(),
        success:function (data) {
            if(data===0){
                $("#passwordMsg").text("更改成功");
            }else {
                $("#passwordMsg").text("更改失败");
            }
        },error:function () {
            alert("Connect error");
        }
    });
}
//获取歌单信息
function getUserSongList() {
    if($.isEmptyObject(userSongList)) {
        $.ajax({
            type:"GET",
            url:"/songList/getUserSongList.do",
            error: function() {  //失败的话
                alert("Connection error");
            },
            success: function(data) {  //成功
                if(data[0].songlistid!=null){

                    userSongList=data;
                    $(".songList").remove();
                    for(let i=0;i<data.length;i++){
                        createSongList(data[i].songlistid,data[i].name,data[i].cover);
                    }
                }
            }
        });
    }else {
        $(".songList").remove();
        $(".deleteSongList").remove();
        for(let i=0;i<userSongList.length;i++){
            createSongList(userSongList[i].songlistid,userSongList[i].name,userSongList[i].cover);
        }
    }
}
//创建歌单列表
function createSongList(songlistid,name,cover) {
    $("#userSongList").append("<div class ='songList' id='"+songlistid+"'><img src='"+cover+
        "' class='songListCover' width='15px'>"+name+
        "</div>").append("<input type='button' value='删除' class='deleteSongList' id='del"+songlistid+"'>");
}
//创建歌单
function addSongList() {
    $.ajax({
        type:"POST",
        url:"/songList/setUserSongList.do",
        data:$("#addSongListForm").serialize(),
        error:function () {
            alert("Connect error");
        },success:function (data) {
            if(data.songlistid!==null){
                userSongList[userSongList.length]=data;
                getUserSongList();
            }
        }
    });
}
//添加歌单点击事件
function songListAction() {
    $(document).on("click",".songList",function () {
        $.ajax({
            type:"GET",
            url:"/music/getMusicFormSongList.do",
            data:{"songlistid":this.id},
            error:function () {
                alert("Connect error");
            },success:function (data) {
                if(data[0].musicid!==null){
                    songList=data;
                    $(".music").remove();
                    for(let i=0;i<data.length;i++)
                    $("#userMusicList").append("<div class='music' id='music"+data[i].musicid+"'><img width='15px' src='"+data[i].cover+"'>"+data[i].name+"</div>");
                }
            }
        });
    });
//删除按钮
    $(document).on("click",".deleteSongList",function () {
        let slID = parseInt(this.id.substring(3));
        $.ajax({
            type:"DELETE",
            url:"/songList/deleteUserSongList.do",
            data:{"songListId":slID},
            error:function () {
                alert("Connect error");
            },success:function (data) {
                if(data===1){
                    for(let i=0;i<userSongList.length;i++){
                        if(userSongList[i].songlistid===slID){
                            userSongList.splice(i,1);
                            break;
                        }
                    }
                    getUserSongList();
                }
            }
        });
    });
}
//播放歌曲
$(document).on("click",".music",function () {
    let musicId = parseInt(this.id.substring(5));
    let n=0;
    for(let i=0;i<songList.length;i++){
        if(musicId===songList[i].musicid){
            n=i;
            break;
        }
    }
    let audio = $("#musicAudio");
    audio.attr("src",songList[n].path);
    if(audio[0].paused)
        audio[0].play();
})