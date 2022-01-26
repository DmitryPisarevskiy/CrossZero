package com.example.crosszero.entities

import android.util.Log

class Game (val size: Int = 3, val rowToWin: Byte = 3, var field: Field = Field(size)) {
    init {
        if (size!=field.size) {
            field = Field(size)
            Log.d("debug", "size and field don't match")
        }
    }
}