$(function(){
  console.log("queryList");
  $.ajax({
    type:"POST",
    url:"/HKHome/login/queryMusicList",
    success:function (data) {
        if (data.statusCode=="200") {

        }
    }, error:function(error){
          alert("后台异常")
      }
  });
});