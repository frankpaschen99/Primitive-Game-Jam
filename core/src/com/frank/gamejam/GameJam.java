package com.frank.gamejam;

import com.badlogic.gdx.Game;

import stages.LevelOne;

public class GameJam extends Game {
	
	@Override
	public void create () {
		setScreen(new LevelOne(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
