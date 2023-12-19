package com.boostcamp.shoppingapp.databinding;
import com.boostcamp.shoppingapp.R;
import com.boostcamp.shoppingapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemFullAdBindingImpl extends ItemFullAdBinding  {

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
    @NonNull
    private final android.widget.Button mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemFullAdBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemFullAdBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.utils.widget.ImageFilterView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.imageView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.Button) bindings[3];
        this.mboundView3.setTag(null);
        this.titleTextView.setTag(null);
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
            setItem((com.boostcamp.shoppingapp.model.FullAd) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.boostcamp.shoppingapp.model.FullAd Item) {
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
        java.lang.String itemTitle = null;
        java.lang.String itemImageUrl = null;
        boolean itemButtonJavaLangObjectNull = false;
        com.boostcamp.shoppingapp.model.FullAd item = mItem;
        java.lang.String itemButton = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.title
                    itemTitle = item.getTitle();
                    // read item.imageUrl
                    itemImageUrl = item.getImageUrl();
                    // read item.button
                    itemButton = item.getButton();
                }


                // read item.button != null
                itemButtonJavaLangObjectNull = (itemButton) != (null);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.boostcamp.shoppingapp.BindingAdapterKt.setImage(this.imageView, itemImageUrl);
            com.boostcamp.shoppingapp.BindingAdapterKt.setVisible(this.mboundView3, itemButtonJavaLangObjectNull);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, itemButton);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.titleTextView, itemTitle);
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