package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Game.MyGame;

public class TheMosquitoGame extends MyGame {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;


	public TextButton.TextButtonStyle btnStart() {

		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

		textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);

		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_TEXTURE)));

		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_TEXTURE)));

		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_DOWN_TEXTURE)));

		return textButtonStyle;

	}



	public TextButton.TextButtonStyle btnExit() {

		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

		textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);

		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_TEXTURE)));

		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_TEXTURE)));

		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_DOWN_TEXTURE)));

		return textButtonStyle;

	}

	public TextField.TextFieldStyle getTextFieldStyle_Black() {
		// TODO: 1/5/2018 textfield texture
		TextField.TextFieldStyle style = new TextField.TextFieldStyle();
		//style.background.setLeftWidth(style.background.getLeftWidth()+20);
		//style.background.setRightWidth(style.background.getRightWidth()+20);
		style.font = Assets.manager.get(Assets.ARIAL_30_FONT);
		style.font.getData().setScale(1.2f);

		style.fontColor = Color.BLACK;
		return style;
	}
	public TextField.TextFieldStyle getTextFieldStyle_Red() {
		// TODO: 1/5/2018 textfield texture
		TextField.TextFieldStyle style = new TextField.TextFieldStyle();
		//style.background.setLeftWidth(style.background.getLeftWidth()+20);
		//style.background.setRightWidth(style.background.getRightWidth()+20);
		style.font = Assets.manager.get(Assets.ARIAL_30_FONT);
		style.font.getData().setScale(1.2f);
		style.fontColor = Color.RED;
		return style;
	}

	static public class FloatNumberFilter implements TextField.TextFieldFilter{
        @Override
        public boolean acceptChar(TextField textField, char c) {
            return Character.isDigit(c) || c == '.' || c == ',' || c == '-';
        }
    }

	@Override
	public void create () {
		Assets.prepare();
		setScreen(new LoadingScreen(this));
	}

	@Override
	public void resume() {
		super.resume();
		Assets.manager.update();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.unload();
	}
}
