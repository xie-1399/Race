package com.example.bankmanager.Template.fragement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bankmanager.Card.Rec.recon;
import com.example.bankmanager.DayliReading.Reading;
import com.example.bankmanager.DayliReading.index_news.index_news1;
import com.example.bankmanager.DayliReading.index_news.index_news2;
import com.example.bankmanager.DayliReading.index_news.index_news3;
import com.example.bankmanager.Location.find_position;
import com.example.bankmanager.Mine.contact_us;
import com.example.bankmanager.Picture.bankcardrec.PicActivity;
import com.example.bankmanager.R;
import com.example.bankmanager.Template.Index;
import com.example.bankmanager.Template.adapter.GlideImageLoader;
import com.example.bankmanager.Template.adapter.index_news;
import com.example.bankmanager.Template.adapter.index_newsAdapter;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
//有必要先去学习一下fragement的使用
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link index_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class index_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<index_news> index_news_List=new ArrayList<index_news>();   //创建一个首页新闻对象集合
    private boolean Flag=true;

//    private String data[]={"Apple", "Banana", "Orange", "Watermelon", "Pear",
//            "Grape", "Pineapple", "Strawberry", "Cherry", "Mango", "Apple", "Banana", "Orange", "Watermelon", "Pear",
//            "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public index_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment index_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static index_Fragment newInstance() {
        index_Fragment fragment = new index_Fragment();
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
        View view=inflater.inflate(R.layout.fragment_index, container, false);
        if(Flag){
            initindex_news();
        }
        index_newsAdapter adapter=new index_newsAdapter(getContext(),R.layout.item_index,index_news_List);
        ListView listView=view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //下面给首页的文章添加点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent_1=new Intent(getActivity(), index_news1.class);
                        startActivity(intent_1);
                        break;
                    case 1:
                        Intent intent_2=new Intent(getActivity(), index_news2.class);
                        startActivity(intent_2);
                        break;
                    case 2:
                        Intent intent_3=new Intent(getActivity(), index_news3.class);
                        startActivity(intent_3);
                        break;
                    default:
                        break;
                }
            }
        });


        //下面是轮播图的代码
        List images = new ArrayList();
        images.add("http://image14.m1905.cn/uploadfile/2018/0907/thumb_1_1380_460_20180907013518839623.jpg");
        images.add("http://image14.m1905.cn/uploadfile/2018/0906/thumb_1_1380_460_20180906040153529630.jpg");
        images.add("http://image13.m1905.cn/uploadfile/2018/0907/thumb_1_1380_460_20180907114844929630.jpg");
        Banner banner = view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        //增加点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
            }
        });

        //图像识别
        ImageButton pic=view.findViewById(R.id.pic_rec);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.pic_rec:
                        Intent intent=new Intent(getActivity(),PicActivity.class);
                        startActivity(intent);
                    default:
                        break;
                }
            }
        });

        //归属地查询
        ImageButton search=view.findViewById(R.id.index_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.index_search:
                        Intent intent=new Intent(getActivity(), recon.class);
                        startActivity(intent);
                    default:
                        break;
                }
            }
        });

        //每日阅读
        ImageView daily_btn=view.findViewById(R.id.daily_btn);
        daily_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.daily_btn:
                        Intent intent=new Intent(getActivity(), Reading.class);
                        startActivity(intent);
                    default:
                        break;
                }
            }
        });

//        ListView listView=view.findViewById(R.id.list_view);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
//        listView.setAdapter(adapter);

        //银行定位
        ImageButton ib_movie_hot=view.findViewById(R.id.ib_movie_hot);
        ib_movie_hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.ib_movie_hot:
                        Intent intent=new Intent(getActivity(), find_position.class);
                        startActivity(intent);
                    default:
                        break;
                }
            }
        });
        return view;
    }

    private void initindex_news() {
            index_news t1=new index_news(R.mipmap.index_pic1,"纯干货: 工商银行信用卡全套攻略!","支付佬","2020-9-3","知乎");
            index_news_List.add(t1);
            index_news t2=new index_news(R.mipmap.index_pic2,"长期不用的银行卡，需要注销吗？","中科融金","2020-9-1","知乎");
            index_news_List.add(t2);
            index_news t3=new index_news(R.mipmap.index_pic3,"如何快速查询自己名下的所有银行卡呢？","易有银","2020-9-2","知乎");
            index_news_List.add(t3);
            Flag=false;
    }
}