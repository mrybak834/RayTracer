package model.matrix

import model.matrix.Matrix.Companion.identity
import model.ray.Ray
import model.tuple.Point
import model.tuple.Tuple
import model.tuple.Vector
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

        fun transform(tuple: Tuple, transformation: Matrix) = transformation * tuple
        fun transform(ray: Ray, transformation: Matrix) = Ray(
            Point(transform(ray.origin, transformation)),
            Vector(transform(ray.direction, transformation))
        )

        fun translate(x: Number, y: Number, z: Number) = translation(x, y, z) * identity
        fun scale(x: Number, y: Number, z: Number) = scaling(x, y, z) * identity
        fun rotateX(theta: Number) = rotationX(theta) * identity
        fun rotateY(theta: Number) = rotationY(theta) * identity
        fun rotateZ(theta: Number) = rotationZ(theta) * identity
        fun shear(xy: Number, xz: Number, yx: Number, yz: Number, zx: Number, zy: Number) =
            shearing(xy, xz, yx, yz, zx, zy) * identity

        fun Matrix.translate(x: Number, y: Number, z: Number) = Transformation.translate(x, y, z) * this
        fun Matrix.scale(x: Number, y: Number, z: Number) = Transformation.scale(x, y, z) * this
        fun Matrix.rotateX(theta: Number) = Transformation.rotateX(theta) * this
        fun Matrix.rotateY(theta: Number) = Transformation.rotateY(theta) * this
        fun Matrix.rotateZ(theta: Number) = Transformation.rotateZ(theta) * this
        fun Matrix.shear(xy: Number, xz: Number, yx: Number, yz: Number, zx: Number, zy: Number) =
            Transformation.shear(xy, xz, yx, yz, zx, zy) * this

    }
}
