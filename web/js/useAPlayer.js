$(function(){
    console.log("use - APlayer");
    const ap = new APlayer({
        container: document.getElementById('aplayer'),
        fixed:false,
        audio: [{
            name: 'name',
            artist: 'artist',
            url: '/HKHome/APlayermp3/1/1.mp3',
            cover: '/HKHome/APlayermp3/1/1.jpg',
            theme: '#df0f0f'
        },
            {
                name: 'name',
                artist: 'artist',
                url: '/HKHome/APlayermp3/1/1.mp3',
                cover: '/HKHome/APlayermp3/1/1.jpg',
                theme: '#050505'
            }

             ]
    });


    $.MusicJs = {
        "checkdiv":function () {
            if ($("#divtype").val()=="show"){
                ap.list.toggle();
                $(".music-div").removeClass("music-div-show").addClass("music-div-hide");
                $("#divtype").val("hidden");
            } else{
                $(".music-div").removeClass("music-div-hide").addClass("music-div-show");
                $("#divtype").val("show");
                ap.list.toggle();
            }
        }
    }
});