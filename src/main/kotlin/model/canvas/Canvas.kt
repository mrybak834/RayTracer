package model.canvas

import model.color.Color

data class Canvas(
    val width: Int,
    val height: Int,
    val pixels: List<MutableList<Pixel>>
) {
    constructor(width: Int, height: Int, initialColor: Color = Color(0.0, 0.0, 0.0)) :
            this(width, height, createPixels(width, height, initialColor))


    fun setPixel(x: Int, y: Int, color: Color): Pixel {
        val pixel = Pixel(color)
        pixels[y][x] = pixel
        return pixel
    }

    fun getPixel(x: Int, y: Int) = pixels[y][x]


    fun print() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                print("($x, $y)${if(pixels[y][x].color == Color(1.0, 0.0, 0.0)) "YUP " else " "}")
            }
            println()
        }
    }

    companion object {
        fun createPixels(width: Int, height: Int, initialColor: Color = Color(0.0, 0.0, 0.0)): List<MutableList<Pixel>> {
            val pixels = mutableListOf<MutableList<Pixel>>()

            for (y in 0 until height) {
                val row = mutableListOf<Pixel>()
                for (x in 0 until width) row.add(Pixel(initialColor))
                pixels.add(row)
            }

            return pixels
        }
    }
}