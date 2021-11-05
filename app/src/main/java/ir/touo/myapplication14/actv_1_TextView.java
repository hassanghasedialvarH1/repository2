package ir.touo.myapplication14;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class actv_1_TextView extends AppCompatActivity {

    TextView txtCounter;
    int Counter = 0 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv_1_textview);

        txtCounter = (TextView)findViewById(R.id.act_1_textView1);

        txtCounter.setText(Counter+"");
        txtCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Counter++;
                txtCounter.setText("  شماره  \n"+Counter+"");
                String text = txtCounter.getText().toString();
                Toast.makeText(getApplicationContext(), text + "\n hsn", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
