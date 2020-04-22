package gameoflife.rules

import gameoflife.Cell

class RuleTwo : Rule {
    override val replacementState: Boolean = true

    override fun applies(cell: Cell): Boolean {
        return cell.isAlive && cell.numberOfNeighbours > 1 && cell.numberOfNeighbours < 4
    }
}
