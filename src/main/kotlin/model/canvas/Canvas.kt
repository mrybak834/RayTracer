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
     *
     * @param center center on the canvas
     */
    fun setPixel(
        x: Int,
        y: Int,
        color: Color,
        center: Boolean = false,
        translateHorizontally: Boolean = false
    ): Pixel? {
        var xTransformed = x
        var yTransformed = y

        if (center) {
            xTransformed += (width) / 2
            yTransformed += (height) / 2
        }

        if (translateHorizontally) {
            yTransformed = height - yTransformed - 1
        }

        if (xTransformed < 0 || xTransformed >= width || yTransformed < 0 || yTransformed >= height) {
            println("Error: pixel out of bounds")
            return null
        }
        val pixel = Pixel(color)

        pixels[yTransformed][xTransformed] = pixel
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