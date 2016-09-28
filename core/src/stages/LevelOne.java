package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ColorAction;
import com.frank.gamejam.GameJam;

import entities.RectangleCollider;
import utilities.Constants;

public class LevelOne extends LevelBase {

	public LevelOne(GameJam _game) {
		super(_game, new Vector2(190, 25), new Vector2(20, 0), new Vector2(33, 94), "level_1.json");
		
		// Add walls
		entityManager.addCollider(new Vector2(Constants.camera.viewportWidth / 2, 0), 1, 60, "undefined");
		
		// screen borders - not in the base class because some levels might extend beyond the viewport
		entityManager.addCollider(new Vector2(0, 0), 0, 100, "wall"); // left side
		entityManager.addCollider(new Vector2(Constants.camera.viewportWidth, 0), 0, 100, "wall"); // right side
		entityManager.addCollider(new Vector2(0, 0), Constants.camera.viewportWidth, 0, "floor");
		entityManager.addCollider(new Vector2(0, Constants.camera.viewportHeight), 100, 0, "ceil");
		
		entityManager.addCollider(new Vector2(40, 90), 5, 1, "undefined");	// platform	
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {		
		// TODO Auto-generated method stub
		super.render(delta);

		// Do any additional rendering here
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

		// remove RectangleCollider physics bodies
		for (RectangleCollider r : entityManager.colliders) {
			Constants.world.destroyBody(r.body);
		}
		// remove player physics body
		Constants.world.destroyBody(this.player.body);
	}

	@Override
	protected void fragmentCollision() {
		// Handle custom collision with fragments
		switch(getRegionCollision()) {
		case -1:
			Constants.world.setGravity(new Vector2(0, -10));
			drawEffect("No Effect");
			break;
		case 1:
			Constants.world.setGravity(new Vector2(0, 5));
			this.drawEffect("Inverted Gravity");
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
	}

	@Override
	protected void endStage() {
		// freeze for 5 seconds
		//player.toggleFrozen();
		this.dispose();
		game.setScreen(new LevelTwo(game));
	}

	protected void handleKeyboardInput() {
		super.handleKeyboardInput();
		
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.R)) {          
			this.dispose();
			this.game.setScreen(new LevelOne(game));
		}
	}
}