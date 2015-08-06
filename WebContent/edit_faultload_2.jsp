<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Edit faultload [2/4]</title>
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
				FAULT INJECTOR<small>Edit faultload</small>
			</h1>

			<div class="column-group">
				<div class="all-85">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green">
							<li><a href="loadexperiments">Home</a></li>
							<li><a href="loadfaultloads">New experiment [4/4]</a></li>
							<li class="active"><a href="#">Edit faultload [2/4]</a></li>
						</ul>
					</nav>
				</div>
				<div class="all-15">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green align-center">
							<li><a href="#"><!-- Logout jaff --></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>

		<div class="column-group">
			<div class="all-20"></div>
			<div class="all-80">
				<h2 class="bottom-space">Edit faultload [2/4]</h2>
			</div>
		</div>

		<div class="column-group">
			<div class="all-100">
				<form action="editfaultload31" id="page_2" class="ink-form all-100 small-100 tiny-100" method="post">
					<fieldset>
						<s:hidden name="id" value="%{faultload.faultloadId}" />

						<div class="control-group column-group gutters required">
							<p class="label all-20 align-right push-middle">Hardware fault type</p>
							<ul id="hwfaulttype" class="control unstyled all-80 inline">
								<li><s:radio label="hardwarefaulttype" name="hardwareFaultTypeId" list="hardwareFaultTypes" listKey="hardwareFaultTypeId" listValue="name" value="hardwareFaultTypeId" /></li>
							</ul>
						</div>

						<div class="column-group gutters">
							<div class="control-group all-30 required">
								<div class="column-group gutters">
									<label for="memstart" class="all-66 align-right">Memory fault range</label>
									<div class="control all-33">
										<s:textfield id="memorystart" name="memoryStart" value="%{faultload.memoryRangeBeginning}" />
									</div>
								</div>
							</div>
							<div class="control-group all-15">
								<div class="column-group">
									<div class="all-5"></div>
									<label for="memend" class="all-35 align-left">-</label>
									<div class="control all-60">
										<s:textfield id="memoryend" name="memoryEnd" value="%{faultload.memoryRangeEnd}" />
									</div>
								</div>
							</div>
							<div class="all-55"></div>
						</div>

						<div class="control-group column-group gutters required">
							<label for="name" class="all-20 align-right">Number of faults</label>
							<div class="control all-10">
								<s:textfield id="numberfaults" name="numberFaults" value="%{faultload.numberFaults}" />
							</div>
							<div class="all-70"></div>
						</div>
					</fieldset>

					<div class="column-group">
						<div class="all-20"></div>
						<div class="all-80">
							<fieldset>
								<legend class="bottom-space">1.1 Fault model</legend>
							</fieldset>
						</div>
					</div>

					<fieldset>
						<div class="control-group column-group gutters required">
							<p class="label all-20 align-right push-middle">Fault class</p>
							<ul class="control unstyled all-80 inline">
								<li><s:radio label="faultclass" name="faultClassId" list="faultClasses" listKey="faultClassId" listValue="name" value="faultClassId" /></li>
							</ul>
						</div>
						<div class="column-group gutters">
							<div class="control-group all-30 required">
								<div class="column-group gutters">
									<s:iterator value="faults" end="1">
										<s:iterator value="hardwareFaults" end="1">
											<label for="bitstart" class="all-66 align-right">Bit(s) to change</label>
											<div class="control all-33">
												<s:textfield id="bitstart" name="bitStart" value="%{bitStart}" />
											</div>
										</s:iterator>
									</s:iterator>
								</div>
							</div>
							<div class="control-group all-15">
								<div class="column-group">
									<s:iterator value="faults" end="1">
										<s:iterator value="hardwareFaults" end="1">
											<div class="all-5"></div>
											<label for="bitend" class="all-35 align-left">-</label>
											<div class="control all-60">
												<s:textfield id="bitend" name="bitEnd" value="%{bitEnd}" />
											</div>
										</s:iterator>
									</s:iterator>
								</div>
							</div>
							<div class="all-55"></div>
						</div>

						<div class="column-group">
							<div class="all-20"></div>
							<div class="all-50">
								<div class="column-group">
									<div class="all-50 align-left">
										<a href="editfaultload1" class="ink-button all-95">&lt; Previous</a>
									</div>
									<div class="all-50 align-right">
										<button class="ink-button all-95" type="submit" id="next" disabled>Next &gt;</button>
									</div>
								</div>
							</div>
							<div class="all-30"></div>
						</div>
					</fieldset>
				</form>
			</div>
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
		var check10, check11, value = $('input[name=hardwareFaultTypeId]:checked + label').text();
		
		if (value == "memory")
		{
			$('#memstart').attr("disabled", false);
			$('#memend').attr("disabled", false);
		}
		else
		{
			$('#memstart').attr("disabled", true);
			$('#memend').attr("disabled", true);
		}

		if ($('#numberfaults').val().match(/^\d+$/) && $('#numberfaults').val() > 0)
		{
			if ($('#memstart').is(':disabled') && $('#memend').is(':disabled'))
				check10 = "true";
			else
			{
				if ($('#memstart').val().match(/^\d+$/) && $('#memend').val().match(/^\d+$/) && $('#memstart').val() > 0 && parseInt($('#memstart').val()) <= parseInt($('#memend').val()))
					check10 = "true";
				else
					check10 = "false";
			}
		}
		else
			check10 = "false";

		if ($('#bitstart').val().match(/^\d+$/) && $('#bitend').val().match(/^\d+$/) && $('#bitstart').val() >= 0 && parseInt($('#bitstart').val()) <= parseInt($('#bitend').val()))
			check11 = "true";
		else
			check11 = "false";

		if (check10 == "true" && check11 == "true")
			$('#next').attr("disabled", false);
		else
			$('#next').attr("disabled", true);

		$("#page_2").on("input change", function()
		{
			value = $('input[name=hardwareFaultTypeId]:checked + label').text();

			if (value == "memory")
			{
				$('#memstart').attr("disabled", false);
				$('#memend').attr("disabled", false);
			}
			else
			{
				$('#memstart').attr("disabled", true);
				$('#memend').attr("disabled", true);
			}

			if ($('#numberfaults').val().match(/^\d+$/) && $('#numberfaults').val() > 0)
			{
				if ($('#memstart').is(':disabled') && $('#memend').is(':disabled'))
					check10 = "true";
				else
				{
					if ($('#memstart').val().match(/^\d+$/) && $('#memend').val().match(/^\d+$/) && $('#memstart').val() > 0 && parseInt($('#memstart').val()) <= parseInt($('#memend').val()))
						check10 = "true";
					else
						check10 = "false";
				}
			}
			else
				check10 = "false";

			if ($('#bitstart').val().match(/^\d+$/) && $('#bitend').val().match(/^\d+$/) && $('#bitstart').val() >= 0 && parseInt($('#bitstart').val()) <= parseInt($('#bitend').val()))
				check11 = "true";
			else
				check11 = "false";

			if (check10 == "true" && check11 == "true")
				$('#next').attr("disabled", false);
			else
				$('#next').attr("disabled", true);
		});
	</script>
</body>
</html>