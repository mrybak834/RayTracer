package canvas

import model.canvas.Canvas
import model.canvas.PPM
import model.canvas.PPM.Companion.toPPM
import model.canvas.Pixel
import model.color.Color
import model.color.times
import model.tuple.Tuple
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import util.Util

@Suppress("USELESS_IS_CHECK")
internal class PPMTest {

    @Test
    fun `PPM header`() {
        val c = Canvas(5, 3)
        val ppm = toPPM(c)
        assertTrue(ppm.startsWith("""
            P3
            5 3
            255
        """.trimIndent()))
    }

    @Test
    fun `PPM pixel data`() {
        val c = Canvas(5, 3)
        val c1 = Color(1.5, 0.0, 0.0)
        val c2 = Color(0.0, 0.5, 0.0)
        val c3 = Color(-0.5, 0.0, 1.0)
        c.setPixel(0, 0, c1)
        c.setPixel(2, 1, c2)
        c.setPixel(4, 2, c3)
        val ppm = toPPM(c)
        val test = """
            P3
            5 3
            255
            255 0 0 0 0 0 0 0 0 0 0 0 0 0 0
            0 0 0 0 0 0 0 128 0 0 0 0 0 0 0
            0 0 0 0 0 0 0 0 0 0 0 0 0 0 255

        """.trimIndent()
        assertTrue(ppm == test)
    }

    @Test
    fun `PPM lines must be under 70 characters`(){
        val c = Canvas(10, 2, Color(1.0, 0.8, 0.6))
        val ppm = toPPM(c)
        print(ppm)
        assertTrue(ppm.lines().all { it.length < 70 })
    }

    @Test
    fun `PPM files must be terminated by a newline`(){
        val c = Canvas(5, 3)
        val ppm = toPPM(c)
        assertTrue(ppm.endsWith("\n"))
    }

    @Test
    fun `PPM file`(){
        val c = Canvas(5, 3)
        val c1 = Color(1.5, 0.0, 0.0)
        val c2 = Color(0.0, 0.5, 0.0)
        val c3 = Color(-0.5, 0.0, 1.0)
        c.setPixel(0, 0, c1)
        c.setPixel(2, 1, c2)
        c.setPixel(4, 2, c3)
        val ppm = toPPM(c)
        val ppmFile = toPPM(c,"test.ppm")
        val contents = ppmFile.readLines()
        assertTrue(contents.joinToString("\n") == ppm.trim())
    }

}