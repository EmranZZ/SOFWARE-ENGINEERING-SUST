package com.trevorl.FlappyBird.Environment;

public interface GameDimensions {
	
	public final static int DX = 5;
	
	public final static int GAME_WIDTH = 475;
	public final static int GAME_HEIGHT = 575;
	public final static int CENTER_X = GAME_WIDTH / 2;
	
	public final static int FLOOR_HEIGHT = 70;
	
	public final static int PLAY_AREA_HEIGHT = 
			GAME_HEIGHT - FLOOR_HEIGHT;
	
	public final static int TITLE_WIDTH = 350;
	public final static int TITLE_HEIGHT = 200;
	public final static int TITLE_Y =  (int)(GAME_HEIGHT * .05);
	
	public final static int NUMBER_WIDTH = 40;
	public final static int NUMBER_HEIGHT = 50;
	public final static int NUMBER_GAP = 5;
	
	public final static int SCORE_WRITER_Y = 25;
	
	public final static int SCORE_WINDOW_WIDTH = 200;
	public final static int SCORE_WINDOW_HEIGHT = 300;
	public final static int SCORE_WINDOW_Y = (int)(GAME_HEIGHT * .15);

	public final static int BUTTON_WIDTH = 150;
	public final static int BUTTON_HEIGHT = 60;
	
	public final static int START_Y = SCORE_WINDOW_Y 
			+ SCORE_WINDOW_HEIGHT + 40;

	public final static int RESTART_Y = START_Y;
	
	public final static int FLOOR_Y = PLAY_AREA_HEIGHT;
	public final static int RIGHT_FLOOR_WIDTH = GAME_WIDTH - DX;
	
	public final static int POLE_WIDTH = 85;
	public final static int POLE_GAP = 120;
	
	public final static int BIRD_WIDTH = 50;
	public final static int BIRD_HEIGHT = 30;
	public final static int BIRD_X = 170;
	public final static int BIRD_INITIAL_Y = 250;
	public final static int BIRD_MAX_Y = PLAY_AREA_HEIGHT - BIRD_HEIGHT + 11;

	public final static int UPDATE_DELAY = 20;
	public final static int SPRITE_UPDATE_DELAY = 80;
	public final static int POLE_GENERATION_DELAY = 1600;
	
}
