package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import utils.InputHandler;
import utils.MathHelper;
import utils.NoiseGenerator;

public class Dungeon extends JPanel {

	private static final long serialVersionUID = -7756466239770457395L;
	private int floor = 0;
	private boolean floorChange = true;
	private boolean[][] cellularNoise;
	private Rectangle[] randomRooms;
	private NoiseGenerator noise;
	private InputHandler input;
	private double xDif = 0, yDif = 0;
	private Image dungeon;
	//private Player player;

	public Dungeon(long seed, InputHandler input, Image img) {
		noise = new NoiseGenerator(seed);
		cellularNoise = new boolean[128][128];
		this.input = input;
		dungeon = img;
		//player = new Player("", "playerSprites.png");
	}

	public void update() {
		if (floorChange) {
			if (floor % 2 == 0) {
				cellularNoise = noise.getCellularAutomataNoise(cellularNoise.length, cellularNoise[0].length, 5, 3, 90);
			} else {
				randomRooms = noise.generateRooms(20, 4096, 4096, -512, -512, 512, 512, 128, 128, 64);
			}
			createImage();
			floorChange = false;
		}
		if(input.isKeyDown(KeyEvent.VK_W) && input.isKeyDown(KeyEvent.VK_A)){
			yDif += 1/MathHelper.root2;
			xDif += 1/MathHelper.root2;
		}else if (input.isKeyDown(KeyEvent.VK_W) && input.isKeyDown(KeyEvent.VK_D)){
			yDif += 1/MathHelper.root2;
			xDif -= 1/MathHelper.root2;
		}else if(input.isKeyDown(KeyEvent.VK_S) && input.isKeyDown(KeyEvent.VK_A)){
			yDif -= 1/MathHelper.root2;
			xDif += 1/MathHelper.root2;
		}else if(input.isKeyDown(KeyEvent.VK_S) && input.isKeyDown(KeyEvent.VK_D)){
			yDif -= 1/MathHelper.root2;
			xDif -= 1/MathHelper.root2;
		}else if (input.isKeyDown(KeyEvent.VK_W)) {
			yDif++;
		}else if (input.isKeyDown(KeyEvent.VK_A)) {
			xDif++;
		}else if (input.isKeyDown(KeyEvent.VK_S)) {
			yDif--;
		}else if (input.isKeyDown(KeyEvent.VK_D)) {
			xDif--;
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height);
		g2d.drawImage(dungeon, (int)xDif, (int)yDif, null);
		//player.draw(g2d);
	}

	public void createImage() {
		Graphics2D g2d = (Graphics2D) dungeon.getGraphics();
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, dungeon.getWidth(null), dungeon.getHeight(null));
		if (floor % 2 == 0) {
			g2d.setColor(Color.DARK_GRAY);
			for (int i = 0; i < cellularNoise.length; i++) {
				for (int j = 0; j < cellularNoise[0].length; j++) {
					if (cellularNoise[i][j]) {
						g2d.fillRect(i * 8, j * 8, 8, 8);
					}
				}
			}
		} else {
			g2d.setColor(Color.DARK_GRAY);
			for (int i = 0; i < randomRooms.length; i++) {
				if (randomRooms[i] != null) {
					g2d.fillRect(randomRooms[i].x, randomRooms[i].y, randomRooms[i].width, randomRooms[i].height);
				}
			}
		}
	}

	public void incrementFloor() {
		floor++;
		floorChange = true;
	}

}
