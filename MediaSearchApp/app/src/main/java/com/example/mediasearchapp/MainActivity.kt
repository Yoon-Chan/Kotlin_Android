package com.example.mediasearchapp

import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.disposables.Disposable
import com.example.mediasearchapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val searchFragment = SearchFragment()
    private val fragmentList = listOf(searchFragment, FavoriteFragment())
    val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, fragmentList)

    private var observableTextQuery: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        observableTextQuery?.dispose()
        observableTextQuery = null
    }


    fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this

        setSupportActionBar(binding.toolbarLayout)
        binding.toolbarLayout.setBackgroundColor(getColor(R.color.primary_color))
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = if (fragmentList[position] is SearchFragment) {
                "검색 결과"
            } else "즐겨 찾기"
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)


        observableTextQuery = Observable.create { emitter: ObservableEmitter<String>? ->
            (menu.findItem(R.id.search).actionView as SearchView).apply {
                setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    //텍스트가 변경될 때마다 호출하게 된다.
                    override fun onQueryTextChange(newText: String): Boolean {
                        binding.viewPager.setCurrentItem(0, true)
                        emitter?.onNext(newText)
                        return false
                    }

                    //실제 입력을 하고 입력 완료 버튼을 누를 때
                    override fun onQueryTextSubmit(query: String): Boolean {
                        emitter?.onNext(query)
                        return false
                    }
                })
            }
        }
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { searchFragment.searchKeyword(it) }



        return super.onCreateOptionsMenu(menu)
    }
}