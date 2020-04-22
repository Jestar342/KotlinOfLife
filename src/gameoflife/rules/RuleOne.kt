package gameoflife.rules

import gameoflife.Cell

class RuleOne : Rule {
    override val replacementState: Boolean = false

    override fun applies(cell: Cell): Boolean {
        return cell.isAlive && cell.numberOfNeighbours < 2
    }
}