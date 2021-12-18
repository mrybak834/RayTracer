package tuples

import model.tuple.Point
import model.tuple.Tuple
import model.tuple.Vector
import model.tuple.div
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DivisionTest {

    @Test
    fun `tVector div scalar = tVector`() {
        val a = Tuple(1.0, -2.0, 3.0, 0.0)
        val scalar = 2.5
        assertTrue( a / scalar == Tuple(0.4, -0.8, 1.2, 0.0))
        assertTrue( a / scalar == Vector(0.4, -0.8, 1.2,))
    }

    @Test
    fun `scalar div tVector = tVector`() {
        val a = Tuple(1.0, -2.0, 3.0, 0.0)
        val scalar = 2.5
        assertTrue( scalar / a == Tuple(2.5, -1.25, 0.83333, 0.0))
        assertTrue( scalar / a == Vector(2.5, -1.25, 0.83333))
    }

    @Test
    fun `vector div scalar = vector`() {
        val a = Vector(1.0, -2.0, 3.0)
        val scalar = 2.5
        assertTrue( a / scalar == Tuple(0.4, -0.8, 1.2, 0.0))
        assertTrue( a / scalar == Vector(0.4, -0.8, 1.2,))
    }

    @Test
    fun `scalar div vector = vector`() {
        val a = Vector(1.0, -2.0, 3.0)
        val scalar = 2.5
        assertTrue( scalar / a == Tuple(2.5, -1.25, 0.83333, 0.0))
        assertTrue( scalar / a == Vector(2.5, -1.25, 0.83333))
    }

    @Test
    fun `tPoint div scalar = tPoint`() {
        val a = Tuple(1.0, -2.0, 3.0, 1.0)
        val scalar = 2.5
        assertTrue( a / scalar == Tuple(0.4, -0.8, 1.2, 1.0))
        assertTrue( a / scalar == Point(0.4, -0.8, 1.2,))
    }

    @Test
    fun `scalar div tPoint = tPoint`() {
        val a = Tuple(1.0, -2.0, 3.0, 1.0)
        val scalar = 2.5
        assertTrue( scalar / a == Tuple(2.5, -1.25, 0.83333, 1.0))
        assertTrue( scalar / a == Point(2.5, -1.25, 0.83333))
    }

    @Test
    fun `point div scalar = point`() {
        val a = Point(1.0, -2.0, 3.0)
        val scalar = 2.5
        assertTrue( a / scalar == Tuple(0.4, -0.8, 1.2, 1.0))
        assertTrue( a / scalar == Point(0.4, -0.8, 1.2,))
    }

    @Test
    fun `scalar div point = point`() {
        val a = Point(1.0, -2.0, 3.0)
        val scalar = 2.5
        assertTrue( scalar / a == Tuple(2.5, -1.25, 0.83333, 1.0))
        assertTrue( scalar / a == Point(2.5, -1.25, 0.83333))
    }

}
