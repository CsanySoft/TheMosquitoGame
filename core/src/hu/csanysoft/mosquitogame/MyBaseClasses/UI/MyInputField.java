package hu.csanysoft.mosquitogame.MyBaseClasses.UI;

import com.badlogic.gdx.Input;

import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class MyInputField extends MyTextField implements Input.TextInputListener {

    TextFieldStyle validStyle, invalidStyle;

    public MyInputField(String text, TextFieldStyle validStyle, TextFieldStyle invalidStyle) {
        super(text, validStyle);
        this.validStyle = validStyle;
        this.invalidStyle = invalidStyle;
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
}
