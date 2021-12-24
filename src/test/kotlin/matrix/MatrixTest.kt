package matrix

import model.matrix.Matrix
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE

@Suppress("USELESS_IS_CHECK")
internal class MatrixTest {

    @Test
    fun `Create a 4x4 matrix`() {
        val m = Matrix(
            listOf(
                listOf(1.0, 2.0, 3.0, 4.0),
                listOf(5.5, 6.5, 7.5, 8.5),
                listOf(9.0, 10.0, 11.0, 12.0),
                listOf(13.5, 14.5, 15.5, 16.5)
            )
        )

        assertTrue(m[0, 0].equalsE(1.0))
        assertTrue(m[0, 3].equalsE(4.0))
        assertTrue(m[1, 0].equalsE(5.5))
        assertTrue(m[1, 2].equalsE(7.5))
        assertTrue(m[2, 2].equalsE(11.0))
        assertTrue(m[3, 0].equalsE(13.5))
        assertTrue(m[3, 2].equalsE(15.5))
    }

    @Test
    fun `Create a 2x2 matrix`() {
        val m = Matrix(
            listOf(
                listOf(-3.0, 5.0),
                listOf(1.0, -2.0)
            )
        )

        assertTrue(m[0, 0].equalsE(-3.0))
        assertTrue(m[0, 1].equalsE(5.0))
        assertTrue(m[1, 0].equalsE(1.0))
        assertTrue(m[1, 1].equalsE(-2.0))
    }

    @Test
    fun `Create a 3x3 matrix`() {
        val m = Matrix(
            listOf(
                listOf(-3.0, 5.0, 0.0),
                listOf(1.0, -2.0, -7.0),
                listOf(0.0, 1.0, 1.0)
            )
        )

        assertTrue(m[0, 0].equalsE(-3.0))
        assertTrue(m[1, 1].equalsE(-2.0))
        assertTrue(m[2, 2].equalsE(1.0))
    }

    @Test
    fun `Identical matrices are equal`() {
        val a = Matrix(
            listOf(
                listOf(1.0, 2.0, 3.0, 4.0),
                listOf(5.0, 6.0, 7.0, 8.0),
                listOf(9.0, 8.0, 7.0, 6.0),
                listOf(5.0, 4.0, 3.0, 2.0)
            )
        )

        val b = Matrix(
            listOf(
                listOf(1.0, 2.0, 3.0, 4.0),
                listOf(5.0, 6.0, 7.0, 8.0),
                listOf(9.0, 8.0, 7.0, 6.0),
                listOf(5.0, 4.0, 3.0, 2.0)
            )
        )

        assertTrue(a == b)
    }

    @Test
    fun `Dissimilar matrices are not equal`() {
        val a = Matrix(
            listOf(
                listOf(1.0, 2.0, 3.0, 4.0),
                listOf(5.0, 6.0, 7.0, 8.0),
                listOf(9.0, 8.0, 7.0, 6.0),
                listOf(5.0, 4.0, 3.0, 2.0)
            )
        )

        val b = Matrix(
            listOf(
                listOf(2.0, 3.0, 4.0, 5.0),
                listOf(6.0, 7.0, 8.0, 9.0),
                listOf(8.0, 7.0, 6.0, 5.0),
                listOf(4.0, 3.0, 2.0, 1.0)
            )
        )

        assertTrue(a != b)
    }

}