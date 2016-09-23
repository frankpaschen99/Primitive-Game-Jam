package utilities;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

public class Map {
	private String jsonFile;
	private List<Fragment> fragments;
	
	public Map(String json) {
		this.jsonFile = json;
		this.deserialize();
		this.fragments = new ArrayList<Fragment>();
	}
	void deserialize() {
		JsonReader json = new JsonReader();
		JsonValue base = json.parse(Gdx.files.internal(this.jsonFile));
		
		List<Vector2> vertices = new ArrayList<Vector2>();
		
		for (JsonValue fragments : base.get("fragments")) {	
			for (JsonValue v : fragments.get("vertices")) {
				vertices.add(new Vector2(Float.parseFloat(v.getString("x")), Float.parseFloat(v.getString("y"))));
			}
			// TODO: make this work
			//this.fragments.add(new Fragment(Byte.parseByte(fragments.getString("region_id")), vertices));
		}
	}
}
