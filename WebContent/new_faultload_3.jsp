<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Create new faultload [3/4]</title>
<meta name="description" content="">
<meta name="author" content="ink, cookbook, recipes">
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="mobile-web-app-capable" content="yes">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<!-- Place favicon.ico and apple-touch-icon(s) here  -->

<link rel="shortcut icon" href="http://cdn.ink.sapo.pt/3.1.7/img/favicon.ico">
<link rel="apple-touch-icon" href="http://cdn.ink.sapo.pt/3.1.7/img/touch-icon-iphone.png">
<link rel="apple-touch-icon" sizes="76x76" href="http://cdn.ink.sapo.pt/3.1.7/img/touch-icon-ipad.png">
<link rel="apple-touch-icon" sizes="120x120" href="http://cdn.ink.sapo.pt/3.1.7/img/touch-icon-iphone-retina.png">
<link rel="apple-touch-icon" sizes="152x152" href="http://cdn.ink.sapo.pt/3.1.7/img/touch-icon-ipad-retina.png">
<link rel="apple-touch-startup-image" href="http://cdn.ink.sapo.pt/3.1.7/img/splash.320x460.png" media="screen and (min-device-width: 200px) and (max-device-width: 320px) and (orientation:portrait)">
<link rel="apple-touch-startup-image" href="http://cdn.ink.sapo.pt/3.1.7/img/splash.768x1004.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<link rel="apple-touch-startup-image" href="http://cdn.ink.sapo.pt/3.1.7/img/splash.1024x748.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">

<!-- load Ink's css from the cdn -->
<link rel="stylesheet" type="text/css" href="http://cdn.ink.sapo.pt/3.1.7/css/ink-flex.min.css">
<link rel="stylesheet" type="text/css" href="http://cdn.ink.sapo.pt/3.1.7/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="css/ink-custom.css">

<!-- load Ink's css for IE8 -->
<!--[if lt IE 9 ]>
<link rel="stylesheet" href="http://cdn.ink.sapo.pt/3.1.7/css/ink-ie.min.css" type="text/css" media="screen" title="no title" charset="utf-8">
<![endif]-->

<!-- test browser flexbox support and load legacy grid if unsupported -->
<script type="text/javascript" src="http://cdn.ink.sapo.pt/3.1.7/js/modernizr.js"></script>
<script type="text/javascript">
	Modernizr.load(
	{
		test : Modernizr.flexbox,
		nope : 'http://cdn.ink.sapo.pt/3.1.7/css/ink-legacy.min.css'
	});
</script>

<!-- load Ink's javascript files from the cdn -->
<script type="text/javascript" src="http://cdn.ink.sapo.pt/3.1.7/js/holder.js"></script>
<script type="text/javascript" src="http://cdn.ink.sapo.pt/3.1.7/js/ink-all.min.js"></script>
<script type="text/javascript" src="http://cdn.ink.sapo.pt/3.1.7/js/autoload.js"></script>


<style type="text/css">
body {
	background: #ededed;
}

header h1 small:before {
	content: "|";
	margin: 0 0.5em;
	font-size: 1.6em;
}

footer {
	background: #ccc;
}
</style>

</head>

<body>
	<div class="ink-grid">

		<!--[if lte IE 9 ]>
				<div class="ink-alert basic" role="alert">
					<button class="ink-dismiss">&times;</button>
					<p>
						<strong>You are using an outdated Internet Explorer version.</strong>
						Please <a href="http://browsehappy.com/">upgrade to a modern browser</a> to improve your web experience.
					</p>
				</div>
			 <![endif]-->

		<!-- Add your site or application content here -->

		<header class="vertical-space">
			<h1>
				FAULT INJECTOR<small>Create new faultload</small>
			</h1>

			<div class="column-group">
				<div class="all-85">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green">
							<li><a href="loadexperiments">Home</a></li>
							<li><a href="loadfaultloads">New experiment [4/4]</a></li>
							<li class="active"><a href="#">New faultload [3/4]</a></li>
						</ul>
					</nav>
				</div>
				<div class="all-15">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green align-center">
							<li><a href="#">Logout jaff</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>

		<div class="column-group">
			<div class="all-20"></div>
			<div class="all-50">
				<h2 class="bottom-space">Create new faultload [3/4]</h2>

				<h3 class="quarter-bottom-space">1.2 Fault model: target register selection</h3>
				<hr />

				<table class="ink-table hover alternating checkbox">
					<thead>
						<tr>
							<th class="all-5"></th>
							<th class="all-95 align-left large">Select the registers to use:</th>
						</tr>
					</thead>
					<tbody class="all-100">
						<s:if test="registers.size > 0">
							<s:iterator value="registers">
								<tr class="all-100">
									<td>
										<div class="ink-form quarter-top-space">
											<div class="control-group" style="margin: 0">
												<ul class="control unstyled" style="margin: 0">
													<s:if test="#session.faultloadBean.containsRegisterId(reg_id) == true">
														<li style="margin: 0"><input type="checkbox" class="cb" name="select" id="<s:property value="reg_id"/>" value="" checked><label for=""></label></li>
													</s:if>
													<s:else>
														<li style="margin: 0"><input type="checkbox" class="cb" name="select" id="<s:property value="reg_id"/>" value=""><label for=""></label></li>
													</s:else>
												</ul>
											</div>
										</div>
									</td>
									<td class="all-100"><a href="#" class="large align-left"><s:property value="name" /></a></td>
								</tr>
							</s:iterator>
						</s:if>
					</tbody>
				</table>

				<a href="#" class="ink-button all-40 double-bottom-space" id="all">Select all</a>
			</div>
			<div class="all-30"></div>
		</div>

		<div class="column-group">
			<div class="all-20"></div>
			<div class="all-50">
				<div class="column-group">
					<div class="all-50 align-left">
						<a href="new_faultload_2.jsp" class="ink-button all-95">&lt; Previous</a>
					</div>
					<div class="all-50 align-right">
						<button class="ink-button all-95" type="submit" id="nextfl" disabled>Next &gt;</button>
					</div>
				</div>
			</div>
			<div class="all-30"></div>
		</div>
	</div>

	<footer class="clearfix double-top-space">
		<div class="ink-grid">
			<ul class="unstyled inline half-vertical-space">
				<li class="active"><a href="#">About</a></li>
				<li><a href="#">Sitemap</a></li>
				<li><a href="#">Contacts</a></li>
			</ul>
			<p class="note">Identification of the owner of the copyright, either by name, abbreviation, or other designation by which it is generally known.</p>
		</div>
	</footer>

	<script src="js/jquery/jquery-1.11.2.js"></script>
	<script src="js/my-jquery.js"></script>

	<script type="text/javascript">
		var checkboxes = $("input[type='checkbox']");

		$('#nextfl').attr("disabled", !checkboxes.is(":checked"));

		checkboxes.click(function()
		{
			$('#nextfl').attr("disabled", !checkboxes.is(":checked"));
		});
	</script>

	<script type="text/javascript">
		$('#nextfl').click(function(event)
		{
			var rids = $('input:checkbox').filter(':checked').map(function()
			{
				return this.id;
			}).get();

			$.ajax(
			{
				method : "POST",
				url : "createfaultload31.action",
				data :
				{
					rids : rids
				},
				traditional : true,
				success : function()
				{
					//  					    	alert("RIDS -> "+rids);
					//  					    	alert("RIDS [0] -> "+rids[0]);
					window.location = "createfaultload32.action";
				}
			});
		});
	</script>
</body>
</html>