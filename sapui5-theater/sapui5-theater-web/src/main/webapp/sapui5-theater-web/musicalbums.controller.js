sap.ui.controller("sapui5-theater-web.musicalbums", {

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf test-xml.test-xml
*/
	onInit: function() {
		
		//Define some sample data 
		//TODO: move the data binding to an higher level
		var aAlbums = [
			{title: "As Heard on Radio Soulwax, Part 7", albumArtistCredits: "2 Many DJ’s", year: 2004, rating: -1},
			{title: "Born to Die: The Paradise Edition", albumArtistCredits: "Lana Del Rey", year: 2012, rating: 5},
			{title: "Ultraviolence", albumArtistCredits: "Lana Del Rey", year: 2014, rating: 4},			
			{title: "Birdy", albumArtistCredits: "Birdy", year: 2011, rating: 4},
			{title: "Fire Within", albumArtistCredits: "Birdy", year: 2013, rating: -1},
			{title: "Charango", albumArtistCredits: "Morcheeba", year: 2002, rating: 3}, ];
		
		var oModel = new sap.ui.model.json.JSONModel();
		oModel.setData({modelData: aAlbums});
		
	},

/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf test-xml.test-xml
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf test-xml.test-xml
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf test-xml.test-xml
*/
//	onExit: function() {
//
//	}

});