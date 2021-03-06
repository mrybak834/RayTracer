package canvas

import model.canvas.Canvas
import model.color.Color
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@Suppress("USELESS_IS_CHECK")
internal class CanvasTest {

    @Test
    fun `Canvas is created`() {
        val c = Canvas(10, 20)
        assertEquals(10, c.width)
        assertEquals(20, c.height)
        assertNull(c.pixels.firstOrNull { row ->
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

    @Test
    fun `Set pixel outside bounds`() {
        val c = Canvas(5, 4)
        val red = Color(1.0, 0.0, 0.0)
        assertNull(c.setPixel(6, 7, red))
    }
}