package beakjoon.set

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    br.readLine()

    val list = br.readLine().split(" ").map(String::toInt).toIntArray()
    val sortedUniqueList = list.toSortedSet().toList()
    val indexMap = sortedUniqueList.withIndex().associate { (index, value) -> value to index }
    // withIndex() 는 mapIndexed랑 동일.

    // 현재 상황에서는 associate에서 본격적으로 transform이 일어나기 떄문에, withIndex를 쓴듯하다
    // GPT : In summary, while both withIndex() and mapIndexed() provide access to the index during iteration,
    // withIndex() is mainly used for iteration while
    // mapIndexed() is primarily used for transformation.

    // associate는 collection map으로 바꾸는애!
    list.forEach { bw.write("${indexMap[it]} ") }

    bw.flush()
}