package projects.projectiles

import model.tuple.Point
import model.tuple.Vector

data class Projectile(
    val position: Point,
    val velocity: Vector
)

data class Environment(
    val gravity: Vector,
    val wind: Vector
)

fun tick(projectile: Projectile, environment: Environment) =
    Projectile(
        projectile.position + projectile.velocity,
        projectile.velocity + environment.gravity + environment.wind
    )

fun runSimulation(projectile: Projectile, environment: Environment) {
    var projectileFired = projectile
    var tickCount = 0
    while(projectileFired.position.y > 0) {
        projectileFired = tick(projectileFired, environment)
        tickCount++
        println("Position after $tickCount ticks: ${projectileFired.position}")
    }
}