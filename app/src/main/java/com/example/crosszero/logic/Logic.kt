package com.example.crosszero.logic

import com.example.crosszero.entities.Field
import com.example.crosszero.entities.Mask
import com.example.crosszero.entities.Move

const val zero: Byte = 0

class Logic {
    companion object {

        fun moveIsWinning(field: Field, move: Move, rowToWin: Int): Boolean {
            var i: Int = 0
            var count: Int = 1

            // проверка по вертикали
            while (move.yCoord + i + 1 <= field.size - 1 && field.cell(
                    move.xCoord,
                    move.yCoord + i + 1
                ) == move.sign
            ) {
                i++
                count++
            }
            if (count >= rowToWin) {
                return true
            }
            i = 0
            while (move.yCoord - i - 1 >= 0 && field.cell(
                    move.xCoord,
                    move.yCoord - i - 1
                ) == move.sign
            ) {
                i++
                count++
            }
            if (count >= rowToWin) {
                return true
            }

            // проверка по горизонтали
            i = 0
            count = 1
            while (move.xCoord + i + 1 <= field.size - 1 && field.cell(
                    move.xCoord + i + 1,
                    move.yCoord
                ) == move.sign
            ) {
                i++
                count++
            }
            if (count >= rowToWin) {
                return true
            }
            i = 0
            while (move.xCoord - i - 1 >= 0 && field.cell(
                    move.xCoord - i - 1,
                    move.yCoord
                ) == move.sign
            ) {
                i++
                count++
            }
            if (count >= rowToWin) {
                return true
            }

            // проверка по диагонали1
            i = 0
            count = 1
            while (move.xCoord + i + 1 <= field.size - 1 && move.yCoord + i + 1 <= field.size - 1 && field.cell(
                    move.xCoord + i + 1,
                    move.yCoord + i + 1
                ) == move.sign
            ) {
                i++
                count++
            }
            if (count >= rowToWin) {
                return true
            }
            i = 0
            while (move.xCoord - i - 1 >= 0 && move.yCoord - i - 1 >= 0 && field.cell(
                    move.xCoord - i - 1,
                    move.yCoord - i - 1
                ) == move.sign
            ) {
                i++
                count++
            }
            if (count >= rowToWin) {
                return true
            }

            // проверка по диагонали2
            i = 0
            count = 1
            while (move.xCoord + i + 1 <= field.size - 1 && move.yCoord - i - 1 >= 0 && field.cell(
                    move.xCoord + i + 1,
                    move.yCoord - i - 1
                ) == move.sign
            ) {
                i++
                count++
            }
            if (count >= rowToWin) {
                return true
            }
            i = 0
            while (move.xCoord - i - 1 >= 0 && move.yCoord + i + 1 <= field.size - 1 && field.cell(
                    move.xCoord - i - 1,
                    move.yCoord + i + 1
                ) == move.sign
            ) {
                i++
                count++
            }
            if (count >= rowToWin) {
                return true
            }

            return false
        }

        fun bestMove(field: Field, sign: Byte, rowToWin: Int, depth: Int, presenterFactor: Int = 1, mask_: Mask = Mask(0)): Move {
            var mask = Mask(mask_.fieldTable)
            var bestMove = Move(-1, -1, sign, -sign)
            if (mask.size == 0) {
                mask = Mask(field, presenterFactor)
            }
            if (depth == 1) {
                for (i in 0..field.size - 1) {
                    for (j in 0..field.size - 1) {
                        if (field.cell(i, j).toInt() == 0
                            && mask.cell(i,j)
                            && moveIsWinning(field, Move(i, j, sign), rowToWin)
                        ) {
                            return Move(i, j, sign, sign.toInt())
                        } else bestMove = Move(i,j,sign, 0)
                    }
                }
            } else {
                var move = Move(-1, -1, sign)
                for (i in 0..field.size - 1) {
                    for (j in 0..field.size - 1) {
                        if (field.cell(i, j).toInt() == 0 && mask.cell(i,j)) {
                            if (moveIsWinning(field, Move(i, j, sign), rowToWin)) {
                                return Move(i, j, sign, sign.toInt())
                            } else {
                                field.setCell(i, j, sign)
                                move = bestMove(field, (-sign).toByte(), rowToWin, depth - 1)
                                if (move.estimation == (-sign) && bestMove.xCoord == -1) {
                                    bestMove = Move(i, j, sign, -sign)
                                }
                                if (move.estimation == 0 && bestMove.estimation == -sign) {
                                    bestMove = Move(i, j, sign, 0)
                                }
                                if (move.estimation == sign.toInt()) {
                                    field.setCell(i, j, 0)
                                    return Move(i, j, sign, sign.toInt())
                                }
                                field.setCell(i, j, 0)
                            }
                        }
                    }
                }
            }
            return bestMove
        }

        fun moveIsPresenting(field: Field, move: Move, presenterFactor: Int): Boolean {
            if ((move.xCoord - 1 >= 0 && field.cell(move.xCoord - 1, move.yCoord) != zero)
                || (move.xCoord + 1 <= field.size - 1 && field.cell(move.xCoord + 1,move.yCoord) != zero)
                || (move.yCoord - 1 >= 0 && field.cell(move.xCoord ,move.yCoord - 1) != zero)
                || (move.yCoord + 1 <= field.size - 1 && field.cell(move.xCoord,move.yCoord + 1) != zero)
                || (move.xCoord + 1 <= field.size - 1 && move.yCoord + 1 <= field.size - 1 && field.cell(move.xCoord + 1,move.yCoord + 1) != zero)
                || (move.xCoord + 1 <= field.size - 1 && move.yCoord - 1 >=0 && field.cell(move.xCoord + 1,move.yCoord - 1) != zero)
                || (move.xCoord - 1 >=0 && move.yCoord + 1 <= field.size - 1 && field.cell(move.xCoord - 1,move.yCoord + 1) != zero)
                || (move.xCoord - 1 >=0 && move.yCoord - 1 >= 0 && field.cell(move.xCoord - 1,move.yCoord - 1) != zero)
            ) {
               return true
            }
            if (presenterFactor == 2) {
                if ((move.xCoord - 2 >= 0 && field.cell(move.xCoord - 2, move.yCoord) != zero)
                    || (move.xCoord + 2 <= field.size - 1 && field.cell(move.xCoord + 2,move.yCoord) != zero)
                    || (move.yCoord - 2 >= 0 && field.cell(move.xCoord ,move.yCoord - 2) != zero)
                    || (move.yCoord + 2 <= field.size - 1 && field.cell(move.xCoord,move.yCoord + 2) != zero)
                    || (move.xCoord + 2 <= field.size - 1 && move.yCoord + 2 <= field.size - 1 && field.cell(move.xCoord + 2,move.yCoord + 2) != zero)
                    || (move.xCoord + 2 <= field.size - 1 && move.yCoord - 2 >=0 && field.cell(move.xCoord + 2,move.yCoord - 2) != zero)
                    || (move.xCoord - 2 >=0 && move.yCoord + 2 <= field.size - 1 && field.cell(move.xCoord - 2,move.yCoord + 2) != zero)
                    || (move.xCoord - 2 >=0 && move.yCoord - 2 >= 0 && field.cell(move.xCoord - 2,move.yCoord - 2) != zero)
                    || (move.xCoord + 2 <= field.size - 1 && move.yCoord - 1 >= 0 && field.cell(move.xCoord + 2,move.yCoord - 1) != zero)
                    || (move.xCoord + 2 <= field.size - 1 && move.yCoord + 1 <= field.size - 1 && field.cell(move.xCoord + 2,move.yCoord + 1) != zero)
                    || (move.xCoord + 1 <= field.size - 1 && move.yCoord + 2 <= field.size - 1 && field.cell(move.xCoord + 1,move.yCoord + 2) != zero)
                    || (move.xCoord - 1 >=0 && move.yCoord + 2 <= field.size - 1 && field.cell(move.xCoord - 1,move.yCoord + 2) != zero)
                    || (move.xCoord - 2 >=0 && move.yCoord + 1 <= field.size - 1 && field.cell(move.xCoord - 2,move.yCoord + 1) != zero)
                    || (move.xCoord - 2 >=0 && move.yCoord - 1 >= 0 && field.cell(move.xCoord - 2,move.yCoord - 1) != zero)
                    || (move.xCoord - 1 >=0 && move.yCoord - 2 >= 0 && field.cell(move.xCoord - 1,move.yCoord - 2) != zero)
                    || (move.xCoord + 1 <= field.size - 1 && move.yCoord - 2 >= 0 && field.cell(move.xCoord + 1,move.yCoord - 2) != zero)
                ) {
                    return true
                }
            }
            return false
        }
    }
}