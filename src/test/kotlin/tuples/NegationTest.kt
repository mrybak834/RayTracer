package tuples

import model.tuple.Point
import model.tuple.Tuple
import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NegationTest {

    @Test
    fun `-tVector`() {
        val a = Tuple(1.0, -2.0, 3.0, 0.0)
        assertTrue(-a == Tuple(-1.0, 2.0, -3.0, 0.0))
        assertTrue(-a == Vector(-1.0, 2.0, -3.0))
    }

    @Test
    fun `-vector`() {
        val a = Vector(1.0, -2.0, 3.0)
        assertTrue(-a == Tuple(-1.0, 2.0, -3.0, 0.0))
        assertTrue(-a == Vector(-1.0, 2.0, -3.0))
    }

    @Test
    fun `-tPoint`() {
        val a = Tuple(1.0, -2.0, 3.0, 1.0)
        assertTrue(-a == Tuple(-1.0, 2.0, -3.0, 1.0))
        assertTrue(-a == Point(-1.0, 2.0, -3.0))
    }

    @Test
    fun `-point`() {
        val a = Point(1.0, -2.0, 3.0)
        assertTrue(-a == Tuple(-1.0, 2.0, -3.0, 1.0))
        assertTrue(-a == Point(-1.0, 2.0, -3.0))
    }
}