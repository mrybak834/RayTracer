package projects.projectiles

import model.canvas.Canvas
import model.canvas.PPM.Companion.toPPM
import model.color.Color
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

fun drawSimulation(canvas: Canvas, projectile: Projectile, environment: Environment) {
    val color = Color(1.0, 0.0, 0.0)
    canvas.setPixel(projectile.position.x.toInt(), projectile.position.y.toInt(), color, translateHorizontally = true)

    var projectileFired = projectile
    var tickCount = 0
    while(projectileFired.position.y > 0) {
        projectileFired = tick(projectileFired, environment)
        canvas.setPixel(projectileFired.position.x.toInt(), projectileFired.position.y.toInt(), color, translateHorizontally = true)
        tickCount++
        println("Position after $tickCount ticks: ${projectileFired.position}")
    }

    toPPM(canvas, "projectile.ppm")
}