package com.zbobin.androiddemo.app.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zbobin.androiddemo.R;
import com.zbobin.androiddemo.app.home.entity.KindEntity;
import java.util.ArrayList;


/**
 * 类别列表适配器
 *
 * @author zbobin
 */

public class KindListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<KindEntity> entities;

    public KindListAdapter(Context context, ArrayList<KindEntity> entities) {
        if (entities == null) entities = new ArrayList<KindEntity>();
        this.context = context;
        this.entities = entities;
    }

    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int index) {
        return entities.get(index);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_content_main, null);
            holder = new ViewHolder();
            holder.textView_kind_name = (TextView) convertView.findViewById(R.id.textView_kind_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        KindEntity entity = entities.get(position);
        holder.textView_kind_name.setText(entity.getKind_name());

        return convertView;
    }

    class ViewHolder {
        TextView textView_kind_name;
    }
}

