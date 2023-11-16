package com.boostcamp.shoppingapp.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.boostcamp.shoppingapp.databinding.ItemEmptyBinding
import com.boostcamp.shoppingapp.viewholder.BindingViewHolder
import com.boostcamp.shoppingapp.viewholder.FullAdViewHolder
import com.boostcamp.shoppingapp.viewholder.HorizontalVIewHolder
import com.boostcamp.shoppingapp.viewholder.ViewPagerViewHolder


//리스트어댑터에 크리에이트 뷰 부분에서 이것을 호출할 건데
// 리스트에 따른 뷰호더를 호출하기 때문에
//다양한 리스트들이 있을 때 뷰타입에 맞는 뷰홀더를 하나로 관리하기 위해 아래 코드 작성
object ViewHolderGenerator {

    fun get(
        parent: ViewGroup,
        viewType: Int
    ) : BindingViewHolder<*>{
        return when(viewType){
            ViewType.VIEW_PAGER.ordinal -> ViewPagerViewHolder(parent.toBinding())
            ViewType.HORIZONTAL.ordinal -> HorizontalVIewHolder(parent.toBinding())
            ViewType.FULL_AD.ordinal -> FullAdViewHolder(parent.toBinding())
            else -> ItemViewHolder(parent.toBinding())
        }
    }

    class ItemViewHolder(binding: ItemEmptyBinding) : BindingViewHolder<ItemEmptyBinding>(binding)

    private inline fun<reified V: ViewBinding> ViewGroup.toBinding() : V {
        return V::class.java.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null, LayoutInflater.from(context), this, false) as V
    }
}