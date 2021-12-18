import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AdditionTest {

    @Test
    fun `tVector + tVector = tVector`() {
        val a = Tuple(1.0, 2.0, 3.0, 0.0)
        val b = Tuple(2.0, 3.0, 4.0, 0.0)
        assertTrue(a + b == Tuple(3.0, 5.0, 7.0, 0.0))
    }

    @Test
    fun `tPoint + tVector = tPoint`() {
        val a = Tuple(3.0, -2.0, 5.0, 1.0)
        val b = Tuple(-2.0, 3.0, 1.0, 0.0)
        assertTrue(a + b == Tuple(1.0, 1.0, 6.0, 1.0))
    }

    @Test
    fun `vector + vector = vector`() {
        val a = Vector(3.0, -2.0, 5.0)
        val b = Vector(-2.0, 3.0, 1.0)
        assertTrue(a + b == Vector(1.0, 1.0, 6.0))
        assertTrue(a + b == Tuple(1.0, 1.0, 6.0, 0.0))

    }

    @Test
    fun `point + vector = point`() {
        val p = Point(3.0, -2.0, 5.0)
        val v = Vector(-2.0, 3.0, 1.0)
        assertTrue(p + v == Point(1.0, 1.0, 6.0))
        assertTrue(p + v == Tuple(1.0, 1.0, 6.0, 1.0))
    }

    @Test
    fun `ERROR point + point`() {
        val a = Point(3.0, -2.0, 5.0)
        val b = Point(-2.0, 3.0, 1.0)
        assertThrows(AssertionError::class.java) { a + b }
    }

    @Test
    fun `ERROR tPoint + tPoint`() {
        val a = Tuple(3.0, -2.0, 5.0, 1.0)
        val b = Tuple(-2.0, 3.0, 1.0, 1.0)
        assertThrows(AssertionError::class.java) { a + b }
    }
}