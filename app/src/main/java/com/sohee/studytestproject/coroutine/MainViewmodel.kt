package com.sohee.studytestproject.coroutine

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewmodel : ViewModel() {

    val _testFlow: MutableStateFlow<TestEvent> = MutableStateFlow(TestEvent.test1)
//    val _testFlow = MutableStateFlow<TestEvent>(TestEvent.test1)   -> 가능
//    val _testFlow = MutableStateFlow(TestEvent.test1)  -> 타입이 TestEvent.test1로 설정됨
    val testFlow: StateFlow<TestEvent> = _testFlow

    val scope = CoroutineScope(Dispatchers.Main)

    init {
        something(TestEvent.test3)
    }

    fun test() {
        scope.launch {
            // 포그라운드 작업
        }

        scope.launch(Dispatchers.Default) {
            // CoroutineContext 를 변경하여 백그라운드로 전환하여 작업을 처리합니다
        }
    }

    fun something(value: TestEvent) {
        _testFlow.value = value
    }
}

sealed class TestEvent {
    object test1 : TestEvent()
    object test2 : TestEvent()
    object test3 : TestEvent()
    object test4 : TestEvent()
}