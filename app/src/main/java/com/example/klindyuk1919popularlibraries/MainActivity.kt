package com.example.klindyuk1919popularlibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.klindyuk1919popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CounterPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        initPresenter()
    }

    private fun initPresenter() {
        presenter = CounterPresenter()
    }
}