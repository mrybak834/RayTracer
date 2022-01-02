package projects

import model.canvas.Canvas
import model.color.Color
import org.junit.jupiter.api.Test
import projects.sphere.draw

@Suppress("USELESS_IS_CHECK")
internal class SphereTest {

    @Test
    fun `Draw a sphere`() {
        val c = Canvas(200, 200, Color(0, 0, 0))
        draw(c)
    }
}

// 62000
// 65000
//