package com.boostcamp.shoppingapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.boostcamp.shoppingapp.databinding.ActivityMainBindingImpl;
import com.boostcamp.shoppingapp.databinding.ItemCouponBindingImpl;
import com.boostcamp.shoppingapp.databinding.ItemEmptyBindingImpl;
import com.boostcamp.shoppingapp.databinding.ItemFullAdBindingImpl;
import com.boostcamp.shoppingapp.databinding.ItemHorizontalBindingImpl;
import com.boostcamp.shoppingapp.databinding.ItemImageBindingImpl;
import com.boostcamp.shoppingapp.databinding.ItemSaleBindingImpl;
import com.boostcamp.shoppingapp.databinding.ItemSellItemBindingImpl;
import com.boostcamp.shoppingapp.databinding.ItemViewpagerBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_ITEMCOUPON = 2;

  private static final int LAYOUT_ITEMEMPTY = 3;

  private static final int LAYOUT_ITEMFULLAD = 4;

  private static final int LAYOUT_ITEMHORIZONTAL = 5;

  private static final int LAYOUT_ITEMIMAGE = 6;

  private static final int LAYOUT_ITEMSALE = 7;

  private static final int LAYOUT_ITEMSELLITEM = 8;

  private static final int LAYOUT_ITEMVIEWPAGER = 9;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(9);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.item_coupon, LAYOUT_ITEMCOUPON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.item_empty, LAYOUT_ITEMEMPTY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.item_full_ad, LAYOUT_ITEMFULLAD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.item_horizontal, LAYOUT_ITEMHORIZONTAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.item_image, LAYOUT_ITEMIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.item_sale, LAYOUT_ITEMSALE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.item_sell_item, LAYOUT_ITEMSELLITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.boostcamp.shoppingapp.R.layout.item_viewpager, LAYOUT_ITEMVIEWPAGER);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCOUPON: {
          if ("layout/item_coupon_0".equals(tag)) {
            return new ItemCouponBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_coupon is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMEMPTY: {
          if ("layout/item_empty_0".equals(tag)) {
            return new ItemEmptyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_empty is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMFULLAD: {
          if ("layout/item_full_ad_0".equals(tag)) {
            return new ItemFullAdBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_full_ad is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMHORIZONTAL: {
          if ("layout/item_horizontal_0".equals(tag)) {
            return new ItemHorizontalBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_horizontal is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMIMAGE: {
          if ("layout/item_image_0".equals(tag)) {
            return new ItemImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_image is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSALE: {
          if ("layout/item_sale_0".equals(tag)) {
            return new ItemSaleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_sale is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSELLITEM: {
          if ("layout/item_sell_item_0".equals(tag)) {
            return new ItemSellItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_sell_item is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMVIEWPAGER: {
          if ("layout/item_viewpager_0".equals(tag)) {
            return new ItemViewpagerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_viewpager is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "item");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(9);

    static {
      sKeys.put("layout/activity_main_0", com.boostcamp.shoppingapp.R.layout.activity_main);
      sKeys.put("layout/item_coupon_0", com.boostcamp.shoppingapp.R.layout.item_coupon);
      sKeys.put("layout/item_empty_0", com.boostcamp.shoppingapp.R.layout.item_empty);
      sKeys.put("layout/item_full_ad_0", com.boostcamp.shoppingapp.R.layout.item_full_ad);
      sKeys.put("layout/item_horizontal_0", com.boostcamp.shoppingapp.R.layout.item_horizontal);
      sKeys.put("layout/item_image_0", com.boostcamp.shoppingapp.R.layout.item_image);
      sKeys.put("layout/item_sale_0", com.boostcamp.shoppingapp.R.layout.item_sale);
      sKeys.put("layout/item_sell_item_0", com.boostcamp.shoppingapp.R.layout.item_sell_item);
      sKeys.put("layout/item_viewpager_0", com.boostcamp.shoppingapp.R.layout.item_viewpager);
    }
  }
}
