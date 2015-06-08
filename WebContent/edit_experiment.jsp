<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Edit experiment</title>
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
	Modernizr.load({
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
				FAULT INJECTOR<small>Edit experiment</small>
			</h1>

			<div class="column-group">
				<div class="all-85">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green">
							<li><a href="loadexperiments">Home</a></li>
							<li class="active"><a href="#">Edit experiment</a></li>
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
			<div class="all-80">
				<h2 class="bottom-space">Edit experiment</h2>
			</div>
		</div>
		<div class="column-group">
			<div class="all-100">
				<form action="saveexperiment" class="ink-form all-100 small-100 tiny-100" method="post">
					<fieldset>
						<s:hidden name="id" value="%{experiment.exp_id}" />

						<div class="control-group column-group gutters required">
							<label for="name" class="all-20 align-right">Name</label>
							<div class="control all-50">
								<!-- <input type="text" id="name" name="name"> -->
								<s:textfield id="name" name="name" value="%{experiment.name}" />
							</div>
							<div class="all-30"></div>
						</div>

						<div class="control-group column-group gutters required">
							<label for="creatorname" class="all-20 align-right">Creator name</label>
							<div class="control all-50">
								<!-- <input type="text" id="creatorname" name="creatorName"> -->
								<s:textfield id="creatorname" name="creatorName" value="%{experiment.user.name}" disabled="true"/>
							</div>
							<div class="all-30"></div>
						</div>

						<div class="control-group column-group gutters">
							<label for="creationdate" class="all-20 align-right">Creation date</label>
							<div class="control all-50">
								<!-- <input type="text" id="creationdate" name="creationDate"> -->
								<s:textfield id="creationdate" disabled="true" value="%{experiment.creation_date}" />
							</div>
							<div class="all-30"></div>
						</div>

						<div class="control-group column-group gutters">
							<label for="injectiondate" class="all-20 align-right">Injection date</label>
							<div class="control all-50">
								<s:textfield id="injectiondate" disabled="true" value="%{experiment.injection_date}" />
							</div>
							<div class="all-30"></div>
						</div>

						<div class="control-group column-group gutters required">
							<label for="targetname" class="all-20 align-right">Target name</label>
							<div class="control all-50">
								<!-- <input type="text" id="targetname" name="targetName"> -->
								<s:textfield id="targetname" name="targetName" value="%{experiment.target.name}" />
							</div>
							<%-- 	                            <a href="<s:url action="edittarget"><s:param name="id"><s:property value="experiment.target.target_id"/></s:param></s:url>" class="ink-button all-10">Edit...</a> --%>
							<div class="all-20"></div>
						</div>

						<s:if test="faultloads.size > 0">
							<s:iterator value="faultloads">
								<div class="control-group column-group gutters required">
									<label for="faultloadname" class="all-20 align-right">Faultload name</label>
									<div class="control all-50">
										<!-- <input type="text" id="faultloadname" name="faultloadName"> -->
										<s:textfield id="faultloadname" name="faultloadName" value="%{name}" />
									</div>
									<div class="all-30"></div>
								</div>

								<s:if test="injectionRuns.size > 0">
									<s:iterator value="injectionRuns">
										<div class="control-group column-group gutters required">
											<label for="workloadname" class="all-20 align-right">Workload name</label>
											<div class="control all-50">
												<!-- <input type="text" id="workloadname" name="workloadName"> -->
												<s:textfield id="workloadname" name="workloadName" value="%{workload.name}" />
											</div>
											<div class="control all-30"></div>
										</div>

										<div class="control-group column-group gutters required">
											<label for="outputfilename" class="all-20 align-right">Output filename</label>
											<div class="control all-50">
												<!-- <input type="text" id="outputfilename" name="outputFilename"> -->
												<s:textfield id="outputfilename" name="outputFilename" value="%{output_filename}" disabled="true" />
											</div>
											<div class="all-30"></div>
										</div>
									</s:iterator>
								</s:if>
							</s:iterator>
						</s:if>

						<div class="control-group column-group gutters required">
							<label for="description" class="all-20 align-right">Description</label>
							<div class="control all-50">
								<!-- <textarea id="description" name="description"></textarea> -->
								<s:textarea id="description" name="description" rows="5" maxlength="300" value="%{experiment.description}" />
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
