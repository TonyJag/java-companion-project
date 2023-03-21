package com.organization.mvcproject.repository;

import java.util.List;

import com.organization.mvcproject.model.Game;

public interface GameDAO {
	
	// Read
	List<Game> retrieveAllGames();
	
	// Create
	Game saveGame(Game game);
	
	// Update
	Game updateGame(Game game);
	
	// Delete
	boolean deleteGame(Long id);
	
}
