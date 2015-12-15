window.onload = function(){
		  //create map
		 var singapoerCenter=new google.maps.LatLng(12.5, 77.9);
		 var myOptions = {
		  	zoom: 10,
		  	center: singapoerCenter,
		  	mapTypeId: google.maps.MapTypeId.ROADMAP
		  };
		 map = new google.maps.Map(document.getElementById('main-map'), myOptions);
		 
		 var creator = new PolygonCreator(map);
		 
		 //reset
		 $('#reset').click(function(){ 
		 		creator.destroy();
		 		creator=null;
		 		
		 		creator=new PolygonCreator(map);
		 });		 
		 
		 
		 //show paths
		 $('#showData').click(function(){ 
			 var coords = creator.pen.polygon.coords;
			 var value = coords[0];
			 var value1 = coords[2];
			 var coordinates = ({"lat1":value.B,"lng1":value.k,"lat2":value1.B,"lng2":value1.k});
			 document.getElementById("form:coords").value = JSON.stringify(coordinates);
		 });
	};