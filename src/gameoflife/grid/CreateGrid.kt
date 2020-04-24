package gameoflife.grid

import gameoflife.Grid

fun createGrid(rows: Int, columns: Int): Grid {
    return Array(rows) { _ -> Array(columns) { _ -> Math.random() > 0.5 } }
}

