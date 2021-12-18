import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import util.Util

internal class TupleTest {

    @Test
    fun `A tuple with w = 1 is a point`() {
        val a = Tuple(4.3, -4.2, 3.1, 1.0)
        assertTrue(Util.equals(4.3, a.x))
        assertTrue(Util.equals(-4.2, a.y))
        assertTrue(Util.equals(3.1, a.z))
        assertTrue(Util.equals(1.0, a.w))
        assertEquals(true, a.isPoint())
        assertEquals(false, a.isVector())
    }

    @Test
    fun `A tuple with w = 0 is a vector`() {
        val a = Tuple(4.3, -4.2, 3.1, 0.0)
        assertTrue(Util.equals(4.3, a.x))
        assertTrue(Util.equals(-4.2, a.y))
        assertTrue(Util.equals(3.1, a.z))
        assertTrue(Util.equals(0.0, a.w))
        assertEquals(a.isPoint(), false)
        assertEquals(a.isVector(), true)
    }

    @Test
    fun `A point is a tuple with w = 1`() {
        val a = Point(4.0, -4.0, 3.0)
        assertTrue(Util.equals(4.0, a.x))
        assertTrue(Util.equals(-4.0, a.y))
        assertTrue(Util.equals(3.0, a.z))
        assertTrue(Util.equals(1.0, a.w))
        assertEquals(a.isPoint(), true)
        assertEquals(a.isVector(), false)
        assertTrue(a == Tuple(4.0, -4.0, 3.0, 1.0))
    }

    @Test
    fun `A vector is a tuple with w = 0`() {
        val a = Vector(4.0, -4.0, 3.0)
        assertTrue(Util.equals(4.0, a.x))
        assertTrue(Util.equals(-4.0, a.y))
        assertTrue(Util.equals(3.0, a.z))
        assertTrue(Util.equals(0.0, a.w))
        assertEquals(a.isPoint(), false)
        assertEquals(a.isVector(), true)
        assertTrue(a == Tuple(4.0, -4.0, 3.0, 0.0))
    }

}