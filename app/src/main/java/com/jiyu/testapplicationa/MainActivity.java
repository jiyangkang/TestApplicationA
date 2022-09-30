package com.jiyu.testapplicationa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String result = "0";
    private String recordValue = "0";

    private TextView resultText;

    private OperateType currentType = null;

    private boolean isFirst = true;

    private ConcurrentHashMap<Integer, String> valueMap= new ConcurrentHashMap<>();

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1 :{

                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result);
        resultText.setText("0");

        findViewById(R.id.one).setOnClickListener(this);
        valueMap.put(R.id.one, "1");
        findViewById(R.id.two).setOnClickListener(this);
        valueMap.put(R.id.two, "2");
        findViewById(R.id.three).setOnClickListener(this);
        valueMap.put(R.id.three, "3");
        findViewById(R.id.four).setOnClickListener(this);
        valueMap.put(R.id.four, "4");
        findViewById(R.id.five).setOnClickListener(this);
        valueMap.put(R.id.five, "5");
        findViewById(R.id.six).setOnClickListener(this);
        valueMap.put(R.id.six, "6");
        findViewById(R.id.seven).setOnClickListener(this);
        valueMap.put(R.id.seven, "7");
        findViewById(R.id.eight).setOnClickListener(this);
        valueMap.put(R.id.eight, "8");
        findViewById(R.id.nine).setOnClickListener(this);
        valueMap.put(R.id.nine, "9");
        findViewById(R.id.zero).setOnClickListener(this);
        valueMap.put(R.id.zero, "0");
        findViewById(R.id.plus).setOnClickListener(this);
        valueMap.put(R.id.plus, "+");
        findViewById(R.id.sub).setOnClickListener(this);
        valueMap.put(R.id.sub, "-");
        findViewById(R.id.fois).setOnClickListener(this);
        valueMap.put(R.id.fois, "*");
        findViewById(R.id.div).setOnClickListener(this);
        valueMap.put(R.id.div, "/");
        findViewById(R.id.point).setOnClickListener(this);
        valueMap.put(R.id.point, ".");
        findViewById(R.id.equal).setOnClickListener(this);
        valueMap.put(R.id.equal, "=");
        findViewById(R.id.back_word).setOnClickListener(this);
        valueMap.put(R.id.back_word, "b");
        findViewById(R.id.mod).setOnClickListener(this);
        valueMap.put(R.id.mod, "%");


    }


    @Override
    public void onClick(View view) {
        String value = valueMap.get(view.getId());
        if (value == null) return;
        if ("1234567890.".contains(value)){//点击了数字
            if (value.equals(".") && recordValue.contains(".")){
                Toast.makeText(MainActivity.this, "请不要多次写入小数点", Toast.LENGTH_SHORT).show();
            }else {
                recordValue = recordValue + value;
                resultText.setText(recordValue);
            }
        }else if ("+-*/".contains(value)){//点击了加减乘除
            if (!isFirst && currentType != null){
                doResult();
            }


            if (value.equals("+")){
                currentType = OperateType.Plus;
            }else if (value.equals("-")){
                currentType = OperateType.Sub;
            }else if (value.equals("*")){
                currentType = OperateType.Fois;
            }else if (value.equals("/")){
                currentType = OperateType.Div;
            }

            recordValue = "0";

        }else if ("c".equals(value)){
            currentType = null;
            isFirst = true;
            result = "0";
            recordValue = "0";
        }
    }

    private void doResult(){

    }

    private float stringToFloat(String s){
        return 0.0f;
    }
}