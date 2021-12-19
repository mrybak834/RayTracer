package model.color

import model.tuple.Tuple
import kotlin.math.roundToInt

data class Color(
    val red: Double,
    val green: Double,
    val blue: Double
): Tuple(red, green, blue, 0.0) {
    companion object{
        fun toColor(other: Tuple) = Color(other.x, other.y, other.z)
        fun rbgScaled(value: Double) = (value * 255.0).roundToInt().coerceIn(0, 255)
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

    fun rgbScaled() = mapOf("red" to "${rbgScaled(red)}", "green" to "${rbgScaled(green)}", "blue" to "${rbgScaled(blue)}")
}
operator fun Double.times(other: Color) = other.times(this)
