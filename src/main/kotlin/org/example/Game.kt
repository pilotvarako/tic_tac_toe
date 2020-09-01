package org.example

class Game(private var board: AreaGame) {
    private var playerFirst: Player
    private var playerSecond: Player

    init{
        val rand = (1..10).random()
        if(rand <= 5) {
            playerFirst = Player('X')
            playerSecond = Player('O')
        }
        else {
            playerFirst = Player('O')
            playerSecond = Player('X')
        }
    }

    private fun currentStep(playerStep: Char) {
        println("Сейчас ход [" + playerStep + "]")
    }

    private fun choiceMove(): Int {
        print("Выберите клетку [1;9]: ")
        val result = readLine()!!.toInt()
        return result
    }

    private fun motionPlayer(point: Int, playerStep: Char) {
        var count = 1;
        for (i in 0 until board.zoneGameGet().size) {
            for(j in 0 until board.zoneGameGet()[i].size) {
                if(point == count) {
                    board.zoneGameSet(i, j, playerStep)
                    return
                }
                count++
            }
        }
    }

    private fun checkCombinationsGame(key: Char): Boolean {
        if(checkCombinationHorizontal(board.zoneGameGet(), key)) {
            return true
        }

        var bufferArea = sortAreaVertical()

        for(combination in 0..1) {
            if (checkCombinationVerticalAndDiagonal(bufferArea, key)) {
                return true
            }
            bufferArea = sortAreaDiagonal(bufferArea)
        }

        return false
    }

    private fun checkCombinationHorizontal(pieceArea: Array<Array<Char>>, key: Char): Boolean {
        for(i in 0 until pieceArea.size) {
            if(pieceArea[i].all({ it == key })) {
                return true
            }
        }
        return false
    }

    private fun checkCombinationVerticalAndDiagonal(pieceArea: List<List<Char>>, key: Char): Boolean {
        for(i in 0 until pieceArea.size) {
            if(pieceArea[i].all({it == key })) {
                return true;
            }
        }
        return false;
    }

    private fun sortAreaVertical(): List<List<Char>> {
        var bufferArea = board.zoneGameGet()
        var sortPieceArea = ArrayList<Char> ()
        for(column in 0 until bufferArea.size) {
            for(row in 0 until bufferArea.size) {
                sortPieceArea.add(bufferArea[row][column])
            }
        }
        return sortPieceArea.chunked(3)
    }

    private fun sortAreaDiagonal(pieceArea: List<List<Char>>): List<List<Char>> {
        var pieceAreaBuffer = pieceArea
        var sortPieceArea = ArrayList<Char>()
        for(count in 0 until 2) {
            for (i in 0 until pieceAreaBuffer.size) {
                for (j in 0 until pieceAreaBuffer[i].size) {
                    if (i == j) {
                        sortPieceArea.add(pieceAreaBuffer[i][j])
                    }
                }
            }
            pieceAreaBuffer = pieceArea.reversed()
        }
        return sortPieceArea.chunked(3)
    }

    private fun victoryGame(winPlayer: Player) {
        println("Игра окончена! Победили [" + winPlayer.stepGet() + "]")
    }

    private fun endGame() {
        println("Игра окончена! Ничья!")
    }

    fun startGame() {
        board.printAreaGame()

        var progress: Int
        var currentPlayer: Player

        for(counterGame in 1..9) {
            progress = counterGame % 2
            if(progress != 0) {
                currentPlayer = playerFirst
            }
            else {
                currentPlayer = playerSecond
            }
            currentStep(currentPlayer.stepGet())
            var point = choiceMove()
            motionPlayer(point, currentPlayer.stepGet())
            board.printAreaGame()
            if(checkCombinationsGame(currentPlayer.stepGet())) {
                victoryGame(currentPlayer)
                return
            }
        }

        endGame()
    }
}
