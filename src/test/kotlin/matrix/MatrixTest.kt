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
    }

}