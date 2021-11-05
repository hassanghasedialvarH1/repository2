package ir.touo.myapplication14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class hhssn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hhssn);

        //   محدوده باتن
        Button btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Toast.makeText(getApplicationContext(),"صفحه کامل لود شده",
                        Toast.LENGTH_SHORT).show();

                Intent o = new Intent(hhssn.this,hsn.class);
                startActivity(o);
            }
        });


    }

    public void runActivity(View v) {

        Intent i = null;
        int id = v.getId();
        if (id == R.id.textView) {
            i = new Intent(hhssn.this, actv_1_TextView.class);}
        else if (id == R.id.textView2){
                i = new Intent(hhssn.this, actv_2_EditText.class);}
        else if (id == R.id.imageView){
            i = new Intent(hhssn.this, actv_3_ImageView.class);}
        else if (id == R.id.checkedTextView){
            i = new Intent(hhssn.this, actv_4_CheckBox.class);}
        startActivity(i);
    }


}
