package model.ray

import model.intersection.Intersection
import model.intersection.Intersection.Companion.getIntersections
import model.matrix.Matrix.Companion.inverse
import model.matrix.Transformation.Companion.transform
import model.sphere.Sphere
import model.tuple.Point
import model.tuple.Vector
import kotlin.math.sqrt

data class Ray(
    val origin: Point,
    val direction: Vector
) {
    fun position(t: Number) = origin + (direction * t.toDouble())

    companion object {

        /**
         * This assumes we are using a unit sphere
         */
        fun intersect(ray: Ray, sphere: Sphere): List<Intersection> {
            val (origin, direction) = transform(ray, inverse(sphere.transform))
            val sphereToRay = origin - sphere.origin
            val a = direction.dot(direction)
            val b = 2 * direction.dot(sphereToRay)
            val c = sphereToRay.dot(sphereToRay) - 1
            val discriminant = b * b - 4 * a * c

            if (discriminant < 0) return listOf()

            val intersection1 = Intersection((-b - sqrt(discriminant)) / (2 * a), sphere)
            val intersection2 = Intersection((-b + sqrt(discriminant)) / (2 * a), sphere)

            return getIntersections(intersection1, intersection2)
        }
    }
}