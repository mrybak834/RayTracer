package vector

import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import util.Util
import kotlin.math.sqrt

internal class MagnitudeTest {

    @Test
    fun `Magnitude of a vector`() {
        val v = Vector(1.0, 0.0, 0.0)
        assertTrue(Util.equals(v.magnitude(), 1.0))

        val v2 = Vector(0.0, 1.0, 0.0)
        assertTrue(Util.equals(v2.magnitude(), 1.0))

        val v3 = Vector(0.0, 0.0, 1.0)
        assertTrue(Util.equals(v3.magnitude(), 1.0))

        val v4 = Vector(1.0, 2.0, 3.0)
        assertTrue(Util.equals(v4.magnitude(), sqrt(14.0)))

        val v5 = Vector(-1.0, -2.0, -3.0)
        assertTrue(Util.equals(v5.magnitude(), sqrt(14.0)))
    }
}