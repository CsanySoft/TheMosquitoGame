package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.ShapeType;
import hu.csanysoft.mosquitogame.InputStage;

public class GameStage extends MyStage {

    float posA, posB, length, mosquitoWidth, travelLength, speedManA, speedManB, speedMosquito, lengthToStart, speedMan, wind;
    Calcuations c;
    ManActor manActor1, manActor2;
    MosquitoActor mosquitoActor;
    boolean canGo, end, once, egyszerRobban;
    Image bg;
    ExplosionActor explosionActor;
    Label lblTavolsag, lblMegtettTav;


    public GameStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(game.SCREEN_WIDTH,game.SCREEN_HEIGHT), batch, game);

        bg = new Image(Assets.manager.get(Assets.BACKGROUND_TEXTURE));
        addActor(bg);
        addActor(lblMegtettTav);
        addActor(lblTavolsag);

        c = new Calcuations();

        posA=100;
        length = InputStage.getValue(InputStage.EMBER_TAV);
        mosquitoWidth= 20;
        speedManA= InputStage.getValue(InputStage.EMBER1_SEB);
        speedManB= InputStage.getValue(InputStage.EMBER2_SEB);
        speedMosquito= InputStage.getValue(InputStage.SZUNYOG_SEB);
        posB=posA+length;
        travelLength=InputStage.getValue(InputStage.SZUNYOG_TAV);

        System.out.println("length = " + length);
        System.out.println("speedManA = " + speedManA);
        System.out.println("speedManB = " + speedManB);
        System.out.println("speedMosquito = " + speedMosquito);
        System.out.println("travelLength = " + travelLength);

        //wind = InputStage.getValue(InputStage.SZEL); //Pozitív=jobbra fúj a szél, negatív = balra fúj a szél. Nem lehet nagyobb vagy egyenlő, mint a szúnyog sebességének fele

        speedMan = 0; //Nincs használva ha különböző a két ember sebessége

        manActor1 = new ManActor(Assets.manager.get(Assets.MAN_TEXTURE),posA,speedManA);
        manActor1.setId((short)0);
        manActor2 = new ManActor(Assets.manager.get(Assets.MAN_TEXTURE), posB+manActor1.getWidth(), 0-speedManB);
        manActor2.setId((short)1);
        manActor2.flip(true);
        mosquitoActor = new MosquitoActor(posA,speedMosquito, mosquitoWidth, false);
        //mosquitoActor.setRightSpeed(speedMosquito+wind);
        //mosquitoActor.setLeftSpeed(0-speedMosquito+wind);

        canGo=false;  end = false; egyszerRobban=true;
        if(!canGo)mosquitoActor.setSpeed(0);

        addActor(manActor1);
        addActor(manActor2);
        addActor(mosquitoActor);

        addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("x = " + x);
                System.out.println("y = " + y);
            }
        });


        mosquitoActor.setSpeed(speedMosquito);
        //speedMosquito = (mosquitoActor.getRightSpeed() + mosquitoActor.getLeftSpeed()/(wind - ((((wind) * (10*speedManB)) * speedMosquito - 1)/100)));
        lengthToStart = c.getLenghtToStart(mosquitoWidth,speedManA, speedManB,speedMosquito,travelLength);
        fitWorldToWidth();//Különböző méretű képernyők miatt
        setDebugAll(false);
    }

    @Override
    public void init() {
        lblMegtettTav = new Label("Emberek közötti táv: ", getLabelStyle());
        lblTavolsag = new Label("Szúnyog által megtett táv: ", getLabelStyle());
        lblTavolsag.setSize(200, 20);
        lblMegtettTav.setSize(200, 20);
        lblTavolsag.setTouchable(Touchable.disabled);
        lblMegtettTav.setTouchable(Touchable.disabled);
    }


    public Label.LabelStyle getLabelStyle() {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        style.fontColor = Color.WHITE;
        return style;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //float travellableDistance = (((length/((speedMan*2)/(speedMan*10)))*speedMosquito-mosquitoWidth*(speedMosquito*5)) - 10*speedMan)/(10*speedMan)-speedMosquito;


        lblMegtettTav.setText("Szúnyog által megtett táv: "+(int)mosquitoActor.travelledLength);
        lblTavolsag.setText("Emberek közötti táv: "+(int)Math.floor(manActor2.getX() - (manActor1.getX()+manActor1.getWidth())));


        if(!canGo) {
            mosquitoActor.setX(manActor1.getX() + manActor1.getWidth()+1);
        }
        length = manActor2.getX()-manActor1.getX()-manActor1.getWidth();
        if(length<=lengthToStart){
            canGo=true;
            if(once) {
                mosquitoActor.setSpeed(speedMosquito);
                once=false;
            }
        }
        //System.out.println("canGo = " + canGo);
        //System.out.println("speedMosquito = " + speedMosquito);
        //System.out.println("lengthToStart = " + lengthToStart);
        //System.out.println("length = " + length);

        //System.out.println("Travellable: " + travellableDistance);


        if(length<=mosquitoWidth && length > 0) {
            manActor1.setSpeed(0.06f);
            manActor2.setSpeed(-0.06f);
            mosquitoActor.setX(manActor1.getX()+manActor1.getWidth());
            mosquitoActor.setSpeed(0);
            mosquitoActor.setRightSpeed(0);
            mosquitoActor.setLeftSpeed(0);
            if(mosquitoActor.getWidth()>=-1)mosquitoActor.setWidth(mosquitoActor.getWidth()-0.12f);
            end = true;
            if(travelLength-mosquitoActor.travelledLength <= 5 && travelLength-mosquitoActor.travelledLength >= -5) mosquitoActor.travelledLength = travelLength;
        }

        if(length<0.5f) {
            manActor1.setSpeed(0);
            manActor2.setSpeed(0);
            getActors().removeValue(mosquitoActor,true);
            if(egyszerRobban) {
                addActor(explosionActor = new ExplosionActor());
                explosionActor.setPosition(mosquitoActor.getX()-explosionActor.getWidth()/2 + mosquitoWidth/2, mosquitoActor.getY()-explosionActor.getHeight()/2 + mosquitoWidth/2);
                egyszerRobban = false;
                manActor1.setFps(0);
                manActor2.setFps(0);
            }
        }
    }

    @Override
    public void resize(int screenWidth, int screenHeight) {
        super.resize(screenWidth, screenHeight);

        lblTavolsag.setPosition(10, getViewport().getWorldHeight() - lblTavolsag.getHeight()-10);
        lblMegtettTav.setPosition(10, getViewport().getWorldHeight() - (lblTavolsag.getHeight()-10)*8);
        lblTavolsag.setSize(200, 20);
        lblMegtettTav.setSize(200, 20);
        bg.setWidth(getViewport().getWorldWidth());
        bg.setHeight(getViewport().getWorldHeight());
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK || keycode == Input.Keys.ESCAPE){
            game.setScreenBackByStackPop();
        }
        return false;
    }
}
