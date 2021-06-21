package com.example.practice10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PracticeActivity2 extends AppCompatActivity {
    String[] settingList;
    ArrayAdapter<String> settingAdapter;
    ListView liSetting;
    int backColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice2);
        setTitle("Background Color Setting");

        settingList = getResources().getStringArray(R.array.setting_color);
        settingAdapter = new ArrayAdapter<String>(
                PracticeActivity2.this,
                android.R.layout.simple_list_item_1,
                settingList
        );

        liSetting = (ListView)findViewById(R.id.p2_listView);
        liSetting.setAdapter(settingAdapter);
        liSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        singleBackColor();
                        break;
                    case 1:
                        multiBackColor();
                        break;
                }
            }
        });
    }

    // 배경색 단일 설정
    public void singleBackColor() {
        // 대화상자에 표시될 Data
        String[] colorList = {"Red", "Green", "Blue"};
        int[] colorResource = {Color.RED, Color.GREEN, Color.BLUE};
        backColor = Color.RED;

        AlertDialog.Builder singleBuilder = new AlertDialog.Builder(PracticeActivity2.this);
        singleBuilder.setIcon(R.drawable.get_info);
        singleBuilder.setTitle("단일색 배경 설정");
        //singleBuilder.setMessage("색상 선택");
        // 단 메시지와 리스트는 같이 표시 안됨.
        // 대화상자에 라디오버튼 표시
        // 리스트 타이틀 리소스, 선택항목, OnClickListner

        singleBuilder.setSingleChoiceItems(colorList, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 3가지 생상 중 하나를 선택
                // which : 선택 아이템 position
                backColor = colorResource[which];
            }
        });

        singleBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                liSetting.setBackgroundColor(backColor);
            }
        });
        singleBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        singleBuilder.show();
    }

    // 배경색 중복 설정
   public void multiBackColor() {
        String[] colorList = {"Red", "Green", "Blue"};
        int[] colorResource = {Color.RED, Color.GREEN, Color.BLUE};
        // 현재 체크상태를 가지는 boolean타입의 배열
        boolean[] checkedList = {false, false, false};

        AlertDialog.Builder multiBuilder = new AlertDialog.Builder(PracticeActivity2.this);
        multiBuilder.setIcon(R.drawable.get_info);
        multiBuilder.setTitle("배경 혼색 설정");
        // 대화상자에 체크박스 표시
        // 리스트 타이틀 리소스, 체크상태를 가지는 배열, OnMultiChoiceClickListener
       multiBuilder.setMultiChoiceItems(colorList, checkedList, new DialogInterface.OnMultiChoiceClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which, boolean isChecked) {
               // checkedList 상태를 기록
               // which : 선택항목
               // ischecked : 선택의 체크여부
               // 현재 테크 상태를 체크리스트에 다시 설정
               checkedList[which] = isChecked;
           }
       });

       multiBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               // 체크리스트를 차례로 확인하여 색을 결정
               backColor = 0;
               for(int index = 0; index < checkedList.length; index++) {
                   if(checkedList[index]) {
                       backColor += colorResource[index];
                   }
               }
               liSetting.setBackgroundColor(backColor);
           }
       });

       multiBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });
       multiBuilder.show();
    }
}