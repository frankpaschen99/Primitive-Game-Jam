package stages;

import com.badlogic.gdx.math.Vector2;
import com.frank.gamejam.GameJam;

import utilities.Constants;

public class LevelOne extends LevelBase {

	public LevelOne(GameJam _game) {
		super(_game, new Vector2(190, 25), new Vector2(20, 0), "level_1.json");
		
		// Add walls
		entityManager.addCollider(new Vector2(Constants.camera.viewportWidth / 2, 0), 1, 60);
		entityManager.addCollider(new Vector2(-2, 0), 1, 100); // left side
		entityManager.addCollider(new Vector2(Constants.camera.viewportWidth+3, 0), 1, 100); // right side
		entityManager.addCollider(new Vector2(0, Constants.camera.viewportHeight+3), 100, 1);
		entityManager.addCollider(new Vector2(40, 90), 5, 1);
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
		
	}

	@Override
	protected void fragmentCollision() {
		// Handle custom collision with fragments
		switch(getRegionCollision()) {
		case -1:	// not colliding
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

}
