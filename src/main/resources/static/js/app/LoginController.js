'use strict'

var module = angular.module('babulilm.controllers', []);

module.controller("LoginController", ["$scope", "LoginService", "$location",
  function($scope, LoginService, $location) {
      $scope.init = function () {
          $scope.showInvalidCredentialError = false;
          if ($location.$$absUrl.toString().indexOf("error=true") > 0) {
              console.log("$scope.showInvalidCredentialError = true;")
              $scope.showInvalidCredentialError = true;
          }
      };
  }
]);
