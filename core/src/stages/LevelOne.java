package stages;

import com.badlogic.gdx.Screen;
import com.frank.gamejam.GameJam;

import entities.Player;

public class LevelOne implements Screen {
	GameJam game;
	Player p;
	
	public LevelOne(GameJam game) {
		this.game = game;
		p = new Player();
		System.out.println("LevelOne started");
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("show() called in LevelOne");
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
