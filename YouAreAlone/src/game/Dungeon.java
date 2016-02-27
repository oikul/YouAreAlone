package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import utils.InputHandler;
import utils.NoiseGenerator;

public class Dungeon extends JPanel {

	private static final long serialVersionUID = -7756466239770457395L;
	private int floor = 1;
	private boolean floorChange;
	private boolean[][] cellularNoise;
	private Rectangle[] randomRooms;
	private NoiseGenerator noise;
	private InputHandler input;
	private int xDif = 0, yDif = 0;

	public Dungeon(long seed) {
		noise = new NoiseGenerator(seed);
		cellularNoise = new boolean[1024][1024];
		this.requestFocus();
		input = new InputHandler(this);
	}

	public void update() {
		if (floorChange) {
			if (floor % 2 == 0) {
				cellularNoise = noise.getCellularAutomataNoise(cellularNoise.length, cellularNoise[0].length, 3, 4, 6);
			} else {
				randomRooms = noise.generateRooms(128, 1024, 1024, 512, 512, 12, 12, 2, 2);
			}
		}
		if (input.isKeyDown(KeyEvent.VK_W)) {
			yDif++;
		}
		if (input.isKeyDown(KeyEvent.VK_A)) {
			xDif++;
		}
		if (input.isKeyDown(KeyEvent.VK_S)) {
			yDif--;
		}
		if (input.isKeyDown(KeyEvent.VK_D)) {
			xDif--;
		}
	}

	public void draw(Graphics2D g2d) {
		if (floor % 2 == 0) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height);
			g2d.setColor(Color.DARK_GRAY);
			for(int i = 0; i < cellularNoise.length; i++){
				for(int j = 0; j < cellularNoise[0].length; j++){
					if(cellularNoise[i][j]){
						g2d.fillRect(i * 32 + xDif, j * 32 + yDif, 32, 32);
					}
				}
			}
		} else {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height);
			g2d.setColor(Color.DARK_GRAY);
			for(int i = 0; i < randomRooms.length; i++){
				g2d.fill(randomRooms[i]);
			}
		}
	}

	public void incrementFloor() {
		floor++;
		floorChange = true;
	}

}
