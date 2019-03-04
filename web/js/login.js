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
    loadding = false;
  $.loginjs = {
      "addMusic" : function () {
          var num = 0;
          layer.open({
              type:1,
              title: '添加Music',
              maxmin:true,
              shadeClose:false,
              area: ['450px', ''],
              content: $('#add_Music_style'),
              btn: ['添加', '取消'],
              yes:function (index,lavero) {
                  if ($("#mscName").val()==null) {
                      layer.alert("添加歌曲名称！\r\n", {
                          title: '提示框'
                      });
                      num++;
                      return false;
                  }else if ($("#mscName").val()==null){
                      layer.alert("添加歌手名称！\r\n", {
                          title: '提示框'
                      });
                      num++;
                      return false;
                  }
                  if (num>0) {
                      return false;
                  }else {
                      if (loadding) {
                          return;
                      }
                     var upfrom = new FormData($("#addMusicForm")[0]);
                      console.log(upfrom);
                    $.ajax({
                        url:"/HKHome/upload/upMusic",
                        dataType: "json",
                        type: 'POST',
                        data: upfrom,
                        cache: false,
                        contentType: false,
                        processData: false,
                        beforeSend: function (data) {
                            loadding = true;
                        },
                        success: function (data) {
                            if (data.statusCode == '200' || data.statusCode == 200) {
                                layer.alert(data.message, {
                                    title: '提示框'
                                });
                            } else {
                                layer.alert(data.message, {
                                    title: '提示框'
                                });
                            }
                            loadding = false;
                        }, error: function (data) {
                            loadding = false;
                            layer.alert('系统异常，请联系管理员', {
                                title: '提示框'
                            });
                        }
                    })
                  }
              }
          });
      },

      "checkFile":function () {
          $("#mscmp3file").click();
      },

      "setFile":function () {
          var val = $("#mscmp3file").val();
          val = val.substr(val.lastIndexOf("\\") + 1, val.length);
          $("#dlscFileInput").val(val);
      }
  }

});