package com.example.firebasemessenger.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

interface BaseViewModel {
    val scope: CoroutineScope
    val jobs: MutableList<Job>

    fun onViewShow()
    fun onViewHidden()
    fun onCleared()
}

