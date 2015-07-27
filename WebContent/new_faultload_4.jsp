<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Create new faultload [4/4]</title>
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
				FAULT INJECTOR<small>Create new faultload</small>
			</h1>

			<div class="column-group">
				<div class="all-85">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green">
							<li><a href="loadexperiments">Home</a></li>
							<li><a href="loadfaultloads">New experiment [4/4]</a></li>
							<li class="active"><a href="#">New faultload [4/4]</a></li>
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
				<h2 class="bottom-space">Create new faultload [4/4]</h2>
			</div>
		</div>

		<div class="column-group">
			<div class="all-100">
				<form action="createfaultload4" id="page_4" class="ink-form all-100 small-100 tiny-100" method="post">
					<div class="column-group">
						<div class="all-20"></div>
						<div class="all-80">
							<fieldset>
								<legend class="bottom-space">2.1 Fault trigger</legend>
							</fieldset>
						</div>
					</div>

					<fieldset>
						<div class="control-group column-group gutters required">
							<p class="label all-20 align-right push-middle">Mode</p>
							<ul class="control unstyled all-80 inline">
<%-- 								<s:if test="%{!#session.faultloadBean.kernelMode}"> --%>
<!-- 									<li><input type="radio" id="kernel" name="faultMode" value="true"><label for="kernel">kernel</label></li> -->
<!-- 									<li><input type="radio" id="user" name="faultMode" value="false" checked><label for="user">user</label></li> -->
<%-- 								</s:if> --%>
<%-- 								<s:else> --%>
<!-- 									<li><input type="radio" id="kernel" name="faultMode" value="true" checked><label for="kernel">kernel</label></li> -->
<!-- 									<li><input type="radio" id="user" name="faultMode" value="false"><label for="user">user</label></li> -->
<%-- 								</s:else> --%>
								<li><s:radio label="faultmode" name="faultModeId" list="faultModes" listKey="faultModeId" listValue="name" value="defaultFaultModeId" /></li>
							</ul>
						</div>

						<div class="control-group column-group gutters required">
							<label for="processid" class="all-20 align-right">Process ID</label>
							<div class="control all-15">
								<s:textfield id="processid" name="processId" value="%{#session.faultloadBean.processId}" />
							</div>
							<div class="all-70"></div>
						</div>
					</fieldset>

					<div class="column-group">
						<div class="all-20"></div>
						<div class="all-80">
							<fieldset>
								<legend>2.2 Fault trigger type</legend>
								<div class="control-group">
									<ul id="triggertype" class="control unstyled">
										<li class="column-group quarter-gutters">
											<div class="all-30 large push-bottom">
												<input type="radio" id="temporal" name="triggerType" value="tp" checked><label for="temporal">temporal between</label>
											</div>
											<div class="all-15">
												<!-- 			                                        <input type="text" id="timestart" name="timeStart" value="%{#session.faultloadBean.temporalTriggerStart}" class="all-66 quarter-right-space"><label for="timestart" class="all-33">and</label> -->
												<s:textfield id="timestart" name="timeStart" value="%{#session.faultloadBean.temporalTriggerStart}" cssClass="all-66 quarter-right-space" />
												<label for="timestart" class="all-33">and</label>
											</div>
											<div class="all-15">
												<!-- 			                                        <input type="text" id="timeend" name="timeEnd" value="%{#session.faultloadBean.temporalTriggerEnd}" class="all-66 quarter-right-space"><label for="timeend" class="all-33">ms</label> -->
												<s:textfield id="timeend" name="timeEnd" value="%{#session.faultloadBean.temporalTriggerEnd}" cssClass="all-66 quarter-right-space" />
												<label for="timeend" class="all-33">ms</label>
											</div>
										</li>
										<li class="column-group quarter-gutters">
											<div class="all-30 large push-bottom">
												<input type="radio" id="spatialcode" name="triggerType" value="sc"><label for="spatialcode">spatial (code segment)</label>
											</div>
											<div class="all-10">
												<s:select label="spatial (code segment)" id="accesscode" list="accessTypes" name="accessCode" cssClass="all-100" value="%{#session.faultloadBean.readAddress}" disabled="true" />
											</div>
											<div class="all-20">
												<label for="codeaddress" class="all-50 quarter-right-space">address</label><input type="text" id="codeaddress" name="codeAddress" value="" class="all-50" disabled>
											</div>
										</li>
										<li class="column-group quarter-gutters">
											<div class="all-30 large push-bottom">
												<input type="radio" id="spatialdata" name="triggerType" value="sd"><label for="spatialdata">spatial (data segment)</label>
											</div>
											<div class="all-10">
												<s:select label="spatial (data segment)" id="accessdata" list="accessTypes" name="accessData" cssClass="all-100" disabled="true" />
											</div>
											<div class="all-20">
												<label for="dataaddress" class="all-50 quarter-right-space">address</label><input type="text" id="dataaddress" name="dataAddress" value="" class="all-50" disabled>
											</div>
										</li>
									</ul>
								</div>
							</fieldset>
						</div>
					</div>

					<fieldset>
						<div class="column-group">
							<div class="all-20"></div>
							<div class="all-50">
								<div class="column-group">
									<div class="all-50 align-left">
										<a href="createfaultload22" class="ink-button all-95">&lt; Previous</a>
									</div>
									<div class="all-50 align-right">
										<button class="ink-button all-95" type="submit" id="finish" disabled>Finish</button>
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
		var check21, check22;
		
		if ($('#processid').val().match(/^\d+$/) && $('#processid').val() > 0)
			check21 = "true";
		else
			check21 = "false";

		var option = $('input[name=triggerType]:checked').val();

		switch (option)
		{
			case 'tp':
			{
				$('#timestart').attr("disabled", false);
				$('#timeend').attr("disabled", false);
				$('#accesscode').attr("disabled", true);
				$('#codeaddress').attr("disabled", true);
				$('#accessdata').attr("disabled", true);
				$('#dataaddress').attr("disabled", true);

				if ($('#timestart').val().match(/^\d+$/) && $('#timestart').val() > 0 && $('#timeend').val().match(/^\d+$/) && $('#timeend').val() > 0 && (parseInt($('#timestart').val()) < parseInt($('#timeend').val())))
					check22 = "true";
				else
					check22 = "false";
				break;
			}
			case 'sc':
			{
				$('#timestart').attr("disabled", true);
				$('#timeend').attr("disabled", true);
				$('#accesscode').attr("disabled", false);
				$('#codeaddress').attr("disabled", false);
				$('#accessdata').attr("disabled", true);
				$('#dataaddress').attr("disabled", true);

				if ($('#codeaddress').val().match(/^\d+$/) && $('#codeaddress').val() > 0)
					check22 = "true";
				else
					check22 = "false";
				break;
			}
			case 'sd':
			{
				$('#timestart').attr("disabled", true);
				$('#timeend').attr("disabled", true);
				$('#accesscode').attr("disabled", true);
				$('#codeaddress').attr("disabled", true);
				$('#accessdata').attr("disabled", false);
				$('#dataaddress').attr("disabled", false);

				if ($('#dataaddress').val().match(/^\d+$/) && $('#dataaddress').val() > 0)
					check22 = "true";
				else
					check22 = "false";
				break;
			}
		}

		if (check21 == "true" && check22 == "true")
			$('#finish').attr("disabled", false);
		else
			$('#finish').attr("disabled", true);

		$("#page_4, .triggerType").on("input change", function() {
			if ($('#processid').val().match(/^\d+$/) && $('#processid').val() > 0)
				check21 = "true";
			else
				check21 = "false";

			var option = $('input[name=triggerType]:checked').val();

			switch (option)
			{
				case 'tp':
				{
					$('#timestart').attr("disabled", false);
					$('#timeend').attr("disabled", false);
					$('#accesscode').attr("disabled", true);
					$('#codeaddress').attr("disabled", true);
					$('#accessdata').attr("disabled", true);
					$('#dataaddress').attr("disabled", true);
	
					if ($('#timestart').val().match(/^\d+$/) && $('#timestart').val() >= 0 && $('#timeend').val().match(/^\d+$/) && $('#timeend').val() >= 0 && (parseInt($('#timestart').val()) <= parseInt($('#timeend').val())))
						check22 = "true";
					else
						check22 = "false";
					break;
				}
				case 'sc':
				{
					$('#timestart').attr("disabled", true);
					$('#timeend').attr("disabled", true);
					$('#accesscode').attr("disabled", false);
					$('#codeaddress').attr("disabled", false);
					$('#accessdata').attr("disabled", true);
					$('#dataaddress').attr("disabled", true);
	
					if ($('#codeaddress').val().match(/^\d+$/) && $('#codeaddress').val() > 0)
						check22 = "true";
					else
						check22 = "false";
					break;
				}
				case 'sd':
				{
					$('#timestart').attr("disabled", true);
					$('#timeend').attr("disabled", true);
					$('#accesscode').attr("disabled", true);
					$('#codeaddress').attr("disabled", true);
					$('#accessdata').attr("disabled", false);
					$('#dataaddress').attr("disabled", false);
	
					if ($('#dataaddress').val().match(/^\d+$/) && $('#dataaddress').val() > 0)
						check22 = "true";
					else
						check22 = "false";
					break;
				}
			}

			if (check21 == "true" && check22 == "true")
				$('#finish').attr("disabled", false);
			else
				$('#finish').attr("disabled", true);
		});
	</script>
</body>
</html>