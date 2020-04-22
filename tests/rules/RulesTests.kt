package rules

import gameoflife.Cell
import gameoflife.rules.*
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.be
import io.kotest.matchers.should
import io.kotest.property.forAll
import io.kotest.property.Exhaustive
import io.kotest.property.PropertyContext
import io.kotest.property.exhaustive.ints

class RuleOneTests : FreeSpec({
    val theRule: Rule = RuleOne()

    "Any live cell with fewer than two live neighbours dies, as if by underpopulation." - {
        "Should not apply to dead cells" {
            forAllNeighbourCounts { n ->
                !theRule.applies(Cell.deadWith(n))
            }
        }
        "Should not apply to live cell with more than one live neighbour" {
            forNeighbourCounts(2..9) { n ->
                !theRule.applies(Cell.aliveWith(n))
            }
        }
        "Replacement state should be dead" {
            theRule.replacementState should be(false)
        }
    }
})

class RuleTwoTests : FreeSpec({
    val theRule: Rule = RuleTwo()

    "Any live cell with two or three live neighbours lives on to the next generation." - {
        "Should not apply to live cells with other than two or three neighbours" {
            forAllNeighbourCounts { n: Int ->
                (2..3).contains(n) || !theRule.applies(Cell.aliveWith(n))
            }
        }
        "Should not apply to dead cells" {
            forAllNeighbourCounts { n ->
                !theRule.applies(Cell.deadWith(n))
            }
        }
        "Should apply to live cell with 2 or 3 neighbours" {
            forNeighbourCounts(2..3) { n ->
                theRule.applies(Cell.aliveWith(n))
            }
        }
        "Replacement state should be alive" {
            theRule.replacementState should be(true)
        }
    }
})

class RuleThreeTests : FreeSpec({
    val theRule: Rule = RuleThree()

    "Any live cell with more than three live neighbours dies, as if by overpopulation." - {
        "Should not apply to dead cells" {
            forAllNeighbourCounts { n ->
                !theRule.applies(Cell.deadWith(n))
            }
        }
        "Should not apply to live cell with fewer than four neighbours" {
            forNeighbourCounts(1..3) { n ->
                !theRule.applies(Cell.aliveWith(n))
            }
        }
        "Should apply to live cell with more than three neighours" {
            forNeighbourCounts(4..9) { n ->
                theRule.applies(Cell.aliveWith(n))
            }
        }
        "Replacement should be dead" {
            theRule.replacementState should be(false)
        }
    }
})

class RuleFourTests : FreeSpec({
    val theRule: Rule = RuleFour()
    "Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction." - {
        "Should not apply to live cells" {
            forAllNeighbourCounts { n ->
                !theRule.applies(Cell.aliveWith(n))
            }
        }
        "Should not apply to a dead cell that does not have three neighbours" {
            forAllNeighbourCounts { n ->
                n == 3 || !theRule.applies(Cell.deadWith(n))
            }
        }
        "Should apply to a dead cell that has three neighbours" {
            theRule.applies(Cell.deadWith(3)) should be(true)
        }
        "Replacement state should be alive" {
            theRule.replacementState
        }
    }
})

private suspend fun forNeighbourCounts(range: IntRange, propertyContext: PropertyContext.(Int) -> Boolean) = forAll(Exhaustive.ints(range), propertyContext)
private suspend fun forAllNeighbourCounts(propertyContext: PropertyContext.(Int) -> Boolean) = forNeighbourCounts((1..9), propertyContext)
