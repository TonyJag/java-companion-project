package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.api.model.GameInterface;

public interface GameDAO {
	
	// Read
	List<GameInterface> retrieveAllGames();
	
	// Create
	GameInterface saveGame(GameInterface game);
	
	// Update
	GameInterface updateGame(GameInterface game);
	
	// Delete
	boolean deleteGame(Long id);
	
}
