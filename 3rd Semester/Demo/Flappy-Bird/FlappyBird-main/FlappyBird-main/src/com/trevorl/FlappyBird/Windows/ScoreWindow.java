package com.trevorl.FlappyBird.Windows;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JComponent;

import com.trevorl.Engine.GameButton;
import com.trevorl.Engine.SpriteDigitWriter;
import com.trevorl.Engine.SpriteLoader;
import com.trevorl.FlappyBird.Environment.GameDimensions;
import com.trevorl.FlappyBird.Environment.SpriteInfo;

public class ScoreWindow implements GameDimensions, SpriteInfo{
	private int bestScore;
	
	private Image scoreWindow;
	private SpriteDigitWriter currentScoreWriter;
	private SpriteDigitWriter bestScoreWriter;
	
	@SuppressWarnings("rawtypes")
	private GameButton restart;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	ScoreWindow(Game game) throws IOException {
		SpriteLoader loader = new SpriteLoader(
				SCORE_WINDOW_SPRITE_FILE, 
				SCORE_WINDOW_WIDTH, 
				SCORE_WINDOW_HEIGHT);
		
		scoreWindow = loader.sprite();
		
		int currentScoreWriterY = SCORE_WINDOW_Y + 100;
		
		currentScoreWriter = new SpriteDigitWriter(
				NUMBER_SPRITE_FILE, 
				CENTER_X,
				currentScoreWriterY, 
				NUMBER_SPRITE_ROWS, 
				NUMBER_SPRITE_COLS,
				NUMBER_WIDTH, 
				NUMBER_HEIGHT, 
				NUMBER_GAP);
		
		currentScoreWriter.centerAlign();
		
		int bestScoreWriterY = SCORE_WINDOW_Y + 225;
		
		bestScoreWriter = new SpriteDigitWriter(
				NUMBER_SPRITE_FILE, 
				CENTER_X, 
				bestScoreWriterY, 
				NUMBER_SPRITE_ROWS, 
				NUMBER_SPRITE_COLS,
				NUMBER_WIDTH, 
				NUMBER_HEIGHT, 
				NUMBER_GAP);
		
		bestScoreWriter.centerAlign();
		
		restart = new GameButton(
				RESTART_SPRITE_FILE, 
				CENTER_X, 
				RESTART_Y, 
				BUTTON_WIDTH, 
				BUTTON_HEIGHT , 
				e -> {
					game.reset();
					restart.deactivate();
					game.canPaintScoreWindow = false;
				});
		
		restart.deactivate();
		restart.centerAlign();
		
		game.addMouseListener(restart);
	}

	void prepareScoreWindow(int newScore) {
		if(newScore > bestScore) {
			bestScore = newScore;
		}

		currentScoreWriter.setNumber(newScore);
		bestScoreWriter.setNumber(bestScore);
		
		restart.activate();
	}
	
	private final int SCORE_WINDOW_X = CENTER_X - SCORE_WINDOW_WIDTH / 2;
	
	void paint(Graphics g, JComponent component) {
		g.drawImage(scoreWindow,
				SCORE_WINDOW_X,
				SCORE_WINDOW_Y,
				component);
		
		currentScoreWriter.paint(g, component);
		bestScoreWriter.paint(g, component);
		restart.paint(g, component);
	}
	
}
