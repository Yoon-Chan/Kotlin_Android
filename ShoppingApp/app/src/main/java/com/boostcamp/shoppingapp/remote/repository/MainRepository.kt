package com.boostcamp.shoppingapp.remote.repository

import androidx.paging.PagingData
import com.boostcamp.shoppingapp.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun loadList() : Flow<PagingData<ListItem>>
}