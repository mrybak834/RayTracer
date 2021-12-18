package model.tuple

import util.Util
import kotlin.math.sqrt

data class Vector(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple(x, y, z, 0.0) {
    override fun equals(other: Any?) =
        if (other is Tuple) Util.equals(x, other.x) && Util.equals(y, other.y) && Util.equals(z, other.z) && Util.equals(w, other.w) else false

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }

    operator fun plus(other: Vector) = Vector(x + other.x, y + other.y, z + other.z)
    operator fun plus(other: Point) = Point(x + other.x, y + other.y, z + other.z)
    operator fun minus(other: Vector): Vector = Vector(x - other.x, y - other.y, z - other.z)
    operator fun minus(other: Point): Vector = throw IllegalArgumentException("Cannot subtract a point from a vector")
    override operator fun unaryMinus() = Vector(-x, -y, -z)
    override operator fun times(scalar: Double) = Vector(x * scalar, y * scalar, z * scalar)
    override operator fun div(scalar: Double) = Vector(x / scalar, y / scalar, z / scalar)


    fun magnitude(): Double = sqrt(x * x + y * y + z * z)

    fun normalize(): Vector {
        val magnitude = magnitude()
        return Vector(x / magnitude, y / magnitude, z / magnitude)
    }

    fun dot(other: Vector): Double = x * other.x + y * other.y + z * other.z

    fun cross(other: Vector): Vector = Vector(
        y * other.z - z * other.y,
        z * other.x - x * other.z,
        x * other.y - y * other.x
    )
}
operator fun Double.times(other: Vector) = other * this
operator fun Double.div(other: Vector) = Vector(this / other.x, this / other.y, this / other.z)