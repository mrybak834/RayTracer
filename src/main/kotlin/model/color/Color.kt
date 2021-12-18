package model.color

import model.tuple.Tuple

data class Color(
    val red: Double,
    val green: Double,
    val blue: Double
): Tuple(red, green, blue, 0.0) {
    companion object{
        fun toColor(other: Tuple) = Color(other.x, other.y, other.z)
    }
    override fun equals(other: Any?) = super.equals(other)
    override fun hashCode() = super.hashCode()



}
