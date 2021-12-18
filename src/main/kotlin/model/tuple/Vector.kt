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

    fun magnitude(): Double = sqrt(x * x + y * y + z * z)

    fun normalize(): Vector {
        val magnitude = magnitude()
        return Vector(x / magnitude, y / magnitude, z / magnitude)
    }

    fun dot(other: Vector): Double = x * other.x + y * other.y + z * other.z
}