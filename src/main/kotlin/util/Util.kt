package util

import kotlin.math.abs

fun Double.equalsE(b: Double, epsilon: Double = 0.00001): Boolean {
    return abs(b - this) <= epsilon
}