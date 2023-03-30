package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.model.GameInterface;
import com.organization.mvcproject.api.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	@Qualifier("gameDAO")
	private GameDAO gameDao;

	@Override
	public List<GameInterface> retrieveAllGames() {
		return gameDao.retrieveAllGames();
	}

	@Override
	public GameInterface saveGame(GameInterface game) {
		return gameDao.saveGame(game);
	}
	
	@Override
	public GameInterface updateGame(GameInterface game) {
		// any additional business logic here.
		// then
		return gameDao.updateGame(game);
	}
	
	@Override
	public boolean deleteGame(Long id) {
		return gameDao.deleteGame(id);
	}

}