data class Tuple(
    val x: Double,
    val y: Double,
    val z: Double,
    val w: Double,
    val isPoint: Boolean,
    val isVector: Boolean
)  {

    constructor(x: Double, y: Double, z: Double, w: Double) : this(x, y, z, w, w == 1.0, w == 0.0)



    companion object {
        fun point(x: Double, y: Double, z: Double): Tuple {
            return Tuple(x, y, z, 1.0)
        }

        fun vector(x: Double, y: Double, z: Double): Tuple {
            return Tuple(x, y, z, 0.0)
        }
    }
}
