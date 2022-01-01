package projects.clock

import model.canvas.Canvas
import model.canvas.PPM.Companion.toPPM
import model.color.Color
import model.matrix.Matrix.Companion.identity
import model.matrix.Transformation.Companion.rotateZ
import model.matrix.Transformation.Companion.transform
import model.matrix.Transformation.Companion.translate
import model.tuple.Point
import kotlin.math.PI

fun draw(canvas: Canvas) {
    val origin = Point(0, 0, 0)
    canvas.setPixel(
        origin.x.toInt(),
        origin.y.toInt(),
        Color(216, 71, 39),
        translateHorizontally = true,
        center = true
    )

    for (i in 0..200) {
        val transform = identity.translate(0, canvas.height / 3, 0).rotateZ((2 * PI) / 200 * i)

        val transformed = transform(origin, transform)
        canvas.setPixel(
            transformed.x.toInt(),
            transformed.y.toInt(),
            Color(189, 214, 255),
            translateHorizontally = true,
            center = true
        )
    }



    toPPM(canvas, "clock.ppm")
}