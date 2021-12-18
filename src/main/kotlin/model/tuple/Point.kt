package model.tuple

import util.Util

data class Point(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple(x, y, z, 1.0) {
    override fun equals(other: Any?) =
        if (other is Tuple) Util.equals(x, other.x) && Util.equals(y, other.y) && Util.equals(z, other.z) && Util.equals(w, other.w) else false

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }

    operator fun plus(other: Vector) = Point(x + other.x, y + other.y, z + other.z)
    operator fun plus(other: Point): Point = throw IllegalArgumentException("Points cannot be added to points")
    operator fun minus(other: Point): Vector = Vector(x - other.x, y - other.y, z - other.z)
    operator fun minus(other: Vector): Point = Point(x - other.x, y - other.y, z - other.z)
    override operator fun unaryMinus() = Point(-x, -y, -z)
    override operator fun times(scalar: Double) = Point(x * scalar, y * scalar, z * scalar)
    override operator fun div(scalar: Double) = Point(x / scalar, y / scalar, z / scalar)

}
operator fun Double.times(other: Point) = other * this
operator fun Double.div(other: Point) = Point(this / other.x, this / other.y, this / other.z)