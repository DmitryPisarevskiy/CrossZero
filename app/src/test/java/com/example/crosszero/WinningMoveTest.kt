package com.example.crosszero

import com.example.crosszero.entities.Field
import com.example.crosszero.entities.Move
import com.example.crosszero.logic.Logic
import org.junit.Test

import org.junit.Assert.*


class WinningMoveTest {
    val cros:Byte = 1
    val zero: Byte = -1
    val empt: Byte = 0

    @Test
    fun field_init_is_correct() {
        val field = Field(3)
        assertEquals(field.fieldTable[1][1].toInt(),0)
    }

    @Test
    fun winning_move_is_correct_1() {
        val field = arrayOf(
            arrayOf(empt, cros, empt),
            arrayOf(empt, cros, empt),
            arrayOf(empt, empt, empt),
        )
        assertTrue(Logic.moveIsWinning(Field(field), Move(1,2,cros),3))
    }

    @Test
    fun winning_move_is_correct_2() {
        val field = arrayOf(
            arrayOf(empt, empt, empt),
            arrayOf(cros, cros, empt),
            arrayOf(empt, empt, empt),
        )
        assertTrue(Logic.moveIsWinning(Field(field), Move(2,1,cros),3))
    }

    @Test
    fun winning_move_is_correct_3() {
        val field = arrayOf(
            arrayOf(cros, empt, empt),
            arrayOf(empt, cros, empt),
            arrayOf(empt, empt, empt),
        )
        assertTrue(Logic.moveIsWinning(Field(field), Move(2,2,cros),3))
    }

    @Test
    fun winning_move_is_correct_4() {
        val field = arrayOf(
            arrayOf(empt, empt, cros),
            arrayOf(empt, cros, empt),
            arrayOf(empt, empt, empt),
        )
        assertTrue(Logic.moveIsWinning(Field(field), Move(0,2,cros),3))
    }

    @Test
    fun winning_move_is_correct_5() {
        val field = arrayOf(
            arrayOf(empt, empt, cros),
            arrayOf(empt, empt, empt),
            arrayOf(cros, empt, empt),
        )
        assertTrue(Logic.moveIsWinning(Field(field), Move(1,1,cros),3))
    }
}