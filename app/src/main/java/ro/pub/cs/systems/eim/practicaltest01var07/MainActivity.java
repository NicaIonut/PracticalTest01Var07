package ro.pub.cs.systems.eim.practicaltest01var07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nr1 = null;
    private EditText nr2 = null;
    private EditText nr3 = null;
    private EditText nr4 = null;

    private Button set = null;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private Button navigateToSecondaryActivityButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.SET){
                if(nr1.getText().length() > 0 &&
                        nr2.getText().length() > 0 &&
                        nr3.getText().length() > 0 &&
                        nr4.getText().length() > 0){
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                    int s1 = Integer.parseInt(nr1.getText().toString());
                    int s2 = Integer.parseInt(nr2.getText().toString());
                    int s3 = Integer.parseInt(nr3.getText().toString());
                    int s4 = Integer.parseInt(nr4.getText().toString());

                    intent.putExtra("nr1", s1);
                    intent.putExtra("nr2", s2);
                    intent.putExtra("nr3", s3);
                    intent.putExtra("nr4", s4);

                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                }else{
                    Toast.makeText(getApplicationContext(),"Error,nr boxes must have a number!",Toast.LENGTH_SHORT).show();
                }
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nr1 = (EditText)findViewById(R.id.edit_text_1);
        nr2 = (EditText)findViewById(R.id.edit_text_2);
        nr3 = (EditText)findViewById(R.id.edit_text_3);
        nr4 = (EditText)findViewById(R.id.edit_text_4);

        set = (Button)findViewById(R.id.SET);
        set.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("nr1", nr1.getText().toString());
        savedInstanceState.putString("nr2", nr2.getText().toString());
        savedInstanceState.putString("nr3", nr3.getText().toString());
        savedInstanceState.putString("nr4", nr4.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("nr1")) {
            nr1.setText(savedInstanceState.getString("nr1"));
        }
        if (savedInstanceState.containsKey("nr2")) {
            nr2.setText(savedInstanceState.getString("nr2"));
        }
        if (savedInstanceState.containsKey("nr3")) {
            nr3.setText(savedInstanceState.getString("nr3"));
        }
        if (savedInstanceState.containsKey("nr4")) {
            nr4.setText(savedInstanceState.getString("nr4"));
        }

    }

}
