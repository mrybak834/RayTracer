package matrix

import model.matrix.Matrix
import model.matrix.Matrix.Companion.cofactor
import model.matrix.Matrix.Companion.determinant
import model.matrix.Matrix.Companion.identity
import model.matrix.Matrix.Companion.inverse
import model.matrix.Matrix.Companion.isInvertible
import model.matrix.Matrix.Companion.minor
import model.matrix.Matrix.Companion.submatrix
import model.matrix.Matrix.Companion.transpose
import model.tuple.Tuple
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE

@Suppress("USELESS_IS_CHECK")
internal class MatrixTest {

    @Test
    fun `Create a 4x4 matrix`() {
        val m = Matrix(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5.5, 6.5, 7.5, 8.5),
                listOf(9, 10, 11, 12),
                listOf(13.5, 14.5, 15.5, 16.5)
            )
        )

        assertTrue(m[0, 0].equalsE(1))
        assertTrue(m[0, 3].equalsE(4))
        assertTrue(m[1, 0].equalsE(5.5))
        assertTrue(m[1, 2].equalsE(7.5))
        assertTrue(m[2, 2].equalsE(11))
        assertTrue(m[3, 0].equalsE(13.5))
        assertTrue(m[3, 2].equalsE(15.5))
    }

    @Test
    fun `Create a 2x2 matrix`() {
        val m = Matrix(
            listOf(
                listOf(-3, 5),
                listOf(1, -2)
            )
        )

        assertTrue(m[0, 0].equalsE(-3))
        assertTrue(m[0, 1].equalsE(5))
        assertTrue(m[1, 0].equalsE(1))
        assertTrue(m[1, 1].equalsE(-2))
    }

    @Test
    fun `Create a 3x3 matrix`() {
        val m = Matrix(
            listOf(
                listOf(-3, 5, 0),
                listOf(1, -2, -7),
                listOf(0, 1, 1)
            )
        )

        assertTrue(m[0, 0].equalsE(-3))
        assertTrue(m[1, 1].equalsE(-2))
        assertTrue(m[2, 2].equalsE(1))
    }

    @Test
    fun `Identical matrices are equal`() {
        val a = Matrix(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 8, 7, 6),
                listOf(5, 4, 3, 2)
            )
        )

        val b = Matrix(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 8, 7, 6),
                listOf(5, 4, 3, 2)
            )
        )

        assertTrue(a == b)
    }

    @Test
    fun `Dissimilar matrices are not equal`() {
        val a = Matrix(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 8, 7, 6),
                listOf(5, 4, 3, 2)
            )
        )

        val b = Matrix(
            listOf(
                listOf(2, 3, 4, 5),
                listOf(6, 7, 8, 9),
                listOf(8, 7, 6, 5),
                listOf(4, 3, 2, 1)
            )
        )

        assertTrue(a != b)
    }

    @Test
    fun `Multiply matrices`() {
        val a = Matrix(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 8, 7, 6),
                listOf(5, 4, 3, 2)
            )
        )

        val b = Matrix(
            listOf(
                listOf(-2, 1, 2, 3),
                listOf(3, 2, 1, -1),
                listOf(4, 3, 6, 5),
                listOf(1, 2, 7, 8)
            )
        )

        val result = Matrix(
            listOf(
                listOf(20, 22, 50, 48),
                listOf(44, 54, 114, 108),
                listOf(40, 58, 110, 102),
                listOf(16, 26, 46, 42)
            )
        )

        assertTrue(a * b == result)
    }

    @Test
    fun `Multiply uneven matrices`() {
        val a = Matrix(
            listOf(
                listOf(1, 2),
                listOf(3, 4),
            )
        )

        val b = Matrix(
            listOf(
                listOf(5, 6, 7),
                listOf(8, 9, 10)
            )
        )

        val result = Matrix(
            listOf(
                listOf(21, 24, 27),
                listOf(47, 54, 61)
            )
        )

        assertTrue(a * b == result)
    }

    @Test
    fun `Matrix x tuple`() {
        val a = Matrix(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(2, 4, 4, 2),
                listOf(8, 6, 4, 1),
                listOf(0, 0, 0, 1)
            )
        )

        val b = Tuple(1, 2, 3, 1)

        val result = Tuple(18, 24, 33, 1)

        assertTrue(a * b == result)
    }

    @Test
    fun `Matrix x Identity`() {
        val a = Matrix(
            listOf(
                listOf(0, 1, 2, 4),
                listOf(1, 2, 4, 8),
                listOf(2, 4, 8, 16),
                listOf(4, 8, 16, 32)
            )
        )

        assertTrue(a * identity == a)
    }

    @Test
    fun `Identity x Tuple`() {
        val a = Tuple(1, 2, 3, 4)

        assertTrue(identity * a == a)
    }

    @Test
    fun `Transpose a matrix`() {
        val a = Matrix(
            listOf(
                listOf(0, 9, 3, 0),
                listOf(9, 8, 0, 8),
                listOf(1, 8, 5, 3),
                listOf(0, 0, 5, 8)
            )
        )

        val b = Matrix(
            listOf(
                listOf(0, 9, 1, 0),
                listOf(9, 8, 8, 0),
                listOf(3, 0, 5, 5),
                listOf(0, 8, 3, 8)
            )
        )

        assertTrue(transpose(a) == b)
    }

    @Test
    fun `Transpose the identity matrix`() {
        assertTrue(transpose(identity) == identity)
    }

    @Test
    fun `2x2 determinant`() {
        val a = Matrix(
            listOf(
                listOf(1, 5),
                listOf(-3, 2)
            )
        )

        assertTrue(determinant(a).equalsE(17.0))
    }

    @Test
    fun `Submatrix of 3x3`() {
        val a = Matrix(
            listOf(
                listOf(1, 5, 0),
                listOf(-3, 2, 7),
                listOf(0, 6, -3)
            )
        )

        val b = Matrix(
            listOf(
                listOf(-3, 2),
                listOf(0, 6)
            )
        )

        assertTrue(submatrix(a, 0, 2) == b)
    }

    @Test
    fun `Submatrix of a 4x4`() {
        val a = Matrix(
            listOf(
                listOf(-6, 1, 1, 6),
                listOf(-8, 5, 8, 6),
                listOf(-1, 0, 8, 2),
                listOf(-7, 1, -1, 1)
            )
        )

        val b = Matrix(
            listOf(
                listOf(-6, 1, 6),
                listOf(-8, 8, 6),
                listOf(-7, -1, 1)
            )
        )

        assertTrue(submatrix(a, 2, 1) == b)
    }

    @Test
    fun `Minor of 3x3`() {
        val a = Matrix(
            listOf(
                listOf(3, 5, 0),
                listOf(2, -1, -7),
                listOf(6, -1, 5)
            )
        )

        assertTrue(minor(a, 1, 0).equalsE(25.0))
    }

    @Test
    fun `Cofactor of 3x3`() {
        val a = Matrix(
            listOf(
                listOf(3, 5, 0),
                listOf(2, -1, -7),
                listOf(6, -1, 5)
            )
        )

        assertTrue(minor(a, 0, 0).equalsE(-12.0))
        assertTrue(cofactor(a, 0, 0).equalsE(-12.0))
        assertTrue(minor(a, 1, 0).equalsE(25.0))
        assertTrue(cofactor(a, 1, 0).equalsE(-25.0))
    }

    @Test
    fun `Determinant of 3x3`() {
        val a = Matrix(
            listOf(
                listOf(1, 2, 6),
                listOf(-5, 8, -4),
                listOf(2, 6, 4)
            )
        )

        assertTrue(cofactor(a, 0, 0).equalsE(56.0))
        assertTrue(cofactor(a, 0, 1).equalsE(12.0))
        assertTrue(cofactor(a, 0, 2).equalsE(-46.0))
        assertTrue(determinant(a).equalsE(-196.0))
    }

    @Test
    fun `Determinant of 4x4`() {
        val a = Matrix(
            listOf(
                listOf(-2, -8, 3, 5),
                listOf(-3, 1, 7, 3),
                listOf(1, 2, -9, 6),
                listOf(-6, 7, 7, -9)
            )
        )

        assertTrue(cofactor(a, 0, 0).equalsE(690.0))
        assertTrue(cofactor(a, 0, 1).equalsE(447.0))
        assertTrue(cofactor(a, 0, 2).equalsE(210.0))
        assertTrue(cofactor(a, 0, 3).equalsE(51.0))
        assertTrue(determinant(a).equalsE(-4071.0))
    }

    @Test
    fun `A Matrix is invertible`() {
        val a = Matrix(
            listOf(
                listOf(6, 4, 4, 4),
                listOf(5, 5, 7, 6),
                listOf(4, -9, 3, -7),
                listOf(9, 1, 7, -6)
            )
        )

        assertTrue(determinant(a) != 0.0)
        assertTrue(isInvertible(a))
    }

    @Test
    fun `A Matrix is not invertible`() {
        val a = Matrix(
            listOf(
                listOf(-4, 2, -2, -3),
                listOf(9, 6, 2, 6),
                listOf(0, -5, 1, -5),
                listOf(0, 0, 0, 0)
            )
        )

        assertTrue(determinant(a).equalsE(0.0))
        assertFalse(isInvertible(a))
    }

    @Test
    fun `Invert a 4x4 matrix`() {
        val a = Matrix(
            listOf(
                listOf(-5, 2, 6, -8),
                listOf(1, -5, 1, 8),
                listOf(7, 7, -6, -7),
                listOf(1, -3, 7, 4)
            )
        )

        val inverse = Matrix(
            listOf(
                listOf(0.21805, 0.45113, 0.24060, -0.04511),
                listOf(-0.80827, -1.45677, -0.44361, 0.52068),
                listOf(-0.07895, -0.22368, -0.05263, 0.19737),
                listOf(-0.52256, -0.81391, -0.30075, 0.30639)
            )
        )

        val b = inverse(a)

        assertTrue(determinant(a).equalsE(532.0))
        assertTrue(cofactor(a, 2, 3).equalsE(-160.0))
        assertTrue(b[3, 2].equalsE(-160.0 / 532.0))
        assertTrue(cofactor(a, 3, 2).equalsE(105.0))
        assertTrue(b[2, 3].equalsE(105.0 / 532.0))

        assertTrue(b == inverse)
    }

    @Test
    fun `Inverse of 4x4 matrix 2`() {
        val a = Matrix(
            listOf(
                listOf(8, -5, 9, 2),
                listOf(7, 5, 6, 1),
                listOf(-6, 0, 9, 6),
                listOf(-3, 0, -9, -4)
            )
        )

        val inverse = Matrix(
            listOf(
                listOf(-0.15385, -0.15385, -0.28205, -0.53846),
                listOf(-0.07692, 0.12308, 0.02564, 0.03077),
                listOf(0.35897, 0.35897, 0.43590, 0.92308),
                listOf(-0.69231, -0.69231, -0.76923, -1.92308)
            )
        )

        assertTrue(inverse(a) == inverse)
    }

    @Test
    fun `Inverse of 4x4 matrix 3`() {
        val a = Matrix(
            listOf(
                listOf(9, 3, 0, 9),
                listOf(-5, -2, -6, -3),
                listOf(-4, 9, 6, 4),
                listOf(-7, 6, 6, 2)
            )
        )

        val inverse = Matrix(
            listOf(
                listOf(-0.04074, -0.07778, 0.14444, -0.22222),
                listOf(-0.07778, 0.03333, 0.36667, -0.33333),
                listOf(-0.02901, -0.14630, -0.10926, 0.12963),
                listOf(0.17778, 0.06667, -0.26667, 0.33333)
            )
        )

        assertTrue(inverse(a) == inverse)
    }

    @Test
    fun `A x B = C therefore C x Binverse = A`() {
        val a = Matrix(
            listOf(
                listOf(3, -9, 7, 3),
                listOf(3, -8, 2, -9),
                listOf(-4, 4, 4, 1),
                listOf(-6, 5, -1, 1)
            )
        )

        val b = Matrix(
            listOf(
                listOf(8, 2, 2, 2),
                listOf(3, -1, 7, 0),
                listOf(7, 0, 5, 4),
                listOf(6, -2, 0, 5)
            )
        )

        val c = a * b

        assertTrue(c * inverse(b) == a)
    }

    @Test
    fun `Invert identity matrix`() {
        assertTrue(inverse(identity) == identity)
    }

    // THIS SHIT IS MAGIC, wtf!!!!!!!!!!
    @Test
    fun `Matrix x MatrixInverse`() {
        val a = Matrix(
            listOf(
                listOf(3, -9, 7, 3),
                listOf(3, -8, 2, -9),
                listOf(-4, 4, 4, 1),
                listOf(-6, 5, -1, 1)
            )
        )

        val inverse = inverse(a)

        val result = a * inverse

        assertTrue(result == identity)
    }

    @Test
    fun `inverse of transpose == transpose of inverse`() {
        val a = Matrix(
            listOf(
                listOf(8, 2, 2, 2),
                listOf(3, -1, 7, 0),
                listOf(7, 0, 5, 4),
                listOf(6, -2, 0, 5)
            )
        )

        val transpose = transpose(a)
        val inverseOfTranspose = inverse(transpose)

        val inverse = inverse(a)
        val transposeOfInverse = transpose(inverse)

        assertTrue(inverseOfTranspose == transposeOfInverse)
    }
}