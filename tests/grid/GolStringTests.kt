package grid

import gameoflife.grid.toGolString
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.be
import io.kotest.matchers.should

class GolStringTests : FreeSpec({
    val ln: String = System.lineSeparator()

    "When interpreting grid as a GoL string" - {
        "Harlequin pattern" {
            arrayOf(
                arrayOf(true, false, true),
                arrayOf(false, true, false),
                arrayOf(true, false, true)
            ) golStringShouldBe
                    "# #$ln" +
                    " # $ln" +
                    "# #$ln"
        }
        "All alive" {
            arrayOf(
                arrayOf(true, true, true),
                arrayOf(true, true, true),
                arrayOf(true, true, true)
            ) golStringShouldBe
                    "###$ln" +
                    "###$ln" +
                    "###$ln"
        }
        "All dead" {
            arrayOf(
                arrayOf(false, false, false),
                arrayOf(false, false, false),
                arrayOf(false, false, false)
            ) golStringShouldBe
                    "   $ln" +
                    "   $ln" +
                    "   $ln"
        }
    }
})

private infix fun Array<Array<Boolean>>.golStringShouldBe(expected: String) = this.toGolString() should be(expected)