package com.trevorl.FlappyBird.Windows;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class FlappyBird extends JFrame {

	private FlappyBird() throws IOException{
		Game game = new Game();
		add(game);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		game.requestFocusInWindow();
		
		game.start();
		
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			try {
				new FlappyBird();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
}
