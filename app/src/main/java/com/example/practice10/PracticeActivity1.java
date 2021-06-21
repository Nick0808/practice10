package com.example.practice10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PracticeActivity1 extends AppCompatActivity {
    String[] nationList;
    ArrayAdapter<String> nationAdapter;
    ListView liNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice1);
        setTitle("XML 배열 리소스 다루기");

        // 리소스 객체로 부터 XML에서 정의한 배열 리소스를 활용
        Resources res = getResources();
        nationList = res.getStringArray(R.array.res_nation);

        nationAdapter = new ArrayAdapter<String>(
                PracticeActivity1.this,
                android.R.layout.simple_list_item_1,
                nationList
        );

        liNation = (ListView)findViewById(R.id.p1_listView1);
        liNation.setAdapter(nationAdapter);
        liNation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}