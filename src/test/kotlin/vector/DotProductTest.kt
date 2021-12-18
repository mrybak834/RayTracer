package vector

import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import util.Util
import kotlin.math.sqrt

class DotProductTest {

    @Test
    fun `dot product`() {
        val a = Vector(1.0, 2.0, 3.0)
        val b = Vector(2.0, 3.0, 4.0)
        assertTrue(Util.equals(a.dot(b), 20.0))

    }
}