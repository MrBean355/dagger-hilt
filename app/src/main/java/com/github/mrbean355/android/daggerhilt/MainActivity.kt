package com.github.mrbean355.android.daggerhilt

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Alternative to 'by viewModels<MainViewModel>()':
        // val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        text_view.text = viewModel.getData()
    }
}

class MainViewModel @ViewModelInject constructor(
        private val someRepository: SomeRepository
) : ViewModel() {

    fun getData(): String {
        return someRepository.loadData().joinToString(separator = " ")
    }
}
