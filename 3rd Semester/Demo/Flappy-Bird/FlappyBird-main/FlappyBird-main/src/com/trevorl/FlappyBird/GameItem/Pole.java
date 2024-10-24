package com.trevorl.FlappyBird.GameItem;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JComponent;

import com.trevorl.Engine.SpriteLoader;
import com.trevorl.FlappyBird.Environment.GameDimensions;
import com.trevorl.FlappyBird.Environment.SpriteInfo;

public class Pole implements GameDimensions, SpriteInfo{
	private static BufferedImage topPole;
	private static int topPoleHeight;
	
	private static BufferedImage bottomPole;
	
	private static Random random;
	
	private Image thisTopPole;
	private Image thisBottomPole;

	int x;
	
	private int topY;
	private int bottomY;
	
	private int topLength;
	private int bottomLength;
	
	boolean passed;
	
	static {
		SpriteLoader loader = null;
		
		try {
			loader = new SpriteLoader(
					POLE_SPRITE_FILE,
					NUMBER_POLE_SPRITES,
					POLE_SPRITE_ROWS,
					POLE_SPRITE_COLS,
					POLE_WIDTH,
					PLAY_AREA_HEIGHT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		topPole = loader.frame(1);
		bottomPole = loader.frame(0);
		
		topPoleHeight = topPole.getHeight();
		
		random = new Random();
	}
	
	private final static int UPPER_SIZE_LIMIT = PLAY_AREA_HEIGHT - 200;
	private final static int LOWER_SIZE_LIMIT = 100;

	Pole() throws IOException {
		int topPoleEndY = 0;
		int bottomPoleStartY = 0;
	
		while((topPoleEndY = random.nextInt(PLAY_AREA_HEIGHT)) 
				> UPPER_SIZE_LIMIT
				|| topPoleEndY < LOWER_SIZE_LIMIT);
		
		bottomPoleStartY = topPoleEndY + POLE_GAP;	

		thisTopPole = topPole.getSubimage(
				0, topPoleHeight - topPoleEndY, 
				POLE_WIDTH, topPoleEndY);
		
		thisBottomPole = bottomPole.getSubimage(
				0, 0, POLE_WIDTH, 
				PLAY_AREA_HEIGHT - bottomPoleStartY);
		
		x = GAME_WIDTH;
	
		topY = 0;
		bottomY = bottomPoleStartY;
		
		topLength = topPoleEndY;
		bottomLength = PLAY_AREA_HEIGHT - bottomPoleStartY;	
	}

	public void paint(Graphics g, JComponent component) {
		g.drawImage(thisTopPole, x, topY, component);
		
		g.drawImage(thisBottomPole, x, bottomY, component);
	}
	
	/**
	 * Pole collision logic. Returns the number of poles the
	 * bird has passed for score updating.
	 */
	public static int checkPoleCollisions(
			ConcurrentLinkedQueue<Pole>poles, Bird bird) {
		
		Iterator<Pole>poleItr = poles.iterator();
		
		int addToScore = 0;
		
		while(poleItr.hasNext()) {
			Pole pole = poleItr.next();
			
			if(!pole.passed 
					&& BIRD_X > pole.x + POLE_WIDTH) {
				addToScore++;
				pole.passed = true;
			}
			
			if(pole.x + POLE_WIDTH <= 0) {
				poleItr.remove();
				continue;
			}
			
			if(poleHasCollision(
					pole.x, pole.topY, POLE_WIDTH, pole.topLength,
					BIRD_X, bird.y, BIRD_WIDTH, BIRD_HEIGHT)
					
					||
					
				poleHasCollision(
					pole.x, pole.bottomY, POLE_WIDTH, pole.bottomLength,
					BIRD_X, bird.y, BIRD_WIDTH, BIRD_HEIGHT)) {
				
				bird.dead = true;
			}
		}
		
		return addToScore;
	}
	
	private static boolean poleHasCollision(
			int x1,int y1,int w1,int l1,
			int x2,int y2,int w2,int l2) {
		
		return x1 < x2 + w2 
		        && x1 + w1 > x2 
		        &&  y1 < y2 + l2 
		        &&  l1 + y1 > y2;
	}

}
