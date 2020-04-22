package grid

import gameoflife.grid.createGrid
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.be
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class CreateGridTests : FreeSpec({
    "Dimensions should be as expected" - {
        "Five by five" - {
            val grid = createGrid(5, 5)
            "Should have five rows" {
                grid.size should be(5)
            }
            "Should have five columns in each row" {
                grid eachRowColumnCountShouldBe 5
            }
        }
        "Ten by five" - {
            val grid = createGrid(10, 5)
            "Should have ten rows" {
                grid.size should be(10)
            }
            "Should have five columns in each row" {
                grid eachRowColumnCountShouldBe 5
            }
        }
    }
})

private infix fun <T> Array<Array<T>>.eachRowColumnCountShouldBe(size: Int): Unit {
    val filtered = this.withIndex().filter { row -> row.value.size != size }
    val rowNumbers = filtered.joinToString { row -> row.index.toString() }
    withClue("rows $rowNumbers do not have the expected column count") { filtered shouldBe emptyList() }
}