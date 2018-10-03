package hu.csanysoft.mosquitogame.MyBaseClasses.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class MyInputField extends MyTextField {

    TextFieldStyle validStyle, invalidStyle;
    String placeholder;
    private float value = 0;

    public MyInputField(final String placeholder, TextFieldStyle validStyle, TextFieldStyle invalidStyle) {
        super(placeholder+0, validStyle);
        this.validStyle = validStyle;
        this.invalidStyle = invalidStyle;
        this.placeholder = placeholder;
        setWidth(500);
        //setTextFieldFilter(new TheMosquitoGame.FloatNumberFilter());
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.input.getTextInput(textListener, placeholder, "", "Adj meg egy értéket");
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

    public float getValue() {
        return value;
    }

    Input.TextInputListener textListener = new Input.TextInputListener() {
        @Override
        public void input(String text) {
            try{
                value = Float.parseFloat(text.replace(',', '.'));
                setDataValidity(true);
                if(value %1 == 0) setText(placeholder + (int)(value));
                else setText(placeholder+value);
            }catch(Exception e){
                e.printStackTrace();
                setDataValidity(false);
            }
        }

        @Override
        public void canceled() {
            System.out.println("cancelled ");
        }
    };
}
