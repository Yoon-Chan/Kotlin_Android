package com.example.mediasearchapp.repository

import com.example.mediasearchapp.model.ListItem
import io.reactivex.rxjava3.core.Observable

interface SearchRepository {

    suspend fun search(query: String): Observable<List<ListItem>>
}