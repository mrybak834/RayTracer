package util

import kotlin.math.abs

fun Double.equalsE(b: Number, epsilon: Double = 0.00001): Boolean {
    return abs(b.toDouble() - this) <= epsilon
    return abs(b.toDouble() - this) <= epsilon
}