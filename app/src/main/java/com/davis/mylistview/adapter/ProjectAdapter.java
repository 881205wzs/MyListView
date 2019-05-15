package com.davis.mylistview.adapter;

import android.content.Context;
import android.view.View;

import com.davis.mylistview.R;
import com.davis.mylistview.bean.ProjectBean;
import com.davis.mylistview.holder.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/1/2.
 */
public class ProjectAdapter extends CommonAdapter<ProjectBean> {

    public ProjectAdapter(Context context, List<ProjectBean> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, final int position, ProjectBean item) {
        holder.setText(R.id.txt_project_title, item.getTitle());
        holder.setText(R.id.txt_project_distribe, item.getDiscribe());
        switch (item.getState()){
            case 0: //绿色
                holder.setImageResource(R.id.img_project_state, R.mipmap.pj_g);
                break;
            case 1: //灰色
                holder.setImageResource(R.id.img_project_state, R.mipmap.pj_n);
                break;
            case 2: //红色
                holder.setImageResource(R.id.img_project_state, R.mipmap.pj_r);
                break;
        }
        switch (item.getCollect()){
            case 0:
                holder.setImageResource(R.id.img_project_collect, R.mipmap.collect_normal);
                break;
            case 1:
                holder.setImageResource(R.id.img_project_collect, R.mipmap.collect_selected);
                break;
        }
        final int collect = item.getCollect();
        holder.getImageView(R.id.img_project_collect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelect(collect, position);
            }
        });
    }

    public void setSelect(int state, int position){
        if(state == 1){
            this.listDatas.get(position).setCollect(0);
        } else {
            this.listDatas.get(position).setCollect(1);
        }
        refresh();
    }
}
