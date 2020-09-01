package org.example

import org.junit.*
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TestPlayer {

    @Test
    fun testPlayer1() {
        var cross = 'X'
        var toe = 'O'
        var playerFirst = Player(cross)
        var playerSecond = Player(toe)
        assertEquals(cross, playerFirst.stepGet())
        assertEquals(toe, playerSecond.stepGet())
    }

    @Test
    fun testPlayer2() {
        var cross = 'X'
        var toe = 'O'
        var playerFirst = Player(toe)
        var playerSecond = Player(cross)
        assertNotEquals(cross, playerFirst.stepGet())
        assertNotEquals(toe, playerSecond.stepGet())
    }
}
