package model.matrix

import util.equalsE

data class Matrix(
    val matrix: List<List<Double>>
) {
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

        if (matrix != other.matrix) return false
        return true
    }

    override fun hashCode(): Int {
        return matrix.hashCode()
    }

    fun print() {
        for (row in matrix) {
            for (col in row) {
                print("$col ")
            }
            println()
        }
    }
}
