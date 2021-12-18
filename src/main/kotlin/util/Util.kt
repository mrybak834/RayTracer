package util

import kotlin.math.abs

class Util {
    companion object {
        val epsilon: Double = 0.00001

        // Compares doubles within an epsilon tolerance
        fun equals(expected: Double, actual: Double, epsilon: Double): Boolean {
            return abs(expected - actual) <= epsilon
        }
    }

}