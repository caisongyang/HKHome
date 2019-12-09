$(function(){
    console.log(123);
 $.dologinJs = {
     "dologin":function () {
         var param = {
             "userName": $("input[name=username]").val(),
             "passWord": $("input[name=password]").val()
         };
         $.ajax({
             type: "POST",
             url: "/HKHome/userLogin/dologin",
             dataType: "json",
             data: param,
             success: function (ret) {
             },
             error: function (error) {
             }
         })
     }
 }
});