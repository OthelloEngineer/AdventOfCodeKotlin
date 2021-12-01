import java.io.File
import java.io.InputStream

fun main(args: Array<String>){
     println("hey")
    println(countIncreased())
 }

 fun countIncreased(): Int {

     var previousLine = 0
     var amountIncreased = 0
     val inputStream: InputStream = File("D:\\SDUProjects\\AdventOfCode\\1dec1\\src\\1December1.txt").inputStream()
     val inputValue = inputStream.bufferedReader().use { it.readLines() }

     inputValue.forEach {
             string ->
         var nextValue = string.toInt()
         println("previous: ${previousLine} next: ${string.toInt()}")
         if(nextValue > previousLine){
             println("Amount was increased")
                 amountIncreased++
         }
         previousLine = string.toInt()
     }
    return amountIncreased-1
 }
