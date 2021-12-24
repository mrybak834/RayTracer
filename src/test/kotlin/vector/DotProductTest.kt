package vector

import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE

internal class DotProductTest {

    @Test
    fun `dot product`() {
        val a = Vector(1.0, 2.0, 3.0)
        val b = Vector(2.0, 3.0, 4.0)
        assertTrue(a.dot(b).equalsE(20.0))

    }
}