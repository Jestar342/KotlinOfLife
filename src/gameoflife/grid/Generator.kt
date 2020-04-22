package gameoflife.grid

fun createGrid(rows: Int, columns: Int): Array<Array<Boolean>> {
    return Array(rows) { _ -> Array(columns) { _ -> Math.random() > 0.5 } }
}

fun Array<Array<Boolean>>.toGolString(): String {
    val builder = StringBuilder()
    this.forEach { row ->
        builder.appendln(
            row.fold("") { rowAccum, col ->
                rowAccum + if (col) "#" else " "
            })
    }
    return builder.toString()
}