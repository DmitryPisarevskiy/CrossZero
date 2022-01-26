package com.example.crosszero.entities

import com.example.crosszero.logic.Logic
import com.example.crosszero.logic.copy
import com.example.crosszero.logic.zero

class Mask(val size: Int) {

    var fieldTable = Array(size) {
            _ -> Array<Boolean>(size) { _ -> false }
    }

    constructor(field: Array<Array<Boolean>>): this(field.size) {
        fieldTable = field.copy()
    }

    constructor(field: Field, presenterFactor: Int): this(field.size) {
        for (i in 0..field.size-1) {
            for (j in 0..field.size-1) {
                if (field.cell(i,j)== zero && Logic.moveIsPresenting(field,Move(i,j,+1),presenterFactor)) {
                    fieldTable[j][i] = true
                }
            }
        }
    }

    fun cell(x:Int, y:Int) = fieldTable[y][x]

    fun setCell(x:Int, y:Int, value: Boolean) {
        fieldTable[y][x] = value
    }
}