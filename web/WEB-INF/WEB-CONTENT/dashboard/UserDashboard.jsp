<%--
  Created by IntelliJ IDEA.
  User: hypo
  Date: 15-11-22
  Time: 上午12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="static/head.jsp"%>
<>
<%@include file="static/nav.jsp"%>
<%@include file="static/sideber.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
			<li class="active">Dashboard</li>
		</ol>
	</div><!--/.row-->
		
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">个人仪表盘</h3>
		</div>
	</div><!--/.row-->
        
	<div class="row">
		<div class="col-xs-12 col-md-6 col-lg-3">
			<div class="panel panel-blue panel-widget ">
				<div class="row no-padding">
					<div class="col-sm-3 col-lg-5 widget-left">
						<em class="glyphicon glyphicon-user glyphicon-l"></em>
					</div>
					<div class="col-sm-9 col-lg-7 widget-right">
						<div class="large">120</div>
						<div class="text-muted">个人事件进行数</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-md-6 col-lg-3">
			<div class="panel panel-orange panel-widget">
				<div class="row no-padding">
					<div class="col-sm-3 col-lg-5 widget-left">
						<em class="glyphicon glyphicon-briefcase glyphicon-l"></em>
					</div>
					<div class="col-sm-9 col-lg-7 widget-right">
						<div class="large">52</div>
						<div class="text-muted">团队任务进行数</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-md-6 col-lg-3">
			<div class="panel panel-teal panel-widget">
				<div class="row no-padding">
					<div class="col-sm-3 col-lg-5 widget-left">
						<em class="glyphicon glyphicon-ok glyphicon-l"></em>
					</div>
					<div class="col-sm-9 col-lg-7 widget-right">
						<div class="large">24</div>
						<div class="text-muted">已完成事件数</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-md-6 col-lg-3">
			<div class="panel panel-red panel-widget">
				<div class="row no-padding">
					<div class="col-sm-3 col-lg-5 widget-left">
						<em class="glyphicon glyphicon-stats glyphicon-l"></em>
					</div>
					<div class="col-sm-9 col-lg-7 widget-right">
						<div class="large">25.2k</div>
						<div class="text-muted">及时完成率</div>
					</div>
				</div>
			</div>
		</div>
	</div><!--/.row-->
		
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">往期月完成事件数</div>
				<div class="panel-body">
					<div class="canvas-wrapper">
						<canvas class="main-chart" id="line-chart" height="200" width="600"></canvas>
					</div>
				</div>
			</div>
		</div>
	</div><!--/.row-->
		
	<div class="row">
		<div class="col-xs-6 col-md-3">
			<div class="panel panel-default">
				<div class="panel-body easypiechart-panel">
					<h4>提前完成率</h4>
					<div class="easypiechart" id="easypiechart-blue" data-percent="92" ><span class="percent">92%</span>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-6 col-md-3">
			<div class="panel panel-default">
				<div class="panel-body easypiechart-panel">
					<h4>正常完成率</h4>
					<div class="easypiechart" id="easypiechart-orange" data-percent="65" ><span class="percent">65%</span>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-6 col-md-3">
			<div class="panel panel-default">
				<div class="panel-body easypiechart-panel">
					<h4>延迟完成率</h4>
					<div class="easypiechart" id="easypiechart-teal" data-percent="56" ><span class="percent">56%</span>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-6 col-md-3">
			<div class="panel panel-default">
				<div class="panel-body easypiechart-panel">
					<h4>计划死亡率</h4>
					<div class="easypiechart" id="easypiechart-red" data-percent="27" ><span class="percent">27%</span>
					</div>
				</div>
			</div>
		</div>
	</div><!--/.row-->
</div>	<!--/.main-->
<div class="row">
	<div class="col-lg-12" style="border-top:1px solid #cfcfcf;margin-top: 30px;">
		<footer style="padding-left: 10%; padding-top: 15px;">
			<center>
				<p>SpongeTime designed and built with all the love in the world by
					<a href="http://www.ihypo.net" target="_blank"> @hhHypo</a> and
					<a href="https://github.com/blf2" target="_blank"> @BLF2</a>.</p>
				<p>本项目开源并受 <a href="https://github.com/Coderhypo/SpongeTime/blob/master/LICENSE" target="_blank"> MIT</a> 开源协议保护，
					项目源码获取：<a href="https://github.com/Coderhypo/SpongeTime" target="_blank"> CoderHypo/SpongeTime</a>。</p>
				<p>欢迎start，欢迎fork，欢迎<a href="#" target="_blank">反馈</a>！</p>
				<p>&copy; SpongeTime v0.1 BETA</p>
			</center>
		</footer>
	</div>
</div>
<script src="/static/js/jquery-1.11.1.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/chart.min.js"></script>
<script src="/static/js/chart-data.js"></script>
<script src="/static/js/easypiechart.js"></script>
<script src="/static/js/easypiechart-data.js"></script>
<script src="/static/js/bootstrap-datepicker.js"></script>
<script>
	$('#calendar').datepicker({
	});

	!function ($) {
		$(document).on("click","ul.nav li.parent > a > span.icon", function(){
			$(this).find('em:first').toggleClass("glyphicon-minus");
		});
		$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
	}(window.jQuery);

	$(window).on('resize', function () {
		if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
	})
	$(window).on('resize', function () {
		if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
	})
</script>
</body>

</html>
