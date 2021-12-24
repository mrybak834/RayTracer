package model.tuple

import model.tuple.Point.Companion.toPoint
import model.tuple.Vector.Companion.toVector
import kotlin.math.sqrt

data class Vector(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple(x, y, z, 0.0) {
    companion object {
        fun toVector(other: Tuple) = Vector(other.x, other.y, other.z)
    }

    override fun equals(other: Any?) = super.equals(other)
    override fun hashCode() = super.hashCode()


    override operator fun plus(other: Tuple) =
        if (other.isVector()) toVector(super.plus(other)) else toPoint(super.plus(other))

    operator fun plus(other: Vector) = toVector(super.plus(other))
    operator fun plus(other: Point) = toPoint(super.plus(other))
    override operator fun minus(other: Tuple) = toVector(super.minus(other))
    override operator fun unaryMinus() = toVector(super.unaryMinus())
    override operator fun times(scalar: Double) = toVector(super.times(scalar))
    override operator fun div(scalar: Double) = toVector(super.div(scalar))


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

operator fun Double.times(other: Vector) = toVector(this.times(other as Tuple))
operator fun Double.div(other: Vector) = toVector(this.div(other as Tuple))