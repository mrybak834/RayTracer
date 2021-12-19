package model.canvas

import java.io.File

class PPM(
) {
    companion object {
        fun toPPM(canvas: Canvas) = "P3\n${canvas.width} ${canvas.height}\n255\n${pixelsToString(canvas.pixels)}"

        fun toPPM(canvas: Canvas, filename: String): File {
            val ppm = toPPM(canvas)

            return runCatching {
                val file = File(filename)
                file.writeText(ppm)
                file
            }.getOrElse {
                println("Could not write to file=$filename reason=$it")
                throw it
            }
        }

        fun pixelsToString(pixels: List<List<Pixel>>): String {
            val result = StringBuilder()
            val line = StringBuilder()
            val maxCharacters = 70
            var fullPixelsDisplayed = 0

            for (row in pixels) {
                for (pixel in row) {
                    for (position in 0 until 3) {
                        val value = when(position) {
                            0 -> pixel.color.rgbScaledRed()
                            1 -> pixel.color.rgbScaledGreen()
                            2 -> {
                                fullPixelsDisplayed++
                                pixel.color.rgbScaledBlue()
                            }
                            else -> throw IllegalStateException("Position=$position is not valid")
                        }
                        if (line.length + "$value ".length > maxCharacters){
                            result.appendLine(line.trim())
                            line.clear()
                        }
                        line.append("$value ")
                    }
                }
                if (line.isNotEmpty()) result.appendLine(line.trim())
                line.clear()
            }

            return result.toString()
        }
    }
}