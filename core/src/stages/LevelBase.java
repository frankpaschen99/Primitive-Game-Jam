package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.frank.gamejam.GameJam;

import entities.EndGate;
import entities.EntityManager;
import entities.Player;
import utilities.Constants;
import utilities.Fragment;
import utilities.Map;
import utilities.Text;

public abstract class LevelBase implements Screen {
	/* Member Variables */
	protected Player player;
	protected SpriteBatch batch;
	private Map map;
	protected EntityManager entityManager;
	private EndGate endGate;
	private OrthographicCamera textCam;
	private GameJam game;
	private Text textHandler;
	private FreeTypeFontGenerator generator;
    private FreeTypeFontParameter parameter;
    private Box2DDebugRenderer debugRenderer;
    private boolean levelComplete = false;
    
	/* Constructor */
	public LevelBase(GameJam _game, Vector2 playerStartPos, Vector2 endGatePos, String jsonFile) {
		/* Initialize member variables */
		this.batch = new SpriteBatch();
		this.game = _game;
		this.entityManager = new EntityManager();
		this.generator = new FreeTypeFontGenerator(Gdx.files.internal("prstart.ttf"));
		this.parameter = new FreeTypeFontParameter();
		this.parameter.size = 16;
		this.textHandler = new Text(generator, parameter);
		
		/* World camera */
		Constants.camera.translate(Constants.camera.viewportWidth / 2, Constants.camera.viewportHeight / 2);
		Constants.camera.setToOrtho(false, Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		Constants.camera.update();
		
		/* FreeType camera */
		textCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());	// pixel perfect cam for text rendering
		textCam.setToOrtho(false);
		textCam.update();
		
		/* Set up Box2D Physics */
		debugRenderer = new Box2DDebugRenderer();
		BodyDef groundBodyDef = new BodyDef();  
		groundBodyDef.position.set(new Vector2(0, 0));  
		Body groundBody = Constants.world.createBody(groundBodyDef);  
		PolygonShape groundBox = new PolygonShape();  
		groundBox.setAsBox(Constants.camera.viewportWidth, 0f);
		groundBody.createFixture(groundBox, 0.0f); 
		groundBox.dispose();
		
		/* Player Setup */
		player = new Player(playerStartPos.x, playerStartPos.y);
		player.physicsSetup();
		
		/* Map Setup */
		map = new Map(jsonFile);
		
		/* EndGate Setup */
		endGate = new EndGate(endGatePos);
	}
	public void render(float delta) {
		Gdx.gl.glClearColor( 0, 0, 0, 1 );
	    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
	    
	    // Draw Player
	    batch.begin();
	    batch.setProjectionMatrix(Constants.camera.combined);
	    player.draw(batch);
	    batch.end();
	    
	    // Draw Text
	    batch.begin();
		batch.setProjectionMatrix(this.textCam.combined);
		textHandler.draw("github.com/frankpaschen99", batch, 0, this.textCam.viewportHeight);
		batch.end();
		
		// Draw polygons/shapes
		map.draw();
		endGate.draw();
		entityManager.draw();
		
		// Update entities
		player.update();
		
		// debugRenderer.render(Constants.world, Constants.camera.combined);
		Constants.world.step(1/60f, 6, 2);	// lol bethesda problems am i rite
		this.fragmentCollision();
		this.checkGateCollision();
	}
	private void checkGateCollision() {
		if (levelComplete) return;
		if (this.endGate.getRectangle().contains(this.player.getPosition())) {	// TODO: check if player has acquired objective block
			batch.begin();
			batch.setProjectionMatrix(this.textCam.combined);
			textHandler.draw("Stage Complete", batch, 0, Gdx.graphics.getHeight()-40);
			batch.end();
			this.levelComplete = true;
			this.endStage();
		}
	}
	protected void drawEffect(String effect) {
		batch.begin();
		batch.setProjectionMatrix(this.textCam.combined);
		textHandler.draw(effect, batch, 0, Gdx.graphics.getHeight()-20);
		batch.end();
	}
	protected byte getRegionCollision() {
		for (Fragment f : this.map.getFragments()) {
			if (f.getArea().contains(this.player.getPosition())) {
				return f.getId();
			}
		}
		return -1;
	}
	protected abstract void endStage();
	protected abstract void fragmentCollision();
}
