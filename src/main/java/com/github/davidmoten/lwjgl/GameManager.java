package com.github.davidmoten.lwjgl;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class GameManager {

	private final Container container;

	/** The Canvas where the LWJGL Display is added */
	private Canvas displayParent;

	/** Thread which runs the main game loop */
	private Thread gameThread;

	/** The Game instance */
	private Runnable game;

	private final GameFactory gameFactory;

	public GameManager(Container component, GameFactory gameFactory) {
		this.container = component;
		this.gameFactory = gameFactory;
	}

	public Canvas getDisplayParent() {
		return displayParent;
	}

	public void start() {
		container.setLayout(new BorderLayout());
		try {
			displayParent = new Canvas() {
				private static final long serialVersionUID = 6214343040898248932L;

				@Override
				public void addNotify() {
					super.addNotify();
					startLWJGL();
				}

				@Override
				public void removeNotify() {
					stopLWJGL();
					super.removeNotify();
				}
			};
			displayParent.setSize(container.getWidth(), container.getHeight());
			container.add(displayParent);
			displayParent.setFocusable(true);
			displayParent.requestFocus();
			displayParent.setIgnoreRepaint(true);
			container.setVisible(true);
		} catch (Exception e) {
			System.err.println(e);
			throw new RuntimeException("Unable to create display");
		}
	}

	/**
	 * Once the Canvas is created its add notify method will call this method to
	 * start the LWJGL Display and game loop in another thread.
	 */
	public void startLWJGL() {
		gameThread = new Thread() {
			@Override
			public void run() {

				try {
					Display.setParent(displayParent);

				} catch (LWJGLException e) {
					e.printStackTrace();
				}
				// start game
				game = gameFactory.createGame();
				game.run();
			}
		};
		gameThread.start();
	}

	/**
	 * Tell game loop to stop running, after which the LWJGL Display will be
	 * destoryed. The main thread will wait for the Display.destroy() to
	 * complete
	 */
	private void stopLWJGL() {
		gameThread.interrupt();
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void cleanUp() {
		container.remove(displayParent);
	}

}
