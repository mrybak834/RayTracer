package projects

import model.canvas.Canvas
import model.color.Color
import model.tuple.Point
import model.tuple.Vector
import org.junit.jupiter.api.Test
import projects.projectiles.Environment
import projects.projectiles.Projectile
import projects.projectiles.drawSimulation
import projects.projectiles.runSimulation

internal class ProjectilesTest {

    @Test
    fun `projectiles`() {
        val projectile = Projectile(
            position = Point(0.0, 1.0, 0.0),
            velocity = Vector(1.0, 1.8, 0.0).normalize() * 11.25
        )
        val environment = Environment(
            gravity = Vector(0.0, -0.1, 0.0),
            wind = Vector(-0.01, 0.0, 0.0)
        )

        runSimulation(projectile, environment)
    }

    @Test
    fun `projectiles drawn`() {
        val projectile = Projectile(
            position = Point(0.0, 1.0, 0.0),
            velocity = Vector(1.0, 1.8, 0.0).normalize() * 11.25
        )
        val environment = Environment(
            gravity = Vector(0.0, -0.1, 0.0),
            wind = Vector(-0.01, 0.0, 0.0)
        )
        val c = Canvas(900, 550, Color(4, 42, 43))
        drawSimulation(c, projectile, environment)
    }
}