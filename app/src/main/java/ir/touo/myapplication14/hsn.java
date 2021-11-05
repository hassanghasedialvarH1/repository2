package ir.touo.myapplication14;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class hsn extends AppCompatActivity {

    RecyclerView recycler;
    UserAdapter adapter;
    List<User> list;
    Button btn;
    EditText txt;
    int ss[] ={21};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hsn);

        findViews();
        btnClicks();

    }

    void sendMessage(View view){
        String message;
        message = txt.getText().toString();

    }

    void findViews(){
        txt = findViewById(R.id.act_hsn_editTextPhone);
        recycler = findViewById(R.id.act_hsn_recycler);
        btn = findViewById(R.id.act_hsn_btn);

    }

    void btnClicks(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  recycler.setTextAlignment(Integer.parseInt(txt.getText().toString()));
            }
        });
    }

}
