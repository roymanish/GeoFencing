
function createMarkers(locationList){

	var markers=[];
	for(var i = 0; i< locationList.length; i++){

		var values = locationList[i].split("/");

		markers.push({"title":values[0],"lat":values[1],"lng":values[2],"description":values[3]});

	}
	return markers;
}
function showMap() {
	var vehicleName = document.getElementById("form:tabView:vehicleName").value;
	var locationList = document.getElementById("form:tabView:markers").value.split("?");
	var markers = createMarkers(locationList);
	var mapOptions = {
			center : new google.maps.LatLng(markers[0].lat, markers[0].lng),
			zoom : 10,
			mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("dvMap"), mapOptions);
	var infoWindow = new google.maps.InfoWindow();
	var lat_lng = new Array();
	var latlngbounds = new google.maps.LatLngBounds();
	for (i = 0; i < markers.length; i++) {
		var data = markers[i]
		var myLatlng = new google.maps.LatLng(data.lat, data.lng);
		if(vehicleName == data.title){
			lat_lng.push(myLatlng);
		}
		var marker = new google.maps.Marker({
			position : myLatlng,
			map : map,
			title : data.title
		});
		latlngbounds.extend(marker.position);
		(function (marker, data) {
			google.maps.event.addListener(marker, "click", function (e) {
				infoWindow.setContent(data.description);
				infoWindow.open(map, marker);
			});
		})(marker, data);
	}
	map.setCenter(latlngbounds.getCenter());
	map.fitBounds(latlngbounds);

//	***********ROUTING****************//

//	Intialize the Path Array
	var path = new google.maps.MVCArray();

//	Intialize the Direction Service
	var service = new google.maps.DirectionsService();

//	Set the Path Stroke Color

//	Loop and Draw Path Route between the Points on MAP
	for (var i = 0; i < lat_lng.length; i++) {
		if ((i + 1) < lat_lng.length) {
			var src = lat_lng[i];
			var des = lat_lng[i + 1];
			path.push(src);
			var poly = new google.maps.Polyline({
				map : map,
				strokeColor : getRandomColor()
			});
			poly.setPath(path);
			service.route({
				origin : src,
				destination : des,
				travelMode : google.maps.DirectionsTravelMode.DRIVING
			}, function (result, status) {
				if (status == google.maps.DirectionsStatus.OK) {
					for (var i = 0, len = result.routes[0].overview_path.length; i < len; i++) {
						path.push(result.routes[0].overview_path[i]);
					}
				}
			});
		}
	}
	document.getElementById("dvMap").style.visibility="";
}
function getRandomColor() {
	var letters = '0123456789ABCDEF'.split('');
	var color = '#';
	for (var i = 0; i < 6; i++ ) {
		color += letters[Math.floor(Math.random() * 16)];
	}
	return color;
}