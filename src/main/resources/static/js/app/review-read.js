$(function(){
    const movie = document.getElementById('movie');
    const len = movie.options.length;
    const id = document.getElementById('postId').value;
    for (let i=0; i<len; i++){
        if(movie.options[i].value == id){
            movie.options[i].selected = true;
        }
    }

    let defScore = document.getElementById("defScore").value;
    if(defScore != null){
        $("input[name='score']").each(function (i) {
            if(defScore == i+1){
                $("#score"+defScore).prop("checked", true);
            }
        });
    }

    let select = document.querySelectorAll('input.readonly');
    for(let i = 0; i < select.length; i++) {
      select[i].setAttribute('onclick', 'return false');
    }

    $('.starScore').score();
});

