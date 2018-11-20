'use strict'

var module = angular.module('babulilm.controllers', []);

module.controller("UserController", ["$scope", "EventService",
  function($scope, EventService) {
    $scope.showHome = function() {
        $scope.homeShown = true;
        $scope.eventsShown = false;
        $scope.eventDetailsShown = false;
    };

    $scope.showHome();

    $scope.showEvents = function() {
        $scope.homeShown = false;
        $scope.eventsShown = true;
        $scope.eventDetailsShown = false;
        $scope.events = null;
        $scope.eventsCallReturned = false;
        debugger;
        EventService.getAllEvents().then(function(value) {
            debugger;
            $scope.events = value.data;
            $scope.eventsCallReturned = true;
        }, function(reason) {
            console.log("error occured: " + reason);
        });
    };

    $scope.showEventDetails = function(eventID) {
        $scope.homeShown = false;
        $scope.eventsShown = false;
        $scope.eventDetailsShown = true;
        $scope.eventsCallReturned = false;
        EventService.getEventById(eventID).then(function(value) {
            $scope.selectedEvent = value.data;
            $scope.eventsCallReturned = true;
        }, function(reason) {
            console.log("error occured: " + reason);
        });
    }
  }
]);
