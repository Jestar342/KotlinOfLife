package gameoflife.rules

import gameoflife.Cell

interface Rule {
    val replacementState: Boolean
    fun applies(cell : Cell) : Boolean
}
