package com.tecc0.urlimagetogridview.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tecc0.urlimagetogridview.R;

import java.util.ArrayList;

/**
 * Created by makotonishimoto on 2015/10/11.
 */
public class HomeGridAdapter extends ArrayAdapter<ItemData> {
    private LayoutInflater inflater;
    private int layoutId;
    private ArrayList<ItemData> itemData;

    public HomeGridAdapter(Context context, int layoutId, ArrayList<ItemData> data) {
        super(context, 0, data);
        this.itemData = data;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutId = layoutId;
    }

    private class ViewHolder {
        private TextView name;
        private ImageView imageView;
        private TextView like;
        private TextView comment;
        private TextView price;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder h;

        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            h = new ViewHolder();
            h.name = (TextView) convertView.findViewById(R.id.name);
            h.like = (TextView) convertView.findViewById(R.id.likes);
            h.comment = (TextView) convertView.findViewById(R.id.comments);
            h.price = (TextView) convertView.findViewById(R.id.price);
            h.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(h);
        } else {
            h = (ViewHolder) convertView.getTag();
        }

        ItemData i = getItem(position);

        h.name.setText(i.getName());
        h.like.setText(i.getLike());
        h.comment.setText(i.getComment());
        h.price.setText(i.getPrice());
        Picasso.with(getContext()).load(i.getPhoto()).into(h.imageView);

        return convertView;
    }


}
