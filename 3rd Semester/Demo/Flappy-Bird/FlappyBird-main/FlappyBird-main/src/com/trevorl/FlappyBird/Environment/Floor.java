package com.trevorl.FlappyBird.Environment;

import java.awt.Graphics; 
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import com.trevorl.Engine.SpriteLoader;

public class Floor implements GameDimensions, SpriteInfo {
	private BufferedImage sprite;
	
	public Floor() throws IOException {
		SpriteLoader loader = new SpriteLoader(
				FLOOR_SPRITE_FILE, 
				GAME_WIDTH, 
				FLOOR_HEIGHT);
		
		sprite = loader.sprite();
	}
	
	public void move() {
		ImageIcon floorLeft = new ImageIcon(
				sprite.getSubimage(
				0, 0,
				DX, FLOOR_HEIGHT));
		
		ImageIcon floorRight = new ImageIcon(
				sprite.getSubimage(
				DX, 0,
				RIGHT_FLOOR_WIDTH, FLOOR_HEIGHT));
		
		BufferedImage newFloor = new BufferedImage(
				GAME_WIDTH, FLOOR_HEIGHT,
				BufferedImage.TYPE_INT_ARGB);
		
		Graphics newFloorG = newFloor.getGraphics();
		
		newFloorG.drawImage(floorRight.getImage(), 
				0, 0,
				RIGHT_FLOOR_WIDTH, FLOOR_HEIGHT,
				floorRight.getImageObserver());
		
		newFloorG.drawImage(floorLeft.getImage(),
				RIGHT_FLOOR_WIDTH, 0, 
				DX, FLOOR_HEIGHT,
				floorLeft.getImageObserver());
		
		sprite = newFloor;
	}

	public void paint(Graphics g, JComponent component) {
		g.drawImage(sprite, 0, 
				FLOOR_Y,
				component);
	}
	
}
