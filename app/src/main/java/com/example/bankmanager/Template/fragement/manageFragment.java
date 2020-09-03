package com.example.bankmanager.Template.fragement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.bankmanager.Manage.MysqlHelp;
import com.example.bankmanager.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link manageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class manageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView card_number;
    private Button btn_cardnumber;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what==0){
                int count=(Integer) msg.obj;
                card_number.setText("银行卡的数量为："+count);
            }
        }
    };

    public manageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment manageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static manageFragment newInstance() {
        manageFragment fragment = new manageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manage, container, false);
         btn_cardnumber=view.findViewById(R.id.btn_cardnumber);
         card_number=view.findViewById(R.id.card_number);
        btn_cardnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_cardnumber://查询数量
                        doQuerycount();
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }
//开启查询的线程
    private void doQuerycount() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count=MysqlHelp.getUserSize();
                Message msg=Message.obtain();
                msg.what=0;
                msg.obj=count;
                //向主线程发送数据
                handler.sendMessage(msg);
            }
        }).start();
    }
}