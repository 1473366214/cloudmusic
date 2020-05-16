//退出
function userLogout() {
    $.ajax({
        type:"PUT",
        url:"user/userLogout.do",
        error:function () {
            alert("Connect error");
        },success:function (data) {
            if(data===1) {
                sessionStorage.setItem("userMsg",null);
                window.location.reload();
                //$("#userLogoutMsg").text("退出成功!");
            }
            else if(data=="user has not logined"){
                sessionStorage.setItem("userMsg",null);
                window.location.reload();
            }else {
                $("#userLogoutMsg").text("退出失败!");
            }
        }
    });
}
//获取用户信息
function getUserMsg() {
    let msg=new Object(null);
    $.ajax({
        type:"GET",
        url: "user/getUserMsg.do",
        async:false,
        error:function () {
            alert("Connect error");
        },success:function (data) {
            msg=data;
        }
    });
    return msg;
}
//上传文件
function uploadFile(type) {
    if(type!=="userCover"&&type!=="musicCover"&&type!=="music"){
        alert("函数参数错误");
        return new Object(null);
    }
    let coverFile = $("#userCovers");
    let cover=coverFile.val();
    if(cover===""){
        alert("请选择文件");
        return new Object(null);
    }
    let coverType=cover.substring(cover.lastIndexOf(".")+1).toLowerCase();
    if(coverType!=="jpg"&&coverType!=="png"&&coverType!=="jpeg"&&coverType!=="bmp"){
        alert("请选择jpg/png/jpeg/bmp文件");
        return new Object(null);
    }
    if(coverFile[0].files[0].size>52428800){
        alert("上传图片不能大于5M");
        return new Object(null);
    }
    let formData = new FormData();
    formData.append("file",coverFile[0].files[0]);
    formData.append("style",type);
    $.ajax({
        type:"POST",
        url:"/uploadFile.do",
        data:formData,
        processData:false,
        contentType:false,
        success:function (data) {
            if(data!=null){
                return data;
            }else {
                return new Object(null);
            }
        },error:function () {
            alert("Connect error");
            return new Object(null);
        }
    });
}