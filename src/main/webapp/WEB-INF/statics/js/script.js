$(function () {
    /* 菜单栏 start */
    var offset = $("#tab-menu").offset();
    var topPadding = 15;
    $(window).scroll(function() {
        if ($(window).scrollTop() > offset.top) {
            $("#tab-menu").stop().animate({
                marginTop: $(window).scrollTop() - offset.top + topPadding
            });
        } else {
            $("#tab-menu").stop().animate({
                marginTop: 0
            });
        }
    });
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
});
