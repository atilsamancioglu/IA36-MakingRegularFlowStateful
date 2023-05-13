package com.atilsamancioglu.makingregularflowstateful

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class FirstScreenVM : ViewModel() {

    private var count = 0

    val counter = flow{
        while (true) {
            delay(1000L)
            println("running flow")
            emit(count++)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily,0)
}