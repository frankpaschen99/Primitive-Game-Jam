package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
	private Sprite sprite;
	
	public Player() {
		sprite = new Sprite(new Texture(Gdx.files.internal("player.png")));
		sprite.setPosition(0, 140);
		System.out.println("Player constructor called");
	}
	public void draw(Batch batch) {
		batch.draw(sprite, sprite.getX(), sprite.getY());
	}
	public void update() {
		
	}
}
