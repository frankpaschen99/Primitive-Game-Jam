/* intro to computer programming AM I RITE */

package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.frank.gamejam.GameJam;
import utilities.Constants;
import entities.Player;

public class LevelOne implements Screen {
	GameJam game;
	Player p;
	OrthographicCamera camera;
	Batch batch;
	World world;
	Box2DDebugRenderer debugRenderer;
	
	public LevelOne(GameJam game) {
		this.game = game;
		batch = new SpriteBatch();
		
		/* Ortho Camera */
		camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
		camera.setToOrtho(false, Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		camera.update();
		/* Box2D Physics */
		world = new World(new Vector2(0, -10), true);
		debugRenderer = new Box2DDebugRenderer();
		
		/* Player Setup */
		p = new Player();
		p.physicsSetup(world);
		
		System.out.println("LevelOne started");
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("show() called in LevelOne");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
	    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
 
		// TODO Auto-generated method stub
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		
		/*** Begin drawing entities here ***/
		p.draw(batch);
		
		batch.end();
		p.update();
		
		//debugRenderer.render(world, camera.combined);
		world.step(1/60f, 6, 2);	// lol bethesda problems am i rite
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
