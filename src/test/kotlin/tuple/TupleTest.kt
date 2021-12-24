package tuple

import model.tuple.Point
import model.tuple.Tuple
import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE

internal class TupleTest {

    @Test
    fun `A tuple with w = 1 is a point`() {
        val a = Tuple(4.3, -4.2, 3.1, 1.0)
        assertTrue(4.3.equalsE(a.x))
        assertTrue((-4.2).equalsE(a.y))
        assertTrue(3.1.equalsE(a.z))
        assertTrue(1.0.equalsE(a.w))
        assertEquals(true, a.isPoint())
        assertEquals(false, a.isVector())
    }

    @Test
    fun `A tuple with w = 0 is a vector`() {
        val a = Tuple(4.3, -4.2, 3.1, 0.0)
        assertTrue(4.3.equalsE(a.x))
        assertTrue((-4.2).equalsE(a.y))
        assertTrue(3.1.equalsE(a.z))
        assertTrue(0.0.equalsE(a.w))
        assertEquals(a.isPoint(), false)
        assertEquals(a.isVector(), true)
    }

    @Test
    fun `A point is a tuple with w = 1`() {
        val a = Point(4.0, -4.0, 3.0)
        assertTrue(4.0.equalsE(a.x))
        assertTrue((-4.0).equalsE(a.y))
        assertTrue(3.0.equalsE(a.z))
        assertTrue(1.0.equalsE(a.w))
        assertEquals(a.isPoint(), true)
        assertEquals(a.isVector(), false)
        assertTrue(a == Tuple(4.0, -4.0, 3.0, 1.0))
    }

    @Test
    fun `A vector is a tuple with w = 0`() {
        val a = Vector(4.0, -4.0, 3.0)
        assertTrue(4.0.equalsE(a.x))
        assertTrue((-4.0).equalsE(a.y))
        assertTrue(3.0.equalsE(a.z))
        assertTrue(0.0.equalsE(a.w))
        assertEquals(a.isPoint(), false)
        assertEquals(a.isVector(), true)
        assertTrue(a == Tuple(4.0, -4.0, 3.0, 0.0))
    }
}