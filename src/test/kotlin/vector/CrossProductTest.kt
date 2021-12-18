package vector

import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import util.Util
import kotlin.math.sqrt

internal class CrossProductTest {

    @Test
    fun `cross product`() {
        val a = Vector(1.0, 2.0, 3.0)
        val b = Vector(2.0, 3.0, 4.0)
        assertTrue(a.cross(b) == Vector(-1.0, 2.0, -1.0))
        assertTrue(b.cross(a) == Vector(1.0, -2.0, 1.0))
    }
}