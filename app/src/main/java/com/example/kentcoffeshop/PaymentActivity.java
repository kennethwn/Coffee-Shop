package com.example.kentcoffeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
  private TextView fullname, order, sugar, ice, paymentStat;
  private OrderData orderData;
  private AppCompatButton btnBack, btnValidate;

  @SuppressLint("MissingInflatedId")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_payment);

    fullname = (TextView) findViewById(R.id.tvFullname);
    order = (TextView) findViewById(R.id.tvOrder);
    sugar = (TextView) findViewById(R.id.tvSugar);
    ice = (TextView) findViewById(R.id.tvIce);
    paymentStat = (TextView) findViewById(R.id.tvPayment);
    btnBack = (AppCompatButton) findViewById(R.id.btnGoBack);
    btnValidate = (AppCompatButton) findViewById(R.id.btnValidate);

    Intent intent = getIntent();
    orderData = (OrderData) intent.getSerializableExtra("order_data");

    fullname.setText(orderData.getName());
    order.setText(orderData.getOrder());
    sugar.setText(orderData.getSugarLevel());
    ice.setText(orderData.getIceLevel());
    paymentStat.setText(orderData.getPayment());

    btnBack.setOnClickListener(v -> {
      finish();
      startActivity(new Intent(PaymentActivity.this, OrderActivity.class));
    });

    btnValidate.setOnClickListener(v -> {
      orderData.setPayment("Lunas");
      paymentStat.setText(orderData.getPayment());
      Toast.makeText(PaymentActivity.this, "Payment Successed!", Toast.LENGTH_SHORT).show();
      finish();
      startActivity(new Intent(PaymentActivity.this, MainActivity.class));
    });
  }
}