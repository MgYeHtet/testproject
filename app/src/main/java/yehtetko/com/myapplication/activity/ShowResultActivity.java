package yehtetko.com.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import yehtetko.com.myapplication.R;

public class ShowResultActivity extends AppCompatActivity{
    TextView txtResult;
    String firstName,lastName,favFood;
    int favNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        txtResult = (TextView) findViewById(R.id.txt_result);

        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        favFood = getIntent().getStringExtra("favFood");
        favNumber = getIntent().getIntExtra("favNumber", 0);

//        Integer[] intNo = new Integer[]{0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,144};


        if (favNumber <100 && Fibonacci(favNumber)) {
            txtResult.setText("Hello " + firstName + ", today is your lucky day with your favorite number" + favNumber);
        }else {
            txtResult.setText("Hello Mr/Ms " + lastName + ", I love " + favFood + " too. Lets go get that for lunch today.");
        }
    }
    public static boolean Fibonacci(int n) {
        int fib1 = 0;
        int fib2 = 1;
        do {
            int saveFib1 = fib1;
            fib1 = fib2;
            fib2 = saveFib1 + fib2;
        }
        while (fib2 < n);

        if (fib2 == n)
            return true;
        else
            return false;

    }


    }
