package ua.labs.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText etNum1;
    EditText etNum2;

    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        Button button = findViewById(R.id.btnAdd);
        TextView text = findViewById(R.id.text);

        View.OnClickListener oMyButton = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float num1 = 0;
                float num2 = 0;
                float result = 0;

                if (TextUtils.isEmpty(etNum1.getText().toString())
                        || TextUtils.isEmpty(etNum2.getText().toString())){
                    return;
                }

                num1 = Float.parseFloat(etNum1.getText().toString());
                num2 = Float.parseFloat(etNum2.getText().toString());

                switch(v.getId()){
                    case R.id.btnMult:
                        result = num1*num2;
                        break;
                    case R.id.btnDiv:
                        try{
                            if(num2 ==0){
                                tvResult.setText("Can't divide by zero");
                                return;
                            }
                            result = num1/num2;
                            tvResult.setText(Float.toString(result));
                        }catch(Exception e){
                            tvResult.setText("Could not devide");
                        }


                        //result = num1/num2;
                        break;
                }
                tvResult.setText(Float.toString(result));
            }
        };

        btnMult.setOnClickListener(oMyButton);
        btnDiv.setOnClickListener(oMyButton);

    }

    public void handleClickBtnAdd(View view){
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if (TextUtils.isEmpty(etNum1.getText().toString())
            || TextUtils.isEmpty(etNum2.getText().toString())){
            return;
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        result = num1 + num2;

        tvResult.setText(Float.toString(result));
    }


    public void handleClickBtnSub(View view){
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())){
            return;
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        result = num1 - num2;

        tvResult.setText(Float.toString(result));
    }
}

