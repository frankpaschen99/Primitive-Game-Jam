package utilities;

import java.util.List;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

/* The Fragment class represents polygons on the Map that have unique properties */

public class Fragment {
	private Polygon p;
	private byte regionId;
	
	public Fragment(byte i, List<Vector2> _vertices) {
		// TODO: be able to create a Polygon object from _vertices
		p = new Polygon();
		
	}
	public Polygon getArea() {
		return this.p;
	}
}
