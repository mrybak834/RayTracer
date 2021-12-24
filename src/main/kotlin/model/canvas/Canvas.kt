package model.canvas

import model.color.Color

data class Canvas(
    val width: Int,
    val height: Int,
    val pixels: List<MutableList<Pixel>>
) {
    constructor(width: Int, height: Int, initialColor: Color = Color(0.0, 0.0, 0.0)) :
            this(width, height, createPixels(width, height, initialColor))


    /**
     * @param translateHorizontally if true, flips the result about the horizontal axis.
     * Useful since we are dealing with a -y axis, and most calculations are done with a +y axis.
     */
    fun setPixel(x: Int, y: Int, color: Color, translateHorizontally: Boolean = false): Pixel? {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            println("Error: pixel out of bounds")
            return null
        }
        val pixel = Pixel(color)
        pixels[if (translateHorizontally) height - 1 - y else y][x] = pixel
        return pixel
    }

    fun getPixel(x: Int, y: Int) = pixels[y][x]

    fun print() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                val color = pixels[y][x].color
                print("${color.rgbScaledRed()} ${color.rgbScaledGreen()} ${color.rgbScaledBlue()} ")
            }
            println()
        }
    }

    companion object {
        fun createPixels(
            width: Int,
            height: Int,
            initialColor: Color = Color(0.0, 0.0, 0.0)
        ): List<MutableList<Pixel>> {
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