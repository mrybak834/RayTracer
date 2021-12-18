open class Tuple(
    open val x: Double,
    open val y: Double,
    open val z: Double,
    open val w: Double
) {
    fun isPoint() =  w == 1.0
    fun isVector() = w == 0.0
}

data class Point(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple(x, y, z, 1.0) {
    override fun equals(other: Any?): Boolean {
        if (other is Tuple) {
            return x == other.x && y == other.y && z == other.z && w == other.w
        }
        return false
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }
}

data class Vector(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple(x, y, z, 0.0) {
    override fun equals(other: Any?): Boolean {
        if (other is Tuple) {
            return x == other.x && y == other.y && z == other.z && w == other.w
        }
        return false
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }
}