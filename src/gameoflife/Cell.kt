package gameoflife

data class Cell(val isAlive: Boolean, val numberOfNeighbours: Int) {
    companion object {
        fun aliveWith(numberOfNeighbours: Int) : Cell = Cell(true, numberOfNeighbours)
        fun deadWith(numberOfNeighbours: Int) : Cell = Cell(false, numberOfNeighbours)
    }
}
