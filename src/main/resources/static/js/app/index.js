
let main = {
    init : function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
        $('#post-check').on('click', function () {
            _this.postChk();
        });
    },
    save : function () {

        if($("#movie option:selected").val()==null){
            alert("영화 옵션을 선택해 주세요.");
            return;
        }
        let date = dateFormat();

        let data = {
            title: $("#title").val(),
            score: $("input[type=radio][name=score]:checked").val(),
            openYn: $("input[type=radio][name=openYn]:checked").val(),
            content: $("#content").val(),
            movieId:$("#movie option:selected").val(),
            deleteYn: "N",
            regDate: date
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/review',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/review';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        let date = dateFormat();

        let data = {
            movieId:$("#movie option:selected").val(),
            title: $('#title').val(),
            score: $("input[type=radio][name=score]:checked").val(),
            openYn: $("input[type=radio][name=openYn]:checked").val(),
            content: $('#content').val(),
            modifyDate: date
        };

        let id = $('#id').val();


        $.ajax({
            type: 'PUT',
            url: '/api/v1/review/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/review';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
     delete : function () {
         let id = $('#id').val();

         $.ajax({
             type: 'DELETE',
             url: '/api/v1/review/'+id,
             dataType: 'json',
             contentType:'application/json; charset=utf-8'
         }).done(function() {
             alert('글이 삭제되었습니다.');
             window.location.href = '/review';
         }).fail(function (error) {
             alert(JSON.stringify(error));
         });
     },
};

main.init();

function dateFormat(){
let today = new Date();

let year = today.getFullYear();
let month = ('0' + (today.getMonth() + 1)).slice(-2);
let day = ('0' + today.getDate()).slice(-2);
let hours = ('0' + today.getHours()).slice(-2);
let minutes = ('0' + today.getMinutes()).slice(-2);
let seconds = ('0' + today.getSeconds()).slice(-2);

let dateString = year + '-' + month  + '-' + day + ' ' + hours + ':' + minutes  + ':' + seconds;

return dateString;
}