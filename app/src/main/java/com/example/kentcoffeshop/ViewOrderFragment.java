package com.example.kentcoffeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/*
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewOrderFragment extends Fragment {
  private ListView listView;
  private ViewOrderAdapter adapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_view_order, container, false);

    listView = (ListView) view.findViewById(R.id.orderListView);

    adapter = new ViewOrderAdapter(getContext(), OrderData.orderDataList);
    listView.setAdapter(adapter);

    return view;
  }
}