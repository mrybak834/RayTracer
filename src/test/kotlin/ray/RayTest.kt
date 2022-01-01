package ray

import model.ray.Ray
import model.sphere.Sphere
import model.tuple.Point
import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE

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

}