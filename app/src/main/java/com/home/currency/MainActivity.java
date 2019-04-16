package com.home.currency;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    private Float mUSDExchangeRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView(){
        mEditText = (EditText) findViewById(R.id.ntd);
        mUSDExchangeRate = 30.9f;
    }

    public void getExchangeRate(View view){
        if (mEditText.getText().toString().length() <= 1){
            showPupopMessage("Problem", "Please enter your NTD amount");
        }else{
            showPupopMessage("Result", "USD is " + getResult(Integer.valueOf(mEditText.getText().toString())));
        }
    }

    private void showPupopMessage(String title, String message){
      new AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK", null)
        .show();
    }

    private Float getResult(int value){
        return value / mUSDExchangeRate;
    }

}
