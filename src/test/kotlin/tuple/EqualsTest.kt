package tuple

import model.tuple.Tuple
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EqualsTest {

    @Test
    fun `tuple == tuple within error`() {
        val a = Tuple(1.22222, -2.0, 3.0, 0.0)
        val b = Tuple(1.22222222, -2.0, 3.0, 0.0)
        assertTrue( a == b )
    }
}
