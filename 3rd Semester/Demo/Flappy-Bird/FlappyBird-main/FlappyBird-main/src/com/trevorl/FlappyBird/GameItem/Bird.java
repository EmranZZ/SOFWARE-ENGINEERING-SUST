package com.trevorl.FlappyBird.GameItem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.Timer;

import com.trevorl.Engine.SpriteLoader;
import com.trevorl.Engine.SpritePlayer;
import com.trevorl.FlappyBird.Environment.GameDimensions;
import com.trevorl.FlappyBird.Environment.SpriteInfo;

public class Bird implements GameDimensions, SpriteInfo {
	
	int y;
	private int dy;
	private int distanceFallen;
	private double birdRotationAngle;
	
	public boolean dead;
	public boolean hasHitGround;
	
	public boolean playerMoved;
	public boolean keyInputBlocked;
	
	private SpritePlayer spritePlayer;

	public boolean allowSpriteChange;
	private Timer spriteChangeTimer = new Timer(SPRITE_UPDATE_DELAY,
			new ActionListener() {
	    @Override
		public void actionPerformed(ActionEvent e) {
		    allowSpriteChange = true;
			spriteChangeTimer.stop();
		}	
	});

	public Bird() throws IOException{
		y = BIRD_INITIAL_Y;
		dy = 1;

		SpriteLoader loader = new SpriteLoader(
				BIRD_SPRITE_FILE, 
				NUMBER_BIRD_SPRITES, 
				BIRD_SPRITE_ROWS,
				BIRD_SPRITE_COLS,
				BIRD_WIDTH,
				BIRD_HEIGHT);

		spritePlayer = new SpritePlayer(loader.frames());
		allowSpriteChange = true;
	}
	
	public void reset() {
		y = BIRD_INITIAL_Y;
		dy = 1;
		distanceFallen = 0;
		birdRotationAngle = 0;
		
		dead = false;
		hasHitGround = false;
		
		playerMoved = false;
		keyInputBlocked = false;
		
		spritePlayer.reset();

	    allowSpriteChange = true;
	}
	
	private final double MOVE_ROTATION =  -Math.PI / 8;
	private final int MOVE_DY =  -15;
	
	public void move() {
		if(!keyInputBlocked && !dead) {
			if(!playerMoved) {
				playerMoved = true;
			}
			
			dy = MOVE_DY;
			distanceFallen = 0;
			birdRotationAngle = MOVE_ROTATION;
			
			keyInputBlocked = true;
		}
	}
	
	public void updateSprite() {
		spritePlayer.update();
		
		allowSpriteChange = false;
		spriteChangeTimer.start();
	}
	
	private final int UPPER_IDLE_Y = BIRD_INITIAL_Y + 6;
	private final int LOWER_IDLE_Y = BIRD_INITIAL_Y - 6;
	private final double FALLING_ROTATION = Math.PI / 12;
	private final double MAX_ROTATION = Math.PI / 2;
	private final int GRAVITY = 2;
	 
	public void checkPosition() {
		if (hasHitGround) {
			return;
		} 
		
		if (!playerMoved) {
			if(y == UPPER_IDLE_Y || y == LOWER_IDLE_Y) {
				dy *= -1;
			}
			
			y += dy;
			return;
		}
		
		if (distanceFallen > 25) {
			birdRotationAngle += FALLING_ROTATION;
			
			birdRotationAngle = 
					Math.min(birdRotationAngle, MAX_ROTATION);
		} 

		if (y + dy <= 0) {
			y = 0;
			
		} else if(y + dy >= BIRD_MAX_Y) {
			y = BIRD_MAX_Y;
			dy = 0;

			hasHitGround = true;
			dead = true;
			return;
		}

		dy += GRAVITY;
		y += dy;
		distanceFallen += dy;
	}
	
	private final int ROTATION_POINT_X = BIRD_X + BIRD_WIDTH / 2;
	private final int ROTATION_POINT_Y_OFFSET = BIRD_HEIGHT / 2;
 
	public void paint(Graphics g, JComponent component) {
	    Graphics2D g2d = (Graphics2D) g;
		    
		AffineTransform backupTransform
		        = g2d.getTransform();

		AffineTransform newTransform 
	            = AffineTransform.getRotateInstance(
		       birdRotationAngle, 
		       ROTATION_POINT_X , 
		       y + ROTATION_POINT_Y_OFFSET);

		g2d.transform(newTransform);
			   
		g2d.drawImage(spritePlayer.currentFrame(), BIRD_X, y, component);
			 
		g2d.setTransform(backupTransform);
	}

}
