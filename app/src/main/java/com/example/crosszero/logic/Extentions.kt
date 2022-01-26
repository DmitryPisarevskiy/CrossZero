package com.example.crosszero.logic

fun Array<Array<Boolean>>.copy() = map { it.clone() }.toTypedArray()
