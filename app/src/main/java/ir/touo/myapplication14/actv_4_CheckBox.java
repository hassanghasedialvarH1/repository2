package ir.touo.myapplication14;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class actv_4_CheckBox extends AppCompatActivity {

    CheckBox checkBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv_4_checkbox);

      //  onCheckboxClicked();
      //  checkBox = findViewById(R.id.act_4_checkBox);

      //  checkBox.setChecked(true);

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.act_4_checkBox:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(),"چک باکس 2 تیک خورد",
                            Toast.LENGTH_SHORT).show();
                }
            else
                // Remove the meat
                    Toast.makeText(getApplicationContext(),"چک باکس 2 تیک نخورد",
                            Toast.LENGTH_SHORT).show();
                break;

            case R.id.act_4_checkbox_cheese:
                if (checked) {
                    // Cheese me
                    Toast.makeText(getApplicationContext(),"چک باکس 1 تیک خورد",
                            Toast.LENGTH_SHORT).show();
                }
            else
                // I'm lactose intolerant
                    Toast.makeText(getApplicationContext(),"چک باکس 1 تیک نخورد",
                            Toast.LENGTH_SHORT).show();
                break;

            // TODO: Veggie sandwich
        }
    }

}
