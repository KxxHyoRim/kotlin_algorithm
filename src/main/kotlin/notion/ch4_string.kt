package notion

import java.util.*

fun main() {
    val s = "hello"
    var s2 = StringBuilder(s)
    s2[0] = 'a'
    println(s2) // aello
    s2.deleteAt(0) // 0번째 인덱스의 원소 제거
    println(s2) // ello
    var s3 = s2.slice(0..1) // slicing
    println(s3) // el
    println("this : ${s[0].isUpperCase()}")

    var s4 = " hello "
    s4 = s4.trim()
    println(s4) // "hello"

    /* Group by */
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val map = numbers.groupingBy { it }.eachCount() // {1=1, 2=1, 3=1, 4=1, 5=1, 6=1}

    val str = "abcda"
    val map2 = numbers.groupingBy { it }.eachCount() // {a=2, b=1, c=1, d=1}

    /* Priority Queue */
    // min heap이 default
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
}