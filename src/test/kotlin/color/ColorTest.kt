package color

import model.color.Color
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import util.Util

internal class ColorTest {

    @Test
    fun `Colors are r g b tuples`() {
        val c = Color(-0.5, 0.4, 1.7)
        assertTrue(Util.equals(c.red, -0.5))
        assertTrue(Util.equals(c.green, 0.4))
        assertTrue(Util.equals(c.blue, 1.7))
    }

}