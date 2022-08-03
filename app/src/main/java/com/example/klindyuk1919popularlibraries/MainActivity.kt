package com.example.klindyuk1919popularlibraries

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import com.example.klindyuk1919popularlibraries.databinding.ActivityMainBinding
import com.example.klindyuk1919popularlibraries.utils.COUNTER_FIRST
import com.example.klindyuk1919popularlibraries.utils.COUNTER_SECOND
import com.example.klindyuk1919popularlibraries.utils.COUNTER_THIRD

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CounterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        initPresenter()
        initBtn()
    }

    override fun renderData(counter: String, position: Int) {
        with(binding) {
            when (position) {
                COUNTER_FIRST -> tvText1.text = counter
                COUNTER_SECOND -> tvText2.text = counter
                COUNTER_THIRD -> tvText3.text = counter
            }
        }
    }

    private val btnListener = View.OnClickListener {
        when (it.id) {
            R.id.btnNumber1 -> presenter.onCounterClick(COUNTER_FIRST)
            R.id.btnNumber2 -> presenter.onCounterClick(COUNTER_SECOND)
            R.id.btnNumber3 -> presenter.onCounterClick(COUNTER_THIRD)
        }
    }

    private fun initBtn() {
        binding.root.forEach {
            if (it is Button) it.setOnClickListener(btnListener)
        }
    }

    private fun initPresenter() {
        presenter = CounterPresenter(this)
    }
}