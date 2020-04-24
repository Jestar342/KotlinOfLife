package gameoflife.grid

import gameoflife.Grid

fun Grid.toGolString(): String {
    val builder = StringBuilder()
    this.forEach { row ->
        builder.appendln(
            row.fold("") { rowAccum, col ->
                rowAccum + if (col) "#" else " "
            })
    }
    return builder.toString()
}