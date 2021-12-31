package util

import kotlin.math.abs

fun Double.equalsE(b: Number, epsilon: Double = 0.00001): Boolean {
    if (abs(b.toDouble() - this) <= epsilon) {
        return true
    } else {
        return false
    }
    return abs(b.toDouble() - this) <= epsilon
}