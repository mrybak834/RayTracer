package model.color

import model.tuple.Tuple
import kotlin.math.roundToInt
import kotlin.random.Random

data class Color(
    val red: Double,
    val green: Double,
    val blue: Double
) : Tuple(red, green, blue, 0.0) {

    constructor(r255: Int, g255: Int, b255: Int) : this(
        r255.toDouble() / 255.0,
        g255.toDouble() / 255.0,
        b255.toDouble() / 255.0
    )

    companion object {
        fun toColor(other: Tuple) = Color(other.x, other.y, other.z)
        fun rgbScaled(value: Double) = (value * 255.0).roundToInt().coerceIn(0, 255)
        fun randomColor() = Color(Random.nextDouble(0.0, 1.0), Random.nextDouble(0.0, 1.0), Random.nextDouble(0.0, 1.0))
    }

    override fun equals(other: Any?) = super.equals(other)
    override fun hashCode() = super.hashCode()

    override operator fun plus(other: Tuple) = toColor(super.plus(other))
    override operator fun minus(other: Tuple) = toColor(super.minus(other))
    override operator fun times(scalar: Double) = toColor(super.times(scalar))
    operator fun times(c: Color) = Color(red * c.red, green * c.green, blue * c.blue)

    fun hex() = "#%02x%02x%02x".format(
        (red * 255).toInt(),
        (green * 255).toInt(),
        (blue * 255).toInt()
    )

    fun rgbScaled() = mapOf("red" to rgbScaled(red), "green" to rgbScaled(green), "blue" to rgbScaled(blue))
    fun rgbScaledRed() = (red * 255.0).roundToInt().coerceIn(0, 255)
    fun rgbScaledGreen() = (green * 255.0).roundToInt().coerceIn(0, 255)
    fun rgbScaledBlue() = (blue * 255.0).roundToInt().coerceIn(0, 255)
}

operator fun Double.times(other: Color) = other.times(this)
