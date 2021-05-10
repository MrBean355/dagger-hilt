package com.github.mrbean355.android.daggerhilt

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Alternative to 'by viewModels<MainViewModel>()':
        // val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        findViewById<TextView>(R.id.text_view).text = viewModel.getData()
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val someRepository: SomeRepository
) : ViewModel() {

    fun getData(): String {
        return someRepository.loadData().joinToString(separator = " ")
    }
}
