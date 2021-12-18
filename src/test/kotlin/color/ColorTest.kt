package color

import model.tuple.Point
import model.tuple.Tuple
import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException

internal class ColorTest {

    @Test
    fun `tVector + tVector = tVector`() {
        val a = Tuple(1.0, 2.0, 3.0, 0.0)
        val b = Tuple(2.0, 3.0, 4.0, 0.0)
        assertTrue(a + b == Tuple(3.0, 5.0, 7.0, 0.0))
        assertTrue(a + b == Vector(3.0, 5.0, 7.0))
    }

}