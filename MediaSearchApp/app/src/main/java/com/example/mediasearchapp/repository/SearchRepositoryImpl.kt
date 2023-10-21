package com.example.mediasearchapp.repository


import com.example.mediasearchapp.SearchService
import com.example.mediasearchapp.model.ListItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchRepositoryImpl(private val searchService: SearchService) : SearchRepository {
    override fun search(query: String): Observable<List<ListItem>> {
        return searchService.searchImage(query)
            .zipWith(searchService.searchVideo(query)) { i, v ->
                val list = mutableListOf<ListItem>().apply {
                    addAll(i.document)
                    addAll(v.document)
                }
                list.sortBy { it.dateTime }
                list.toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    }
}