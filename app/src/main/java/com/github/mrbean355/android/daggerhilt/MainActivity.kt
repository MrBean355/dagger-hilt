package com.github.mrbean355.android.daggerhilt

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        Log.i("MainActivity", viewModel.getData())
    }
}

class MainViewModel @Inject constructor(
        private val someRepository: SomeRepository
) : ViewModel() {

    fun getData(): String {
        return someRepository.loadData().joinToString()
    }
}
