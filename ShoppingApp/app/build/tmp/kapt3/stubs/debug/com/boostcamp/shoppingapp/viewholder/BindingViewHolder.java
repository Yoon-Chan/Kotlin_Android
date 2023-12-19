package com.boostcamp.shoppingapp.viewholder;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.boostcamp.shoppingapp.BR;
import com.boostcamp.shoppingapp.model.ListItem;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/boostcamp/shoppingapp/viewholder/BindingViewHolder;", "VB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "item", "Lcom/boostcamp/shoppingapp/model/ListItem;", "getItem", "()Lcom/boostcamp/shoppingapp/model/ListItem;", "setItem", "(Lcom/boostcamp/shoppingapp/model/ListItem;)V", "bind", "", "app_debug"})
public abstract class BindingViewHolder<VB extends androidx.databinding.ViewDataBinding> extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private final VB binding = null;
    @org.jetbrains.annotations.Nullable
    private com.boostcamp.shoppingapp.model.ListItem item;
    
    public BindingViewHolder(@org.jetbrains.annotations.NotNull
    VB binding) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    protected final com.boostcamp.shoppingapp.model.ListItem getItem() {
        return null;
    }
    
    protected final void setItem(@org.jetbrains.annotations.Nullable
    com.boostcamp.shoppingapp.model.ListItem p0) {
    }
    
    public void bind(@org.jetbrains.annotations.NotNull
    com.boostcamp.shoppingapp.model.ListItem item) {
    }
}