package projects

import model.canvas.Canvas
import model.color.Color
import org.junit.jupiter.api.Test
import projects.clock.draw

@Suppress("USELESS_IS_CHECK")
internal class ClockTest {

    @Test
    fun `Draw a clock` () {
        val c = Canvas(1920, 1080, Color(4, 42, 43))
        draw(c)
    }
}