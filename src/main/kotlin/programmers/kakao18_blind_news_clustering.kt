package programmers

import java.lang.Math.floor
import kotlin.math.max
import kotlin.math.min


fun String.toMultiSet(): List<String> {
    val multiSet = mutableListOf<String>()
    this.windowed(2) { str ->
        if (str.all { it.isLetter() })
            multiSet.add(str[0].lowercase() + str[1].lowercase())
    }
    return multiSet
}

fun solution(str1: String, str2: String): Int {
    var list1 = mutableListOf<String>()
    var list2 = mutableListOf<String>()

    str1.lowercase().fold("") { a, b -> list1.add("$a$b");"$b" }
    list1 = list1.drop(1) // 처음 원소는 길이가 1이다
        .filter { it[0].isLetter() && it[1].isLetter() }
        .toMutableList()


    str2.lowercase().fold("") { a, b -> list2.add("$a$b");"$b" }

    list2 = list2.drop(1) // 처음 원소는 길이가 1이다
        .filter { it[0].isLetter() && it[1].isLetter() }
        .toMutableList()

    if (list1.isEmpty() && list2.isEmpty()) return 65536


    val map1 = list1.groupingBy { it }.eachCount().toSortedMap()
    val map2 = list2.groupingBy { it }.eachCount().toSortedMap()
    val keys = map1.keys + map2.keys

    var intersect = 0
    var union = 0


    for (key in keys) {
        intersect += min(map1[key] ?: 0, map2[key] ?: 0)
        union += max(map1[key] ?: 0, map2[key] ?: 0)
    }

    val ratio: Double = intersect.toDouble() / union
    val answer = floor(ratio * 65536).toInt()

    println(answer)

    return answer
}

fun main() {
    solution("FRANCE", "french")
    solution("handshake", "shake hands")
    solution("aa1+aa2", "AAAA12")
    solution("E=M*C^2", "e=m*c^2")
}