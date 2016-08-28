 $.fn.messagebox = function (message, type, delay) {
     $("#msgprint").remove();
     delay = (typeof delay == "undefined" ? 2000 : delay);
     var box_style = 'position:absolute;display:none;z-index:1000;padding:10px 30px 10px 40px;';
     switch (type) {
         case 1: box_style += 'border:1px solid Green;color:#000;background:url(static/jquery/icons/ok.png) 10px 10px no-repeat #F1FEF2;'; break;
         case 0: box_style += 'border:1px solid Red;color:#000;background:url(static/jquery/icons/error.png) 10px 10px no-repeat #FDF8E8;'; break;
         case 2: box_style += 'border:1px solid Orange;color:#000;background:url(static/jquery/icons/warning.png) 10px 10px no-repeat #FEFDE9;'; break;
         default: box_style += 'border:1px solid Green;color:#000;background:url(static/jquery/icons/ok.png) 10px 10px no-repeat #F1FEF2;'; break;
     }
     var str = "<div id=\"msgprint\" style=\"" + box_style + "\">" + message + "</div>"; $(this).append(str);
     var dom_obj = document.getElementById("msgprint");
     dom_obj.style.left=$(this).offset().left+$('#msgprint').width();
     dom_obj.style.top=$(this).offset().top;
     $("#msgprint").fadeIn(delay).fadeOut(delay);
 };