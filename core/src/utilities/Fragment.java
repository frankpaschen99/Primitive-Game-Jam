package utilities;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

/* The Fragment class represents polygons on the Map that have unique physical properties */

public class Fragment {
	private Polygon p;
	private byte regionId;
	
	/* WHAT THE HELL IS THIS CANCER */
	public Fragment(byte _regionId, List<Vector2> _vertices) {
		float[] vertices = new float[_vertices.size()*2];
		List<Float> v = new ArrayList<Float>();
		for (Vector2 k : _vertices) {
			v.add(k.x);
			v.add(k.y);
		}
		int i = 0;
		for (Float f : v) {
			vertices[i++] = (f != null ? f : Float.NaN);
		}
		this.p = new Polygon(vertices);
		this.regionId = regionId;
	}
	public Polygon getArea() {
		return this.p;
	}
}