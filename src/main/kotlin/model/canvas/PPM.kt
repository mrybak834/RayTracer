package model.canvas

data class PPM(
    val width: Int,
    val height: Int,
    val pixels: List<MutableList<Pixel>>
) {

}