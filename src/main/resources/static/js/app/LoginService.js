'use strict'

angular.module('babulilm.services', []).factory('LoginService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.login = function(userDto) {
				return $http.post(CONSTANTS.loginUser, userDto);
			}
			return service;
		} ]);
