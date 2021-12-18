import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NegationTest {

    @Test
    fun `-tVector`() {
        val a = Tuple(1.0, -2.0, 3.0, 0.0)
        assertTrue(-a == Tuple(-1.0, 2.0, -3.0, 0.0))
    }

    @Test
    fun `-vector`() {
        val a = Vector(1.0, -2.0, 3.0)
        assertTrue(-a == Tuple(-1.0, 2.0, -3.0, 0.0))
        assertTrue(-a == Vector(-1.0, 2.0, -3.0))
    }

    @Test
    fun `ERROR -tPoint`() {
        val a = Tuple(1.0, -2.0, 3.0, 1.0)
        assertThrows(AssertionError::class.java) { -a }
    }

    @Test
    fun `ERROR -point`() {
        val a = Point(1.0, -2.0, 3.0)
        assertThrows(AssertionError::class.java) { -a }
    }
}