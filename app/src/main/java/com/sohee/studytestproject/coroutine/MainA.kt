package com.sohee.studytestproject.coroutine

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainA : AppCompatActivity() {
    val viewmodel: MainViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            viewmodel.testFlow.collect {
                when(it) {
                    TestEvent.test1 -> {}
                    TestEvent.test2 -> {}
                    TestEvent.test3 -> {}
                    TestEvent.test4 -> {}
                }
            }
        }
    }
}