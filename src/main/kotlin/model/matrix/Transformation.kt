package model.matrix

import model.tuple.Tuple
import kotlin.math.cos
import kotlin.math.sin

class Transformation {
    companion object {
        fun translation(x: Number, y: Number, z: Number) = Matrix(
            listOf(
                listOf(1.0, 0.0, 0.0, x.toDouble()),
                listOf(0.0, 1.0, 0.0, y.toDouble()),
                listOf(0.0, 0.0, 1.0, z.toDouble()),
                listOf(0.0, 0.0, 0.0, 1.0)
            )
        )

        fun scaling(x: Number, y: Number, z: Number) = Matrix(
            listOf(
                listOf(x.toDouble(), 0.0, 0.0, 0.0),
                listOf(0.0, y.toDouble(), 0.0, 0.0),
                listOf(0.0, 0.0, z.toDouble(), 0.0),
                listOf(0.0, 0.0, 0.0, 1.0)
            )
        )

        fun rotationX(theta: Number) = Matrix(
            listOf(
                listOf(1.0, 0.0, 0.0, 0.0),
                listOf(0.0, cos(theta.toDouble()), -sin(theta.toDouble()), 0.0),
                listOf(0.0, sin(theta.toDouble()), cos(theta.toDouble()), 0.0),
                listOf(0.0, 0.0, 0.0, 1.0)
            )
        )

        fun rotationY(theta: Number) = Matrix(
            listOf(
                listOf(cos(theta.toDouble()), 0.0, sin(theta.toDouble()), 0.0),
                listOf(0.0, 1.0, 0.0, 0.0),
                listOf(-sin(theta.toDouble()), 0.0, cos(theta.toDouble()), 0.0),
                listOf(0.0, 0.0, 0.0, 1.0)
            )
        )

        fun rotationZ(theta: Number) = Matrix(
            listOf(
                listOf(cos(theta.toDouble()), -sin(theta.toDouble()), 0.0, 0.0),
                listOf(sin(theta.toDouble()), cos(theta.toDouble()), 0.0, 0.0),
                listOf(0.0, 0.0, 1.0, 0.0),
                listOf(0.0, 0.0, 0.0, 1.0)
            )
        )

        fun shearing(xy: Number, xz: Number, yx: Number, yz: Number, zx: Number, zy: Number) = Matrix(
            listOf(
                listOf(1.0, xy.toDouble(), xz.toDouble(), 0.0),
                listOf(yx.toDouble(), 1.0, yz.toDouble(), 0.0),
                listOf(zx.toDouble(), zy.toDouble(), 1.0, 0.0),
                listOf(0.0, 0.0, 0.0, 1.0)
            )
        )

        fun Matrix.transform(tuple: Tuple) = this * tuple
        fun Matrix.translate(x: Number, y: Number, z: Number) = translation(x, y, z) * this
        fun Matrix.scale(x: Number, y: Number, z: Number) = scaling(x, y, z) * this
        fun Matrix.rotateX(theta: Number) = rotationX(theta) * this
        fun Matrix.rotateY(theta: Number) = rotationY(theta) * this
        fun Matrix.rotateZ(theta: Number) = rotationZ(theta) * this
        fun Matrix.shear(xy: Number, xz: Number, yx: Number, yz: Number, zx: Number, zy: Number) = shearing(xy, xz, yx, yz, zx, zy) * this
    }
}
