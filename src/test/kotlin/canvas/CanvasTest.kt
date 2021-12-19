package canvas

import model.canvas.Canvas
import model.canvas.Pixel
import model.color.Color
import model.color.times
import model.tuple.Tuple
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import util.Util

@Suppress("USELESS_IS_CHECK")
internal class CanvasTest {

    @Test
    fun `Canvas is created`() {
        val c = Canvas(10, 20)
        assertEquals(10, c.width)
        assertEquals(20, c.height)
        assertNull(c.pixels.firstOrNull{ row ->
            row.firstOrNull { it.color != Color(0.0, 0.0, 0.0) } != null
        })
    }

    @Test
    fun `Set pixel`() {
        val c = Canvas(5, 4)
        val red = Color(1.0, 0.0, 0.0)
        c.setPixel(2, 3, red)
        assertTrue(red == c.getPixel(2, 3).color)
    }
}