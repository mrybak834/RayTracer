package matrix

import model.matrix.Matrix.Companion.inverse
import model.matrix.Transformation.Companion.rotateX
import model.matrix.Transformation.Companion.rotationX
import model.matrix.Transformation.Companion.rotationY
import model.matrix.Transformation.Companion.rotationZ
import model.matrix.Transformation.Companion.scale
import model.matrix.Transformation.Companion.scaling
import model.matrix.Transformation.Companion.shearing
import model.matrix.Transformation.Companion.transform
import model.matrix.Transformation.Companion.translate
import model.matrix.Transformation.Companion.translation
import model.tuple.Point
import model.tuple.Vector
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.PI
import kotlin.math.sqrt

@Suppress("USELESS_IS_CHECK")
internal class TranslationTest {

    @Test
    fun `Multiply by a translation matrix`() {
        val t = translation(5, -3, 2)
        val p = Point(-3, 4, 5)

        assertTrue(transform(p, t) == Point(2, 1, 7))
    }

    @Test
    fun `Multiplying by the inverse of a translation matrix`() {
        val t = translation(5, -3, 2)
        val inv = inverse(t)
        val p = Point(-3, 4, 5)

        assertTrue(transform(p, inv) == Point(-8, 7, 3))
    }

    @Test
    fun `Translation does not affect vectors`() {
        val transform = translation(5, -3, 2)
        val v = Vector(-3, 4, 5)

        assertTrue(transform(v, transform) == v)
    }

    @Test
    fun `Scaling applied to a point`() {
        val t = scaling(2, 3, 4)
        val p = Point(-4, 6, 8)
        assertTrue(transform(p, t) == Point(-8, 18, 32))
    }

    @Test
    fun `Scaling a vector`() {
        val t = scaling(2, 3, 4)
        val v = Vector(-4, 6, 8)
        assertTrue(transform(v, t) == Vector(-8, 18, 32))
    }

    @Test
    fun `Multiplying the inverse of a scaling matrix`() {
        val t = scaling(2, 3, 4)
        val inv = inverse(t)
        val v = Vector(-4, 6, 8)
        assertTrue(transform(v, inv) == Vector(-2, 2, 2))
    }

    @Test
    fun `Reflection is scaling by a negative value`() {
        val t = scaling(-1, 1, 1)
        val p = Point(2, 3, 4)
        assertTrue(transform(p, t) == Point(-2, 3, 4))
    }

    @Test
    fun `Rotating a point about the x axis`() {
        val p = Point(0, 1, 0)
        val halfQuarter = rotationX(PI / 4)
        val fullQuarter = rotationX(PI / 2)
        assertTrue(transform(p, halfQuarter) == Point(0, sqrt(2.0) / 2, sqrt(2.0) / 2))
        assertTrue(transform(p, fullQuarter) == Point(0, 0, 1))
    }

    @Test
    fun `The inverse of an x-rotation rotates in the opposite direction`() {
        val p = Point(0, 1, 0)
        val halfQuarter = rotationX(PI / 4)
        val inv = inverse(halfQuarter)
        assertTrue(transform(p, inv) == Point(0, sqrt(2.0) / 2, -sqrt(2.0) / 2))
    }

    @Test
    fun `Rotating a point around the y axis`() {
        val p = Point(0, 0, 1)
        val halfQuarter = rotationY(PI / 4)
        val fullQuarter = rotationY(PI / 2)
        assertTrue(transform(p, halfQuarter) == Point(sqrt(2.0) / 2, 0, sqrt(2.0) / 2))
        assertTrue(transform(p, fullQuarter) == Point(1, 0, 0))
    }

    @Test
    fun `Rotating a point about the z axis`() {
        val p = Point(0, 1, 0)
        val halfQuarter = rotationZ(PI / 4)
        val fullQuarter = rotationZ(PI / 2)
        assertTrue(transform(p, halfQuarter) == Point(-sqrt(2.0) / 2, sqrt(2.0) / 2, 0))
        assertTrue(transform(p, fullQuarter) == Point(-1, 0, 0))
    }

    @Test
    fun `shearing x in proportion to y`() {
        val transform = shearing(1, 0, 0, 0, 0, 0)
        val p = Point(2, 3, 4)
        assertTrue(transform(p, transform) == Point(5, 3, 4))
    }

    @Test
    fun `shearing x in proportion to z`() {
        val transform = shearing(0, 1, 0, 0, 0, 0)
        val p = Point(2, 3, 4)
        assertTrue(transform(p, transform) == Point(6, 3, 4))
    }

    @Test
    fun `shearing y in proportion to x`() {
        val transform = shearing(0, 0, 1, 0, 0, 0)
        val p = Point(2, 3, 4)
        assertTrue(transform(p, transform) == Point(2, 5, 4))
    }

    @Test
    fun `shearing y in proportion to z`() {
        val transform = shearing(0, 0, 0, 1, 0, 0)
        val p = Point(2, 3, 4)
        assertTrue(transform(p, transform) == Point(2, 7, 4))
    }

    @Test
    fun `shearing z in proportion to x`() {
        val transform = shearing(0, 0, 0, 0, 1, 0)
        val p = Point(2, 3, 4)
        assertTrue(transform(p, transform) == Point(2, 3, 6))
    }

    @Test
    fun `shearing z in proportion to y`() {
        val transform = shearing(0, 0, 0, 0, 0, 1)
        val p = Point(2, 3, 4)
        assertTrue(transform(p, transform) == Point(2, 3, 7))
    }

    @Test
    fun `Individual transformations are applied in sequence`() {
        val p = Point(1, 0, 1)
        val a = rotationX(PI / 2)
        val b = scaling(5.0, 5.0, 5.0)
        val c = translation(10.0, 5.0, 7.0)
        val p2 = transform(p, a)
        assertTrue(p2 == Point(1, -1, 0))
        val p3 = transform(p2, b)
        assertTrue(p3 == Point(5, -5, 0))
        val p4 = transform(p3, c)
        assertTrue(p4 == Point(15.0, 0.0, 7.0))
    }

    @Test
    fun `Chained transformations must be applied in reverse order`() {
        val p = Point(1, 0, 1)

        val t = rotateX(PI / 2).scale(5.0, 5.0, 5.0).translate(10.0, 5.0, 7.0)
        assertTrue(transform(p, t) == Point(15.0, 0.0, 7.0))
    }
}