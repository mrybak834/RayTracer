open class Tuple(
    open val x: Double,
    open val y: Double,
    open val z: Double,
    open val w: Double
) {
    fun isPoint() =  w == 1.0
    fun isVector() = w == 0.0
}