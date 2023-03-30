package com.organization.mvcproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.model.GameInterface;
import com.organization.mvcproject.model.Game;

@Repository("gameDAO")
public class GameDAOImpl implements GameDAO{
	
	private static Logger LOGGER = LoggerFactory.getLogger(GameDAOImpl.class);
		
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	
	@Override
	public List<GameInterface> retrieveAllGames() {
		return ImmutableList.copyOf(games);
	}

	@Override
	public GameInterface saveGame(GameInterface game) {
		game.setId(++gameId);
		games.add((Game) game);
		return game;
	}

	@Override
	public GameInterface updateGame(GameInterface updatedGame) {
		if(updatedGame.getId() != null) {
			//update game
			Game foundGame = findGameById(updatedGame.getId());
			if (foundGame != null) {
				// update game in the list
				for(int i = 0; i < games.size(); i++) {
					if (updatedGame.getId().equals(games.get(i).getId())) {
						games.set(i, (Game) updatedGame);
						return updatedGame;
					}
				}
			} else {
				LOGGER.warn("Game has invalid Id [{}], overwriting and creating new record", updatedGame.getId());
				return saveGame(updatedGame);
			}
		} 
		LOGGER.warn("Caution you are using the updateGame method in lieu of saveGame");
		return null;
	}

	@Override
	public boolean deleteGame(Long id) {
		for(int i = 0; i < games.size(); i++) {
			if(id.equals(games.get(i).getId())) {
				games.remove(i);
				return true;
			}
		}
		return false;
	}
	
	private Game findGameById(Long id) {
		for(Game game: games) {
			if(id.equals(game.getId())) {
				return game;
			}
		}
		return null;
	}
}
