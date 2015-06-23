<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body onload="initTmap()">
	<script>
		//초기화 함수
		
		
		function initTmap() {
			centerLL = new Tmap.LonLat(14145677.4, 4511257.6);
			map = new Tmap.Map({
				div : 'map_div',
				width : '100%',
				height : '400px',
				transitionEffect : "resize",
				animation : true
			});
			
			
		    map.setCenter(new Tmap.LonLat(14135911, 4518361),15);
		    var c_ll = map.getCenter();
			searchRoute();
			loadGetAddressFromLonLat(c_ll);
			
			map.events.register("click", map, onClickMap)
		};
		
		
		//경로 정보 로드
		function searchRoute() {
			var routeFormat = new Tmap.Format.KML({
				extractStyles : true,
				extractAttributes : true
			});
			var startX = 14129105.461214;
			var startY = 4517042.1926406;
			var endX = 14136027.789587;
			var endY = 4517572.4745242;
			var urlStr = "https://apis.skplanetx.com/tmap/routes?version=1&format=xml";
			urlStr += "&startX=" + startX;
			urlStr += "&startY=" + startY;
			urlStr += "&endX=" + endX;
			urlStr += "&endY=" + endY;
			urlStr += "&appKey=06296168-a5d4-3a11-bfe0-d178d3db6ccd";
			var prtcl = new Tmap.Protocol.HTTP({
				url : urlStr,
				format : routeFormat
			});
			var routeLayer = new Tmap.Layer.Vector("route", {
				protocol : prtcl,
				strategies : [ new Tmap.Strategy.Fixed() ]
			});
			routeLayer.events.register("featuresadded", routeLayer,
					onDrawnFeatures);
			map.addLayer(routeLayer);
		}
		//경로 그리기 후 해당영역으로 줌
		function onDrawnFeatures(e) {
			map.zoomToExtent(this.getDataExtent());
		}

		function onClickMap(evt) {
			/* var lonlat = map.getLonLatFromViewPortPx(evt.xy); */
			LonLatFromPixel(evt.clientX, evt.clientY)
			/* alert("clientX = " + evt.clientX);
			alert("clientY = " + evt.clientY); */
		}
		
		function LonLatFromPixel(x, y) {
			alert(map.getLonLatFromPixel(new Tmap.Pixel(x, y)));
			
			loadGetAddressFromLonLat(map.getLonLatFromPixel(new Tmap.Pixel(x, y)));
			/* CreateMarker(x,y); */
		}
		function loadGetAddressFromLonLat(ll){
			var tdata = new Tmap.TData();
			        tdata.events.register("onComplete", tdata, onCompleteLoadGetAddressFromLonLat);   
			        tdata.getAddressFromLonLat("06296168-a5d4-3a11-bfe0-d178d3db6ccd","xml",'1',ll);
			}
			function onCompleteLoadGetAddressFromLonLat(){
			        console.log(this.responseXML);
			        alert(jQuery(this.responseXML).find("fullAddress").text());
			}
		
	</script>
	<script language="javascript"
		src="https://apis.skplanetx.com/tmap/js?version=1&format=javascript&appKey=06296168-a5d4-3a11-bfe0-d178d3db6ccd"></script>




	<div id="map_div"></div>

</body>
</html>