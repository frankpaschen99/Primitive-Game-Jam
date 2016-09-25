package com.frank.gamejam;

import com.badlogic.gdx.Game;

import stages.LevelOne;
import stages.StartMenu;

public class GameJam extends Game {
	
	@Override
	public void create () {
		setScreen(new StartMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
