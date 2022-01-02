package sphere

import model.matrix.Matrix
import model.matrix.Transformation.Companion.scaling
import model.matrix.Transformation.Companion.translation
import model.ray.Ray
import model.ray.Ray.Companion.intersect
import model.sphere.Sphere
import model.tuple.Point
import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import util.equalsE

@Suppress("USELESS_IS_CHECK")
internal class SphereTest {

    @Test
    fun `A ray intersects a sphere at two points`() {
        val r = Ray(Point(0, 0, -5), Vector(0, 0, 1))
        val s = Sphere()
        val xs = intersect(r,s)
        assertTrue(xs.size == 2)
        assertTrue(xs[0].t.equalsE(4.0))
        assertTrue(xs[1].t.equalsE(6.0))
    }

    @Test
    fun `A ray intersects a sphere at a tangent`() {
        val r = Ray(Point(0, 1, -5), Vector(0, 0, 1))
        val s = Sphere()
        val xs = intersect(r,s)
        assertTrue(xs.size == 2)
        assertTrue(xs[0].t.equalsE(5.0))
        assertTrue(xs[1].t.equalsE(5.0))
    }

    @Test
    fun `A ray misses a sphere`() {
        val r = Ray(Point(0, 2, -5), Vector(0, 0, 1))
        val s = Sphere()
        val xs = intersect(r,s)
        assertTrue(xs.isEmpty())
    }

    @Test
    fun `A ray originates inside a sphere`() {
        val r = Ray(Point(0, 0, 0), Vector(0, 0, 1))
        val s = Sphere()
        val xs = intersect(r,s)
        assertTrue(xs.size == 2)
        assertTrue(xs[0].t.equalsE(-1.0))
        assertTrue(xs[1].t.equalsE(1.0))
    }

    @Test
    fun `A sphere is behind a ray`() {
        val r = Ray(Point(0, 0, 5), Vector(0, 0, 1))
        val s = Sphere()
        val xs = intersect(r,s)
        assertTrue(xs.size == 2)
        assertTrue(xs[0].t.equalsE(-6.0))
        assertTrue(xs[1].t.equalsE(-4.0))
    }

    @Test
    fun `A spheres default transformation`() {
        val s = Sphere()
        assertTrue(s.transform === Matrix.identity)
    }

    @Test
    fun `Changing a spheres transformation`() {
        val s = Sphere()
        val t = translation(2, 3, 4)
        s.transform = t
        assertTrue(s.transform === t)
    }

    @Test
    fun `Intersecting a scaled sphere with a ray`() {
        val r = Ray(Point(0, 0, -5), Vector(0, 0, 1))
        val s = Sphere()
        s.transform = scaling(2, 2, 2)
        val xs = intersect(r,s)
        assertTrue(xs.size == 2)
        assertTrue(xs[0].t.equalsE(3.0))
        assertTrue(xs[1].t.equalsE(7.0))
    }

    @Test
    fun `Intersecting a translated sphere with a ray`() {
        val r = Ray(Point(0, 0, -5), Vector(0, 0, 1))
        val s = Sphere()
        s.transform = translation(5, 0, 0)
        val xs = intersect(r,s)
        assertTrue(xs.isEmpty())
    }

}