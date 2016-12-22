
 // Calling the function
$(function() {
    $('.toggle-nav').click(function() {
        toggleNavigation();
    });
});


// The toggleNav function itself
function toggleNavigation() {
    if ($('#container_ad').hasClass('display-nav')) {
        // Close Nav
        $('#container_ad').removeClass('display-nav');
    } else {
        // Open Nav
        $('#container_ad').addClass('display-nav');
    }
}


// SLiding codes
$("#toggle > li > div").click(function () {
    if (false == $(this).next().is(':visible')) {
        $('#toggle ul').slideUp();
    }

    var $currIcon=$(this).find("span.the-btn");

    $("span.the-btn").not($currIcon).addClass('fa-plus').removeClass('fa-minus');

    $currIcon.toggleClass('fa-minus fa-plus');

    $(this).next().slideToggle();

    $("#toggle > li > div").removeClass("active");
    $(this).addClass('active');

});

//tab切换
 $("#nav ul li").click(function () {
     var _index = $(this).index();
     $(this).find('a').addClass('active1').parent().parent().siblings('li').find('div').find('a').removeClass('active1');
     $("#nav ul li ul li a").removeClass('active1');
     $('.listmenu').eq(_index).show().siblings('.libiao').hide();
 });

 //tab切换 日志管理
 $("#toggle ul li").click(function () {
     var _index = $(this).index();
     $(this).find('a').addClass('active2').parent().siblings('li').find('a').removeClass('active2');
     $('.listmenu1').eq(_index).show().siblings('.libiao1').hide();
 });
