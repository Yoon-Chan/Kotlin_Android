package com.example.project6

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.project6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), WordAdapter.ItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var wordadapter: WordAdapter
    private var selectedWord : Word? = null
    private val updateAddWordResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        val isUpdated = result.data?.getBooleanExtra("isUpdated", false) ?: false

        if(result.resultCode == RESULT_OK && isUpdated){
           updateAddWord()
        }
    }


    private val updateEditWordResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        val editdWord = result.data?.getParcelableExtra<Word>("editWord") ?: null

        if(result.resultCode == RESULT_OK && editdWord != null){
            updateEditWord(editdWord)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            Intent(this, AddActivity::class.java).let {
                updateAddWordResult.launch(it)
            }
        }

        binding.deleteImageView.setOnClickListener {
            delete()
        }

        binding.editImageView.setOnClickListener {
            edit()
        }

        initRecyclerView()

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerView() {

        wordadapter = WordAdapter(mutableListOf(), this)
        binding.wordRecyclerView.apply {
            adapter = wordadapter
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            val dividerItemDecoration =
                DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }

        Thread {
            val list = AppDatabase.getInstance(this)?.wordDao()?.getAll() ?: emptyList()
            wordadapter.data.addAll(list)
            runOnUiThread {
                wordadapter.notifyDataSetChanged()
            }
        }.start()
    }

    override fun onClick(word: Word) {
        selectedWord = word
        binding.textTextView.text = word.text
        binding.meanTextView.text = word.mean


        Toast.makeText(this, "${word.text} 가 클릭 됐습니다.", Toast.LENGTH_SHORT).show()
    }

    private fun updateAddWord(){
        Thread{
            AppDatabase.getInstance(this)?.wordDao()?.getLatesWord()?.let { word ->
                wordadapter.data.add(0,word)
                runOnUiThread{
                    wordadapter.notifyDataSetChanged()
                }
            }
        }.start()
    }

    private fun updateEditWord(word: Word){
        val index = wordadapter.data.indexOfFirst { it.id == word.id }
        wordadapter.data[index] = word
        runOnUiThread {
            selectedWord = word
            binding.textTextView.text = word.text
            binding.meanTextView.text = word.mean
            wordadapter.notifyItemChanged(index)
        }
    }

    private fun delete(){
        if (selectedWord == null)
            return

        Thread {
            selectedWord?.let { word ->
                AppDatabase.getInstance(this)?.wordDao()?.delete(word)
                runOnUiThread{
                    wordadapter.data.remove(word)
                    wordadapter.notifyDataSetChanged()
                    binding.textTextView.text = ""
                    binding.meanTextView.text = ""

                    Toast.makeText(this, "삭제가 완료됐습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            selectedWord = null
        }.start()
    }

    private fun edit(){
        if(selectedWord == null) return

        val intent = Intent(this, AddActivity::class.java).putExtra("originWord", selectedWord)
        updateEditWordResult.launch(intent)

    }
}