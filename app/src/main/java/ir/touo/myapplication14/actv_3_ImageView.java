package ir.touo.myapplication14;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class actv_3_ImageView extends AppCompatActivity {

    ImageView imeig ;
    Button btnnext,btngbl;
    TextView textView1;

    int ids[] = {
            R.drawable.hh,
            R.drawable.hhh,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.shap_button,
    };

    int counter = 0;
    int length;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv_3_imageview);
        findviews();
        initiali();

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                checkandset();
            }
        });

        btngbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                checkandset();
            }
        });

    }

    void checkandset(){
        if (counter >= length)
            counter = 0;
        else if (counter <0)
            counter = length-1;
        imeig.setImageResource(ids[counter]);
        textView1.setText(counter+1 + " / " + length);
    };

    void initiali(){
        length = ids.length;
        checkandset();
    };

    void findviews(){
        imeig = (ImageView) findViewById(R.id.act_3_imageView2);
        btnnext = findViewById(R.id.act_3_btnnext);
        btngbl = findViewById(R.id.act_3_btnprevius);
        textView1 = findViewById(R.id.act_3_textView3);
    }

    void setimagefanction(){
        Bitmap bmp = BitmapFactory.decodeResource(this.getResources(),R.drawable.hh);
        imeig.setImageBitmap(bmp);

        imeig.setImageResource(R.drawable.ic_launcher_background);

        imeig.setImageDrawable(getDrawable(R.drawable.hh));

        Uri uri = Uri.parse("android.resource://ir.touo.myapplication14/drawable/hhh");
        imeig.setImageURI(uri);
    }

}
