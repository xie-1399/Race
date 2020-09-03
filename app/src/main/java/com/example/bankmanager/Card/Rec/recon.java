package com.example.bankmanager.Card.Rec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bankmanager.R;
import com.lsh.library.BankNumEditText;

public class recon extends AppCompatActivity {
    BandCardEditText editText;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recon);
        BankNumEditText bankNumEditText = (BankNumEditText) findViewById(R.id.bankCardNum);
        final EditText editText = (EditText) findViewById(R.id.bankName);
        bankNumEditText
                .setFullVerify(false)
                .setBankNameListener(new BankNumEditText.BankNameListener() {
                    @Override
                    public void success(String name) {
                        editText.setText(name);
                    }

                    @Override
                    public void failure(int failCode, String failmsg) {
                        editText.setText(failCode+failmsg);
                    }
                });
        tv = (TextView) findViewById(R.id.tv);
        BandCardEditText editText1 = (BandCardEditText) findViewById(R.id.et);
        editText1.setBankCardListener(new BankCardListener() {
            @Override
            public void success(String name) {
                tv.setText("所属银行：" + name);
            }

            @Override
            public void failure() {
                Log.i("TAG", "failure");
                tv.setText("所属银行：未查询到您的银行卡号，请您仔细检验卡号");
            }
        });

    }
}