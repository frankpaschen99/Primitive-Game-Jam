package stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.frank.gamejam.GameJam;

import utilities.Constants;

public class LevelTwo extends LevelBase {

	public LevelTwo(GameJam _game) {
		super(_game, new Vector2(190, 25), new Vector2(0, 0), new Vector2(6, 123), "level_2.json", (byte) 2);
		// TODO Auto-generated constructor stub
		
		// screen borders - not in the base class because some levels might extend beyond the viewport
		entityManager.addCollider(new Vector2(0, 0), 0, 100, "wall"); // left side
		entityManager.addCollider(new Vector2(Constants.camera.viewportWidth, 0), 0, 100, "wall"); // right side
		entityManager.addCollider(new Vector2(0, 0), Constants.camera.viewportWidth, 0, "floor");
		entityManager.addCollider(new Vector2(0, Constants.camera.viewportHeight), 100, 0, "ceil");
		
		entityManager.addCollider(new Vector2(14, 125), 5, 1, "undefined");	// platform
	}

	@Override
	public void show() {
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

	@Override
	protected void fragmentCollision() {
		// TODO Auto-generated method stub
		switch(getRegionCollision()) {
		case -1:
			Constants.world.setGravity(new Vector2(0, -10));
			drawEffect("Effect: No Effect");
			break;
		case 1:	// super speed
			// thanks alex/sorrer for the CODESSSSSssss
			if (this.player.body.getLinearVelocity().y >= 0)
				this.player.body.applyLinearImpulse(new Vector2(this.player.body.getLinearVelocity().x*5, this.player.body.getLinearVelocity().y*10), this.player.body.getPosition(), true);
			this.drawEffect("Effect: Velocity Boost");
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
		// freeze player for 2 seconds, then dispose/change screen
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		this.dispose();
		//game.setScreen(new LevelThree(game));
	}

	@Override
	protected void handleKeyboardInput() {
		super.handleKeyboardInput();
		if (Gdx.input.isKeyPressed(Keys.R)) {          
			this.dispose();
			//this.game.setScreen(new LevelOne(game));
		}
	}

}
