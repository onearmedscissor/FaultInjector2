$(document).ready(function()
{
	if ($('.dynamicTable tbody tr').hasClass("highlight"))	
    	$('.dynamicButton').attr("disabled", false);
	
	$('.dynamicTable tbody tr').click(function()
    {
		var selected = $(this).hasClass("highlight");
		
		if(selected)
		{
			$(this).removeClass("highlight");
			$('.dynamicButton').attr("disabled", true);
		}
		else
		{
			$('.dynamicTable tbody tr').removeClass("highlight");
			$(this).addClass("highlight");
			$('.dynamicButton').attr("disabled", false);
		}
    });

//    if ($('.dynamicTable tbody tr').hasClass("highlight"))	
//    	$('.dynamicButton').attr("disabled", false);
//	
//	$('.dynamicTable tbody tr').click(function()
//    {
//        var selected = $(this).hasClass("highlight");
//
//        $('.dynamicTable tbody tr').removeClass("highlight");
//        $('.dynamicButton').attr("disabled", false);
//
//        if(!selected)
//          $(this).addClass("highlight");
//    });
	
//	$('.select').click(function()
//	{
//		var selected2 = $(this).parent('td').parent('tr').hasClass("highlight");
//		
//		//alert(selected);
//		
//		if(selected2)
//		{
//			$(this).parent('td').parent('tr').removeClass("highlight");
//			$('.dynamicButton').attr("disabled", true);
//		}
//		else
//		{
//			$(this).parent('td').parent('tr').addClass("highlight");
//			$('.dynamicButton').attr("disabled", false);
//		}
//	});
	
    $('#all').click(function(event)
    {  //on click
//        if(this.checked) { // check select status
//            $('.cb').each(function() { //loop through each checkbox
//                this.checked = true;  //select all checkboxes with class "checkbox1"              
//            });
//        }else{
            $('.cb').each(function() { //loop through each checkbox
                this.checked = true; //deselect all checkboxes with class "checkbox1"                      
            });

            $('#finish, #nextfl').attr("disabled", false);
//        }
    });
    
    function isEmpty(el)
    {
        return !$.trim(el.html());
    }
});