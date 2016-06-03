package com.chatak.parkinfiniamarket;

import android.content.Context;
//import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//import android.widget.ImageView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private static class ViewHolder {
        //public ImageView ivProductImage;
        public TextView tvTitle;
        public TextView tvWeight;
        public TextView tvPrice;
    }

    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    private String convertToString(double val) {
        return val + "";
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Product product = getItem(position);
        
        ViewHolder viewHolder;
        
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_product, parent, false);
            //viewHolder.ivProductImage = (ImageView)convertView.findViewById(R.id.ivProductImage);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            viewHolder.tvWeight = (TextView)convertView.findViewById(R.id.tvWeight);
            viewHolder.tvPrice = (TextView)convertView.findViewById(R.id.tvPrice);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        viewHolder.tvTitle.setText(product.getTitle());
        viewHolder.tvWeight.setText(product.getWeight());
        viewHolder.tvPrice.setText(convertToString(product.getPrice()));
        //Picasso.with(getContext()).load(Uri.parse(product.getProductImageUrl())).error(R.drawable.ic_nocover).into(viewHolder.ivProductImage);
        
        return convertView;
    }
}