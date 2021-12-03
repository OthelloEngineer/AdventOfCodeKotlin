import java.io.File
import java.io.InputStream

fun main() {
    println(locationCalculator(directionParser()))
}

fun locationCalculator(moveSet: MutableList<Movement>) : Int{
    var depth: Int = 0
    var length: Int = 0

    for (movement in moveSet) {
        when(movement.direction){
            Direction.DOWN -> {depth+=movement.amount}
            Direction.UP -> {depth-=movement.amount}
            Direction.FORWARD -> {length += movement.amount}
        }
    }
    return depth*length
}

enum class Direction(){
    FORWARD, DOWN, UP
}
fun getLinesFromFile(): List<String> {
    val inputStream: InputStream = File("2dec/2December.txt").inputStream()
    return inputStream.bufferedReader().use { it.readLines() }
}
fun directionParser() : MutableList<Movement> {
    val moveSetList : MutableList<Movement> = mutableListOf()
    val stringList: List<String> = getLinesFromFile()
    stringList.forEach { string ->
        val moveSet: List<String> = string.split(' ')
        when(moveSet[0]) {
            "forward" -> {moveSetList.add(Movement(Direction.FORWARD,moveSet[1]))}
            "down" -> {moveSetList.add(Movement(Direction.DOWN,moveSet[1]))}
            "up" -> {moveSetList.add(Movement(Direction.UP,moveSet[1]))}
        }
    }
    return moveSetList
}

class Movement constructor (
    val direction: Direction,
    val amount: Int,
) {constructor(direction: Direction, amount: String) : this(direction,amount.toInt()) }
