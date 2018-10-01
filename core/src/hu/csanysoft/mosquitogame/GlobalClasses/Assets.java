//https://github.com/tuskeb/mester
package hu.csanysoft.mosquitogame.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

import hu.csanysoft.mosquitogame.MosquitoActor;


public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;
	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";

	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();

	static {

		fontParameter.fontFileName = "arial.ttf";

		fontParameter.fontParameters.size = 30;

		fontParameter.fontParameters.characters = CHARS;

		fontParameter.fontParameters.color = Color.WHITE;

	}

	public static final AssetDescriptor<BitmapFont> ARIAL_30_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);

	public static final AssetDescriptor<Texture> MAN_TEXTURE
			= new AssetDescriptor<Texture>("pictures/man.gif", Texture.class);

	public static final AssetDescriptor<Texture> MOSQUITO_TEXTURE
			= new AssetDescriptor<Texture>("pictures/mosquito.png", Texture.class);


	public static final AssetDescriptor<Texture> BTN_START_DOWN_TEXTURE

			= new AssetDescriptor<Texture>("pictures/start_down.png", Texture.class);



	public static final AssetDescriptor<Texture> BTN_START_TEXTURE

			= new AssetDescriptor<Texture>("pictures/start.png", Texture.class);



	public static final AssetDescriptor<Texture> BTN_EXIT_TEXTURE

			= new AssetDescriptor<Texture>("pictures/exit.png", Texture.class);



	public static final AssetDescriptor<Texture> BTN_EXIT_DOWN_TEXTURE

			= new AssetDescriptor<Texture>("pictures/exit_down.png", Texture.class);

	public static final AssetDescriptor<Music> MUSIC_MENU
			= new AssetDescriptor<Music>("sounds/FrogTown.mp3", Music.class);


    public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));


		manager.load(MAN_TEXTURE);
		manager.load(MOSQUITO_TEXTURE);

		manager.load(ARIAL_30_FONT);

		manager.load(BTN_START_TEXTURE);

		manager.load(BTN_START_DOWN_TEXTURE);

		manager.load(BTN_EXIT_TEXTURE);

		manager.load(BTN_EXIT_DOWN_TEXTURE);

		manager.load(MUSIC_MENU);
	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
