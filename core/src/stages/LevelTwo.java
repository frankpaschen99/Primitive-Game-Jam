package stages;

import com.badlogic.gdx.math.Vector2;
import com.frank.gamejam.GameJam;

import utilities.Constants;

public class LevelTwo extends LevelBase {

	public LevelTwo(GameJam _game) {
		super(_game, new Vector2(190, 25), new Vector2(20, 0), new Vector2(33, 94), "level_2.json");
		// TODO Auto-generated constructor stub
		
		// screen borders - not in the base class because some levels might extend beyond the viewport
		entityManager.addCollider(new Vector2(0, 0), 0, 100, "wall"); // left side
		entityManager.addCollider(new Vector2(Constants.camera.viewportWidth, 0), 0, 100, "wall"); // right side
		entityManager.addCollider(new Vector2(0, 0), Constants.camera.viewportWidth, 0, "floor");
		entityManager.addCollider(new Vector2(0, Constants.camera.viewportHeight), 100, 0, "ceil");
		
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

	}

	@Override
	protected void endStage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void handleKeyboardInput() {
		// TODO Auto-generated method stub
		
	}

}
