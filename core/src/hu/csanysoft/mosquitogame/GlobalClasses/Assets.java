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


	public static final AssetDescriptor<Texture> HELPHAND_TEXTURE
			= new AssetDescriptor<Texture>("pictures/help_hand.png", Texture.class);

	public static final AssetDescriptor<Texture> MAN_TEXTURE
			= new AssetDescriptor<Texture>("pictures/man.gif", Texture.class);

	public static final AssetDescriptor<Texture> MAN666_TEXTURE
			= new AssetDescriptor<Texture>("pictures/man666.gif", Texture.class);

	public static final AssetDescriptor<Texture> MOSQUITO_TEXTURE
			= new AssetDescriptor<Texture>("pictures/Moszkito/szunyog.png", Texture.class);

	public static final AssetDescriptor<Texture> BACKGROUND_TEXTURE
			= new AssetDescriptor<Texture>("pictures/bg2.png", Texture.class);

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

	public static final AssetDescriptor<Music>  MSUSIC_AMENO
			= new AssetDescriptor<Music>("sounds/Ameno.mp3", Music.class);

	public static final AssetDescriptor<Music>  MUSIC_MOSQUITOSFX
			= new AssetDescriptor<Music>("sounds/mosquitoSFX.mp3", Music.class);

	public static final AssetDescriptor<Music>  MUSIC_CLICK
			= new AssetDescriptor<Music>("sounds/buttonClick.mp3", Music.class);

	//ATLASOK
	public static final AssetDescriptor<TextureAtlas> EXPLOSION_TEXTURE
			= new AssetDescriptor<TextureAtlas>("animacio/explosion.atlas", TextureAtlas.class);

	public static final AssetDescriptor<TextureAtlas> MOSQUITO_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("pictures/Moszkito/szunyog.atlas", TextureAtlas.class);


	public static final AssetDescriptor<TextureAtlas> WALK_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("animacio/walk.atlas", TextureAtlas.class);

	public static final AssetDescriptor<TextureAtlas> WALK2_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("animacio/walk_2.atlas", TextureAtlas.class);


	public static final AssetDescriptor<TextureAtlas> PUNCH_TEXTUREATLAS
			= new AssetDescriptor<TextureAtlas>("animacio/punch.atlas", TextureAtlas.class);

    public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));


		manager.load(MAN666_TEXTURE);
		manager.load(MSUSIC_AMENO);

		manager.load(HELPHAND_TEXTURE);

		manager.load(MAN_TEXTURE);
		manager.load(MOSQUITO_TEXTURE);

		manager.load(ARIAL_30_FONT);

		manager.load(BTN_START_TEXTURE);

		manager.load(BTN_START_DOWN_TEXTURE);

		manager.load(BTN_EXIT_TEXTURE);

		manager.load(BTN_EXIT_DOWN_TEXTURE);

		manager.load(MOSQUITO_TEXTUREATLAS);

		manager.load(BACKGROUND_TEXTURE);

		manager.load(MUSIC_MENU);

		manager.load(MUSIC_CLICK);

		manager.load(MUSIC_MOSQUITOSFX);


		//ATLASOK
		manager.load(EXPLOSION_TEXTURE);

		manager.load(WALK_TEXTUREATLAS);

		manager.load(PUNCH_TEXTUREATLAS);

		manager.load(WALK2_TEXTUREATLAS);
	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
