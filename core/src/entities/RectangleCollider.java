package entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import utilities.Constants;

public class RectangleCollider {
	
	private ShapeRenderer shapeRenderer;
	private Vector2 position;
	private float width, height;
	public Body body;
	public BodyDef groundBodyDef;
	public PolygonShape groundBox;
	public Fixture fixture;
	
	public RectangleCollider(Vector2 position, float width, float height, String metadata) {
		// Create our body definition
		groundBodyDef = new BodyDef();  
		// Set its world position
		groundBodyDef.position.set(position);  

		// Create a body from the defintion and add it to the world
		body = Constants.world.createBody(groundBodyDef);  

		// Create a polygon shape
		groundBox = new PolygonShape();  
		// Set the polygon shape as a box which is twice the size of our view port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		groundBox.setAsBox(width*2, height*2);
		// Create a fixture from our polygon shape and add it to our ground body  
		fixture = body.createFixture(groundBox, 0.0f); 
		
		// Clean up after ourselves
		groundBox.dispose();

		body.setUserData(metadata);	// should be "floor", "ceil", or "wall"
		
		this.position = position;
		this.width = width;
		this.height = height;
		
		this.shapeRenderer = new ShapeRenderer();
	}
	public void draw() {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setProjectionMatrix(Constants.camera.combined);
		shapeRenderer.setColor(Color.LIME);
		shapeRenderer.rect(position.x - width * 2, position.y - height * 2, width * 4, height * 4);	// WHAT THE HELL
		shapeRenderer.end();
	}
}
