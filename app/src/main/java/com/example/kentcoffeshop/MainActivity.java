package com.example.kentcoffeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
  private BottomNavigationView bottomNavigationView;

  private HomeFragment homeFragment = new HomeFragment();
  private MenuListFragment menuListFragment = new MenuListFragment();
  private ViewOrderFragment viewOrderFragment = new ViewOrderFragment();
  private SettingsFragment settingsFragment = new SettingsFragment();

  private FloatingActionButton btnCreateOrder;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView);
    bottomNavigationView.setBackground(null);

    btnCreateOrder = (FloatingActionButton) findViewById(R.id.floatingButton);

    getSupportFragmentManager().beginTransaction().replace(R.id.templateContent, homeFragment).commit();

    bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
          case R.id.home:
            getSupportFragmentManager().beginTransaction().replace(R.id.templateContent, homeFragment).commit();
            return true;
          case R.id.menu:
            getSupportFragmentManager().beginTransaction().replace(R.id.templateContent, menuListFragment).commit();
            return true;
          case R.id.order:
            getSupportFragmentManager().beginTransaction().replace(R.id.templateContent, viewOrderFragment).commit();
            return true;
          case R.id.settings:
            getSupportFragmentManager().beginTransaction().replace(R.id.templateContent, settingsFragment).commit();
            return true;
        }
        return false;
      }
    });

    btnCreateOrder.setOnClickListener(v -> {
      Intent intent = new Intent(MainActivity.this, OrderActivity.class);
      finish();
      startActivity(intent);
    });
  }
}