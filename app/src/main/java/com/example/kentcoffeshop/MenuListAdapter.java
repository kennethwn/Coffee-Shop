package com.example.kentcoffeshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuViewHolder> {

  private ViewMenuModel viewMenuModel;
  private Context context;

  public MenuListAdapter(ViewMenuModel viewMenuModel, Context context) {
    this.viewMenuModel = viewMenuModel;
    this.context = context;
  }

  @NonNull
  @Override
  public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list, parent, false);
    return new MenuViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
    MenuModel menu = ViewMenuModel.getInstance().get(position);
    holder.textMenuName.setText(menu.getCoffeeTitle());
    holder.textMenuDescription.setText(menu.getCoffeeNotes());
    holder.textMenuPrice.setText("Rp. " + menu.getCoffeePrice());
  }

  @Override
  public int getItemCount() {
    return ViewMenuModel.getInstance().size();
  }

  public static class MenuViewHolder extends RecyclerView.ViewHolder {

    public TextView textMenuName;
    public TextView textMenuDescription;
    public TextView textMenuPrice;

    public MenuViewHolder(View itemView) {
      super(itemView);
      textMenuName = itemView.findViewById(R.id.coffeeTitle);
      textMenuDescription = itemView.findViewById(R.id.coffeeNotes);
      textMenuPrice = itemView.findViewById(R.id.coffeePrice);
    }
  }
}
