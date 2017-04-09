package com.example.zheng.gridviewdividingline;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridViewDividingLine gridViewDividingLine;
    private List<String> list = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    list.add("第" + i + "个item");
                }
                mHandler.obtainMessage(0).sendToTarget();
            }
        }.start();
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };

    private void initView() {
        gridViewDividingLine = (GridViewDividingLine) findViewById(R.id.gridViewDividingLine);
        MyAdapter myAdapter = new MyAdapter();
        gridViewDividingLine.setAdapter(myAdapter);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(MainActivity.this, R.layout.gv_item, null);
            }
            TextView tv_Name = (TextView) convertView.findViewById(R.id.tv_name);
            tv_Name.setText(list.get(position));
            return convertView;
        }
    }

}
