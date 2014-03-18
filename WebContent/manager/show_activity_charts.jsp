<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		changeNavTo("show_activity_charts");
        $('#daysum_chart').highcharts({
            title: {
                text: '最近十天人数变化趋势',
                x: -20 //center
            },
            xAxis: {
                categories: JSON.parse('<s:property escape="false" value="daysumCategory"/>')
            },
            yAxis: {
                title: {
                    text: '人数 (个)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '°C'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '人数',
                data: JSON.parse('<s:property escape="false" value="daysumData" />')
            }]
        });
        $('#place_chart').highcharts({
            chart: {
                type: 'column',
                margin: [ 50, 50, 100, 80]
            },
            title: {
                text: '场地使用情况'
            },
            xAxis: {
                categories: JSON.parse('<s:property escape="false" value="placeCategory" />'),
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '活动数量'
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                pointFormat: 'Population in 2008: <b>{point.y:.1f} millions</b>',
            },
            series: [{
                name: 'Population',
                data: JSON.parse('<s:property escape="false" value="placeData" />'),
                dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif',
                        textShadow: '0 0 3px black'
                    }
                }
            }]
        });
        $('#coach_chart').highcharts({
            chart: {
                type: 'column',
                margin: [ 50, 50, 100, 80]
            },
            title: {
                text: '教练使用情况'
            },
            xAxis: {
                categories: JSON.parse('<s:property escape="false" value="coachCategory" />'),
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '活动数量'
                }
            },
            legend: {
                enabled: false
            },
            tooltip: {
                pointFormat: 'Population in 2008: <b>{point.y:.1f} millions</b>',
            },
            series: [{
                name: 'Population',
                data: JSON.parse('<s:property escape="false" value="coachData" />'),
                dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif',
                        textShadow: '0 0 3px black'
                    }
                }
            }]
        });
	});
</script>
<title></title>
</head>
<body>
<div id="main">
	<jsp:include page="nav.jsp"/>
	<div id="site_content">
		<div id="daysum_chart"></div>
		<div id="place_chart"></div>
		<div id="coach_chart"></div>
	</div>
	<jsp:include page="../footer.jsp"/>
</div>
</body>
</html>