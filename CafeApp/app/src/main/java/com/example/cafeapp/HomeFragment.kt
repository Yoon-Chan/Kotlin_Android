package com.example.cafeapp

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.cafeapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)


        val homeData = context?.readData("home.json", Home::class.java) ?: return
        val menuData = context?.readData("menu.json", Menu::class.java) ?: return
        initAppBar(homeData)
        initRecommendMenuList(homeData, menuData)
        initBanner(homeData)
        initFoodList(menuData)
        initFloatingActiveonButton()
    }

    private fun initFloatingActiveonButton() {
        binding.scrollView.setOnScrollChangeListener { v, _, scrollY, _, oldScrollY ->
            if (scrollY == 0) {
                binding.floatingActionButton.extend()
            } else {
                binding.floatingActionButton.shrink()
            }
        }
    }

    private fun initFoodList(menuData: Menu) {
        binding.foodMenuList.titleTextView.text = getString(R.string.foodmenu_title)
        menuData.food.forEach { menuItem ->
            binding.foodMenuList.menuLayout.addView(
                MenuView(context = requireContext()).apply {
                    setTitle(menuItem.name)
                    setImageUrl(menuItem.image)
                }
            )
        }
    }

    private fun initBanner(homeData: Home) {
        binding.bannerLayout.bannerImageView.apply {
            Glide.with(this)
                .load(homeData.banner.image)
                .into(this)
            this.contentDescription = homeData.banner.contentDescription
        }
    }

    private fun initRecommendMenuList(homeData: Home, menuData: Menu) {
        binding.recommendMenuList.titleTextView.text =
            getString(R.string.recommend_title, homeData.user.nickName)
        menuData.coffee.forEach { menuItem ->
            binding.recommendMenuList.menuLayout.addView(
                MenuView(context = requireContext()).apply {
                    setTitle(menuItem.name)
                    setImageUrl(menuItem.image)
                }
            )
        }
    }

    private fun initAppBar(homeData: Home) {
        binding.appBarTitleTextView.text =
            getString(R.string.appbar_title_text, homeData.user.nickName)

        binding.starCountTextView.text =
            getString(R.string.appbar_star_title, homeData.user.starCount, homeData.user.totalCount)

        binding.appBarProgressBar.max = homeData.user.totalCount


        Glide.with(binding.appBarImageView)
            .load(homeData.appbarImage)
            .into(binding.appBarImageView)

        ValueAnimator.ofInt(0, homeData.user.starCount).apply {
            duration = 1000
            addUpdateListener {
                binding.appBarProgressBar.progress = it.animatedValue as Int
            }
            start()
        }
    }
}

