package com.tecc0.urlimagetogridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
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

    class ViewHolder {
        TextView name;
        ImageView imageView;
        TextView likes;
        TextView comments;
        TextView price;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder h;

        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            h = new ViewHolder();
            h.name = (TextView) convertView.findViewById(R.id.name);
            h.imageView = (ImageView) convertView.findViewById(R.id.imageview);
            h.likes = (TextView) convertView.findViewById(R.id.likes);
            h.comments = (TextView) convertView.findViewById(R.id.comments);
            h.price = (TextView) convertView.findViewById(R.id.price);
            convertView.setTag(h);
        } else {
            h = (ViewHolder) convertView.getTag();
        }

        h.name.setText(itemData.get(position).getName());
        Picasso.with(getContext()).load(itemData.get(position).getPhoto()).into(h.imageView);
        h.likes.setText(itemData.get(position).getLike());
        h.comments.setText(itemData.get(position).getComment());
        h.price.setText("$ " + itemData.get(position).getPrice());

        return convertView;
    }


}
