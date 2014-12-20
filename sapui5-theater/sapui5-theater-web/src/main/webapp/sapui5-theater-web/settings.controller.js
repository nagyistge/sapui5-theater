sap.ui.controller("sapui5-theater-web.settings", {

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf test-xml.test-xml
*/
	onInit: function() {

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
	
	onCheckSettings : function() {
		jQuery.sap.require("sap.ui.commons.MessageBox");
		var kodiURL = "http://192.168.1.251";
		var data = {"jsonrpc": "2.0", "method": "Application.GetProperties", "params": {"properties": ["volume"]}, "id": 1};
		$.getJSON( kodiURL, data)
			.done(function() {
				console.log("Call OK");
			})
			.fail(function() {
				console.log("Call KO")
			});
		sap.ui.commons.MessageBox.show("Check settings button", sap.ui.commons.MessageBox.Icon.ERROR);
	},

	onImportTestData : function() {
		jQuery.sap.require("sap.ui.commons.MessageBox");
		sap.ui.commons.MessageBox.show("Import test data", sap.ui.commons.MessageBox.Icon.SUCCESS);
	},

});