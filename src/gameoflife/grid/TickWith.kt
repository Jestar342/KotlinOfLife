package gameoflife.grid

import gameoflife.Cell
import gameoflife.Grid
import gameoflife.rules.Rule

fun Grid.tickWith(vararg rules: Rule): Grid {
    val rowSize = this.size
    val columnSize = this.map { row -> row.size }.max() ?: 0

    val newGrid = Array(rowSize) { Array(columnSize) { false } }
    val oldGrid = this

    this.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { columnIndex, column ->
            val numberOfNeighbors = oldGrid.numberOfNeighboursAt(rowIndex, columnIndex)
            val rule = rules.find { rule -> rule.applies(
                Cell(
                    column,
                    numberOfNeighbors
                )
            ) }
            if (rule != null) {
                newGrid[rowIndex][columnIndex] = rule.replacementState
            }
        }
    }

    return newGrid
}