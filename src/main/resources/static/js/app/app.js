'use strict'

var babulilmApp = angular.module('babulilm', [ 'ui.bootstrap', 'babulilm.controllers',
		'babulilm.services' ]);

babulilmApp.constant("CONSTANTS", {
	getEventById: "/events/",
	getAllEvents: "/events",
	createEvent: "/events",
	deleteEvent: "/events/",
	loginUser: "/login"
});
