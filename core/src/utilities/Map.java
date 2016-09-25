package utilities;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class Map {
	private String jsonFile;
	private List<Fragment> fragments;
	private ShapeRenderer shapeRenderer;
	
	public Map(String json) {
		this.jsonFile = json;
		this.fragments = new ArrayList<Fragment>();
		this.deserialize();
		this.shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(Constants.camera.combined);
	}
	void deserialize() {
		JsonReader json = new JsonReader();
		JsonValue base = json.parse(Gdx.files.internal(this.jsonFile));
		
		for (JsonValue fragments : base.get("fragments")) {	
			List<Vector2> vertices = new ArrayList<Vector2>();
			for (JsonValue v : fragments.get("vertices")) {
				vertices.add(new Vector2(Float.parseFloat(v.getString("x")), Float.parseFloat(v.getString("y"))));
			}
			this.fragments.add(new Fragment(Byte.parseByte(fragments.getString("region_id")), vertices));
		}
	}
	public List<Fragment> getFragments() {
		return this.fragments;
	}
	public void draw(Batch batch) {
		// for each fragment, shape render them
		shapeRenderer.begin(ShapeType.Line);
		for(Fragment f : this.fragments) {
			shapeRenderer.polygon(f.getArea().getVertices());
		}
		shapeRenderer.end();
	}
}
