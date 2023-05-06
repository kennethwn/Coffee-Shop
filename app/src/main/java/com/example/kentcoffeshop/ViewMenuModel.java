package com.example.kentcoffeshop;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ViewMenuModel extends ViewModel {
  private static ArrayList<MenuModel> menu;

  public static ArrayList<MenuModel> getInstance() {
    if (menu == null) {
      menu = new ArrayList<MenuModel>();
    }
    return menu;
  }

  public ArrayList<MenuModel> getMenu() {
    return this.menu;
  }

  public void addMenu(MenuModel menu) {
    this.menu.add(menu);
  }

  public void setMenuList(ArrayList<MenuModel> menuList) {
    this.menu = menuList;
  }
}
