package com.example.kentcoffeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

  private EditText name, coffee;
  private RadioGroup radioSugarGroup, radioIceGroup;
  private RadioButton radioSugarButton, radioIceButton;
  private AppCompatButton btnPayment, btnBack;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order);

    name = (EditText) findViewById(R.id.name);
    coffee = (EditText) findViewById(R.id.coffee);
    radioSugarGroup = (RadioGroup) findViewById(R.id.sugarGroup);
    radioIceGroup = (RadioGroup) findViewById(R.id.iceGroup);
    btnPayment = (AppCompatButton) findViewById(R.id.btnPayment);
    btnBack = (AppCompatButton) findViewById(R.id.btnGoBackToMain);

    btnPayment.setOnClickListener(v -> {
      if (inputIsEmpty()) {
        return;
      }
      int sugarLvl = radioSugarGroup.getCheckedRadioButtonId();
      int iceLvl = radioIceGroup.getCheckedRadioButtonId();

      radioSugarButton = (RadioButton) findViewById(sugarLvl);
      radioIceButton = (RadioButton) findViewById(iceLvl);

      String txtName = name.getText().toString();
      String txtCoffee = coffee.getText().toString();
      String txtSugarLvl = radioSugarButton.getText().toString();
      String txtIcelvl = radioIceButton.getText().toString();
      OrderData orderData = new OrderData(txtName,txtCoffee,txtSugarLvl,txtIcelvl);

      OrderData.setData(orderData);
      Intent intent = new Intent(OrderActivity.this, PaymentActivity.class);
      intent.putExtra("order_data", orderData);

      finish();
      startActivity(intent);
    });

    btnBack.setOnClickListener(v ->  {
      Intent intent = new Intent(OrderActivity.this, MainActivity.class);
      finish();
      startActivity(intent);
    });
  }

  public boolean inputIsEmpty() {
    if (
        name.getText().toString().isEmpty() ||
        coffee.getText().toString().isEmpty() ||
        radioSugarGroup.getCheckedRadioButtonId() == -1 ||
        radioIceGroup.getCheckedRadioButtonId() == -1
    ) {
      Toast.makeText(OrderActivity.this, "All field should be filled!", Toast.LENGTH_SHORT).show();
      return true;
    }
    else return false;
  }
}