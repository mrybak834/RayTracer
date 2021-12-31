package model.matrix

import model.tuple.Tuple
import util.equalsE

data class Matrix(
    val matrix: List<List<Double>>,
    val rows: Int,
    val columns: Int
) {
    constructor(matrix: List<List<Number>>) : this(
        matrix.map { row -> row.map { it.toDouble() } },
        matrix.size,
        matrix.first().size
    )

    operator fun get(row: Int): List<Double> = matrix[row]

    operator fun get(row: Int, col: Int): Double {
        return matrix[row][col]
    }

    override operator fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as Matrix

        for (col in matrix.indices) {
            for (row in matrix[col].indices) {
                if (!(matrix[col][row].equalsE(other.matrix[col][row]))) return false
            }
        }

        return true
    }

    override fun hashCode(): Int {
        return matrix.hashCode()
    }


    // c1 r2 => r1 c2
    operator fun times(b: Matrix): Matrix {
        assert(matrix.first().size == b.matrix.size) { "Matrix 1 columns must be equal to matrix 2 rows" }

        val product = MutableList(matrix.size) { MutableList(b.matrix[0].size) { 0.0 } }
        for (i in matrix.indices) {
            for (j in 0 until b.matrix[0].size) {
                for (k in 0 until matrix[0].size) {
                    product[i][j] += matrix[i][k] * b.matrix[k][j]
                }
            }
        }

        return Matrix(product)
    }

    operator fun times(b: Tuple): Tuple {
        val result = times(
            Matrix(
                listOf(
                    listOf(b.x),
                    listOf(b.y),
                    listOf(b.z),
                    listOf(b.w)
                )
            )
        ).matrix
        return Tuple(result[0].first(), result[1].first(), result[2].first(), result[3].first())
    }


    fun print() {
        for (row in matrix) {
            for (col in row) {
                print("$col ")
            }
            println()
        }
    }

    companion object {
        val identity = Matrix(
            listOf(
                listOf(1.0, 0.0, 0.0, 0.0),
                listOf(0.0, 1.0, 0.0, 0.0),
                listOf(0.0, 0.0, 1.0, 0.0),
                listOf(0.0, 0.0, 0.0, 1.0)
            )
        )

        fun transpose(a: Matrix): Matrix {
            if (a == identity) return a

            val transposed = MutableList(a.matrix[0].size) { MutableList(a.matrix.size) { 0.0 } }
            for (i in a.matrix.indices) {
                for (j in a.matrix[i].indices) {
                    transposed[j][i] = a.matrix[i][j]
                }
            }
            return Matrix(transposed)
        }

        fun submatrix(a: Matrix, row: Int, col: Int): Matrix {
            val submatrix = MutableList(a.rows - 1) { MutableList(a.columns - 1) { 0.0 } }
            for (i in 0 until a.matrix.size) {
                if (i == row) continue
                for (j in 0 until a.matrix[i].size) {
                    if (j == col) continue
                    submatrix[i - if (i > row) 1 else 0][j - if (j > col) 1 else 0] = a.matrix[i][j]
                }
            }
            return Matrix(submatrix)
        }

        fun minor(a: Matrix, row: Int, col: Int): Double {
            return determinant(submatrix(a, row, col))
        }

        fun cofactor(a: Matrix, row: Int, col: Int): Double {
            val minor = minor(a, row, col)
            return if ((row + col) % 2 == 0) minor else -minor
        }

        fun determinant(a: Matrix): Double {
            var determinant = 0.0

            if (a.matrix.size == 2) {
                determinant = a[0, 0] * a[1, 1] - a[0, 1] * a[1, 0]
            } else {
                for (i in 0 until a.matrix.size) {
                    determinant += a[0, i] * cofactor(a, 0, i)
                }
            }

            return determinant
        }

        fun isInvertible(a: Matrix) = determinant(a) != 0.0

        fun inverse(a: Matrix): Matrix {
            assert(isInvertible(a)) { "Matrix is not invertible" }
            val determinant = determinant(a)

            val inverse = MutableList(a.rows) { MutableList(a.columns) { 0.0 } }
            for (row in a.matrix.indices) {
                for (col in a.matrix[row].indices) {
                    inverse[col][row] = cofactor(a, row, col) / determinant
                }
            }
            return Matrix(inverse)
        }
    }
}
