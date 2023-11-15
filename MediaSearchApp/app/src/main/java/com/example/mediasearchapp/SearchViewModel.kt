package com.example.mediasearchapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mediasearchapp.model.ListItem
import com.example.mediasearchapp.repository.SearchRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _listLiveData = MutableLiveData<List<ListItem>>()
    val listLiveData : LiveData<List<ListItem>> = _listLiveData

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading = _showLoading

    private var disposable : CompositeDisposable? = CompositeDisposable()

    fun search(query : String){
        viewModelScope.launch {
            disposable?.add(searchRepository.search(query)
                .doOnSubscribe {
                    _showLoading.value = true
                }
                .doOnTerminate { _showLoading.value =false}
                .subscribe( { list ->
                    Log.d("searchKeyword", "111${list.toString()}")
                    _listLiveData.value = list
                },{
                    Log.d("searchKeyword", "222${it.printStackTrace()}")
                    _listLiveData.value = emptyList()
                })
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }


    class SearchViewModelFactory(private val searchRepository: SearchRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            return SearchViewModel(searchRepository) as T
        }
    }
}