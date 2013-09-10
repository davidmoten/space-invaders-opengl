package com.github.davidmoten.spaceinvaders;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.github.davidmoten.lwjgl.GameManager;
import com.github.davidmoten.lwjgl.GameFactory;
import com.github.davidmoten.spaceinvaders.Game.Mode;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 3243493114596654127L;
	private static final String LWJGL_LIBRARY_PATH = "org.lwjgl.librarypath";
	private final GameManager manager;

	public GameFrame() {
		setTitle("Space Invaders");
		setSize(800, 600);
		GameFactory gameFactory = new GameFactory() {
			@Override
			public Runnable createGame() {
				return new Game(Mode.APPLICATION, isFullScreen());
			}

			private boolean isFullScreen() {
				return "true".equals(System.getProperty("fullScreen"));
			}
		};
		manager = new GameManager(getContentPane(), gameFactory);
	}

	public void start() {
		manager.start();
	}

	public static void main(String[] args) {
		if (System.getProperty(LWJGL_LIBRARY_PATH) == null)
			System.setProperty(LWJGL_LIBRARY_PATH,
					new File("target/natives").getAbsolutePath());

		// new Game(false).run();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameFrame frame = new GameFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.start();
			}
		});
	}
}
