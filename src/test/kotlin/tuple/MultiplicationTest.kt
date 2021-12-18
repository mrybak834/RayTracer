package tuple

import model.tuple.Point
import model.tuple.Tuple
import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import model.tuple.times

class MultiplicationTest {

    @Test
    fun `tVector x scalar = tVector`() {
        val a = Tuple(1.0, -2.0, 3.0, 0.0)
        val scalar = 3.5
        assertTrue(a * scalar == Tuple(3.5, -7.0, 10.5, 0.0))
        assertTrue(scalar * a == Tuple(3.5, -7.0, 10.5, 0.0))
        assertTrue(a * scalar == Vector(3.5, -7.0, 10.5))
        assertTrue(scalar * a == Vector(3.5, -7.0, 10.5))
    }

    @Test
    fun `vector x scalar = vector`() {
        val a = Vector(1.0, -2.0, 3.0)
        val scalar = 3.5
        assertTrue(a * scalar == Tuple(3.5, -7.0, 10.5, 0.0))
        assertTrue(scalar * a == Tuple(3.5, -7.0, 10.5, 0.0))
        assertTrue(a * scalar == Vector(3.5, -7.0, 10.5))
        assertTrue(scalar * a == Vector(3.5, -7.0, 10.5))
    }

    @Test
    fun `tPoint x scalar`() {
        val a = Tuple(1.0, -2.0, 3.0, 1.0)
        val scalar = 3.5
        assertTrue(a * scalar == Tuple(3.5, -7.0, 10.5, 1.0))
        assertTrue(scalar * a == Tuple(3.5, -7.0, 10.5, 1.0))
        assertTrue(a * scalar == Point(3.5, -7.0, 10.5))
        assertTrue(scalar * a == Point(3.5, -7.0, 10.5))
    }

    @Test
    fun `point x scalar`() {
        val a = Point(-1.0, 2.0, -3.0)
        val scalar = 3.5
        assertTrue(a * scalar == Tuple(-3.5, 7.0, -10.5, 1.0))
        assertTrue(scalar * a == Tuple(-3.5, 7.0, -10.5, 1.0))
        assertTrue(a * scalar == Point(-3.5, 7.0, -10.5))
        assertTrue(scalar * a == Point(-3.5, 7.0, -10.5))
    }
}
