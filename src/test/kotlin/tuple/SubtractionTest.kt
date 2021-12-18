package tuple

import model.tuple.Point
import model.tuple.Tuple
import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SubtractionTest {

    @Test
    fun `tVector - tVector = tVector`() {
        val a = Tuple(1.0, 2.0, 3.0, 0.0)
        val b = Tuple(2.0, 3.0, 4.0, 0.0)
        assertTrue(a - b == Tuple(-1.0, -1.0, -1.0, 0.0))
        assertTrue(a - b == Vector(-1.0, -1.0, -1.0))
    }

    @Test
    fun `tPoint - tVector = tPoint`() {
        val a = Tuple(3.0, -2.0, 5.0, 1.0)
        val b = Tuple(-2.0, 3.0, 1.0, 0.0)
        assertTrue(a - b == Tuple(5.0, -5.0, 4.0, 1.0))
        assertTrue(a - b == Point(5.0, -5.0, 4.0))
    }

    @Test
    fun `tPoint - tPoint = tVector`() {
        val a = Tuple(3.0, -2.0, 5.0, 1.0)
        val b = Tuple(-2.0, 3.0, 1.0, 1.0)
        assertTrue(a - b == Tuple(5.0, -5.0, 4.0, 0.0))
        assertTrue(a - b == Vector(5.0, -5.0, 4.0))
    }

    @Test
    fun `vector - vector = vector`() {
        val a = Vector(1.0, 2.0, 3.0)
        val b = Vector(2.0, 3.0, 4.0)
        assertTrue(a - b == Vector(-1.0, -1.0, -1.0))
        assertTrue(a - b == Tuple(-1.0, -1.0, -1.0, 0.0))
    }

    @Test
    fun `point - point = vector`() {
        val a = Point(1.0, 2.0, 3.0)
        val b = Point(2.0, 3.0, 4.0)
        assertTrue(a - b == Vector(-1.0, -1.0, -1.0))
        assertTrue(a - b == Tuple(-1.0, -1.0, -1.0, 0.0))
    }

    @Test
    fun `point - vector = point`() {
        val a = Point(1.0, 2.0, 3.0)
        val b = Vector(2.0, 3.0, 4.0)
        assertTrue(a - b == Point(-1.0, -1.0, -1.0))
        assertTrue(a - b == Tuple(-1.0, -1.0, -1.0, 1.0))
    }

    @Test
    fun `ERROR vector - point`() {
        val a = Vector(1.0, 2.0, 3.0)
        val b = Point(2.0, 3.0, 4.0)
        assertThrows(IllegalArgumentException::class.java) { a - b }
    }

    @Test
    fun `ERROR tVector - tPoint`() {
        val a = Tuple(3.0, -2.0, 5.0, 0.0)
        val b = Tuple(-2.0, 3.0, 1.0, 1.0)
        assertThrows(IllegalArgumentException::class.java) { a - b }
    }
}