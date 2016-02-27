package main;

import java.awt.Graphics2D;
import java.awt.Image;

import game.Dungeon;
import utils.AbstractMain;
import utils.InputHandler;
import utils.State;

public class Main extends AbstractMain {

	private static final long serialVersionUID = 8076015885157520359L;
	private Dungeon dungeon;

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
	@Override
	public void initialise() {
		running = true;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("You Are Alone.");
		this.setSize(InputHandler.screenSize);
		this.setVisible(true);
		dungeon = new Dungeon();
		State.state = State.STATE.DUNGEON;
	}

	@Override
	public void update() {
		switch(State.state){
		case DUNGEON:
			dungeon.update();
			break;
		case MAIN_MENU:
			break;
		case LOAD_GAME_MENU:
			break;
		case NEW_GAME_MENU:
			break;
		case CONNECT_MENU:
			break;
		default:
			break;
		}
	}

	@Override
	public void draw() {
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		Image offImage = this.createImage(InputHandler.screenSize.width, InputHandler.screenSize.height);
		Graphics2D offGraphics = (Graphics2D) offImage.getGraphics();
		switch(State.state){
		case DUNGEON:
			dungeon.draw(offGraphics);
			g2d.drawImage(offImage, 0, 0, null);
			break;
		case MAIN_MENU:
			break;
		case LOAD_GAME_MENU:
			break;
		case NEW_GAME_MENU:
			break;
		case CONNECT_MENU:
			break;
		default:
			break;
		}
	}

}
