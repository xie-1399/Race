package com.example.bankmanager.Template.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankmanager.R;

import java.util.List;

public class index_newsAdapter extends ArrayAdapter<index_news> {
    private int resorceId;
    public index_newsAdapter(@NonNull Context context, int text_Id, @NonNull List<index_news> objects) {
        super(context, text_Id, objects);
        resorceId=text_Id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        index_news in1=getItem(position);
        View view;//= LayoutInflater.from(getContext()).inflate(resorceId,parent,false);
        //加速一下listview的运行效率
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resorceId,parent,false);
        }else {
            view=convertView;
        }
        ImageView imageId=(ImageView)view.findViewById(R.id.iv_image);
        TextView author=(TextView)view.findViewById(R.id.iv_new);
        TextView ori=(TextView)view.findViewById(R.id.tv_tag_name);
        TextView title=(TextView)view.findViewById(R.id.tv_title);
        TextView date=(TextView)view.findViewById(R.id.tv_time);
        imageId.setImageResource(in1.getImageId());
        author.setText(in1.getAuthor());
        ori.setText(in1.getOri());
        title.setText(in1.getTitle());
        date.setText(in1.getDate());
        return view;
    }
}
