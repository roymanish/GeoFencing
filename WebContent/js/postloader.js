
var first=0,pageSize=2;
$(window).scroll(function()
		{

	if($(window).scrollTop() == $(document).height() - $(window).height())
	{
		$('div#loadmoreajaxloader').show();
		$.ajax({
			url: "getPosts.html?firstResult="+first+"&pageCount="+pageSize,
			success: function(html)
			{
				first+=2;

				if(html)
				{
					$("#postswrapper").append(html);


					$('div#loadmoreajaxloader').hide();

				}else
				{
					$('div#loadmoreajaxloader').html('<center>No more posts to show.</center>');
				}
			}
		});
	}
		});


$(document).ready(function(){
	$contentLoadTriggered = false;
	$("#content-box").scroll(function(){
		if($("#content-box").scrollTop() >= ($("#content-wrapper").height() - $("#content-box").height()) && $contentLoadTriggered == false)
		{
			$contentLoadTriggered = true;
			$.get("getData", function(data){
				$("#content-wrapper").append(data);
				$contentLoadTriggered = false;
			});
		}

	});
});

