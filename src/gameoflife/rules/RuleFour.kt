package gameoflife.rules

import gameoflife.Cell

class RuleFour : Rule {
    override val replacementState: Boolean = true

    override fun applies(cell: Cell): Boolean {
        return !cell.isAlive && cell.numberOfNeighbours == 3
    }

}
