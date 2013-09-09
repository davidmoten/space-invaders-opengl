package org.lwjgl.examples.spaceinvaders;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 3243493114596654127L;
	private static final String LWJGL_LIBRARY_PATH = "org.lwjgl.librarypath";
	private final GameCore core;

	public GameFrame() {
		setTitle("Space Invaders");
		setSize(800, 600);
		core = new GameCore(getContentPane());
	}

	public void start() {
		core.start();
	}

	public static void main(String[] args) {
		if (System.getProperty(LWJGL_LIBRARY_PATH) == null)
			System.setProperty(LWJGL_LIBRARY_PATH,
					new File("target/natives").getAbsolutePath());

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
