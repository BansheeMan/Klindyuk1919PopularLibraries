package com.example.klindyuk1919popularlibraries

class CountersModel {

    private val counters = mutableListOf(0, 0, 0)

    fun getCurrent(position: Int): Int {
        return counters[position]
    }

    fun next(position: Int): Int {
        val newResult = counters[position]++
        return newResult
    }

    fun set(position: Int, value: Int) {
        counters[position] = value
    }
}