package vector

import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE
import kotlin.math.sqrt

internal class MagnitudeTest {

    @Test
    fun `Magnitude of a vector`() {
        val v = Vector(1.0, 0.0, 0.0)
        assertTrue(v.magnitude().equalsE(1.0))

        val v2 = Vector(0.0, 1.0, 0.0)
        assertTrue(v2.magnitude().equalsE(1.0))

        val v3 = Vector(0.0, 0.0, 1.0)
        assertTrue(v3.magnitude().equalsE(1.0))

        val v4 = Vector(1.0, 2.0, 3.0)
        assertTrue(v4.magnitude().equalsE(sqrt(14.0)))

        val v5 = Vector(-1.0, -2.0, -3.0)
        assertTrue(v5.magnitude().equalsE(sqrt(14.0)))
    }
}