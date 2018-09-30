package hu.csanysoft.mosquitogame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

import hu.csanysoft.mosquitogame.GlobalClasses.Assets;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.MyActor;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanysoft.mosquitogame.MyBaseClasses.Scene2D.ShapeType;

public class MosquitoActor extends OneSpriteStaticActor {

    float pos, speed, travelledLength, rightSpeed, leftSpeed;
    boolean differentSpeeds;

    /**
     *
     * @param texture A szúnyog textúrája
     * @param pos Indulási pozíció
     * @param speed A szúnyog sebessége
     * @param width A szúnyog szélessége
     */

    public MosquitoActor(Texture texture, float pos, float speed, float width, boolean differentSpeeds) {
        super(texture);
        this.pos = pos;
        this.speed = speed;
        setPosition(pos, 100);
        setSize(width, width);
        travelledLength=0;
        this.differentSpeeds = differentSpeeds;
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
        setX(getX() + speed);
        if(speed!=0 && ((GameStage)getStage()).canGo && !(((GameStage)getStage()).end)) travelledLength+=Math.abs(speed);
        System.out.println("travelledLength = " + travelledLength);
        for(Actor actor : getStage().getActors()) {
            actor = actor;
            if(actor instanceof ManActor) {
                if(((ManActor) actor).getId()==0) {
                    if(((ManActor) actor).overlaps(ShapeType.Rectangle, this)) {
                        if(differentSpeeds) setSpeed(rightSpeed);
                        else setSpeed(speed);
                    }
                } else if (((ManActor) actor).getId()==1) {
                    if(((ManActor) actor).overlaps(ShapeType.Rectangle, this)) {
                        if(differentSpeeds) setSpeed(leftSpeed);
                        else setSpeed(0-speed);
                    }
                }
            }
        }
    }
}