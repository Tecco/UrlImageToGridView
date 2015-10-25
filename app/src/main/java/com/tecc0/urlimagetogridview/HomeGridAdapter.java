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

    private class ViewHolder {
        private TextView name;
        private ImageView imageView;
        private TextView like;
        private TextView comment;
        private TextView price;

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getLike() {
            return like;
        }

        public void setLike(TextView like) {
            this.like = like;
        }

        public TextView getComment() {
            return comment;
        }

        public void setComment(TextView comment) {
            this.comment = comment;
        }

        public TextView getPrice() {
            return price;
        }

        public void setPrice(TextView price) {
            this.price = price;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder h;

        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            h = new ViewHolder();
            h.setName((TextView) convertView.findViewById(R.id.name));
            h.setLike((TextView) convertView.findViewById(R.id.likes));
            h.setComment((TextView) convertView.findViewById(R.id.comments));
            h.setPrice((TextView) convertView.findViewById(R.id.price));
            h.setImageView((ImageView) convertView.findViewById(R.id.imageview));
            convertView.setTag(h);
        } else {
            h = (ViewHolder) convertView.getTag();
        }

        ItemData i = getItem(position);

        h.getName().setText(i.getName());
        h.getLike().setText(i.getLike());
        h.getComment().setText(i.getComment());
        h.getPrice().setText(i.getPrice());
        Picasso.with(getContext()).load(i.getPhoto()).into(h.imageView);

        return convertView;
    }


}
