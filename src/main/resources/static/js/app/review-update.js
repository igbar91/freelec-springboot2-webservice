$(function(){
    const movie = document.getElementById('movie');
    const len = movie.options.length;
    const id = document.getElementById('postId').value;
    for (let i=0; i<len; i++){
        if(movie.options[i].value == id){
            movie.options[i].selected = true;
        }
    }
});

/*let urlChk = window.location.pathname;
if(urlChk.indexOf("/review/update")==0){*/
let defScore = document.getElementById("defScore").value;
let defOpen = document.getElementById("defOpen").value;
if(defScore != null){
    $("input[name='score']").each(function (i) {
        //alert( i +  $("input[name='score']").eq(i).attr("value") );
        //$("input[name='score']").eq(i).attr("value");
        if(defScore == i+1){
            $("#score"+defScore).prop("checked", true);
        }
    });
}
if(defOpen != null){
     $("input[name='openYn']").each(function (i) {
         if(defOpen=="Y"){
             $("#openYn1").prop("checked", true);
         }else{
            $("#openYn2").prop("checked", true);
         }
     });
}

