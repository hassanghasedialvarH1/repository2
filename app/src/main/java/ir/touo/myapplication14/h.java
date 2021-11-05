package ir.touo.myapplication14;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class h  extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9 ;
    Button btnmsavi,btnjam,btnmnha,btnzarb,btntagsim,btndarsad,btnc,btnac ;
    TextView textView;
    Animation zooming;
    float num1,num2;
    String OP = "";
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.h);

        find_views();
        setOnClick();
        textView.setText("0.0");
        textView.setTextSize(40);
        textView.setAnimation(zooming);

    }

    void setNum(int num){
        String tmp = textView.getText().toString() ;
        textView.setAnimation(zooming);
        if (OP.equals("")){
            if (tmp.equalsIgnoreCase("0.0"))
                textView.setText(num+"");
            else
                textView.setText(tmp+num);
        }
        else {
            if (!flag){
                textView.setText(num+"");
                flag = true;
            }
            else
                textView.setText(tmp+num);
        }
    }

    void setFonts(){
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Nazanin Bold.ttf");
        textView.setTypeface(font);
    }

    void find_views(){
        textView = findViewById(R.id.textView);
        zooming = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btnmsavi = findViewById(R.id.button_mosavi);
        btnjam = findViewById(R.id.button_jam);
        btnmnha = findViewById(R.id.button_mnha);
        btnzarb = findViewById(R.id.button_x);
        btntagsim = findViewById(R.id.button_tagsim);
        btndarsad = findViewById(R.id.button_darsad);
        btnc = findViewById(R.id.button_c);
        btnac = findViewById(R.id.button_ac);

    }

    void setOnClick(){
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = textView.getText().toString().trim();
                if (!tmp.equalsIgnoreCase("0.0")){
                    textView.startAnimation(zooming);
                    textView.setText(tmp+"0");
                }
                textView.setAnimation(zooming);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(3);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(4);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(5);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(6);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(7);

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(8);

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(9);

            }
        });

        btnmsavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2 = Float.parseFloat(textView.getText().toString());
                float result = 0;
                switch (OP) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                textView.setAnimation(zooming);
                textView.setText(result+"");
                num1 = num2 = 0;
                OP = "";
            }
        });

        btnjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Float.parseFloat(textView.getText().toString());
                OP = "+";
            }
        });

        btnmnha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Float.parseFloat(textView.getText().toString());
                OP = "-";
            }
        });

        btnzarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Float.parseFloat(textView.getText().toString());
                OP = "*";
            }
        });

        btntagsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Float.parseFloat(textView.getText().toString());
                OP = "/";
            }
        });

        btndarsad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = num2 = 0;
                OP ="";
                textView.setText("0.0");
                flag = false;
            }
        });

        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = num2 = 0;
                OP ="";
                textView.setText("0.0");
                flag = false;
            }
        });

    }

}
