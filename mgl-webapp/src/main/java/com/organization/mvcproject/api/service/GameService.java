package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.api.model.GameInterface;

public interface GameService {

	List<GameInterface> retrieveAllGames();

	GameInterface saveGame(GameInterface game);

	GameInterface updateGame(GameInterface game);

	boolean deleteGame(Long id);

}
