package com.example.newsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.ActivityMainBinding
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import org.jsoup.Jsoup
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var newsAdapter: NewsAdapter
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://news.google.com/")
        .addConverterFactory(
            TikXmlConverterFactory.create(
                TikXml.Builder()
                    .exceptionOnUnreadXml(false)
                    .build()
            )
        )
        .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newsService = retrofit.create(NewsService::class.java)
        newsService.mainFeed().submitList()

        binding.feedCHip.setOnClickListener {
            //모든 칩들을 클리어체크 (false) 해준다.
            binding.chipGroup.clearCheck()
            binding.feedCHip.isChecked = true


            // api 호출, 리스트를 변경
            newsService.mainFeed().submitList()
        }

        binding.politicsChip.setOnClickListener {
            //모든 칩들을 클리어체크 (false) 해준다.
            binding.chipGroup.clearCheck()
            binding.politicsChip.isChecked = true


            // api 호출, 리스트를 변경
            newsService.politicsNews().submitList()

        }

        binding.economyChip.setOnClickListener {
            //모든 칩들을 클리어체크 (false) 해준다.
            binding.chipGroup.clearCheck()
            binding.economyChip.isChecked = true


            // api 호출, 리스트를 변경
            newsService.economyNews().submitList()
        }


        binding.societyChip.setOnClickListener {
            //모든 칩들을 클리어체크 (false) 해준다.
            binding.chipGroup.clearCheck()
            binding.societyChip.isChecked = true


            // api 호출, 리스트를 변경
            newsService.societyNews().submitList()

        }

        binding.itChip.setOnClickListener {
            //모든 칩들을 클리어체크 (false) 해준다.
            binding.chipGroup.clearCheck()
            binding.itChip.isChecked = true


            // api 호출, 리스트를 변경
            newsService.itNews().submitList()

        }

        binding.sportChip.setOnClickListener {
            //모든 칩들을 클리어체크 (false) 해준다.
            binding.chipGroup.clearCheck()
            binding.sportChip.isChecked = true


            // api 호출, 리스트를 변경
            newsService.sportNews().submitList()

        }


        newsAdapter = NewsAdapter()
        binding.newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }

        binding.searchTextInputEditText.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                binding.chipGroup.clearCheck()


                binding.searchTextInputEditText.clearFocus()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)


                newsService.search(binding.searchTextInputEditText.text.toString()).submitList()
                return@setOnEditorActionListener true
            }

            return@setOnEditorActionListener false
        }

    }

    private fun Call<NewsRss>.submitList() {
        this.enqueue(object : Callback<NewsRss> {
            override fun onFailure(call: Call<NewsRss>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<NewsRss>, response: Response<NewsRss>) {
//                Log.e("MainActivity", "response ${response.body()?.channel?.items}")

                val list = response.body()?.channel?.items.orEmpty().transfrom()
                newsAdapter.submitList(list)
                list.forEachIndexed { index, newsModel ->

                    Thread {
                        try {
                            val jsoup = Jsoup.connect(newsModel.link).get()
                            val elements = jsoup.select("meta[property^=og:]")

//                            Log.i("link", "link : ${newsModel.link}")
//                            Log.e("elements","ogImageNode : $elements")

                            val ogImageNode = elements.find { node ->
                                node.attr("property") == "og:image"
                            }

                            //Log.e("ogImageNode","ogImageNode : $ogImageNode")

                            newsModel.imageUrl = ogImageNode?.attr("content")

                            //Log.e("MainActivity", "imageUrl ${newsModel.imageUrl}")
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                        runOnUiThread {
                            newsAdapter.notifyItemChanged(index)
                        }
                    }.start()
                }


            }
        })
    }
}