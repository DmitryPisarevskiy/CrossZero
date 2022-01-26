package com.example.crosszero.entities

class Field(val size: Int = 3) {
    var fieldTable = Array(size) {
            _ -> Array<Byte>(size) { _ -> 0 }
    }

    constructor(field: Array<Array<Byte>>): this(field.size) {
        fieldTable = field
    }

    fun cell(x:Int, y:Int) = fieldTable[y][x]

    fun setCell(x:Int, y:Int, value: Byte) {
        fieldTable[y][x] = value
    }
}