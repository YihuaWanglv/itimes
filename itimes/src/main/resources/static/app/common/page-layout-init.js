$(function() {
  $("#header").load("./view/header.html", function(){
    $(".menu-nav-right").on('click', function() {
      if($('.nav-right').hasClass('my-navbar-right-show')) {
        $(".nav-right").removeClass('my-navbar-right-show');
      } else {
        $('.nav-right').addClass('my-navbar-right-show');
      }
    });
  });
  $(".nav-right-holder").load("./view/nav-right.html");
  
});