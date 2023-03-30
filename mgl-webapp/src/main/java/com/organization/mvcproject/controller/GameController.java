package com.organization.mvcproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.model.GameInterface;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.Game;

@RequestMapping(value ="/game/")
@RestController
public class GameController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private GameService gameService;

	

	@GetMapping(value = "/")
	public ResponseEntity<List<GameInterface>> fetchAllGames() {
		return new ResponseEntity<List<GameInterface>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/game", method = RequestMethod.GET)
//	public ModelAndView game() {
//		return new ModelAndView("gamesPage", "command", new Game());
//	}
	
	
	// Server requests are GET, POST, PUT, DELETE, ..... OPTIONS.... not as recognizable.
	
	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateGame(@RequestBody Game game){
		
		return new ResponseEntity<>(gameService.updateGame(game), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") Long id){
		return new ResponseEntity<>(gameService.deleteGame(id), HttpStatus.OK);
		
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
}