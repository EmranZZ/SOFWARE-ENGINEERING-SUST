package com.trevorl.FlappyBird.Windows;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JComponent;

import com.trevorl.Engine.GameButton;
import com.trevorl.Engine.SpriteLoader;
import com.trevorl.FlappyBird.Environment.GameDimensions;
import com.trevorl.FlappyBird.Environment.SpriteInfo;

public class SplashScreen implements GameDimensions, SpriteInfo{
	private Image sprite;
	
	@SuppressWarnings("rawtypes")
	private GameButton start;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	SplashScreen(Game game) throws IOException {
		SpriteLoader loader = new SpriteLoader(
				TITLE_SPRITE_FILE,
				TITLE_WIDTH,
				TITLE_HEIGHT);
		
		sprite = loader.sprite();
		
		start = new GameButton(
				START_SPRITE_FILE, 
				CENTER_X, 
				START_Y, 
				BUTTON_WIDTH, 
				BUTTON_HEIGHT, 
				e-> {
					game.exitedSplashScreen = true;
					game.removeMouseListener(start);
					game.splashScreen = null;
				});
		
		start.centerAlign();
		
		game.addMouseListener(start);
	}
	
	private final int SPLASH_SCREEN_X = CENTER_X - TITLE_WIDTH / 2;
	
	void paint(Graphics g, JComponent component){
		g.drawImage(sprite,
				SPLASH_SCREEN_X,
				TITLE_Y,component);
		
		start.paint(g, component);
	}
	
}
