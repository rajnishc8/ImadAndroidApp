package com.mobitribe.imadapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView textView = (TextView) findViewById(R.id.textview);
        //todo: string from resource file
        //textView.setText("New text");
        //EditText editText = (EditText) findViewById(R.id.edittext);

        //these are global now
        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.edittext);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets called when the button is clicked.
                Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_LONG).show();
                String enteredText = editText.getText().toString().trim();
                if(enteredText.isEmpty()) {
                    //Show an alert
                    showAlert();
                }else {
                    //Replace the text in the textview
                    replaceText(enteredText);
                }
            }
        });
        Log.i(TAG,"Inside OnCreate");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    private void replaceText(String newText){
        textView.setText(newText);
        editText.setText("");
    }

    private void showAlert()
    {
        //Building the dialog
        Log.i(TAG,"Inside showAlert");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Empty");
        builder.setMessage("No string to replace");
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
    }
}
