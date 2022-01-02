package projects.sphere

import model.canvas.Canvas
import model.canvas.PPM.Companion.toPPM
import model.color.Color
import model.intersection.Intersection.Companion.hit
import model.matrix.Matrix.Companion.identity
import model.matrix.Transformation.Companion.rotateZ
import model.matrix.Transformation.Companion.scale
import model.matrix.Transformation.Companion.transform
import model.matrix.Transformation.Companion.translate
import model.ray.Ray
import model.ray.Ray.Companion.intersect
import model.sphere.Sphere
import model.tuple.Point
import model.tuple.Tuple
import model.tuple.Vector
import kotlin.math.PI

fun draw(canvas: Canvas) {
    val s = Sphere()

    val rayOrigin = Point(0.0, 0.0, -10.0)
    val wallZ = 1.0
    val wallSize = 20.0
    val half = wallSize / 2

    val startTime = System.currentTimeMillis()

     (0).rangeTo(canvas.height).toList().parallelStream().forEach { y ->
        val worldY = half - (wallSize / canvas.height) * y
        (0).rangeTo(canvas.width).toList().parallelStream().forEach { x ->
            val worldX = -half + (wallSize / canvas.width) * x
            val position = Point(worldX, worldY, wallZ)
            val r = Ray(rayOrigin, position - rayOrigin)
            val xs = intersect(r, s)
            val hit = xs.hit()

            if (hit != null) canvas.setPixel(
                x,
                y,
                Color(216, 71, 39)
            )
        }
    }

    println("Time: ${System.currentTimeMillis() - startTime}")

    toPPM(canvas, "sphere.ppm")
}