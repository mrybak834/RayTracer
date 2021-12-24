package vector

import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class NormalizeTest {

    @Test
    fun `Normalize a vector`() {
        val v = Vector(4.0, 0.0, 0.0).normalize()
        assertTrue(v == Vector(1.0, 0.0, 0.0))
        assertTrue(v.magnitude() == 1.0)

        val v2 = Vector(1.0, 2.0, 3.0).normalize()
        assertTrue(v2 == Vector(0.26726, 0.53452, 0.80178))
        assertTrue(v2.magnitude() == 1.0)

        val v3 = Vector(1.0, -2.0, 3.0).normalize()
        assertTrue(v3 == Vector(0.26726, -0.53452, 0.80178))
        assertTrue(v3.magnitude() == 1.0)

    }
}