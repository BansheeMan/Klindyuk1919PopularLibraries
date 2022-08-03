package com.example.klindyuk1919popularlibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.klindyuk1919popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CounterPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        initPresenter()
        btnListener()
    }

    private fun btnListener() {
        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber1)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber2)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber3)
            }
        }
    }

    private fun initPresenter() {
        presenter = CounterPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                0 -> tvText1.text = counter
                1 -> tvText2.text = counter
                2 -> tvText3.text = counter
            }
        }
    }
}