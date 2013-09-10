/*
 * Copyright (c) 2002-2010 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.github.davidmoten.spaceinvaders;

import java.applet.Applet;

import com.github.davidmoten.lwjgl.GameManager;
import com.github.davidmoten.lwjgl.GameFactory;
import com.github.davidmoten.spaceinvaders.Game.Mode;

public class GameApplet extends Applet {

	private static final long serialVersionUID = 2639530711071685417L;

	private final GameManager manager;

	public GameApplet() {
		GameFactory gameFactory = new GameFactory() {
			@Override
			public Runnable createGame() {
				return new Game(Mode.APPLET, false);
			}

		};
		manager = new GameManager(this, gameFactory);
	}

	/**
	 * initialise applet by adding a canvas to it, this canvas will start the
	 * LWJGL Display and game loop in another thread. It will also stop the game
	 * loop and destroy the display on canvas removal when applet is destroyed.
	 */
	@Override
	public void init() {
		manager.start();
	}

	/**
	 * Applet Destroy method will remove the canvas, before canvas is destroyed
	 * it will notify stopLWJGL() to stop main game loop and to destroy the
	 * Display
	 */
	@Override
	public void destroy() {
		manager.cleanUp();
		super.destroy();
	}

}