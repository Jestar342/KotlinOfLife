package ruleset

import gameoflife.grid.tickWith
import gameoflife.grid.toGolString
import gameoflife.rules.*
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.be
import io.kotest.matchers.should

class StandardRulesetTests : FreeSpec({
    val standardRules = arrayOf(RuleOne(), RuleTwo(), RuleThree(), RuleFour())
    val ln = System.lineSeparator()

    "Vertical line of three live cells" - {
        val theGrid = arrayOf(
            arrayOf(false, true, false),
            arrayOf(false, true, false),
            arrayOf(false, true, false)
        )

        "Should tick over to a horizontal line" {
            theGrid.tickWith(*standardRules).toGolString() should be(
                "   $ln" +
                        "###$ln" +
                        "   $ln"
            )
        }
    }

    "Cell with no neighbours" - {
        val theGrid = arrayOf(
            arrayOf(false, false, false),
            arrayOf(false, true, false),
            arrayOf(false, false, false)
        )
        "Should die" {
            theGrid.tickWith(*standardRules).toGolString() should be(
                "   $ln" +
                        "   $ln" +
                        "   $ln"
            )
        }
    }

    "A Cross" - {
        val theGrid = arrayOf(
            arrayOf(false, true, false),
            arrayOf(true, true, true),
            arrayOf(false, true, false)
        )

        "Should become a doughnut" {
            theGrid.tickWith(*standardRules).toGolString() should be(
                "###$ln" +
                        "# #$ln" +
                        "###$ln"
            )
        }
    }

    "A Block" - {
        val theGrid = arrayOf(
            arrayOf(false, false, false, false),
            arrayOf(false, true, true, false),
            arrayOf(false, true, true, false),
            arrayOf(false, false, false, false)
        )

        "Should remain a block" {
            theGrid.tickWith(*standardRules).toGolString() should be(
                "    $ln" +
                        " ## $ln" +
                        " ## $ln" +
                        "    $ln"
            )
        }
    }
})

