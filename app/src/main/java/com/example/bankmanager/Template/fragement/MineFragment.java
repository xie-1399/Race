package com.example.bankmanager.Template.fragement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankmanager.Mine.contact_us;
import com.example.bankmanager.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MineFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView Mine_home;
    private TextView Mine_saoma;
    private TextView Mine_fankui;
    private TextView Mine_about;
    private TextView Mine_zanshang;
    private TextView Mine_account;
    private TextView Mine_contact;
    private TextView Mine_jifen;
    private TextView Mine_exit;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
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
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        //下面集中添加点击事件
        Mine_home=view.findViewById(R.id.Mine_home);
        Mine_saoma=view.findViewById(R.id.Mine_saoma);
        Mine_fankui=view.findViewById(R.id.Mine_fankui);
        Mine_about=view.findViewById(R.id.Mine_about);
        Mine_zanshang=view.findViewById(R.id.Mine_zanshang);
        Mine_account=view.findViewById(R.id.Mine_account);
        Mine_contact=view.findViewById(R.id.Mine_contact);
        Mine_jifen=view.findViewById(R.id.Mine_jifen);
        Mine_exit=view.findViewById(R.id.Mine_exit);

        //跳转到项目首页
//        Mine_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()){
//                    case R.id.Mine_home:
//                        getActivity().getSupportFragmentManager()
//                                .beginTransaction()
//                                .replace(R.id.Mine_home, new index_Fragment())
//                                .addToBackStack(null)
//                                .commit();
//                    default:
//                        break;
//                }
//            }
//        });

    //联系我们
        Mine_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.Mine_contact:
                        Intent intent=new Intent(getActivity(), contact_us.class);
                        startActivity(intent);
                    default:
                        break;
                }
            }
        });
        //积分功能
        Mine_jifen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.Mine_jifen:
                        Toast.makeText(getContext(),"积分功能正在开发中，敬请期待！",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
            }
        });
        //退出应用
        Mine_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.Mine_exit:
                        getActivity().finish();
                    default:
                        break;
                }
            }
        });




        return view;
    }
}