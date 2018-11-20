'use strict'

angular.module('babulilm.services', []).factory('EventService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getEventById = function(eventId) {
				return $http.get(CONSTANTS.getEventById + eventId);
			}
			service.getAllEvents = function() {
				return $http.get(CONSTANTS.getAllEvents);
			}
			return service;
		} ]);
