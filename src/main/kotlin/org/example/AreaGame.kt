package org.example

class AreaGame {
    private var zoneGame: Array<Array<Char>>

    init {
        var count = '1'
        zoneGame = Array(3, { Array(3, {' '})})
        for(i in 0 until zoneGame.size) {
            for(j in 0 until zoneGame[i].size){
                zoneGame[i][j] = count
                count++
            }
        }
    }

    fun zoneGameGet(): Array<Array<Char>> {
        return zoneGame
    }

    fun zoneGameSet(row: Int, column: Int, step: Char) {
        zoneGame[row][column] = step
    }

    fun printAreaGame() {
        for (i in 0 until zoneGame.size) {
            print("| ")
            for (j in 0 until zoneGame.size) {
                print(zoneGame[i][j] + " | ")
            }
            print("\n")
        }
        print("\n")
    }

    fun zoneGameCompare(area: Array<Array<Char>>): Boolean {
        for(i in 0 until zoneGame.size) {
            for(j in 0 until zoneGame[i].size){
                if(zoneGame[i][j] != area[i][j]) {
                    return false
                }
            }
        }
        return true
    }
}
