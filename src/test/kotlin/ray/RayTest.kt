package ray

import model.matrix.Transformation.Companion.scale
import model.matrix.Transformation.Companion.transform
import model.matrix.Transformation.Companion.translate
import model.ray.Ray
import model.tuple.Point
import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@Suppress("USELESS_IS_CHECK")
internal class RayTest {

    @Test
    fun `Create a ray`() {
        val origin = Point(1, 2, 3)
        val direction = Vector(4, 5, 6)
        val r = Ray(origin, direction)
        assertTrue(r.origin == origin)
        assertTrue(r.direction == direction)
    }

    @Test
    fun `Compute the position of the ray at time t`() {
        val r = Ray(Point(2, 3, 4), Vector(1, 0, 0))
        assertTrue(r.position(0.0) == Point(2, 3, 4))
        assertTrue(r.position(1.0) == Point(3, 3, 4))
        assertTrue(r.position(-1.0) == Point(1, 3, 4))
        assertTrue(r.position(2.5) == Point(4.5, 3, 4))
    }

    @Test
    fun `Translating a ray`() {
        val r = Ray(Point(1, 2, 3), Vector(0, 1, 0))
        val r2 = transform(r, translate(3, 4, 5))
        assertTrue(r2.origin == Point(4, 6, 8))
        assertTrue(r2.direction == Vector(0, 1, 0))
    }

    @Test
    fun `Scaling a ray`() {
        val r = Ray(Point(1, 2, 3), Vector(0, 1, 0))
        val r2 = transform(r, scale(2, 3, 4))
        assertTrue(r2.origin == Point(2, 6, 12))
        assertTrue(r2.direction == Vector(0, 3, 0))
    }

}