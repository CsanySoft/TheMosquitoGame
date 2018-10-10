package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyActor;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.ShapeType;

public class MosquitoActor extends OneSpriteAnimatedActor {

    float pos, speed, travelledLength, rightSpeed, leftSpeed;
    boolean differentSpeeds;
    Music flySound = Assets.manager.get(Assets.MUSIC_MOSQUITOSFX);

    /**
     *
     *
     * @param pos Indulási pozíció
     * @param speed A szúnyog sebessége
     * @param width A szúnyog szélessége
     */

    public MosquitoActor(float pos, float speed, float width, boolean differentSpeeds) {
        super(Assets.manager.get(Assets.MOSQUITO_TEXTUREATLAS));
        this.pos = pos;
        this.speed = speed;
        setPosition(pos, 100);
        setSize(width, width);
        travelledLength=0;
        this.differentSpeeds = differentSpeeds;
        setFps(24);
        if(!differentSpeeds) {
            rightSpeed = speed;
            leftSpeed = 0-speed;
        }

    }

    public float getLeftSpeed() {
        return leftSpeed;
    }

    public void setLeftSpeed(float leftSpeed) {
        this.leftSpeed = leftSpeed;
    }

    public float getRightSpeed() {

        return rightSpeed;
    }

    public void setRightSpeed(float rightSpeed) {
        this.rightSpeed = rightSpeed;
    }

    public void setSpeed (float speed) {
        this.speed = speed;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(!(((GameStage)getStage()).canGo)) setFps(0);
        else setFps(Math.abs(speed*8));

        //System.out.println("travelledLength = " + travelledLength);
        for(Actor actor : getStage().getActors()) {
            actor = actor;
            if(actor instanceof ManActor) {
                if(((ManActor) actor).getId()==0) {
                    if(((ManActor) actor).overlaps(ShapeType.Rectangle, this)) {
                        setSpeed(rightSpeed);
                    }
                } else if (((ManActor) actor).getId()==1) {

                    if(((ManActor) actor).overlaps(ShapeType.Rectangle, this)) {
                        setSpeed(leftSpeed);
                    }
                }
            }
        }
        setX(getX() + speed);
        if(speed!=0 && ((GameStage)getStage()).canGo && !(((GameStage)getStage()).end)) travelledLength+=Math.abs(speed);

        //Ha repül akkor szól a muzsika
        if((((GameStage) getStage()).canGo)){
            flySound.play();
        }else{
            flySound.stop();
        }
    }
}