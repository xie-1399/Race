package com.example.bankmanager.DayliReading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankmanager.R;

import java.util.List;

public class DailyReadingAdapter extends RecyclerView.Adapter<DailyReadingAdapter.ViewHolder> {
    private List<read_class> mread_list;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageId;
        TextView title;
        TextView author;
        TextView date;
        TextView leixing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageId=itemView.findViewById(R.id.iv_android_pic);
            title=itemView.findViewById(R.id.tv_android_des);
            author=itemView.findViewById(R.id.tv_android_who);
            date=itemView.findViewById(R.id.tv_android_time);
            leixing=itemView.findViewById(R.id.tv_content_type);
        }
    }
    public DailyReadingAdapter(List<read_class> readlist){
        mread_list=readlist;
    }
    @NonNull
    @Override
    public DailyReadingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reading,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyReadingAdapter.ViewHolder holder, int position) {
        read_class Red=mread_list.get(position);
        holder.imageId.setImageResource(Red.getImageId());
        holder.title.setText(Red.getTitle());
        holder.author.setText(Red.getAuthor());
        holder.date.setText(Red.getDate());
        holder.leixing.setText(Red.getLeixing());
    }

    @Override
    public int getItemCount() {
        return mread_list.size();
    }
}
