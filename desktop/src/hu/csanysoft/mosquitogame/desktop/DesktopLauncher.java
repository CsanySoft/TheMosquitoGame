package hu.csanysoft.mosquitogame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=TheMosquitoGame.SCREEN_WIDTH;
		config.height=TheMosquitoGame.SCREEN_HEIGHT;
		new LwjglApplication(new TheMosquitoGame(), config);
	}
}
