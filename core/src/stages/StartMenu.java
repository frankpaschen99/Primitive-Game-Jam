package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frank.gamejam.GameJam;

public class StartMenu implements Screen {

	private SpriteBatch batch;
	private Sprite bgSprite;
	private GameJam game;
	
	public StartMenu(GameJam _game) {
		this.game = _game;
		bgSprite = new Sprite(new Texture(Gdx.files.internal("start.png")));
		batch = new SpriteBatch();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		bgSprite.draw(batch);
		batch.end();
		
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			this.game.setScreen(new LevelOne(this.game));
		}
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
