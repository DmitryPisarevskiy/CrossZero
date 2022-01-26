package com.example.crosszero

import com.example.crosszero.entities.Field
import com.example.crosszero.logic.Logic
import org.junit.Test
import org.junit.Assert.*

class BestMoveTest {
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
        assertEquals(move.xCoord, 0)
        assertEquals(move.yCoord, 1)
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
        assertEquals(move.xCoord, 2)
        assertEquals(move.yCoord, 3)
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
        assertEquals(move.xCoord, 3)
        assertEquals(move.yCoord, 4)
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
        assertEquals(move.xCoord, 4)
        assertEquals(move.yCoord, 4)
    }

    @Test
    fun best_move_is_correct5() {
        val field = arrayOf(
            arrayOf(empt, empt, empt, empt, empt, empt),
            arrayOf(empt, cros, empt, empt, cros, empt),
            arrayOf(empt, empt, cros, empt, cros, empt),
            arrayOf(empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, zero, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt),
        )
        val move = Logic.bestMove(Field(field), cros, 5, 5)
        assertEquals(move.xCoord, 4)
        assertEquals(move.yCoord, 4)
    }

    @Test
    fun best_move_is_correct6() {
        val field = arrayOf(
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, zero, zero, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, cros, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, zero, empt, cros, cros, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, zero, cros, empt, cros, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, cros, cros, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, zero, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
        )
        val move = Logic.bestMove(Field(field), cros, 5, 5)
        assertEquals(move.xCoord, 8)
        assertEquals(move.yCoord, 7)
    }

    @Test
    fun best_move_is_correct7() {
        val field = arrayOf(
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, cros, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, cros, empt, cros, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, cros, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
            arrayOf(empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt, empt),
        )
        val move = Logic.bestMove(Field(field), cros, 5, 5)
        assertEquals(move.xCoord, 6)
        assertEquals(move.yCoord, 6)
    }
}