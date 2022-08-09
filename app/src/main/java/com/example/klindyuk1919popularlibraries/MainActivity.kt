package com.example.klindyuk1919popularlibraries

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.forEach
import com.example.klindyuk1919popularlibraries.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { CounterPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        initBtn()
    }

    override fun setCounterOneText(counter: String) = with(binding) {
        tvText1.text = counter
    }

    override fun setCounterTwoText(counter: String) = with(binding) {
        tvText2.text = counter
    }

    override fun setCounterThreeText(counter: String) = with(binding) {
        tvText3.text = counter
    }

    private val btnListener = View.OnClickListener {
        when (it.id) {
            R.id.btnNumber1 -> presenter.onCounterOneClick()
            R.id.btnNumber2 -> presenter.onCounterTwoClick()
            R.id.btnNumber3 -> presenter.onCounterThreeClick()
        }
    }

    private fun initBtn() {
        binding.root.forEach {
            if (it is Button) it.setOnClickListener(btnListener)
        }
    }

    /*private fun initPresenter() {
        presenter = CounterPresenter(CountersModel())
    }*/
}