package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.frank.gamejam.GameJam;

import utilities.Text;

public class StartMenu implements Screen {

	private SpriteBatch batch;
	private Sprite bgSprite;
	private GameJam game;
	private boolean drawText = false;
	
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
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("prstart.TTF"));
	    FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	    parameter.size = 16;
	    Text t = new Text(generator, parameter);
	    
		// TODO Auto-generated method stub
		batch.begin();
		bgSprite.draw(batch);
		if (drawText) t.draw("Goal: Get the objective block, then proceed to the \nexit gate. \nThe map is divided into fragments, each with \nunique physical properties. \nPress ENTER again to begin. \nGood luck.", batch, 0, Gdx.graphics.getHeight() / 2);
		batch.end();
		
		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && drawText) {
			this.game.setScreen(new LevelOne(this.game));
		}
		if (Gdx.input.isKeyJustPressed(Keys.ENTER) && !drawText) {
			drawText = true;
			bgSprite.getTexture().dispose();
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
