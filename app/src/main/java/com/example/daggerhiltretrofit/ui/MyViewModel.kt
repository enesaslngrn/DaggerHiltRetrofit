package com.example.daggerhiltretrofit.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltretrofit.domain.repository.MyRepository
import com.example.daggerhiltretrofit.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor( // Provider factory
    private val repository: MyRepository // injecting dependency into viewmodel
) : ViewModel() {

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> get() = _post

    fun fetchPost(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPost()
            if (response.isSuccessful) {
                _post.postValue(response.body())
            }else{
                Log.e("MyViewModel","Error fetching : ${response.errorBody()}")
            }
        }
    }

}