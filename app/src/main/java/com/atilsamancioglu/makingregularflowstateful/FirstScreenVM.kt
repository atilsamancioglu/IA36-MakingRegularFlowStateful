package com.atilsamancioglu.makingregularflowstateful

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class FirstScreenVM : ViewModel() {

    //this whole thing wouldn't matter if we was working on a normal stateflow
    //private val _mycounter = MutableStateFlow(0)
    //val mycounter = _mycounter.asStateFlow()

    private var count = 0

    val counter = flow{
        while (true) {
            delay(1000L)
            println("running flow")
            emit(count++)
        }
    }
        //.stateIn(viewModelScope, SharingStarted.Lazily,0)
        //we can share the flow to be emitted by multiple observers
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),0)
    //we give 5 seconds to run for flows for cases such as rotating the screen or minimizing the app
}