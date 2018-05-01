package com.example.nurik.sfp;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    protected Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = Camera.open();

    }

    public void startEncoding(View v) {
        EditText textMorse = (EditText)findViewById(R.id.textMorse);
        String data = textMorse.getText().toString().toLowerCase();
        String morseData = getMorseString(data);
        for (int i=0;i<morseData.length();++i) {
            switch ( morseData.charAt(i) ) {
                case '.':
                    dot();
                    break;
                case '-':
                    dash();
                    break;
                case '|':
                    sep();
                    break;
                default:
                    space();
                    break;
            }
        }
    }

    void dot() {
        turnOn();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        catch (Exception e) {}
        turnOff();
    }

    void dash() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        catch (Exception e) {}
    }

    void space() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        }
        catch (Exception e) {}
    }

    void sep() {
        turnOn();
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        }
        catch (Exception e) {}
        turnOff();
    }

    private void turnOff() {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.stopPreview();
    }

    private void turnOn() {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    private String getMorseString(String data) {
        String res = "";
        for (int i=0;i<data.length();++i) {
            res+=getMorseCode(data.charAt(i));
        }
        return res;
    }

    private String getMorseCode(char c) {
        switch ( c ) {
            case 'a':
                return (".- ");
            case 'b':
                return ("-... ");
            case 'c':
                return ("-.-. ");
            case 'd':
                return ("-.. ");
            case 'e':
                return (". ");
            case 'f':
                return ("..-. ");
            case 'g':
                return ("--. ");
            case 'h':
                return (".... ");
            case 'i':
                return (".. ");
            case 'j':
                return (".--- ");
            case 'k':
                return ("-.- ");
            case 'l':
                return (".-.. ");
            case 'm':
                return ("-- ");
            case 'n':
                return ("-. ");
            case 'o':
                return ("--- ");
            case 'p':
                return (".--. ");
            case 'q':
                return ("--.- ");
            case 'r':
                return (".-. ");
            case 's':
                return ("... ");
            case 't':
                return ("- ");
            case 'u':
                return ("..- ");
            case 'v':
                return ("...- ");
            case 'w':
                return (".-- ");
            case 'x':
                return ("-..- ");
            case 'y':
                return ("-.-- ");
            case 'z':
                return ("--... ");
            case '1':
                return (".---- ");
            case '2':
                return ("..--- ");
            case '3':
                return ("...-- ");
            case '4':
                return ("....- ");
            case '5':
                return ("..... ");
            case '6':
                return ("-.... ");
            case '7':
                return ("--... ");
            case '8':
                return ("---.. ");
            case '9':
                return ("----. ");
            case '0':
                return ("----- ");
            case ',':
                return ("..-.. ");
            case '.':
                return (".-.-.- ");
            case '?':
                return ("..--.. ");
            case '!':
                return ("-.-.-- ");
            case ';':
                return ("-.-.-. ");
            case ':':
                return ("---... ");
            case '/':
                return ("-..-. ");
            case '+':
                return ("-.-.- ");
            case '-':
                return ("-....- ");
            case '=':
                return ("-...- ");
            case '@':
                return (".--.-. ");
        }
        return "|";
    }


}
