package com.trevorl.FlappyBird.GameItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.Timer;

import com.trevorl.FlappyBird.Environment.GameDimensions;

public class PoleMover implements GameDimensions{
	
	private ConcurrentLinkedQueue<Pole>poles;
	public boolean canGenerate;
	public Timer generationTimer;
	
	public PoleMover(ConcurrentLinkedQueue<Pole>poles) {
		this.poles = poles;
		canGenerate = true;
		
		generationTimer = new Timer(POLE_GENERATION_DELAY,
		        new ActionListener() {
		    @Override
			public void actionPerformed(ActionEvent e) {
			    canGenerate = true;
				generationTimer.stop();
			}
		});
	}
	
	public void move() {
		poles.forEach(pole-> pole.x -= DX);
	}
	
	public void reset() {
		poles.clear();
		if(generationTimer.isRunning()) {
			generationTimer.stop();
			canGenerate = true;
		}
	}
	
	public void generate() throws IOException {
		poles.add(new Pole());
		canGenerate = false;
		generationTimer.start();
	}

}
