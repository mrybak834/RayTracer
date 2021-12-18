package model.tuple

import util.Util

open class Tuple(
    open val x: Double,
    open val y: Double,
    open val z: Double,
    open val w: Double
) {
    fun isPoint() =  w == 1.0
    fun isVector() = w == 0.0

    override fun equals(other: Any?) =
        if (other is Tuple) Util.equals(x, other.x) && Util.equals(y, other.y) && Util.equals(z, other.z) && Util.equals(w, other.w) else false

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }

    operator fun plus(other: Tuple): Tuple {
        assert(!(isPoint() && other.isPoint())) { throw IllegalArgumentException("Cannot add two points") }
        return Tuple(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    operator fun minus(other: Tuple): Tuple {
        assert(!(isVector() && other.isPoint())) { throw IllegalArgumentException("Cannot subtract a point from a vector") }
        return Tuple(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    open operator fun unaryMinus() = Tuple(-x, -y, -z, w)

    open operator fun times(scalar: Double) = Tuple(x * scalar, y * scalar, z * scalar, w)

    open operator fun div(scalar: Double) = Tuple(x / scalar, y / scalar, z / scalar, w)

}

operator fun Double.times(other: Tuple) = other * this
operator fun Double.div(other: Tuple) = Tuple(this / other.x, this / other.y, this / other.z, other.w)