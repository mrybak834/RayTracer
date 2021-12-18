package projects

import model.tuple.Point
import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import projects.projectiles.Environment
import projects.projectiles.Projectile
import projects.projectiles.runSimulation
import projects.projectiles.tick
import util.Util
import kotlin.math.sqrt

class ProjectilesTest {

    @Test
    fun `projectiles`() {
        val projectile = Projectile(
            position = Point(0.0, 1.0, 0.0),
            velocity = Vector(1.0, 3.0, 0.0).normalize()
        )
        val environment = Environment(gravity = Vector(0.0, -0.2, 0.0), wind = Vector(-0.01, 0.0, 0.0))

        runSimulation(projectile, environment)
    }
}