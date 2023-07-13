package com.nayanthayasiru.lec02.ui.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private var githubService: GithubService
) : ViewModel() {
    init {
        viewModelScope.launch{
            val response = githubService.users()
        }
    }
}