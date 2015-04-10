sap.ui.controller("sapui5-theater-web.musicalbums", {

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf test-xml.test-xml
*/
	onInit: function() {
		var sOrigin = window.location.protocol + "//"
				+ window.location.hostname
				+ (window.location.port ? ":" + window.location.port : "");
		var albumsListOdataServiceUrl = sOrigin
				+ "/sapui5-theater-web/theater.svc/";
		var odataModel = new sap.ui.model.odata.ODataModel(
				albumsListOdataServiceUrl);
		odataModel.setCountSupported(false);
		this.getView().setModel(odataModel);
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