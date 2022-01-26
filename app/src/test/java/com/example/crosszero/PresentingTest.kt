package com.example.crosszero

import com.example.crosszero.entities.Field
import com.example.crosszero.entities.Mask
import com.example.crosszero.entities.Move
import com.example.crosszero.logic.Logic
import org.junit.Test

import org.junit.Assert.*

class PresentingTest {
    val cros:Byte = 1
    val zero: Byte = -1
    val empt: Byte = 0
    val field = arrayOf(
        arrayOf(empt, empt, empt, empt, empt, empt, empt),
        arrayOf(empt, empt, empt, empt, empt, empt, empt),
        arrayOf(empt, empt, empt, empt, empt, empt, empt),
        arrayOf(empt, empt, empt, cros, empt, empt, empt),
        arrayOf(empt, empt, empt, empt, empt, empt, empt),
        arrayOf(empt, empt, empt, empt, empt, empt, empt),
        arrayOf(empt, empt, empt, empt, empt, empt, empt),
    )

    @Test
    fun move_is_presenting1() {
        for (i in 1..5) {
            for (j in 1..5) {
                if (i!=3 && j!=3) {
                    assertTrue(Logic.moveIsPresenting(Field(field),Move(i,j,1),2))
                }
            }
        }
    }

    @Test
    fun move_is_presenting2() {
        for (i in 2..4) {
            for (j in 2..4) {
                if (i!=3 && j!=3) {
                    assertTrue(Logic.moveIsPresenting(Field(field),Move(i,j,1),1))
                }
            }
        }
    }

    @Test
    fun mask_is_correct1() {
        val mask: Mask = Mask(Field(field),1)
        for (i in 2..4) {
            for (j in 2..4) {
                if (i!=3 && j!=3) {
                    assertTrue(mask.cell(i,j))
                }
            }
        }
    }

    @Test
    fun mask_is_correct2() {
        val mask: Mask = Mask(Field(field),2)
        for (i in 1..5) {
            for (j in 1..5) {
                if (i!=3 && j!=3) {
                    assertTrue(mask.cell(i,j))
                }
            }
        }
    }
}