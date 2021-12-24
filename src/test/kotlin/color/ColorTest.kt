package color

import model.color.Color
import model.color.times
import model.tuple.Tuple
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE

@Suppress("USELESS_IS_CHECK")
internal class ColorTest {

    @Test
    fun `Colors are r g b tuples`() {
        val c = Color(-0.5, 0.4, 1.7)
        assertTrue(c.red.equalsE(-0.5))
        assertTrue(c.green.equalsE(0.4))
        assertTrue(c.blue.equalsE(1.7))
        assertTrue(c == Tuple(c.red, c.green, c.blue, 0.0))
    }

    @Test
    fun `Color + color = color`() {
        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Color(0.7, 0.1, 0.25)
        assertTrue(c1 + c2 == Color(1.6, 0.7, 1.0))
        assertTrue(c1 + c2 is Color)
    }

    @Test
    fun `Color + tuple = color`() {
        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Tuple(0.7, 0.1, 0.25, 0.0)
        assertTrue(c1 + c2 == Color(1.6, 0.7, 1.0))
        assertTrue(c1 + c2 is Color)
    }

    // TODO find a way to make this = color
    @Test
    fun `Tuple + color = tuple`() {
        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Tuple(0.7, 0.1, 0.25, 0.0)
        assertTrue(c2 + c1 == Color(1.6, 0.7, 1.0))
        assertTrue(c2 + c1 is Tuple)
    }

    @Test
    fun `Color - color = color`() {
        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Tuple(0.7, 0.1, 0.25, 0.0)
        assertTrue(c1 + c2 == Color(1.6, 0.7, 1.0))
        assertTrue(c1 + c2 is Color)
    }

    @Test
    fun `Color - tuple = color`() {
        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Tuple(0.7, 0.1, 0.25, 0.0)
        assertTrue(c1 - c2 == Color(0.2, 0.5, 0.5))
        assertTrue(c1 - c2 is Color)
    }

    // TODO find a way to make this = color
    @Test
    fun `Tuple - color = tuple`() {
        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Tuple(0.7, 0.1, 0.25, 0.0)
        assertTrue(c1 - c2 == Color(0.2, 0.5, 0.5))
        assertTrue(c1 - c2 is Tuple)
    }

    @Test
    fun `Color x scalar = color`() {
        val c1 = Color(0.2, 0.3, 0.4)
        assertTrue(c1 * 2.0 == Color(0.4, 0.6, 0.8))
        assertTrue(c1 * 2.0 is Color)
    }

    @Test
    fun `scalar x Color = color`() {
        val c1 = Color(0.2, 0.3, 0.4)
        assertTrue(2.0 * c1 == Color(0.4, 0.6, 0.8))
        assertTrue(2.0 * c1 is Color)
    }

    @Test
    fun `color x color = color`() {
        val c1 = Color(0.3921, 0.0, 0.3921)
        val c2 = Color(0.5, 0.0, 0.8)

        assertTrue(c1 * c2 == Color(c1.red * c2.red, c1.green * c2.green, c1.blue * c2.blue))
        assertTrue(c1 * c2 is Color)
    }

    @Test
    fun `Hex of color`() {
        val c = Color(1.0, 0.0, 1.0)
        assertTrue(c.hex() == "#ff00ff")
    }

    @Test
    fun `Scaled rgb of color`() {
        val c = Color(1.2, 0.5, -1.0)
        val scaled = c.rgbScaled()
        assertTrue(scaled["red"] == 255)
        assertTrue(scaled["green"] == 128)
        assertTrue(scaled["blue"] == 0)
    }
}