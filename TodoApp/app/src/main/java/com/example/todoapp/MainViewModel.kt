package com.example.todoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.model.ContentEntity
import com.example.todoapp.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {

    val contentList = contentRepository.loadList().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
    )


    fun updateItem(item : ContentEntity){
        viewModelScope.launch(Dispatchers.IO) {
            contentRepository.modify(item)
        }
    }

    fun deleteItem(item : ContentEntity){
        viewModelScope.launch(Dispatchers.IO) {
            contentRepository.delete(item)
        }
    }
}