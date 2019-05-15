package com.davis.mylistview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.davis.mylistview.adapter.ProjectAdapter;
import com.davis.mylistview.bean.ProjectBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    private ProjectAdapter adapter;
    private List<ProjectBean> datas = new ArrayList<ProjectBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        listview = (ListView)findViewById(R.id.listview);
        loadDatas();
        adapter = new ProjectAdapter(this, datas, R.layout.item_list_project);
        listview.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                add();
            }
        }, 3000);
    }

    private void loadDatas(){
        datas.add(new ProjectBean("dej", "http://dej.esgcc.com.cn", 0, 0));
        datas.add(new ProjectBean("esgcc", "http://www.esgcc.com.cn", 1, 0));
        datas.add(new ProjectBean("e充电-获取社区信息", "http://www.echargenet.com.cn", 1, 0));
        datas.add(new ProjectBean("e充电-增值服务网", "http://dej.esgcc.com.cn", 2, 0));
        datas.add(new ProjectBean("e充电-服务页信息", "http://dej.esgcc.com.cn", 0, 0));

    }

    private void add(){
        datas.add(new ProjectBean("fancai", "http://www.fancai.com.cn", 0, 0));
        datas.add(new ProjectBean("基准测试", "http://dej.esgcc.com.cn", 2, 0));
        datas.add(new ProjectBean("国旅在线-机票订购", "http://dej.esgcc.com.cn", 1, 1));
        datas.add(new ProjectBean("国旅在线-上海页", "http://dej.esgcc.com.cn", 0, 0));
        datas.add(new ProjectBean("克莱斯勒-美国", "http://dej.esgcc.com.cn", 0, 1));
        datas.add(new ProjectBean("克莱斯勒-英国", "http://dej.esgcc.com.cn", 0, 0));
        adapter.refresh();
    }
}
