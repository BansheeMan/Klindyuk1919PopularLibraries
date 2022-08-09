package com.example.klindyuk1919popularlibraries

import moxy.MvpPresenter

class CounterPresenter(
    private val model: CountersModel
) : MvpPresenter<MainView>() {

    fun onCounterOneClick() {
        val newValue = model.next(0)
        viewState.setCounterOneText(newValue.toString())
    }

    fun onCounterTwoClick() {
        val newValue = model.next(1)
        viewState.setCounterTwoText(newValue.toString())
    }

    fun onCounterThreeClick() {
        val newValue = model.next(2)
        viewState.setCounterThreeText(newValue.toString())
    }
}