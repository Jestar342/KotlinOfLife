package grid

import gameoflife.grid.numberOfNeighboursAt
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.be
import io.kotest.matchers.should

class NumberOfNeighboursTests : FreeSpec({
    "When getting the number of live neighbours for a given cell in the following grid" - {
        val theGrid = arrayOf(
            arrayOf(true, false, true),
            arrayOf(false, true, false),
            arrayOf(true, false, true)
        )

        "Cell 0,0 should have one live neighbour" {
            theGrid.numberOfNeighboursAt(0, 0) should be(1)
        }

        "Cell 0,1 should have three live neighbours" {
            theGrid.numberOfNeighboursAt(0, 1) should be(3)
        }

        "Cell 1,1 should have four live neighbours" {
            theGrid.numberOfNeighboursAt(1, 1) should be(4)
        }

        "Cell 1,0 should have three live neighbours" {
            theGrid.numberOfNeighboursAt(1, 0) should be(3)
        }
    }
})
