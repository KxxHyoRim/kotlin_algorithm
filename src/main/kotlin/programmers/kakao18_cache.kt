package programmers

import java.util.*

fun solution(cacheSize: Int, cities: List<String>): Int {
    var answer = 0

    val set = LinkedList<String>()

    cities.map { city ->
        val lowerCase = city.lowercase(Locale.getDefault())
        answer += if (set.contains(lowerCase)) 1 else 5

        if (set.isNotEmpty() && set.size == cacheSize) {
            set.removeFirst()
        }
        set.add(lowerCase)
    }

    println(answer)

    return answer
}

fun main() {


    val v1 = listOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA")
    val v2 = listOf("Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul")
    val v3 = listOf(
        "Jeju",
        "Pangyo",
        "Seoul",
        "NewYork",
        "LA",
        "SanFrancisco",
        "Seoul",
        "Rome",
        "Paris",
        "Jeju",
        "NewYork",
        "Rome"
    )
    val v4 = listOf(
        "Jeju",
        "Pangyo",
        "Seoul",
        "NewYork",
        "LA",
        "SanFrancisco",
        "Seoul",
        "Rome",
        "Paris",
        "Jeju",
        "NewYork",
        "Rome"
    )
    val v5 = listOf("Jeju", "Pangyo", "NewYork", "newyork")
    val v6 = listOf("Jeju", "Pangyo", "Seoul", "NewYork", "LA")

    solution(3, v1)
    solution(3, v2)
    solution(2, v3)
    solution(5, v4)
    solution(2, v5)
    solution(0, v6)

}