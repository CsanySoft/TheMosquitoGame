package hu.csanysoft.mosquitogame.MyBaseClasses.UI;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class MyInputField extends MyTextField implements Input.TextInputListener {

    TextFieldStyle validStyle, invalidStyle;

    public MyInputField(String placeholder, TextFieldStyle validStyle, TextFieldStyle invalidStyle) {
        super(placeholder, validStyle);
        this.validStyle = validStyle;
        this.invalidStyle = invalidStyle;
        setTextFieldFilter(new TheMosquitoGame.FloatNumberFilter());
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void input(String text) {
        System.out.println(this.getText());
    }

    @Override
    public void canceled() {
        System.out.println(this.getText());
    }

    public void setDataValidity(boolean valid){
        this.setStyle(valid ? validStyle : invalidStyle);
    }

    void keyTyped(MyInputField myInputField,char c){

    }
}
