package org.example

import org.junit.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestAreaGame {

    @Test
    fun testAreaGame1() {
        var testArea = Array(3, { Array(3, {' '})})
        testArea[0] = arrayOf('1', '2', '3')
        testArea[1] = arrayOf('4', '5', '6')
        testArea[2] = arrayOf('7', '8', '9')
        var area = AreaGame()
        assertTrue(area.zoneGameCompare(testArea))
    }

    @Test
    fun testAreaGame2() {
        var testArea = Array(3, { Array(3, {' '})})
        testArea[0] = arrayOf('1', '1', '1')
        testArea[1] = arrayOf('2', '2', '2')
        testArea[2] = arrayOf('3', '3', '3')
        var area = AreaGame()
        assertFalse(area.zoneGameCompare(testArea))
    }
}
