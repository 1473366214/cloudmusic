let pageNum=1;
let pageSize=10;
let pages=1;
let alphabet=null;
$(document).ready(function () {
    getSingerPage(pageNum,pageSize,alphabet);
    $("#alphabetAll").addClass("alphabetSelect");
    $(window.parent.$("#my-iframe")).attr("height","635px");
    $(window.parent.gdClick("#index_singer"));
});
function getSingerPage(n1,n2,n3) {
    let data;
    if(n3===null)
        data={"pageNum":n1,"pageSize":n2};
    else
        data={"pageNum":n1,"pageSize":n2,"alphabet":n3};
    $.ajax({
        type:"GET",
        url:"/getSingerPage",
        data:data,
        success:function (data) {
            generalHtml(data.list);
            pages=data.pages;
            pageNum=data.pageNum;
        },
        error:function (data) {
            console.log(data);
        }
    });
}
function generalHtml(list) {
    $(".index_singerItem").remove();
    for(let i=0;i<list.length;i++){
        let html='<div class="index_singerItem">' +
            '                    <img src="'+list[i].cover+'" class="singerCover" id="singer'+list[i].singerid+'">' +
            '                    <div>'+list[i].name+'</div>' +
            '                </div>';
        $("#indexSingerBlock").append(html);
    }
}
//上一页
$("#prePage").click(function () {
    let page=pageNum-1;
    if(page===0){
        alert("这是第一页了");
        return;
    }
    getSingerPage(page,pageSize,alphabet);
});
//下一页
$("#nextPage").click(function () {
    let page=pageNum+1;
    if(page>pages){
        alert("这是最后一页了");
        return;
    }
    getSingerPage(page,pageSize,alphabet);
});
//点击跳转
$("#indexSingerBlock").on("click",".singerCover",function () {
    let id=this.id.substring(6);
    top.location.href="/singer/"+id;
})
//字母
$(".alphabet").click(function () {
    $(".alphabet").removeClass("alphabetSelect");
    alphabet=this.id;
    $("#"+alphabet).addClass("alphabetSelect");
    if(alphabet==="alphabetAll")
        alphabet=null;
    getSingerPage(1,pageSize,alphabet);
});