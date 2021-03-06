<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Edit target</title>
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
				FAULT INJECTOR<small>Edit target</small>
			</h1>

			<div class="column-group">
				<div class="all-85">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green">
							<li><a href="loadexperiments">Home</a></li>
							<li><a href="loadtargets">New experiment [2/4]</a></li>
							<li class="active"><a href="#">Edit target</a></li>
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
				<h2 class="bottom-space">Edit target</h2>
			</div>
		</div>
		<div class="column-group">
			<div class="all-100">
				<form action="savetarget" class="ink-form all-100 small-100 tiny-100" method="post">
					<fieldset>
						<s:hidden name="id" value="%{target.targetId}" />

						<div class="control-group column-group gutters required">
							<label for="name" class="all-20 align-right">Name</label>
							<div class="control all-50">
								<s:textfield id="name" name="name" value="%{target.name}" />
							</div>
							<div class="all-30"></div>
						</div>

						<div class="control-group column-group gutters">
							<p class="label all-20 align-right push-middle">Architecture</p>
							<ul class="control unstyled all-80 inline">
								<li><s:radio label="architectures" name="architectureId" list="architectures" listKey="architectureId" listValue="name" value="architectureId"/></li>
							</ul>
						</div>

						<div class="column-group all-50">
							<div class="control-group all-50 required">
								<div class="column-group gutters">
									<label for="ip1" class="all-75 align-right">IP address</label>
									<div class="control all-25">
										<s:textfield id="ip1" name="ip1" value="%{ip1}" />
									</div>
								</div>
							</div>
							<div class="control-group all-10">
								<div class="column-group">
									<label for="ip2" class="all-20 align-center">.</label>
									<div class="control all-80">
										<s:textfield id="ip2" name="ip2" value="%{ip2}" />
									</div>
								</div>
							</div>
							<div class="control-group all-10">
								<div class="column-group">
									<label for="ip3" class="all-20 align-center">.</label>
									<div class="control all-80">
										<s:textfield id="ip3" name="ip3" value="%{ip3}" />
									</div>
								</div>
							</div>
							<div class="control-group all-10">
								<div class="column-group">
									<label for="ip4" class="all-20 align-center">.</label>
									<div class="control all-80">
										<s:textfield id="ip4" name="ip4" value="%{ip4}" />
									</div>
								</div>
							</div>
							<div class="all-20"></div>
						</div>

						<div class="control-group column-group gutters required">
							<label for="operatingsystem" class="all-20 align-right">Operating system</label>
							<div class="control all-50">
								<s:textfield id="operatingsystem" name="operatingSystem" value="%{target.operatingSystem}" />
							</div>
							<div class="all-30"></div>
						</div>

						<div class="column-group gutters">
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
</body>
</html>