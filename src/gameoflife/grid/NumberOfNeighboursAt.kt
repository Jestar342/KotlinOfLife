package gameoflife.grid

import gameoflife.Grid
import kotlin.math.max
import kotlin.math.min

fun Grid.numberOfNeighboursAt(row: Int, column: Int): Int {
    val minimumRow = max(0, row - 1)
    val maximumRow = min(this.size - 1, row + 1)

    val minimumColumn = max(0, column - 1)
    val maximumColumn = min(this[row].size - 1, column + 1)

    var count = 0
    for (rowIndex in minimumRow..maximumRow)
        for (columnIndex in minimumColumn..maximumColumn)
            if (
                (rowIndex != row || columnIndex != column)
                && this[rowIndex][columnIndex]
            )
                count++
    return count
}