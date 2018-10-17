package hu.csanysoft.mosquitogame.MyBaseClasses.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanysoft.mosquitogame.TheMosquitoGame;

public class MyInputField extends MyTextField {

    public enum InputMode {TEXT, FLOAT, DECIMAL, POSITIVE_FlOAT_ONLY, POSITIVE_DECIMAL_ONLY};


    TextFieldStyle validStyle, invalidStyle;
    String placeholder, unit;
    private float value = 0;
    InputMode inputMode;
    private boolean valid = true;


    public MyInputField(final String placeholder, String unit, TextFieldStyle validStyle, TextFieldStyle invalidStyle, InputMode inputMode) {
        super(placeholder+0+" "+unit, validStyle);
        this.validStyle = validStyle;
        this.invalidStyle = invalidStyle;
        this.placeholder = placeholder;
        this.inputMode = inputMode;
        this.unit = unit;
        setWidth(500);
        setDisabled(true);
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
        this.valid = valid;
    }

    public boolean isValid(){
        return valid;
    }

    public float getValue() {
        return value;
    }

    Input.TextInputListener textListener = new Input.TextInputListener() {
        @Override
        public void input(String text) {
            switch (inputMode){
                case FLOAT:
                    try{
                        value = Float.parseFloat(text.replace(',', '.'));
                        setDataValidity(true);
                        if(value %1 == 0) setText(placeholder + (int)(value)+" "+unit);
                        else setText(placeholder+value+" "+unit);
                    }catch(Exception e){
                        e.printStackTrace();
                        setDataValidity(false);
                    }
                    break;
                case DECIMAL:
                    try{
                        value = Integer.parseInt(text);
                        setDataValidity(true);
                        setText(placeholder+value+" "+unit);
                    }catch(Exception e){
                        e.printStackTrace();
                        setDataValidity(false);
                    }
                    break;
                case POSITIVE_DECIMAL_ONLY:
                    try{
                        value = Integer.parseInt(text);
                        if(value >= 0) {
                            setDataValidity(true);
                            setText(placeholder + value+" "+unit);
                        }else{
                            setDataValidity(false);
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                        setDataValidity(false);
                    }
                    break;
                case POSITIVE_FlOAT_ONLY:
                    try{
                        value = Float.parseFloat(text.replace(',', '.'));
                        if(value >= 0) {
                            setDataValidity(true);
                            if (value % 1 == 0) setText(placeholder + (int) (value)+" "+unit);
                            else setText(placeholder + value+" "+unit);
                        }else setDataValidity(false);
                    }catch(Exception e){
                        e.printStackTrace();
                        setDataValidity(false);
                    }
                    break;
                case TEXT:
                    try{
                        setText(text);
                        setDataValidity(true);
                    }catch (Exception e){
                        e.printStackTrace();
                        setDataValidity(false);
                    }
            }

        }

        @Override
        public void canceled() {
            System.out.println("cancelled ");
        }
    };
}
