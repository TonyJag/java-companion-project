package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.repository.GameDAO;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDao;

	@Override
	public List<Game> retrieveAllGames() {
		return gameDao.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return gameDao.saveGame(game);
	}
	
	@Override
	public Game updateGame(Game game) {
		// any additional business logic here.
		// then
		return gameDao.updateGame(game);
	}
	
	@Override
	public boolean deleteGame(Long id) {
		return gameDao.deleteGame(id);
	}

}