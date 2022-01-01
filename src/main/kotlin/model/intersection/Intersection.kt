package model.intersection

data class Intersection(
    val t: Double,
    val item: Any
) {
    constructor(t: Number, item: Any): this(t.toDouble(), item)

    companion object {
        fun getIntersections(vararg intersection: Intersection): List<Intersection> {
            return listOf(*intersection)
        }
    }
}
