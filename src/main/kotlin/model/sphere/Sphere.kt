package model.sphere

import model.matrix.Matrix
import model.tuple.Point

data class Sphere(
    val origin: Point = Point(0, 0, 0),
    var transform: Matrix = Matrix.identity
)
