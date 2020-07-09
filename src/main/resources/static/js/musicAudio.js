let audio= $("#audio")[0];
let duration=0;
let volume=0;
let onChange=false;
let barLength=0;
let voiceBarLength=150;
let timeBarLength=700;
let voiceToZero=false;
$(document).ready(function () {
    audio.volume=0.5;
    volume=audio.volume;
    let soudLength=voiceBarLength*volume;
    setSoudBar(soudLength);
});
// 进度条
let time=$(".time");
time.click(function(e){
    let length=e.clientX-time.offset().left;
    setMusicBar(length);
    audio.currentTime=parseInt(duration*(length/timeBarLength));
});
function setMusicBar(length){
    if(length<0)
        length=0;
    $(".doc").css("left",length-6);
    $(".length").css("width",length);
}
// 音乐进度监听
audio.addEventListener("timeupdate",audioTimeChange);
function audioTimeChange(){
    let currentTime=Math.ceil(audio.currentTime);
    let currentLength=timeBarLength*currentTime/duration;
    if(!onChange)
        setMusicBar(currentLength);
    let time="";
    let min=parseInt(currentTime/60);
    if(min>10)
        time=time+":"
    else if(min==0)
        time="00:"
    else
        time="0"+min+":"
    let s=parseInt(currentTime%60);
    if(s<10)
        time=time+"0"+s;
    else if(s==0)
        time=time+"00";
    else
        time=time+s;
    $(".nowTime").text(time);
}
audio.addEventListener("ended",function () {
    audio.currentTime=0;
    clickPlay();
});
audio.addEventListener("canplay",function(){
    duration=audio.duration;
});
//音量条
let soud=$(".soud");
soud.click(function(e){
    let length=e.clientX-soud.offset().left;
    setSoudBar(length);
    volume=length/voiceBarLength;
    audio.volume=fixVolume(volume);
});
function setSoudBar(length){
    if(length<0)
        length=0;
    $(".doc1").css("left",length-6);
    $(".soudLength").css("width", length);
}
audio.addEventListener("volumechange",function () {
    volume=audio.volume;
    let currentLength=voiceBarLength*volume;
    setSoudBar(currentLength);
    if(voiceToZero){
        if(volume!=0){
            voiceClick();
            voiceToZero=false;
        }
    }else if(volume==0){
        voiceClick();
        voiceToZero=true;
    }
});
function fixVolume(num){
    if(num<0)
        return 0;
    else if(num>1)
        return 1;
    else
        return num;
}
// 拖动
drag("#doc1",voiceBarLength);
drag("#doc",timeBarLength);
function drag(dev,length){
    let isDrag=false;
    let x=0;
    let doc=$(dev);
    doc.mousedown(function (e) {
        if(!isDrag){
            isDrag=true;
            onChange=true;
        }
    });
    $(window).mousemove(function (e) {
        if(isDrag){
            if(dev==="#doc"){
                x=e.clientX-time.offset().left;
                if(x<0)
                    x=0;
                if(x>length)
                    x=length;
                barLength=parseInt(x);
                setMusicBar(barLength);
            }
            if(dev==="#doc1"){
                x=e.clientX-soud.offset().left;
                if(x<0)
                    x=0;
                if(x>length)
                    x=length;
                barLength=parseInt(x);
                setSoudBar(barLength);
            }
        }
    });
    $(document).mouseup(function () {
        if(isDrag){
            if(barLength<0){
                barLength=0;
            }
            isDrag=false;
            onChange=false;
            if(dev==="#doc"){
                audio.currentTime=parseInt(duration*(barLength/timeBarLength));
            }else if(dev==="#doc1"){
                volume=barLength/voiceBarLength;
                audio.volume=fixVolume(volume);
            }
        }
    });
}
// 点击音量
let voiceBtn=$(".voice");
voiceBtn.click(function(){
    if(voiceToZero){
        audio.volume=0.5;
        voiceToZero=false;
    }else{
        audio.volume=0;
        voiceToZero=true;
    }
    voiceClick();
});

function voiceClick() {
    if(voiceBtn.hasClass("fa-volume-up")){
        voiceBtn.removeClass("fa-volume-up");
        voiceBtn.addClass("fa-volume-off");
    }else if(voiceBtn.hasClass("fa-volume-off")){
        voiceBtn.removeClass("fa-volume-off");
        voiceBtn.addClass("fa-volume-up");
    }
}
//   点击播放
let playBtn=$(".audioPlay");
playBtn.click(clickPlay);
function clickPlay() {
    if(playBtn.hasClass("fa-play")){
        if(duration==0){
            alert("歌曲还没加载完毕！");
            return;
        }
        playBtn.removeClass("fa-play");
        playBtn.addClass("fa-pause");
        audio.play();
        // 更新歌曲时长
        let time="";
        let min=parseInt(duration/60);
        if(min<10)
            time="0"+min;
        else if(min==0)
            time="00:";
        else
            time=""+min;
        time=time+":"
        let s=Math.ceil(duration%60);
        if(s>=10)
            time=time+s;
        else if(s==0)
            time=time+"00";
        else
            time=time+"0"+s;
        $(".allTime").text("/"+time);
    }else if(playBtn.hasClass("fa-pause")){
        playBtn.removeClass("fa-pause");
        playBtn.addClass("fa-play");
        audio.pause();
    }
}

// 评论框获得焦点
$("#focusComment").click(function() {
    $("#myCommentText")[0].focus();
});

// 添加评论
$("#commentBtn").click(function () {
    if(isLoginWin(userMsg.userid)){
        addComment(userMsg.userid,music.musicid,"music");

    }
});

// 登录框
if(userMsg.userid!==null){
    $("#isLoginBox").show();
}else{
    $("#noLoginBox").show();
}
