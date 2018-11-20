'use strict'

var module = angular.module('babulilm.controllers', []);

module.controller("AdminController", ["$scope", "AdminService",
    function ($scope, AdminService) {

        $scope.createEventShown = true;
        $scope.removeEventShown = false;

        $scope.showCreateEvent = function() {
            $scope.createEventShown = true;
            $scope.removeEventShown = false;
            $scope.eventCreationMsg = null;
        };

        $scope.eventDto = {
            name: null,
            description: null,
            dateAndTime: null,
            venue: null,
            type: null,
            speakerDtos: []
        };

        $scope.createEvent = function() {
            AdminService.createEvent($scope.eventDto).then(function(value) {
                debugger;
                if (value.status == 201) {
                    $scope.eventCreationMsg = "Event got created successfully";
                } else {
                    $scope.eventCreationMsg = "Something went wrong while creating the event.";
                }
            }, function(reason) {
                console.log("error occured: " + reason);
            });
        };

        $scope.showRemoveEvent = function() {
            $scope.createEventShown = false;
            $scope.removeEventShown = true;
            $scope.events = null;
            $scope.deleteMsg = null;
            AdminService.getAllEvents().then(function(value) {
                $scope.events = value.data;

                if ($scope.events.length == 0) {
                    $scope.deleteMsg = "No events to delete.";
                }
            }, function(reason) {
                console.log("error occured: " + reason);
            });
        };

        $scope.removeEvent = function(eventId) {
            AdminService.deleteEvent(eventId).then(function(value) {
                if (value.status == 202) {
                    $scope.deleteMsg = "Event deleted successfully";
                } else {
                    $scope.deleteMsg = "Event could not be deleted";
                }

                AdminService.getAllEvents().then(function(value) {
                    $scope.events = value.data;
                    if ($scope.events.length == 0) {
                        $scope.deleteMsg = "No events to delete.";
                    }
                }, function(reason) {
                    console.log("error occured: " + reason);
                });

            }, function(reason) {
                console.log("error occured: " + reason);
            });
        };
    }
]);
