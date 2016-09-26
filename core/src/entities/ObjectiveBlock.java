package entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import utilities.Constants;

public class ObjectiveBlock {
	private Rectangle r;
	private ShapeRenderer shapeRenderer;
	
	public ObjectiveBlock(Vector2 position) {
		r = new Rectangle(position.x, position.y, 15f, 15f);
		this.shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(Constants.camera.combined);
	}
	public void draw() {
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.rect(this.r.x, this.r.y, 5f, 5f);
		shapeRenderer.end();
	}
	public Rectangle getRectangle() {
		return this.r;
	}
	public void moveWithPlayer(Player player) {
		this.r.setPosition(new Vector2(player.getSpritePosition().x+5, player.getSpritePosition().y));
	}
}
