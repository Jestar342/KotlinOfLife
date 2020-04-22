package gameoflife.rules

import gameoflife.Cell

class RuleThree : Rule {
    override val replacementState: Boolean = false

    override fun applies(cell: Cell): Boolean {
        return cell.isAlive && cell.numberOfNeighbours > 3
    }
}
