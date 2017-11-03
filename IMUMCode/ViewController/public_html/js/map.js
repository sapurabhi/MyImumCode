var map,pvtSymb;
//alert("loading");      
function loadMap(long,lat) {
 // alert("loadMap1"); 
  //alert("event::::"+long);
    //alert("event::::"+lat);
  //alert("longitude"+evt.getSource().getProperty("long"));
  //alert("latitude"+evt.getSource().getProperty("lat"));
  
   require([
            "esri/map",
            "esri/layers/ArcGISDynamicMapServiceLayer",
            "esri/geometry/webMercatorUtils", "dojo/dom", "esri/geometry",
            "dojo/domReady!",
            "esri/symbols/SimpleMarkerSymbol",
            "esri/symbols/SimpleLineSymbol",
            "esri/symbols/PictureMarkerSymbol",
            "esri/Color"
    ], function (Map, ArcGISDynamicMapServiceLayer, webMercatorUtils, dom) {

        var spatialRef = new esri.SpatialReference({ wkid: 4326 });
        var startExtent = new esri.geometry.Extent();
        startExtent.xmin = 54.3246;
        startExtent.ymin = 24.4155;
        startExtent.xmax = 54.4455;
        startExtent.ymax = 24.4942;
        startExtent.spatialReference = spatialRef;
     
        map = new Map("map_Div", {
            sliderOrientation: "horizontal",          
            extent: startExtent          
        });
        //Takes a URL to a non cached map service.
        var dynamicMapServiceLayer = new ArcGISDynamicMapServiceLayer("http://www.darb.ae/arcgis/rest/services/BaseMaps/DOT_StreetMap_En/MapServer", {
            "opacity": 5.5
        });
 
        map.on("load", function () {
        addPVTSymbol();
//        long = evt.getSource().getProperty("long"); 
//        lat = evt.getSource().getProperty("lat");
      var graphic = new esri.Graphic(
                   new esri.geometry.Point( long,lat, map.spatialReference),
                  new esri.symbol.PictureMarkerSymbol(pvtSymb)
                 );
            map.graphics.add(graphic);
         
        });

        map.addLayer(dynamicMapServiceLayer);
       });         
      
}

function addPVTSymbol() {
    //alert("addPVTSymbol");
    pvtSymb = new esri.symbol.PictureMarkerSymbol({
        "angle": 0,
        "xoffset": 0,
        "yoffset": 0,
        "type": "esriPMS",
        "url": "http://static.arcgis.com/images/Symbols/Transportation/CarRedBack.png",
        "contentType": "image/png",
        "width": 24,
        "height": 24
    });
//alert("loadMap-last"); 
}

