package entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import utilities.Constants;
import utilities.Fragment;

public class EndGate {
	private Rectangle r;
	private ShapeRenderer shapeRenderer;
	
	public EndGate(Vector2 position) {
		r = new Rectangle(position.x, position.y, 10, 10);
		this.shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(Constants.camera.combined);
	}
	public void draw() {
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.rect(this.r.x, this.r.y, this.r.width, this.r.height);
		shapeRenderer.end();
	}
	public Rectangle getRectangle() {
		return this.r;
	}
}
