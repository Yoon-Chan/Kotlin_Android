package com.example.project2

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.example.project2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

@SuppressLint("MissingInflatedId")
class MainActivity : AppCompatActivity(), OnTabLayoutNameChanged {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreference = getSharedPreferences(WebViewFragment.Companion.SHARED_PREFERENCE, Context.MODE_PRIVATE)
        val tab0 = sharedPreference?.getString("tab0_name", "월요웹툰")
        val tab1 = sharedPreference?.getString("tab1_name", "화요웹툰")
        val tab2 = sharedPreference?.getString("tab2_name", "수욜웹툰")


        binding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tablayout, binding.viewPager){
            tab, position ->
            run {
//                val textView = TextView(this@MainActivity)
//                textView.text = when(position){
//                    0 -> tab0
//                    1 -> tab1
//                    else -> tab2
//                }
//                textView.gravity = Gravity.CENTER
//                tab.customView = textView

                tab.text = when(position){
                    0 -> tab0
                    1 -> tab1
                    else -> tab2
                }
            }
        }.attach()

    }

    override fun onBackPressed() {

        val back = super.getOnBackPressedDispatcher()
        val currentFragment = supportFragmentManager.fragments[binding.viewPager.currentItem]   //TODO 수정 필요함. fragment를 viewPager에서 가져와야함
        if(currentFragment is WebViewFragment){
            if(currentFragment.CanGoBack()){
                currentFragment.goBack()
            }else{
                back.onBackPressed()
            }
        }else{
            back.onBackPressed()
        }

    }

    override fun nameChanged(position: Int, name: String) {
        val tab = binding.tablayout.getTabAt(position)
        tab?.text = name
    }
}