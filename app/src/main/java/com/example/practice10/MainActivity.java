package com.example.practice10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] practiceList = {"실습1", "실습2", "실습3", "실습4"};
    ArrayAdapter<String> practiceAdapter;
    ListView liPractice;
    Intent practiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        practiceAdapter = new ArrayAdapter<String>( // adapter 정의
            MainActivity.this,
            android.R.layout.simple_list_item_1,
            practiceList
        );

        liPractice = (ListView)findViewById(R.id.main_listView);
        liPractice.setAdapter(practiceAdapter);

        liPractice.setOnItemClickListener(new AdapterView.OnItemClickListener() { // 무명클래스
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item = practiceList[position]; Data Array에서 정보를 가져오는 방법
                String item = practiceAdapter.getItem(position); // Adapter에서 정보를 가져오는 방법
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        practiceIntent = new Intent(MainActivity.this, PracticeActivity1.class);
                        break;
                    case 1:
                        practiceIntent = new Intent(MainActivity.this, PracticeActivity2.class);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                startActivity(practiceIntent);
            }
        });
    }
}