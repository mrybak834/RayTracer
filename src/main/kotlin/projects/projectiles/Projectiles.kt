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

fun tick(projectile: Projectile, environment: Environment): Projectile {
    return Projectile(
        projectile.position + projectile.velocity,
        projectile.velocity + environment.gravity + environment.wind
    )
}