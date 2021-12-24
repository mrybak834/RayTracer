package model.matrix

data class Matrix(
    val matrix: List<List<Double>>
) {
    operator fun get(row: Int, col: Int): Double {
        return matrix[row][col]
    }
}
