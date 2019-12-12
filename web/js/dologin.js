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
                 console.log(ret);
                 if (ret.statusCode==300){
                     $.dologinJs.adderror(ret.errorCode,ret.message);
                 } else if (ret.statusCode==200) {

                 }
             },
             error: function (error) {
             }
         })
     },

     "adderror":function (errortype,message) {
         $(".errordiv").html();
/*         if (errortype == 'textnull'){
             var error = '<span style="color: red">请输入用户名和密码</span>';
         } else if (errortype == 'passworderror'){
             var error = '<span style="color: red">户名或密码错误</span>';
         }*/
         var error = '<span style="color: red">'+message+'</span>';
         $(".errordiv").html(error);
     },

     "changeButton":function () {
         if ($("#formtype").val() == "login"){
             //隐藏登录
             $(".login").css('display','none');
             //显示注册
             $(".newuser").css('display','block');
             //修改按钮
             $("#newuser-button").html("");
             $("#newuser-button").append('<button  type="button"  onclick  = "$.dologinJs.changeButton();" class="submit_button">开始登录</button>');
             //修改隐藏val
             $("#formtype").val("newUser");
         }else{
             //隐藏登录
             $(".login").css('display','block');
             //显示注册
             $(".newuser").css('display','none');
             //修改按钮
             $("#newuser-button").html("");
             $("#newuser-button").append('<button  type="button"  onclick  = "$.dologinJs.changeButton();" class="submit_button">注册新用户</button>');
             //修改隐藏val
             $("#formtype").val("login");
         }
     }
 }
});