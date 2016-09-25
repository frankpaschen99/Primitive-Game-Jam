package utilities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public final class Constants {
	public static final String GAME_VERSION = "0.0.1";
	public static final String GAME_AUTHOR = "Frank Paschen";
	public static final float WORLD_WIDTH = 200;	// yayy magic constants??? where tf did i get these numbers lol
	public static final float WORLD_HEIGHT = 150;
	public static final float PPM = 0.5f;
	
	public static World world = new World(new Vector2(0, -10), true); // not technically a constant but what are you gonna do about it
	public static final OrthographicCamera camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
}
