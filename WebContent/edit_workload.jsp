<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Edit workload</title>
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
				FAULT INJECTOR<small>Edit workload</small>
			</h1>

			<div class="column-group">
				<div class="all-85">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green">
							<li><a href="loadexperiments">Home</a></li>
							<li><a href="loadworkloads">New experiment [3/4]</a></li>
							<li class="active"><a href="#">Edit workload</a></li>
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
				<h2 class="bottom-space">Edit workload</h2>
			</div>
		</div>
		<div class="column-group">
			<div class="all-100">
				<form action="saveworkload" class="ink-form all-100 small-100 tiny-100" method="post">
					<fieldset id="editworkload">
						<s:hidden name="id" value="%{workload.workloadId}" />

						<div class="control-group column-group gutters required">
							<label for="name" class="all-20 align-right">Name</label>
							<div class="control all-50">
								<s:textfield id="name" name="name" value="%{workload.name}" />
							</div>
							<div class="all-30"></div>
						</div>
						
						<div id="textbox1" class="control-group column-group gutters required">
							<label for="app1name" class="all-20 align-right">Application #1</label>
							<div class="control all-50">
								<s:textfield id="app1name" name="app1Name" value="%{applications[0].name}" />
							</div>
							<div class="all-30"></div>
						</div>
						
						<s:if test="applications.size > 1">
							<s:iterator value="applications" status="appCounter" begin="1">
								<s:div id="textbox%{#appCounter.count+1}" cssClass="control-group column-group gutters">
									<s:label for="app%{#appCounter.count+1}name" cssClass="all-20 align-right" value="Application #%{#appCounter.count+1}" />
									<div class="control all-50">
										<s:textfield id="app%{#appCounter.count+1}name" name="app%{#appCounter.count+1}Name" value="%{name}" />
									</div>
									<div class="all-5"><a class="remove_field">remove</a></div>
									<div class="all-25"></div>
								</s:div>
							</s:iterator>
						</s:if>
						
						<div class="column-group gutters">
							<div class="all-20"></div>
							<div class="all-80">
								<button class="ink-button all-25" id="addapplication">+ Add new application...</button>
							</div>
						</div>

						<div class="column-group gutters double-top-space">
							<div class="all-20"></div>
							<div class="all-80">
								<button class="ink-button all-25" type="submit">Submit</button>
							</div>
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
		$(document).ready(function()
		{
			var max_fields = 10; //maximum input boxes allowed
			var x = parseInt("<s:property value="applications.size"/>"); //initial text box count is the number of applications for this workload in the DB
			var wrapper = $("#textbox" + x); //Fields wrapper
			var add_button = $("#addapplication"); //Add button ID

			$("#editworkload").on("click", "#addapplication", function(e)
			{
				e.preventDefault();

				if (x < max_fields)
				{ //max input box allowed
					x++; //text box increment

					//add input box
					$(wrapper).after('<div id="textbox'+x+'" class="control-group column-group gutters">' + '<label for="app'+x+'name" class="all-20 align-right">Application #' + x + '</label>' + '<div class="control all-50">' + '<s:textfield id="app' + x + 'name" name="app' + x + 'Name" value="%{app' + x + 'Name}" />' + '</div>' + '<div class="all-5"><a class="remove_field">remove</a></div>' + '<div class="all-25"></div>' + '</div>');

					wrapper = $("#textbox" + x);

					if (x == max_fields)
						$('#addapplication').attr("disabled", true);
				}
			});

			$("#editworkload").on("click", ".remove_field", function(e) //user click on remove text
			{
				e.preventDefault();

				var parent = $(this).parent('div').parent('div');

				var n = $(parent).children('label').text().match(/[\d]/);
				$(parent).remove();

				var nextIndex = parseInt(n, 10);

				// update label text and respective div IDs
				$("label").slice(nextIndex).each(function(index)
				{
					$(this).text("Application #" + n);
					$(this).parent('div').attr('id', 'textbox' + n);
					n++;
				});

				x--;

				wrapper = $("#textbox" + x);

				$('#addapplication').attr("disabled", false);
			});
		});
	</script>
</body>
</html>