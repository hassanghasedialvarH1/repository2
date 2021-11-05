package ir.touo.myapplication14;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class actv_2_EditText extends AppCompatActivity {

    TextView txtOuautpot ;
    TextView edtinpot ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv_2_edittext);

        txtOuautpot = (TextView)findViewById(R.id.actv_2_txtOuautpot);
        edtinpot = (TextView) findViewById(R.id.actv_2_editTextinpot);

        edtinpot.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                txtOuautpot.setText(edtinpot.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
