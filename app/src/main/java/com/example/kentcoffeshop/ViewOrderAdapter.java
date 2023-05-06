package com.example.kentcoffeshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewOrderAdapter extends BaseAdapter {
  private Context context;
  private ArrayList<OrderData> orderData;

  public ViewOrderAdapter(Context context, ArrayList<OrderData> orderData) {
    this.context = context;
    this.orderData = orderData;
  }

  @Override
  public int getCount() {
    return orderData.size();
  }

  @Override
  public Object getItem(int position) {
    return orderData.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
      convertView = LayoutInflater.from(context).inflate(R.layout.list_order_data, parent, false);
      holder = new ViewHolder(convertView);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }

    OrderData data = this.orderData.get(position);
    holder.tvName.setText(data.getName());
    holder.tvCoffee.setText(data.getOrder());

    convertView.setOnClickListener(v -> {
      Intent intent = new Intent(context, OrderDetailActivity.class);
      intent.putExtra("random_data", data);
      context.startActivity(intent);
    });

    return convertView;
  }

  private static class ViewHolder {
    private final TextView tvName;
    private final TextView tvCoffee;

    public ViewHolder(View view) {
      tvName = view.findViewById(R.id.name_view);
      tvCoffee = view.findViewById(R.id.coffee_view);
    }
  }
}
