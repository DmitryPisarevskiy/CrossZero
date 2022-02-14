package com.example.crosszero.logic

import com.example.crosszero.entities.Mask

fun Array<Array<Boolean>>.copy() = map { it.clone() }.toTypedArray()

fun changeFirstCell(mask: Mask) {
    mask.setCell(1,1, true)
}