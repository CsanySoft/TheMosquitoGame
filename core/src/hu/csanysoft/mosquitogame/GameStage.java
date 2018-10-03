package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyStage;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.ShapeType;

public class GameStage extends MyStage {

    float posA, posB, length, mosquitoWidth, travelLength, speedManA, speedManB, speedMosquito, lengthToStart, speedMan, wind;
    Calcuations c;
    ManActor manActor1, manActor2;
    MosquitoActor mosquitoActor;
    boolean canGo, end, once;

    public GameStage(Batch batch, TheMosquitoGame game) {
        super(new ExtendViewport(1024f,768f), batch, game);

        c = new Calcuations();

        posA=100;
        length = 500;
        mosquitoWidth= 20;
        speedManA= .2f;
        speedManB= .4f;
        speedMosquito= 6f;
        posB=posA+length;
        travelLength=2000;
        wind = .2f; //Pozitív=jobbra fúj a szél, negatív = balra fúj a szél. Nem lehet nagyobb vagy egyenlő, mint a szúnyog sebességének fele

        speedMan = 0; //Nincs használva ha különböző a két ember sebessége

        manActor1 = new ManActor(Assets.manager.get(Assets.MAN_TEXTURE),posA,speedManA);
        manActor1.setId((short)0);
        manActor2 = new ManActor(Assets.manager.get(Assets.MAN_TEXTURE), posB+manActor1.getWidth(), 0-speedManB);
        manActor2.setId((short)1);
        manActor2.setFlip(true, false);
        mosquitoActor = new MosquitoActor(posA,speedMosquito, mosquitoWidth, true);
        //mosquitoActor.setRightSpeed(speedMosquito+wind);
        //mosquitoActor.setLeftSpeed(0-speedMosquito+wind);

        canGo=false;  end = false;
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

        lengthToStart = c.getLenghtToStart(mosquitoWidth,speedManA, speedManB,speedMosquito,travelLength);
        mosquitoActor.setSpeed(speedMosquito);
        fitWorldToWidth();//Különböző méretű képernyők miatt
    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //float travellableDistance = (((length/((speedMan*2)/(speedMan*10)))*speedMosquito-mosquitoWidth*(speedMosquito*5)) - 10*speedMan)/(10*speedMan)-speedMosquito;


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


        if(length<=mosquitoWidth) {
            manActor1.setSpeed(0);
            manActor2.setSpeed(0);
            mosquitoActor.setSpeed(0);
            end = true;
            if(travelLength-mosquitoActor.travelledLength <= 5 && travelLength-mosquitoActor.travelledLength >= -5) mosquitoActor.travelledLength = travelLength;
        }
    }
}
