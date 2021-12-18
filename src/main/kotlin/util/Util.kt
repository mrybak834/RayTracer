package util

import kotlin.math.abs

class Util {
    companion object {
        // Compares doubles within an epsilon tolerance
        fun equals(expected: Double, actual: Double, epsilon: Double = 0.00001): Boolean {
            return abs(expected - actual) <= epsilon
        }
    }

}