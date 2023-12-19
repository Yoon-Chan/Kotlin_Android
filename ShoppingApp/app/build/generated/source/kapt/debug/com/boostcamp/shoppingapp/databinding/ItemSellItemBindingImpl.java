package com.boostcamp.shoppingapp.databinding;
import com.boostcamp.shoppingapp.R;
import com.boostcamp.shoppingapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemSellItemBindingImpl extends ItemSellItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSellItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemSellItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.RatingBar) bindings[5]
            );
        this.badgeTextView.setTag(null);
        this.imageView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.nameTextView.setTag(null);
        this.priceTextView.setTag(null);
        this.ratingbar.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.item == variableId) {
            setItem((com.boostcamp.shoppingapp.model.SellItem) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.boostcamp.shoppingapp.model.SellItem Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String itemImageUrl = null;
        boolean itemBadgeJavaLangObjectNull = false;
        com.boostcamp.shoppingapp.model.SellItem item = mItem;
        boolean itemRatingJavaLangObjectNull = false;
        java.lang.String itemName = null;
        java.lang.String itemBadge = null;
        float androidxDatabindingViewDataBindingSafeUnboxItemRating = 0f;
        long itemPrice = 0;
        java.lang.Float itemRating = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.imageUrl
                    itemImageUrl = item.getImageUrl();
                    // read item.name
                    itemName = item.getName();
                    // read item.badge
                    itemBadge = item.getBadge();
                    // read item.price
                    itemPrice = item.getPrice();
                    // read item.rating
                    itemRating = item.getRating();
                }


                // read item.badge != null
                itemBadgeJavaLangObjectNull = (itemBadge) != (null);
                // read item.rating != null
                itemRatingJavaLangObjectNull = (itemRating) != (null);
                // read androidx.databinding.ViewDataBinding.safeUnbox(item.rating)
                androidxDatabindingViewDataBindingSafeUnboxItemRating = androidx.databinding.ViewDataBinding.safeUnbox(itemRating);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.badgeTextView, itemBadge);
            com.boostcamp.shoppingapp.BindingAdapterKt.setVisible(this.badgeTextView, itemBadgeJavaLangObjectNull);
            com.boostcamp.shoppingapp.BindingAdapterKt.setImage(this.imageView, itemImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nameTextView, itemName);
            com.boostcamp.shoppingapp.BindingAdapterKt.setMoneyText(this.priceTextView, itemPrice);
            com.boostcamp.shoppingapp.BindingAdapterKt.setVisible(this.ratingbar, itemRatingJavaLangObjectNull);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.ratingbar, androidxDatabindingViewDataBindingSafeUnboxItemRating);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}