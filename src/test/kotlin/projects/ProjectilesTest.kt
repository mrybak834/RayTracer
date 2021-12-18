package projects

import model.tuple.Point
import model.tuple.Vector
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import projects.projectiles.Environment
import projects.projectiles.Projectile
import projects.projectiles.tick
import util.Util
import kotlin.math.sqrt

class ProjectilesTest {

    @Test
    fun `projectiles`() {
        var projectile = Projectile(
            position = Point(0.0, 1.0, 0.0),
            velocity = Vector(1.0, 1.0, 0.0).normalize()
        )
        println(projectile)

        for(i in 0..100){
            projectile = tick(projectile,
                Environment(gravity = Vector(0.0, -0.1, 0.0), wind = Vector(-0.01, 0.0, 0.0))
            )
            println(projectile)
        }
    }
}