package com.example.kentcoffeshop;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MenuListFragment extends Fragment {
  private RecyclerView recyclerView;
  private RecyclerView.Adapter adapter;
  //public static ArrayList<MenuModel> menu;
  private ViewMenuModel viewMenuModel;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_menu_list, container, false);

    recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewRv);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    viewMenuModel.getInstance();
    viewMenuModel.addMenu(new MenuModel("Latte", "With Milk", 25000.0));
    viewMenuModel.addMenu(new MenuModel("Cappuccino", "With Milk", 30000.0));
    viewMenuModel.addMenu(new MenuModel("Macchiato", "With Honey", 35000.0));
    viewMenuModel.addMenu(new MenuModel("Cold Brew", "Alcohol", 45000.0));
    viewMenuModel.addMenu(new MenuModel("Espresso", "", 16000.0));
    viewMenuModel.addMenu(new MenuModel("Ammericano", "", 20000.0));
    viewMenuModel.addMenu(new MenuModel("Piccolo", "With Milk", 40000.0));

    adapter = new MenuListAdapter(viewMenuModel, getContext());
    recyclerView.setAdapter(adapter);

    return view;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    viewMenuModel = new ViewModelProvider(this).get(ViewMenuModel.class);
  }
}