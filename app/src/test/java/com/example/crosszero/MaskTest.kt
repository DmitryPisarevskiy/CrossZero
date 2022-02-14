package com.example.crosszero

import com.example.crosszero.entities.Field
import com.example.crosszero.entities.Mask
import com.example.crosszero.logic.Logic
import com.example.crosszero.logic.changeFirstCell
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test

class MaskTest {
    val cros: Byte = 1
    val zero: Byte = -1
    val empt: Byte = 0


    @Test
    fun best_move_is_correct1() {
        val field = arrayOf(
            arrayOf(empt, empt, empt),
            arrayOf(empt, cros, cros),
            arrayOf(empt, empt, empt),
        )
        val move = Logic.bestMove(Field(field), cros, 3, 1)
        Assert.assertEquals(move.xCoord, 0)
        Assert.assertEquals(move.yCoord, 1)
    }

    @Test
    fun best_move_is_correct2() {
        val field = arrayOf(
            arrayOf(empt, empt, cros, empt, empt),
            arrayOf(empt, empt, cros, empt, empt),
            arrayOf(empt, empt, cros, empt, empt),
            arrayOf(empt, empt, empt, empt, empt),
            arrayOf(empt, empt, cros, empt, empt),
        )
        val move = Logic.bestMove(Field(field), cros, 5, 1)
        Assert.assertEquals(move.xCoord, 2)
        Assert.assertEquals(move.yCoord, 3)
    }

    @Test
    fun best_move_is_correct3() {
        val field = arrayOf(
            arrayOf(empt, empt, empt, zero, empt),
            arrayOf(empt, empt, empt, zero, empt),
            arrayOf(empt, empt, empt, zero, empt),
            arrayOf(empt, empt, empt, zero, empt),
            arrayOf(empt, empt, empt, empt, empt),
        )
        val move = Logic.bestMove(Field(field), cros, 5, 2)
        Assert.assertEquals(move.xCoord, 3)
        Assert.assertEquals(move.yCoord, 4)
    }

    @Test
    fun best_move_is_correct4() {
        val field = arrayOf(
            arrayOf(empt, empt, empt, zero, empt, empt),
            arrayOf(empt, cros, empt, zero, empt, empt),
            arrayOf(empt, empt, cros, zero, empt, empt),
            arrayOf(empt, empt, empt, cros, empt, empt),
            arrayOf(empt, empt, empt, zero, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt),
        )
        val move = Logic.bestMove(Field(field), cros, 5, 3)
        Assert.assertEquals(move.xCoord, 4)
        Assert.assertEquals(move.yCoord, 4)
    }
}