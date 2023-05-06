package com.example.kentcoffeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {
  private TextView fullname, order, sugar, ice, paymentStat;
  private OrderData orderData;
  private AppCompatButton btnBack;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order_detail);

    fullname = (TextView) findViewById(R.id.tvFullname);
    order = (TextView) findViewById(R.id.tvOrder);
    sugar = (TextView) findViewById(R.id.tvSugar);
    ice = (TextView) findViewById(R.id.tvIce);
    paymentStat = (TextView) findViewById(R.id.tvPayment);
    btnBack = (AppCompatButton) findViewById(R.id.btnGoBack);

    Intent intent = getIntent();
    orderData = (OrderData) intent.getSerializableExtra("random_data");

    fullname.setText(orderData.getName());
    order.setText(orderData.getOrder());
    sugar.setText(orderData.getSugarLevel());
    ice.setText(orderData.getIceLevel());
    paymentStat.setText(orderData.getPayment());

    btnBack.setOnClickListener(v -> {
      finish();
      startActivity(new Intent(OrderDetailActivity.this, MainActivity.class));
    });
  }
}