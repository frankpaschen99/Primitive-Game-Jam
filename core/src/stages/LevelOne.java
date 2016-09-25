/* intro to computer programming AM I RITE */

package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.frank.gamejam.GameJam;
import utilities.Constants;
import utilities.Fragment;
import utilities.Map;
import utilities.Text;
import entities.Player;
import entities.RectangleCollider;

public class LevelOne implements Screen {
	private Player p;
	private SpriteBatch batch;
	@SuppressWarnings("unused")
	private Box2DDebugRenderer debugRenderer;
	private Map map;
	private RectangleCollider r;
	public LevelOne(GameJam game) {
		batch = new SpriteBatch();
		
		/* Ortho Camera */
		Constants.camera.translate(Constants.camera.viewportWidth / 2, Constants.camera.viewportHeight / 2);
		Constants.camera.setToOrtho(false, Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		Constants.camera.update();
		
		/* Box2D Physics */
		//world = new World(new Vector2(0, -10), true);
		debugRenderer = new Box2DDebugRenderer();
		BodyDef groundBodyDef = new BodyDef();  
		groundBodyDef.position.set(new Vector2(0, 0));  
		Body groundBody = Constants.world.createBody(groundBodyDef);  
		PolygonShape groundBox = new PolygonShape();  
		groundBox.setAsBox(Constants.camera.viewportWidth, 0f);
		groundBody.createFixture(groundBox, 0.0f); 
		groundBox.dispose();
		
		/* Player Setup */
		p = new Player();
		p.physicsSetup(Constants.world);
		
		/* Map Setup */
		map = new Map("json_test.json");
		
		/* Colliders */
		r = new RectangleCollider(new Vector2(Constants.camera.viewportWidth / 2, 0), 1, 1);
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
		
	    /* Font Setup */
	    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("prstart.TTF"));
	    FreeTypeFontParameter parameter = new FreeTypeFontParameter();
	    parameter.size = 6;
	    Text t = new Text(generator, parameter);
	    
	    
		batch.begin();
		batch.setProjectionMatrix(Constants.camera.combined);
		
		/** Begin drawing entities here **/
		p.draw(batch);
		t.draw("github.com/frankpaschen99", batch, 0, Constants.camera.viewportHeight-2);
		
		batch.end();
	
		// polygon drawing for the map is different. keep it out of batch.begin() and end()
		map.draw(batch);
		
		// update any entities necessary
		p.update(Constants.camera);
		
		debugRenderer.render(Constants.world, Constants.camera.combined);
		Constants.world.step(1/60f, 6, 2);	// lol bethesda problems am i rite
		this.fragmentCollision();
	}
	private void fragmentCollision() {
		// determine physics properties that affect player here
		switch(getRegionCollision()) {
			case -1:	// not colliding
				this.p.body.setGravityScale(5);
				System.out.println("NOT COLLIDING");
				break;
			case 1:
				this.p.body.setGravityScale(0);
				System.out.println("COLLIDING");
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			}
	}
	private byte getRegionCollision() {
		for (Fragment f : this.map.getFragments()) {
			if (f.getArea().contains(this.p.getPosition())) {
				return f.getId();
			}
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
