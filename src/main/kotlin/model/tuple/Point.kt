package model.tuple

import model.tuple.Point.Companion.toPoint
import model.tuple.Vector.Companion.toVector

data class Point(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple(x, y, z, 1.0) {
    override fun equals(other: Any?) = super.equals(other)
    override fun hashCode() = super.hashCode()


    override operator fun plus(other: Tuple) = toPoint(super.plus(other))
    operator fun minus(other: Vector) = toPoint(super.minus(other))
    operator fun minus(other: Point): Vector = toVector(super.minus(other))
    override operator fun unaryMinus() = toPoint(super.unaryMinus())
    override operator fun times(scalar: Double) = toPoint(super.times(scalar))
    override operator fun div(scalar: Double) = toPoint(super.div(scalar))

    companion object {
        fun toPoint(other: Tuple) = Point(other.x, other.y, other.z)
    }

}

operator fun Double.times(other: Point) = toPoint(this.times(other as Tuple))
operator fun Double.div(other: Point) = toPoint(this.div(other as Tuple))