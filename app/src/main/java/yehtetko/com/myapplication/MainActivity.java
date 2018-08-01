package yehtetko.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import yehtetko.com.myapplication.activity.ShowResultActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstName,lastName,favFood,favNumber;
    Button btnSubmit, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName =(EditText)findViewById(R.id.edit_first_name);
        lastName =(EditText)findViewById(R.id.edit_last_name);
        favFood =(EditText)findViewById(R.id.edit_fav_food);
        favNumber =(EditText)findViewById(R.id.edit_fav_number);
        btnSubmit =(Button)findViewById(R.id.btn_submit);
        btnCancel =(Button)findViewById(R.id.btn_cancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstName.getText().toString().isEmpty() && lastName.getText().toString().isEmpty() && favFood.getText().toString().isEmpty() && favNumber.getText().length() == 0){
                  Toast toast =  Toast.makeText(MainActivity.this,"Please fill data",Toast.LENGTH_SHORT);
                    toast.show();
                }else if (firstName.getText().toString().isEmpty()){
                    lastName.setError(null);
                    favFood.setError(null);
                    favNumber.setError(null);
                    firstName.setError("Please type your first name before submit");
                   Toast toast= Toast.makeText(MainActivity.this, "Type Favourite Number", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();

                }else if (lastName.getText().toString().isEmpty()){
                    firstName.setError(null);
                    favFood.setError(null);
                    favNumber.setError(null);
                    lastName.setError("Please type your last name before submit");
                   Toast toast =Toast.makeText(MainActivity.this, "Type Favourite Number", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();

                }else if (favFood.getText().toString().isEmpty()){
                    firstName.setError(null);
                    lastName.setError(null);
                    favNumber.setError(null);
                    favFood.setError("Please type your favourite food before submit");
                    Toast toast =Toast.makeText(MainActivity.this, "Type Favourite Food", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();

                }else if (favNumber.getText().length()==0){
                    firstName.setError(null);
                    lastName.setError(null);
                    favFood.setError(null);
                    favNumber.setError("Please type your favourite number before submit");
                    Toast toast =Toast.makeText(MainActivity.this, "Type Favourite Number", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }else {
                    int favno =Integer.parseInt(favNumber.getText().toString());
                    Intent intent = new Intent(MainActivity.this,ShowResultActivity.class);
                    intent.putExtra("firstName",firstName.getText().toString());
                    intent.putExtra("lastName",lastName.getText().toString());
                    intent.putExtra("favFood",favFood.getText().toString());
                    intent.putExtra("favNumber",favno);
                    startActivity(intent);
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName.setText("");
                lastName.setText("");
                favFood.setText("");
                favNumber.setText("");
            }
        });
    }
}
