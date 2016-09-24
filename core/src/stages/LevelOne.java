/* intro to computer programming AM I RITE */

package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.frank.gamejam.GameJam;
import utilities.Constants;
import utilities.Fragment;
import utilities.Map;
import entities.Player;

public class LevelOne implements Screen {
	private GameJam game;
	private Player p;
	private final OrthographicCamera camera;
	private Batch batch;
	private World world;
	private Box2DDebugRenderer debugRenderer;
	private Map map;
	
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
		BodyDef groundBodyDef = new BodyDef();  
		groundBodyDef.position.set(new Vector2(0, 0));  
		Body groundBody = world.createBody(groundBodyDef);  
		PolygonShape groundBox = new PolygonShape();  
		groundBox.setAsBox(camera.viewportWidth, 0f);
		groundBody.createFixture(groundBox, 0.0f); 
		groundBox.dispose();
		
		/* Player Setup */
		p = new Player();
		p.physicsSetup(world);
		
		/* Map Setup */
		map = new Map("json_test.json");
		
		System.out.println("LevelOne started");
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		// Clear the buffer so we don't get that weird windows xp thing
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
	    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		
		/** Begin drawing entities here **/
		p.draw(batch);
		
		batch.end();
		p.update(camera);
		
		//debugRenderer.render(world, camera.combined);
		world.step(1/60f, 6, 2);	// lol bethesda problems am i rite
		this.fragmentCollision();
	}
	private void fragmentCollision() {
		// determine physics properties that affect player here
		switch(getRegionCollision()) {
		case -1:
			break;
		case 1:
			this.p.body.setGravityScale(0);
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
	}
	private int getRegionCollision() {
		//System.out.println(this.p.getPosition());
		if(this.map.getFragments().get(0).getArea().contains(this.p.getPosition())) {
			System.out.println("Collision");
		}
		for (Fragment f : this.map.getFragments()) {
			if (f.getArea().contains(this.p.getPosition())) return f.regionId;
		}
		return -1;
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
