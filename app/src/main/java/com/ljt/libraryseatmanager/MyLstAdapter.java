package com.ljt.libraryseatmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class MyLstAdapter extends BaseAdapter {
    Context context;
    List<String> list;

    public MyLstAdapter(Context context,List<String> list){
        this.context=context;
        this.list=list;

    }
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
        ViewHolder viewHolder;
        if (convertView==null)
        {
            viewHolder=new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            viewHolder.textView=convertView.findViewById(R.id.item_textView);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        return null;
    }

    private class ViewHolder {
            TextView textView;
    }
}
