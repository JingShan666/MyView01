package com.example.administrator.myview01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button refreshButton;
    private Button checkButton;
    private EditText editText;

    private CheckView checkView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshButton= (Button) findViewById(R.id.refresh_btn);
        checkButton= (Button) findViewById(R.id.bt_check);
        editText= (EditText) findViewById(R.id.et_text);
        checkView= (CheckView) findViewById(R.id.myview);

        //刷新图形验证码
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkView.text= CheckUtil.createCode();
                checkView.postInvalidate();
            }
        });

        //校验验证码是否正确
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code= editText.getText().toString().trim();
                Log.e("code....",code);
                Log.e("CheckView.text....",CheckView.text);
                if (code!=null&&code.length()>0){

                    if (code.equalsIgnoreCase(CheckView.text) ){
                        Toast.makeText(MainActivity.this,"验证码正确！",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(MainActivity.this,"验证码错误，请从新输入！",Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this,"请输入验证码！",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
