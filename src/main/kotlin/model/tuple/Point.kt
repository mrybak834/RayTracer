package model.tuple

data class Point(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple(x, y, z, 1.0) {
    override fun equals(other: Any?) = super.equals(other)
    override fun hashCode() = super.hashCode()

    constructor(x: Number, y: Number, z: Number) : this(x.toDouble(), y.toDouble(), z.toDouble())
    constructor(t: Tuple) : this(t.x, t.y, t.z)

    override operator fun plus(other: Tuple) = Point(super.plus(other))
    operator fun minus(other: Vector) = Point(super.minus(other))
    operator fun minus(other: Point): Vector = Vector(super.minus(other))
    override operator fun unaryMinus() = Point(super.unaryMinus())
    override operator fun times(scalar: Double) = Point(super.times(scalar))
    override operator fun div(scalar: Double) = Point(super.div(scalar))
}

operator fun Double.times(other: Point) = Point(this.times(other as Tuple))
operator fun Double.div(other: Point) = Point(this.div(other as Tuple))