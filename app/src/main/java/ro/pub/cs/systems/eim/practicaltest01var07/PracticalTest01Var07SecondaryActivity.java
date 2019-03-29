package ro.pub.cs.systems.eim.practicaltest01var07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;



public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private EditText nr1 = null;
    private EditText nr2 = null;
    private EditText nr3 = null;
    private EditText nr4 = null;

    private Button sum = null;
    private Button prod = null;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private Button navigateToSecondaryActivityButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.SUM){
                int sum = 0;
                sum += Integer.parseInt(nr1.getText().toString()) +
                        Integer.parseInt(nr2.getText().toString()) +
                        Integer.parseInt(nr3.getText().toString()) +
                        Integer.parseInt(nr4.getText().toString());
                Toast.makeText(getApplicationContext(),"Sum of numbers is:" + sum,Toast.LENGTH_SHORT).show();
            }
            if(view.getId() == R.id.PROD){
                int prod = 1;
                prod *= Integer.parseInt(nr1.getText().toString()) *
                        Integer.parseInt(nr2.getText().toString()) *
                        Integer.parseInt(nr3.getText().toString()) *
                        Integer.parseInt(nr4.getText().toString());
                Toast.makeText(getApplicationContext(),"Prod of numbers is:" + prod,Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        nr1 = (EditText)findViewById(R.id.edit_text_1);
        nr2 = (EditText)findViewById(R.id.edit_text_2);
        nr3 = (EditText)findViewById(R.id.edit_text_3);
        nr4 = (EditText)findViewById(R.id.edit_text_4);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("nr1")) {
            int nr = intent.getIntExtra("nr1", -1);
            nr1.setText(String.valueOf(nr));
        }
        if (intent != null && intent.getExtras().containsKey("nr2")) {
            int nr = intent.getIntExtra("nr2", -1);
            nr2.setText(String.valueOf(nr));
        }
        if (intent != null && intent.getExtras().containsKey("nr3")) {
            int nr = intent.getIntExtra("nr3", -1);
            nr3.setText(String.valueOf(nr));
        }
        if (intent != null && intent.getExtras().containsKey("nr4")) {
            int nr = intent.getIntExtra("nr4", -1);
            nr4.setText(String.valueOf(nr));
        }

        sum = (Button)findViewById(R.id.SUM);
        prod = (Button)findViewById(R.id.PROD);
        sum.setOnClickListener(buttonClickListener);
        prod.setOnClickListener(buttonClickListener);
    }
}
