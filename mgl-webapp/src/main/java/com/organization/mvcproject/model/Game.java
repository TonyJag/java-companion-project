package com.organization.mvcproject.model;

import org.springframework.stereotype.Component;

@Component
public class Game {

	private Long id;
	private String name;
	private String genre;

	public Long getGame_id() {
		return id;
	}

	public void setGame_id(Long game_id) {
		this.id = game_id;
	}

	public String getGame_name() {
		return name;
	}

	public void setGame_name(String game_name) {
		this.name = game_name;
	}

	public String getGame_genre() {
		return genre;
	}

	public void setGame_genre(String game_genre) {
		this.genre = game_genre;
	}

}
