package hu.csanysoft.mosquitogame.MyBaseClasses.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class MyInputField extends MyTextField {

    TextFieldStyle validStyle, invalidStyle;

    public MyInputField(final String placeholder, TextFieldStyle validStyle, TextFieldStyle invalidStyle) {
        super(placeholder, validStyle);
        this.validStyle = validStyle;
        this.invalidStyle = invalidStyle;
        setTextFieldFilter(new TheMosquitoGame.FloatNumberFilter());
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.input.getTextInput(textListener, placeholder+": ", "0", "");
            }
        });
    }

    @Override
    public void init() {
        super.init();
    }



    public void setDataValidity(boolean valid){
        this.setStyle(valid ? validStyle : invalidStyle);
    }

    void keyTyped(MyInputField myInputField,char c){

    }

    Input.TextInputListener textListener = new Input.TextInputListener() {
        @Override
        public void input(String text) {
            System.out.println(text);
        }

        @Override
        public void canceled() {
            System.out.println("cancelled ");
        }
    };
}
