package com.example.ekacareassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ekacareassignment.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun onSubmitClicked(user: User){
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}