package entities;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

import utilities.Constants;

public class EntityManager {
	ArrayList<RectangleCollider> colliders;
	
	public EntityManager() {
		colliders = new ArrayList<RectangleCollider>();
	}
	public void addCollider(Vector2 position, float width, float height) {
		this.colliders.add(new RectangleCollider(position, width, height));
	}
	public void draw() {
		for (RectangleCollider r : this.colliders) {
			r.draw();
		}
	}
}
