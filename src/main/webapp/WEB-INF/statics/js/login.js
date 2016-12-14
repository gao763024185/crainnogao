$(function () {
    $("#submit").click(function () {
        var userName = $("#username").val();
        var password = $("#password").val();
        var data = {
            userName:userName,
            password:password
        }
        $.post("/gaobh/blog/login",data,function (resp) {
            alert("成功！");
        })
        // $.ajax({
        //     type: 'POST',
        //     url: "login.htm",
        //     data: data,
        //     dataType:"text",
        //     success: function (resp) {
        //         alert("成功");
        //     },
        //     error:function () {
        //         alert("失败");
        //     }
        //
        // });
    })
})
