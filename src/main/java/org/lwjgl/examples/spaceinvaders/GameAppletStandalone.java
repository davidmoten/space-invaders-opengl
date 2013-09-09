package org.lwjgl.examples.spaceinvaders;

import java.io.File;

public class GameAppletStandalone extends GameApplet {

	private static final long serialVersionUID = 5250256585346545114L;

	public GameAppletStandalone() {
		System.setProperty("org.lwjgl.librarypath",
				new File("../natives").getAbsolutePath());
	}

}
