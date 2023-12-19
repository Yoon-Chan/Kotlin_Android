package com.boostcamp.shoppingapp;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import java.text.NumberFormat;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u001b\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007\u00a2\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u000e"}, d2 = {"setImage", "", "Landroid/widget/ImageView;", "imageUrl", "", "setMoneyText", "Landroid/widget/TextView;", "money", "", "(Landroid/widget/TextView;Ljava/lang/Long;)V", "setVisible", "Landroid/view/View;", "isShow", "", "app_debug"})
public final class BindingAdapterKt {
    
    @androidx.databinding.BindingAdapter(value = {"visible"})
    public static final void setVisible(@org.jetbrains.annotations.NotNull
    android.view.View $this$setVisible, boolean isShow) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"imageUrl"})
    public static final void setImage(@org.jetbrains.annotations.NotNull
    android.widget.ImageView $this$setImage, @org.jetbrains.annotations.Nullable
    java.lang.String imageUrl) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"moneyText"})
    public static final void setMoneyText(@org.jetbrains.annotations.NotNull
    android.widget.TextView $this$setMoneyText, @org.jetbrains.annotations.Nullable
    java.lang.Long money) {
    }
}