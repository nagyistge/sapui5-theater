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
		//var kodiDestination = "/kodiweb"
		var weatherURL = "/openweathermap?q=:Lisbon"
		var oModel = new sap.ui.model.json.JSONModel();
        oModel.loadData(weatherURL, null, false);
        //this.setModel(oModel)
        //console.log("/name")
		//var commandJSON = {"jsonrpc": "2.0", "method": "Application.GetProperties", "params": {"properties": ["volume"]}, "id": 1};
		//console.log(JSON.stringify(commandJSON));
		//var kodiURL = kodiDestination + JSON.stringify(commandJSON);
		$.getJSON( weatherURL )
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

	onTestAlbumInspector : function() {
		jQuery.sap.require("sap.ui.commons.MessageBox");
		//Helper function to easier create a Matrixlayout
		function row(sLabel, sText, sUrl) {
			var oControl;
			if(!sUrl){
				oControl = new sap.ui.commons.TextView({
					text: sText,
					tooltip: sText
				});
			}else{
				oControl = new sap.ui.commons.Link({
					text: sText,
					href: sUrl,
					tooltip: sText,
					target: "_blank"
				});
			}

			var oLabel = new sap.ui.commons.Label({
				text: sLabel + ":",
				labelFor: oControl
			});

			var oMLCell1 = new sap.ui.commons.layout.MatrixLayoutCell({
				hAlign : sap.ui.commons.layout.HAlign.End,
				vAlign : sap.ui.commons.layout.VAlign.Top,
				content : [ oLabel ]
			});
			var oMLCell2 = new sap.ui.commons.layout.MatrixLayoutCell({
				hAlign : sap.ui.commons.layout.HAlign.Begin,
				vAlign : sap.ui.commons.layout.VAlign.Top,
				content : [ oControl ]
			});

			return new sap.ui.commons.layout.MatrixLayoutRow({
				cells : [ oMLCell1, oMLCell2 ]
			});
		}
		
		//Facet content of the ThingInspector
		var oFC1 = new sap.ui.ux3.ThingGroup({
			title : "Group 1",
			content: [
				new sap.ui.commons.Button({
					text: "Some example content",
					tooltip: "Some example content"
				})
			]
		});
		
		//Actions of the ThingInspector
		var oPlay = new sap.ui.ux3.ThingAction({
			id: "play",
			text: "Play it now!",
			tooltip: "Play it now!",
			icon: "sap-icon://play",
		});
		
		var oTI = new sap.ui.ux3.ThingInspector({
			firstTitle: "Born To Die",
			secondTitle: "Lana Del Rey",
			type: "Album",
			icon: "sap-icon://microphone",
			updateActionEnabled: false,
			facets: [
				 new sap.ui.ux3.NavigationItem({key : "overview", text : "Album description"}),
				 //new sap.ui.ux3.NavigationItem({key : "detail", text : "Details"}),
			],
			headerContent: [
			     new sap.ui.ux3.ThingGroup({
			    	 title : "Author",
			         content: [
			                   new sap.ui.commons.layout.MatrixLayout({rows: [
			                   row("Date of birth", "09/09/1999"),
			                   row("Gender", "female"),
			                   row("Nationality", "american"),
			                   row("VIP", "yes")
			                   ]})
			        		]
			       }),
				   new sap.ui.ux3.ThingGroup({
					   title : "Cover",
				       content: [
				                   new sap.ui.commons.Image("cover", {
				                	   src: "http://assets.fanart.tv/fanart/music/b7539c32-53e7-4908-bda3-81449c367da6/albumcover/born-to-die-4f2b7dccc6937.jpg/preview",
				                   }),
				        		]
				    }),
			],
			facetSelected: function(oEvent) {
				oTI.removeAllFacetContent();
				oTI.removeAllActions();
				switch(oEvent.getParameter("key")){
					case "overview":
						oTI.addAction(oPlay);
						oTI.addFacetContent(oFC1);
						break;
				}
			},
		});
		oTI.open();
	},
	
});