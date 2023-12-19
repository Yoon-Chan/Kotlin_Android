package com.boostcamp.shoppingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.boostcamp.shoppingapp.model.ListItem
import com.boostcamp.shoppingapp.remote.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {


    private val _pagingData = MutableStateFlow<PagingData<ListItem>?>(null)
    val pagingData : StateFlow<PagingData<ListItem>?> = _pagingData.asStateFlow()

    init {
        getList()
    }

    private fun getList(){
        viewModelScope.launch {
            mainRepository.loadList()
                .cachedIn(this)
                .collectLatest { list ->
                    _pagingData.value = list
                }
        }
    }
}