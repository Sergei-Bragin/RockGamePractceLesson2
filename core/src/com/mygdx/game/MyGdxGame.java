package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.mygdx.game.Reload.A;

import com.mygdx.game.Screens.Start;
import com.mygdx.game.Screens.Start2;
import com.uwsoft.editor.renderer.SceneLoader;

public class MyGdxGame extends Game {
	
	public MyGdxGame() {

	}
	public SceneLoader sh;

	@Override
	public void create() {

		A.x_pit=(float)(Gdx.graphics.getWidth()* A.y_orig)/Gdx.graphics.getHeight();
		if(A.x_pit<= A.x_orig) A.x_pit= A.x_orig;
		A.y_pit=(float)(Gdx.graphics.getHeight()* A.x_orig)/Gdx.graphics.getWidth();
		if(A.y_pit<= A.y_orig) A.y_pit= A.y_orig;


		// Блин не комитит

		sh = new SceneLoader();
		setScreen(new Start(this));

	}
}
