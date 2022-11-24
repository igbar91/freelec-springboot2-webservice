
$(function(){
    //starScore
    $('.starScore').each(function(index, item){
        $(item).score();
    });

    //Paging
    let now = document.getElementById('nowPage').value;
    let start = document.getElementById('startPage').value;
    let end = document.getElementById('endPage').value;

    let html = "";
    if(end==0){ //When no post
        html="<Strong>"+1+"</Strong>";
    }else{
        for(let i=start; i<=end; i++){
            if(i==now){
                html+="<Strong>"+i+"</Strong>";
                continue;
            }
            html+="<a href=/review/?page="+(i-1)+">"+i+"</a>"+"     ";
        }
    }
    document.getElementById('pageHtml').innerHTML=html;
});

function postChk(){
    let count = $('#postCount').val();
    if(count>0){
        location.href="/review/form";
    }else{
        alert("리뷰를 등록할 수 있는 영화 포스터가 없습니다.");
    }
}