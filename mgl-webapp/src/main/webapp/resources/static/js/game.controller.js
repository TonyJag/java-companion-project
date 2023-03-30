'use strict';

angular.module('game_app').controller('GameController',
	['GameService', function(GameService) {
		var self = this;
		self.game = {
			id: '',
			name: '',
			genre: ''
		};
		self.games = [];

		self.fetchAllGames = function() {
			GameService.fetchAllGames().then(function(data) {
				self.games = data;
			});
		}

		self.addOrUpdateGame = function() {
			if (self.game.id) {
				return GameService.updateGame(self.game).then(function() {
					self.game = {};
					self.fetchAllGames();
				});
			} else {
				return GameService.createGame(self.game).then(function() {
					self.game = {};
					self.fetchAllGames();
				});
			}
		}

		self.selectGame = function(game) {
			self.game = angular.copy(game);
		}

		self.deleteGame = function(game) {
			return GameService.deleteGame(game.id).then(function() {
				
				self.fetchAllGames();
			});
		}

		self.fetchAllGames();
		
	}]);
