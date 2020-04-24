package gameoflife.runner

import gameoflife.grid.createGrid
import gameoflife.grid.tickWith
import gameoflife.grid.toGolString
import gameoflife.rules.RuleFour
import gameoflife.rules.RuleOne
import gameoflife.rules.RuleThree
import gameoflife.rules.RuleTwo

fun main(args: Array<String>) {
    var theGrid = createGrid(20, 100)

    println("About to begin; the game will continue until you SIGINT!")

    Thread.sleep(3000)

    while (true) {
        theGrid = theGrid.tickWith(RuleOne(), RuleTwo(), RuleThree(), RuleFour())
        println(theGrid.toGolString())
        println("----------------------------------------------------------------------------------------------------")
        Thread.sleep(100)
    }
}