package com.example.bankmanager.DayliReading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleService;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.bankmanager.R;

import java.util.ArrayList;
import java.util.List;

public class Reading extends AppCompatActivity {
    private List<read_class> readList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        initReading();
        RecyclerView recyclerView=findViewById(R.id.read_page);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DailyReadingAdapter adapter=new DailyReadingAdapter(readList);
        recyclerView.setAdapter(adapter);
    }

    private void initReading() {
        for (int i = 0; i <2 ; i++) {
            read_class r1=new read_class(R.drawable.loading_image,"这是第一个标题","xxl","2020-9-2","科普");
            readList.add(r1);
            read_class r2=new read_class(R.drawable.loading_image,"这是第二个标题","xxl","2020-9-2","科普");
            readList.add(r2);
            read_class r3=new read_class(R.drawable.loading_image,"这是第三个标题","xxl","2020-9-2","科普");
            readList.add(r3);

        }
    }
}