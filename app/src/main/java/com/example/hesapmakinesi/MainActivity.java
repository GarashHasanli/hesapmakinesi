package com.example.hesapmakinesi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity {
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getString(R.string.tap_here).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }
    public  void   anyButton( View view)
    {

        switch ((view.getId()))

        {
            case R.id.clear:display.setText(""); break;
            case R.id.square:display.setText(display.getText()+"^"); break;
            case R.id.division:display.setText(display.getText()+"÷"); break;
            case R.id.one:display.setText(display.getText()+"1"); break;
            case R.id.two:display.setText(display.getText()+"2"); break;
            case R.id.three:display.setText(display.getText()+"3"); break;
            case R.id.times:display.setText(display.getText()+"×"); break;
            case R.id.four:display.setText(display.getText()+"4"); break;
            case R.id.five:display.setText(display.getText()+"5"); break;
            case R.id.six:display.setText(display.getText()+"6"); break;
            case R.id.plus:display.setText(display.getText()+"+"); break;
            case R.id.seven:display.setText(display.getText()+"7"); break;
            case R.id.eight:display.setText(display.getText()+"8"); break;
            case R.id.nine:display.setText(display.getText()+"9"); break;
            case R.id.minus:display.setText(display.getText()+"-"); break;
            case R.id.zero:display.setText(display.getText()+"0"); break;
            case R.id.point:display.setText(display.getText()+"."); break;
            case R.id.equal:calculateTheResult(); break;
        }
    }
    private  void  calculateTheResult() {

        String textDisplay=display.getText().toString();
        String reTextDisplay=textDisplay.replaceAll("÷","/");
        reTextDisplay=reTextDisplay.replaceAll("×","*");
        Expression ifade=new ExpressionBuilder(reTextDisplay)
                .build();
        String result=String.valueOf(ifade.evaluate()).toString();
        if (!result.equals("nan"))
        {
            display.setText(result);
        }

    }

}