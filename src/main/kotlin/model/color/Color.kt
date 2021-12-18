//package model.color
//
//import model.tuple.Tuple
//import util.Util
//
//data class Color(
//    val red: Double,
//    val green: Double,
//    val blue: Double
//): Tuple(red, green, blue) {
//    override fun equals(other: Any?) =
//        if (other is Tuple) Util.equals(x, other.x) && Util.equals(y, other.y) && Util.equals(z, other.z) && Util.equals(w, other.w) else false
//
//    override fun hashCode(): Int {
//        var result = x.hashCode()
//        result = 31 * result + y.hashCode()
//        result = 31 * result + z.hashCode()
//        result = 31 * result + w.hashCode()
//        return result
//    }
//
//}
