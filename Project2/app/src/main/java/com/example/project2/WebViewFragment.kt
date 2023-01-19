package com.example.project2

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.edit
import com.example.project2.databinding.FragmentWebViewBinding


class WebViewFragment(val position: Int, private val webViewurl: String) : Fragment() {

    var listener : OnTabLayoutNameChanged?= null

    companion object{
        const val SHARED_PREFERENCE = "WEB_HISTORY"
    }


    private lateinit var fragmentWebViewBinding: FragmentWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        fragmentWebViewBinding = FragmentWebViewBinding.inflate(inflater, container, false)
        return fragmentWebViewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView = fragmentWebViewBinding.webView
        webView.webViewClient = WebtoonWebViewClient(fragmentWebViewBinding.progressBar) { url ->
            activity?.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)?.edit {
                putString("tab$position", url)
                commit()
            }

        }
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(webViewurl)


        fragmentWebViewBinding.backToLastButton.setOnClickListener {
            val sharedPreference =
                activity?.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)
            val url = sharedPreference?.getString("tab$position", "")
            if (url.isNullOrEmpty()) {
                Toast.makeText(context, "마지막 저장 시점이 없습니다.", Toast.LENGTH_SHORT).show()
            } else {
                fragmentWebViewBinding.webView.loadUrl(url)
            }
        }


        fragmentWebViewBinding.changeTabNameButton.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            val editText = EditText(context)

            dialog.setView(editText)
            dialog.setPositiveButton("저장") { _, _ ->
                //TODO 저장 기능
                activity?.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)?.edit{
                    putString("tab${position}_name", editText.text.toString())
                    listener?.nameChanged(position,editText.text.toString())
                }
            }
            dialog.setNegativeButton("취소") { dialog, _ ->
                dialog.cancel()
            }

            dialog.show()


        }
    }


    fun CanGoBack(): Boolean {
        return fragmentWebViewBinding.webView.canGoBack()
    }

    fun goBack() {
        fragmentWebViewBinding.webView.goBack()
    }
}

interface OnTabLayoutNameChanged {
    fun nameChanged(position: Int, name : String)
}