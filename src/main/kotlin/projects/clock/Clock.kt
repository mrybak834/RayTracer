package projects.clock

import model.canvas.Canvas
import model.canvas.PPM.Companion.toPPM
import model.color.Color
import model.matrix.Matrix.Companion.identity
import model.matrix.Transformation.Companion.rotateX
import model.matrix.Transformation.Companion.rotateY
import model.matrix.Transformation.Companion.rotateZ
import model.matrix.Transformation.Companion.scale
import model.matrix.Transformation.Companion.transform
import model.matrix.Transformation.Companion.translate
import model.tuple.Point
import model.tuple.Vector
import kotlin.math.PI

data class Clock(
    val position: Point,
    val velocity: Vector
)


fun draw(canvas: Canvas) {
    val origin = Point(0,0,0)
    canvas.setPixel(
        origin.x.toInt(),
        origin.y.toInt(),
        Color(216, 71, 39),
        translateHorizontally = true,
        center = true
    )

    for (i in 0..200) {
        var transform = identity.translate(0,canvas.height / 3,0).rotateZ((2*PI)/200*i)

        var transformed = transform.transform(origin)
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