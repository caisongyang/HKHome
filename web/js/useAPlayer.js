$(function(){
    console.log("use - APlayer");
    const ap = new APlayer({
        container: document.getElementById('aplayer'),
        fixed: true,
        audio: [{
            name: 'name',
            artist: 'artist',
            url: '/HKHome/APlayermp3/1/1.mp3',
            cover: '/HKHome/APlayermp3/1/1.jpg'
        }]
    });

});