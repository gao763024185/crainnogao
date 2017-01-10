$(function () {
    /* 菜单栏 start */
    // var offset = $("#tab-menu").offset();
    // var topPadding = 15;
    // $(window).scroll(function() {
    //     if ($(window).scrollTop() > offset.top) {
    //         $("#tab-menu").stop().animate({
    //             marginTop: $(window).scrollTop() - offset.top + topPadding
    //         });
    //     } else {
    //         $("#tab-menu").stop().animate({
    //             marginTop: 0
    //         });
    //     }
    // });
    $('#tab-menu > li').click(function(){
        $('#tab-menu > li').removeClass('selected');
        $(this).addClass('selected');
        $('.tab-content div.tab').slideUp('slow');
        $('.tab-content div.tab:eq(' + $('#tab-menu > li').index(this) + ')').slideDown('slow');
    }).mouseover(function() {
        $(this).addClass('mouseover');
        $(this).removeClass('mouseout');
    }).mouseout(function() {
        $(this).addClass('mouseout');
        $(this).removeClass('mouseover');
    });
    /* 菜单栏 end */

    // var items = $('#countrySelection-items').width();
    // var itemSelected = document.getElementsByClassName('countrySelection-item');
    // var backgroundColours = ["rgb(133, 105, 156)", "rgb(175, 140, 115)","rgb(151, 167, 109)","rgb(171, 100, 122)","rgb(105, 134, 156)","rgb(152, 189, 169)"]
    // countriesPointerScroll($(itemSelected));
    // $("#countrySelection-items").scrollLeft(200).delay(200).animate({
    //     scrollLeft: "-=200"
    // }, 2000, "easeOutQuad");
    //
    // $('.countrySelection-paddle-right').click(function () {
    //     $("#countrySelection-items").animate({
    //         scrollLeft: '+='+items
    //     });
    // });
    // $('.countrySelection-paddle-left').click(function () {
    //     $( "#countrySelection-items" ).animate({
    //         scrollLeft: "-="+items
    //     });
    // });
    //
    // if(!/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
    //     var scrolling = false;
    //
    //     $(".countrySelection-paddle-right").bind("mouseover", function(event) {
    //         scrolling = true;
    //         scrollContent("right");
    //     }).bind("mouseout", function(event) {
    //         scrolling = false;
    //     });
    //
    //     $(".countrySelection-paddle-left").bind("mouseover", function(event) {
    //         scrolling = true;
    //         scrollContent("left");
    //     }).bind("mouseout", function(event) {
    //         scrolling = false;
    //     });
    //
    //     function scrollContent(direction) {
    //         var amount = (direction === "left" ? "-=3px" : "+=3px");
    //         $("#countrySelection-items").animate({
    //             scrollLeft: amount
    //         }, 1, function() {
    //             if (scrolling) {
    //                 scrollContent(direction);
    //             }
    //         });
    //     }
    // }
    //
    // $('.countrySelection-item').click(function () {
    //     $('#countrySelection').find('.active').removeClass('active');
    //     $(this).addClass("active");
    //     countriesPointerScroll($(this));
    //     newBackgroundColour(backgroundColours)
    // });
    // var newBackgroundColour = function(backgroundColours){
    //     var newBackground = backgroundColours[Math.floor(Math.random()*backgroundColours.length)];
    //     if(newBackground != $("html").css("background-color")){
    //         $("html").css("background",newBackground);
    //     }else{
    //         newBackgroundColour(backgroundColours);
    //     }
    // }

    // function countriesPointerScroll(ele) {
    //
    //     var parentScroll = $("#countrySelection-items").scrollLeft();
    //     var offset = ($(ele).offset().left - $('#countrySelection-items').offset().left);
    //     var totalelement = offset + $(ele).outerWidth()/2;
    //
    //     var rt = (($(ele).offset().left) - ($('#countrySelection-wrapper').offset().left) + ($(ele).outerWidth())/2);
    //     $('#countrySelector').animate({
    //         left: totalelement + parentScroll
    //     })
    // }

    // var count = $("#count").val();
    // for (var i =0 ; i<count;i++){
    //     var contentshow = $('.logContent').val();
    //     $('.contentshow').html(marked(contentshow));
    // }


    $("#ajshow").on('click','.logTitle',function () {
        var _index = $(this).index();
        var logId = $("#logId-"+_index).val();
        var data = {logId:logId};
        $.ajax({
            url:"logshow",
            type:"post",
            data:data,
            dataType:"json",
            success:function (resp) {
                var $tr=  '<div class="panel-heading"><strong>'+resp.logTitle+'</strong></div>'+
                        '<div class="panel-body"><div class="panel-body">关键字：'+resp.logSummary+'</div></div>'+
                        '<div  class="contentshow"></div>'+
                        '<input type="hidden" class="logContent" value="'+resp.logContent+'"/>';
                document.getElementById("logshow").innerHTML=$tr;
                $("#firstshow").hide();
                var contentshow = $('.logContent').val();
                $('.contentshow').html(marked(contentshow));
                // setTimeout("hljs.initHighlightingOnLoad();",300);
            },
            error:function () {
                alert("失败");
            }
        })
    });;;;;;;;;;;;;;;;;;;;;;;;;;

    $(document).on('click','#crainnogao_ad',function () {
        window.location.href="/crainnogao/admin/crainnogao_ad";
    });;;;;;;;;;;;;;;;;;;;;;;;;;

    var contentshow = $('#logcontentfir').val();
    $('#firstlog').html(marked(contentshow));
});

