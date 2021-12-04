import java.io.File
import java.io.InputStream
import java.util.*

fun main() {
    val bitStrings: MutableList<String> = getLinesFromFile() as MutableList<String>
    val answer1 = bitCounter(bitStrings,0,true)
    val answer2 =bitCounter(bitStrings,0,false)
    print(answer2*answer1)
}




fun getLinesFromFile(): List<String> {
    val inputStream: InputStream = File("3dec/3December.txt").inputStream()
    return inputStream.bufferedReader().use { it.readLines() }
}

fun stringFilter(removeChar: Char, bitStrings: MutableList<String>, index: Int ): MutableList<String>{
    val validBitStrings: MutableList<String> = bitStrings.filter{ s: String -> s.get(index) != removeChar } as MutableList<String>

    return validBitStrings
}

fun bitCounter(validBitStrings: MutableList<String>, index: Int, higher: Boolean): Int {
    var value: Int = 0
    var answer: Int = 0
    for (string in validBitStrings) {
        if (validBitStrings.size == 1) {
            println(validBitStrings.get(0))
            println(Integer.parseInt(validBitStrings.get(0),2))
            return Integer.parseInt(validBitStrings.get(0),2)
        }
        if (string.get(index) == '0') value -= 1
        else value += 1
    }

    var newIndex: Int = index + 1
    if (value >= 0 == higher)
        answer = bitCounter(stringFilter('0', validBitStrings, index), newIndex, higher)
    else answer = bitCounter(stringFilter('1', validBitStrings, index), newIndex, higher)

    return answer
}

fun bitCounterBaseFunction(){


}

