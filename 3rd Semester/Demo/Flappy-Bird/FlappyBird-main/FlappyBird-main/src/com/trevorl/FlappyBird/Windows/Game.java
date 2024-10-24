package com.trevorl.FlappyBird.Windows;

import java.awt.Dimension; 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JComponent;
import javax.swing.Timer;

import com.trevorl.Engine.KeyIO;
import com.trevorl.Engine.SpriteDigitWriter;
import com.trevorl.Engine.SpriteLoader;
import com.trevorl.FlappyBird.Environment.Floor;
import com.trevorl.FlappyBird.Environment.GameDimensions;
import com.trevorl.FlappyBird.Environment.SpriteInfo;
import com.trevorl.FlappyBird.GameItem.Bird;
import com.trevorl.FlappyBird.GameItem.Pole;
import com.trevorl.FlappyBird.GameItem.PoleMover;

@SuppressWarnings("serial")
public class Game extends JComponent implements GameDimensions, 
		SpriteInfo {
	
	private int currentScore;
	private Image background;
	private boolean gameOver;
	
	private Bird bird;
	private PoleMover poleMover;
	private ConcurrentLinkedQueue<Pole>poles;
	private Floor floor;
	
	private Timer updateTimer;

	SplashScreen splashScreen;
	boolean exitedSplashScreen;

	private SpriteDigitWriter scoreWriter;
	private ScoreWindow scoreWindow;
	boolean canPaintScoreWindow;

	private KeyIO<String> keyIO;
	
	Game() throws IOException{
		setPreferredSize(
				new Dimension(GAME_WIDTH,GAME_HEIGHT));
		
		SpriteLoader loader = new SpriteLoader(
				BACKGROUND_SPRITE_FILE, 
				GAME_WIDTH, GAME_HEIGHT);
		
		background = loader.sprite();
		
		bird = new Bird();
		
		initKeyListener();

		poles = new ConcurrentLinkedQueue<>();
		poleMover = new PoleMover(poles);
		floor = new Floor();
		
		updateTimer = new Timer(UPDATE_DELAY, 
		        new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					update();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		scoreWriter = new SpriteDigitWriter(
				NUMBER_SPRITE_FILE, 
				CENTER_X, 
				SCORE_WRITER_Y, 
				NUMBER_SPRITE_ROWS, 
				NUMBER_SPRITE_COLS,
				NUMBER_WIDTH, 
				NUMBER_HEIGHT, 
				NUMBER_GAP);
		
		scoreWriter.centerAlign();
		scoreWriter.setNumber(0);
		
		splashScreen = new SplashScreen(this);
		scoreWindow = new ScoreWindow(this);
	}
	
	void start() {
		updateTimer.start();
	}

	void reset() {
		bird.reset();
		poleMover.reset();
		
		currentScore = 0;
		scoreWriter.setNumber(0);

		gameOver = false;
	}
	
	private void update() throws IOException {
		if(!bird.dead) {
			floor.move();
		}
		
		if(!bird.hasHitGround) {
			bird.checkPosition();
		} else {
			canPaintScoreWindow = true;
		}
		
		if(bird.playerMoved 
				&& !bird.dead
				&& bird.allowSpriteChange) {
			
			bird.updateSprite();
		}
		
		if(!gameOver && exitedSplashScreen) {
			keyIO.scanInputs(); 
			
			if(poleMover.canGenerate && bird.playerMoved) {
				poleMover.generate();
			}
			
			poleMover.move();
			
			currentScore += Pole.checkPoleCollisions(poles, bird);
			scoreWriter.setNumber(currentScore);
			
			if(bird.dead) {
				scoreWindow.prepareScoreWindow(currentScore);	
				gameOver = true;	
			}
		}
		
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, this);
		
		for(Pole pole : poles) {
			pole.paint(g, this);
		}
		
		bird.paint(g, this); 
		
		floor.paint(g, this); 
		
		if(!exitedSplashScreen) {
			splashScreen.paint(g, this);
			
		} else {
			scoreWriter.paint(g, this);

			if(canPaintScoreWindow) {
				scoreWindow.paint(g, this);
			}
		}
	}
	
	private void initKeyListener() {	
		ConcurrentHashMap<Integer,String> keyBindings = 
				new ConcurrentHashMap<>();
		
		keyBindings.put(KeyEvent.VK_SPACE, "Move Bird");
		
		keyIO = new KeyIO<String>(keyBindings);

		keyIO.addPressHandler(KeyEvent.VK_SPACE, e-> bird.move());
		
		keyIO.addReleaseHandler(KeyEvent.VK_SPACE, e-> {
			bird.keyInputBlocked = false;
		});

		addKeyListener(keyIO);
	}

}
