package ir.touo.myapplication14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //  متغییرهای کلاس
    Thread thread;
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    UserAdapter adapter;
    List<User> list;
    Handler handler;
    Button btn , btb0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setOnClicks();
        getALLUser();



    }

    //   مقدار دهی منوها
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menufile, menu);
        return true;
    }

    //   محدوده باتن منوها
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.calculator:  //  ماشین حساب
                // جای دستورات
                Intent t = new Intent(MainActivity.this,h.class);
                startActivity(t);
                return true;
            case R.id.fil_1:
                // جای دستورات
                Intent i = new Intent(MainActivity.this,hhssn.class);
                startActivity(i);
                return true;
            case R.id.fil_2:
                Intent ii = new Intent(MainActivity.this,actv_1_TextView.class);
                startActivity(ii);
                return true;
            case R.id.fil_3:
                // جای دستورات
                Intent iii = new Intent(MainActivity.this,actv_2_EditText.class);
                startActivity(iii);
                return true;
            case R.id.fil_4:
                // جای دستورات
                Intent w = new Intent(MainActivity.this,actv_3_ImageView.class);
                startActivity(w);
                return true;
            case R.id.fil_5:
                // جای دستورات
                Intent r = new Intent(MainActivity.this,actv_4_CheckBox.class);
                startActivity(r);
                return true;
            case R.id.Mow:
                // جای دستورات
                Toast.makeText(getApplicationContext(),"حرکت دادن",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.new_name:
                myDialog myDialog = new myDialog();
                myDialog.show(getSupportFragmentManager(),null);

                myDialog.setOnAddButtonClick(new myDialog.onAddButtonClick() {
                    @Override
                    public void onAddButton(String firstName, String lastName) {
                        User user = new User();
                        user.setFirstName(firstName);
                        user.setLastName(lastName);

                        AppDatabase.getInstance(getBaseContext()).userDao().insertAll(user);
                        list.add(user);

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();

                            }
                        });

                    }
                });
                return true;
            case R.id.help:
                // جای دستورات
                Toast.makeText(this,"کار آموز قاصدی", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getALLUser() {
        list = AppDatabase.getInstance(this).userDao().getAll();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // adapter = new UserAdapter(this,list);
        adapter = new UserAdapter(this, list, new UserAdapter.QueryEvent() {
            @Override
            public void onDeleteUser(User user, int position) {
               AppDatabase.getInstance(MainActivity.this).userDao().delete(user);
               adapter.notifyItemRemoved(position);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    void findViews(){
        // مقدار دادن متغییر ها
        handler = new Handler();
        floatingActionButton = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_main);
        btn = findViewById(R.id.button);
        btb0 = findViewById(R.id.act_min_button2);

    }

    void setOnClicks(){
        //   محدوده باتن
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Toast.makeText(getApplicationContext(),"صفحه لود شده جاوا است", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this,hhssn.class);
                startActivity(i);
            }
        });

        btb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(MainActivity.this,h.class);
                startActivity(ii);
            }
        });

        //   محدوده باتن تا اینجا
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog myDialog = new myDialog();
                myDialog.show(getSupportFragmentManager(),null);

                myDialog.setOnAddButtonClick(new myDialog.onAddButtonClick() {
                    @Override
                    public void onAddButton(String firstName, String lastName) {
                        User user = new User();
                        user.setFirstName(firstName);
                        user.setLastName(lastName);

                        AppDatabase.getInstance(getBaseContext()).userDao().insertAll(user);
                        list.add(user);

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();

                            }
                        });

                    }
                });
            }
        });

    }

}