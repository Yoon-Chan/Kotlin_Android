package com.example.cafeapp

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.cafeapp.databinding.ItemMenuBinding

//JvmOverloads를 사용하는 이유
//Tools-> Kotlin -> Show Kotlin ByteCode를 누르면 코틀린을 컴파일 했을 떄 바이트 코드로 어떻게 나오는지 보여주는데
//이를 자바형태로 보여주게 되는데
//생성자가 3개가 나오게 된다.(생성자가 1개, 2개, 3개인 경우) 만약 이 애너테이션이 없으면 생성자가 1개만 나오게 된다(3개의 생성자만 입력하는 경우)

class MenuView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attributeSet, defStyleAttr) {

    private lateinit var binding: ItemMenuBinding
    private var title: String? = null
    private var imageUrl : String? = null

    init {
        attributeSet?.let {
            initAttr(it)
        }
        initView()
    }

    private fun initView() {
        val view = inflate(context, R.layout.item_menu, this)
        binding = ItemMenuBinding.bind(view)

        title?.let {
            setTitle(it)
        }

        imageUrl?.let {
            setImageUrl(it)
        }

    }

    private fun initAttr(attributeSet: AttributeSet) {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.MenuView, 0, 0).apply {
            title = getString(R.styleable.MenuView_title)
            imageUrl = getString(R.styleable.MenuView_imageUrl)
        }
    }

    fun setTitle(title: String) {
        this.title = title
        binding.nameTextView.text = title
    }

    fun setImageUrl(imageUrl : String) {
        this.imageUrl = imageUrl
        Glide.with(binding.imageView)
            .load(imageUrl)
            .circleCrop()
            .into(binding.imageView)
    }

}