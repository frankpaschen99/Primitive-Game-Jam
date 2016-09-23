package utilities;

import com.badlogic.gdx.math.Polygon;

/* The Fragment class represents polygons on the Map that have unique properties */

public class Fragment {
	private Polygon p;
	public Fragment(float[] vertices) {
		p = new Polygon(vertices);
	}
	public Polygon getArea() {
		return this.p;
	}
}
