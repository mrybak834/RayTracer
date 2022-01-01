package intersection

import model.intersection.Intersection
import model.intersection.Intersection.Companion.getIntersections
import model.ray.Ray
import model.sphere.Sphere
import model.tuple.Point
import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE

@Suppress("USELESS_IS_CHECK")
internal class IntersectionTest {

    @Test
    fun `An intersection encapsulates the t value and the object` () {
        val s = Sphere()
        val i = Intersection(3.5, s)
        assertTrue(i.t.equalsE(3.5))
        assertTrue(i.item === s)
    }

    @Test
    fun `Aggregating intersections`() {
        val s = Sphere()
        val i1 = Intersection(1, s)
        val i2 = Intersection(2, s)
        val xs = getIntersections(i1, i2)
        assertTrue(xs.count() == 2)
        assertTrue(xs[0].t.equalsE(1))
        assertTrue(xs[1].t.equalsE(2))
    }

    @Test
    fun `Intersect sets the object on the intersection`() {
        val r = Ray(Point(0, 0, -5), Vector(0, 0, 1))
        val s = Sphere()
        val xs = r.intersect(s)
        assertTrue(xs.count() == 2)
        assertTrue(xs[0].item === s)
        assertTrue(xs[1].item === s)
    }
}