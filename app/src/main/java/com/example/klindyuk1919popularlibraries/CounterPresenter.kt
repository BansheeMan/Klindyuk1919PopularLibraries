package com.example.klindyuk1919popularlibraries

class CounterPresenter(
    private val view: MainView,
    private val model: CountersModel = CountersModel()
) {

    fun onCounterClick(key: Int) {
        val newValue = model.next(key).toString()
        view.renderData(newValue, key)
    }
}