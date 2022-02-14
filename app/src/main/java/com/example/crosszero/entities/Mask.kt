package com.example.crosszero.entities

import com.example.crosszero.logic.Logic
import com.example.crosszero.logic.copy
import com.example.crosszero.logic.zero

class Mask(val size: Int, val presenterFactor: Int = 1) {
    var lastMoveCell: Cell? = null
    var addedCells: MutableList<Cell> = mutableListOf()
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

    fun makeMove(x: Int, y: Int): List<Cell> {
        val list: MutableList<Cell> = mutableListOf()
        if (x - 1 >= 0 && !fieldTable[y][x-1]) {
            fieldTable[y][x-1] = true
            list.add(Cell(x-1,y))
        }
        if (x + 1 <=fieldTable.size-1 && !fieldTable[y][x+1]) {
            fieldTable[y][x+1] = true
            list.add(Cell(x+1,y))
        }
        if (y - 1 >= 0 && !fieldTable[y-1][x]) {
            fieldTable[y-1][x] = true
            list.add(Cell(x,y-1))
        }
        if (y + 1 <=fieldTable.size-1 && !fieldTable[y+1][x]) {
            fieldTable[y+1][x] = true
            list.add(Cell(x,y+1))
        }
        if (y + 1 <=fieldTable.size-1 && x + 1 <=fieldTable.size-1 && !fieldTable[y+1][x+1]) {
            fieldTable[y+1][x+1] = true
            list.add(Cell(x+1,y+1))
        }
        if (y - 1 <=fieldTable.size-1 && x + 1 <=fieldTable.size-1 && !fieldTable[y-1][x+1]) {
            fieldTable[y-1][x+1] = true
            list.add(Cell(x+1,y-1))
        }
        if (y - 1 <=fieldTable.size-1 && x - 1 <=fieldTable.size-1 && !fieldTable[y-1][x-1]) {
            fieldTable[y-1][x-1] = true
            list.add(Cell(x-1,y-1))
        }
        if (y + 1 <=fieldTable.size-1 && x - 1 <=fieldTable.size-1 && !fieldTable[y+1][x-1]) {
            fieldTable[y+1][x-1] = true
            list.add(Cell(x-1,y+1))
        }
//        if (presenterFactor == 2) {
//            if ((xCoord - 2 >= 0 && field.cell(xCoord - 2, yCoord) != zero)
//                || (xCoord + 2 <= field.size - 1 && field.cell(xCoord + 2,yCoord) != zero)
//                || (yCoord - 2 >= 0 && field.cell(xCoord ,yCoord - 2) != zero)
//                || (yCoord + 2 <= field.size - 1 && field.cell(xCoord,yCoord + 2) != zero)
//                || (xCoord + 2 <= size - 1 && yCoord + 2 <= field.size - 1 && field.cell(xCoord + 2,yCoord + 2) != zero)
//                || (xCoord + 2 <= field.size - 1 && move.yCoord - 2 >=0 && field.cell(move.xCoord + 2,move.yCoord - 2) != zero)
//                || (xCoord - 2 >=0 && yCoord + 2 <= field.size - 1 && field.cell(xCoord - 2,yCoord + 2) != zero)
//                || (xCoord - 2 >=0 && yCoord - 2 >= 0 && field.cell(xCoord - 2,yCoord - 2) != zero)
//                || (xCoord + 2 <= field.size - 1 && yCoord - 1 >= 0 && field.cell(xCoord + 2,yCoord - 1) != zero)
//                || (xCoord + 2 <= field.size - 1 && yCoord + 1 <= field.size - 1 && field.cell(xCoord + 2,yCoord + 1) != zero)
//                || (xCoord + 1 <= field.size - 1 && yCoord + 2 <= field.size - 1 && field.cell(xCoord + 1,yCoord + 2) != zero)
//                || (xCoord - 1 >=0 && yCoord + 2 <= field.size - 1 && field.cell(xCoord - 1,yCoord + 2) != zero)
//                || (xCoord - 2 >=0 && yCoord + 1 <= field.size - 1 && field.cell(xCoord - 2,yCoord + 1) != zero)
//                || (xCoord - 2 >=0 && yCoord - 1 >= 0 && field.cell(xCoord - 2,yCoord - 1) != zero)
//                || (xCoord - 1 >=0 && yCoord - 2 >= 0 && field.cell(xCoord - 1,yCoord - 2) != zero)
//                || (xCoord + 1 <= field.size - 1 && yCoord - 2 >= 0 && field.cell(xCoord + 1,yCoord - 2) != zero)
        addedCells = list
        lastMoveCell = Cell(x,y)
        return list
    }

    fun cell(x:Int, y:Int) = fieldTable[y][x]

    fun setCell(x:Int, y:Int, value: Boolean) {
        fieldTable[y][x] = value
    }

    fun reFormatMask(field: Field, presenterFactor: Int) {
        fieldTable = Array(field.size) {
                _ -> Array<Boolean>(field.size) { _ -> false }
        }
        for (i in 0..field.size-1) {
            for (j in 0..field.size-1) {
                if (field.cell(i,j)== zero && Logic.moveIsPresenting(field,Move(i,j,+1),presenterFactor)) {
                    fieldTable[j][i] = true
                }
            }
        }
    }
}