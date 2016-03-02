package game;

import java.awt.Graphics2D;

import utils.Entity;
import utils.InputHandler;

public class Player extends Entity {

	public Player(String name, String spritePath) {
		super(name, spritePath, (int) InputHandler.midPoint.x - 8, (int) InputHandler.midPoint.y - 8, 16, 16);
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void draw(Graphics2D g2d){
		g2d.drawImage(sprites[currentISprite][currentJSprite], xPos, yPos, width, height, null);
	}

}
