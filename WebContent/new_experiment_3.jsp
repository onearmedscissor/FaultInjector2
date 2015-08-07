<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Fault Injector: Create new experiment [3/4]</title>
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
				FAULT INJECTOR<small>Create new experiment</small>
			</h1>

			<div class="column-group">
				<div class="all-85">
					<nav class="ink-navigation">
						<ul class="breadcrumbs green">
							<li><a href="loadexperiments">Home</a></li>
							<li class="active"><a href="#">New experiment [3/4]</a></li>
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
			<div class="all-100">
				<h2 class="bottom-space">Create new experiment [3/4]</h2>
				<table class="ink-table dynamicTable">
					<thead>
						<tr>
							<th class="align-left all-50 large">Select the workload to use:</th>
							<th class="all-15"></th>
							<th class="all-15"></th>
							<th class="all-15"></th>
							<th class="all-5"></th>
						</tr>
					</thead>
					<tbody>
						<s:if test="workloads.size > 0">
							<s:iterator value="workloads">
								<s:if test="#session.experimentBean.workloadId == workloadId">
									<tr id="<s:property value="workloadId"/>" class="highlight">
								</s:if>
								<s:else>
									<tr id="<s:property value="workloadId"/>">
								</s:else>
									<td><a href="<s:url action="showworkload"><s:param name="id"><s:property value="workloadId"/></s:param></s:url>" class="large all-100"><s:property value="name" /></a></td>
									<td><a class="select ink-button all-100">select</a></td>
									<td><a href="<s:url action="editworkload"><s:param name="id"><s:property value="workloadId"/></s:param></s:url>" class="ink-button all-100">edit</a></td>
									<td><a href="<s:url action="deleteworkload"><s:param name="id"><s:property value="workloadId"/></s:param></s:url>" class="ink-button all-100 delete">delete</a></td>
									<td class="align-center"><a class="help all-100">?</a></td>
								</tr>
							</s:iterator>
						</s:if>
					</tbody>
				</table>

				<div id="confirm-delete" class="ink-alert block" role="alert" style="display: none">
				    <h4>Confirm delete: do you really want to delete this workload?</h4>
				    <button id="no" class="ink-button quarter-space all-20">Cancel</button>
	                <button id="yes" class="ink-button quarter-space all-20">Confirm</button>
				</div>

				<div id="help-workloads" class="ink-alert block info" role="alert" style="display: none">
					<button class="ink-dismiss">&times;</button>
					<h4>Workload options menu</h4>
					<p>Here you can select, view details, edit or delete previously created workloads, or alternatively create a new one. To select a workload, click on the corresponding row on the table above.</p>
					<!-- 					    <p>To select a workload, please click the corresponding row in the table above. To view the details of a workload, click on its name. To edit a workload, you must click on the corresponding "edit" link. The same applies to the "delete" option. Finally, you can create a new workload by hitting the "Create new workload..." button, below the table.</p> -->
					<!-- 					    <p><b>Note:</b> To be able to proceed and finish the creation of a new experiment, you must select a workload to use, either an existent or a new one.</p> -->
				</div>

				<a href="new_workload.jsp" class="ink-button all-20" id="newworkload">Create new workload...</a>
				<div class="column-group push-center">
					<button class="ink-button double-vertical-space all-25" id="previous">&lt; Previous</button>
					<button class="ink-button double-vertical-space all-25 dynamicButton" id="next" disabled>Next &gt;</button>
				</div>
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
			$('.delete').click(function(e)
			{
				e.preventDefault();
				e.stopPropagation();
				var href = $(this).attr('href');
				$('#confirm-delete').show();

				$('#yes').click(function(event)
				{
					window.location.href = href;
					$('#confirm-delete').hide();
				});
				
				$('#no').click(function(event)
				{
					$('#confirm-delete').hide();
				});
			});

			$('.help').click(function(event)
			{
				$('#help-workloads').show();
			});
		});
	</script>

	<script type="text/javascript">
		$('#previous').click(function(event)
		{
			var wid = $('.highlight').attr("id");

			$.ajax(
			{
				method : "POST",
				url : "createexperiment3backward.action",
				data :
				{
					wid : wid
				},
				success : function()
				{
					window.location = "loadtargets.action";
				}
			});
		});

		$('#next').click(function(event)
		{
			var wid = $('.highlight').attr("id");

			$.ajax(
			{
				method : "POST",
				url : "createexperiment3forward.action",
				data :
				{
					wid : wid
				},
				success : function()
				{
					window.location = "loadfaultloads.action";
				}
			});
		});
	</script>
</body>
</html>