'use strict'

angular.module('babulilm.services', []).factory('AdminService',
    [ "$http", "CONSTANTS", function($http, CONSTANTS) {
        var service = {};
        service.createEvent = function(eventDto) {
            return $http.post(CONSTANTS.createEvent, eventDto);
        }
        service.deleteEvent = function(eventId) {
            return $http.delete(CONSTANTS.deleteEvent + eventId);
        }
        service.getAllEvents = function() {
            return $http.get(CONSTANTS.getAllEvents);
        }
        return service;
    } ]);