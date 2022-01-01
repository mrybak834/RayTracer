package model.tuple


import kotlin.math.sqrt

data class Vector(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple(x, y, z, 0.0) {

    constructor(x: Number, y: Number, z: Number) : this(x.toDouble(), y.toDouble(), z.toDouble())
    constructor(t: Tuple) : this(t.x, t.y, t.z)

    override fun equals(other: Any?) = super.equals(other)
    override fun hashCode() = super.hashCode()


    override operator fun plus(other: Tuple) =
        if (other.isVector()) Vector(super.plus(other)) else Point(super.plus(other))

    operator fun plus(other: Vector) = Vector(super.plus(other))
    operator fun plus(other: Point) = Point(super.plus(other))
    override operator fun minus(other: Tuple) = Vector(super.minus(other))
    override operator fun unaryMinus() = Vector(super.unaryMinus())
    override operator fun times(scalar: Double) = Vector(super.times(scalar))
    override operator fun div(scalar: Double) = Vector(super.div(scalar))


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

operator fun Double.times(other: Vector) = Vector(this.times(other as Tuple))
operator fun Double.div(other: Vector) = Vector(this.div(other as Tuple))