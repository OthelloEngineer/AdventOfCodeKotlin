import java.io.File
import java.io.InputStream

fun main(args: Array<String>){
    println("hey")
    println(countIncreasedBlock())
 }

 fun countIncreased(): Int {
     var previousLine = 0
     var amountIncreased = 0
     val inputValue = getLinesFromFile()

     inputValue.forEach { string ->
         val nextValue = string.toInt()
         println("previous: $previousLine next: ${string.toInt()}")
         if(nextValue > previousLine){
             println("Amount was increased")
                 amountIncreased++
         }
         previousLine = string.toInt()
     }

    return amountIncreased-1
 }

fun countIncreasedBlock(): Int {
    var counter = 0
    var startIndex = 0
    var amountIncreased = 0
    val previousBlock: IntArray = intArrayOf(0,0,0)
    val inputValue = getLinesFromFile()


    inputValue.forEach { String ->
        if (counter >= 3 && previousBlock[startIndex] < String.toInt() ) {
            amountIncreased++
        }
        previousBlock[startIndex] = String.toInt()
        startIndex = ++counter%3
    }

    return amountIncreased
}

fun getLinesFromFile(): List<String> {
    val inputStream: InputStream = File("1dec/1December1.txt").inputStream()
    return inputStream.bufferedReader().use { it.readLines() }
}
