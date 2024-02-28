package programmers.kakao22

import kotlin.math.sqrt

class Prime {
    private fun Long.isPrime(): Boolean {
        val n = this@isPrime
        if (n <= 1) return false // 2보다 큰 자연수 중에
        for (i in 2..sqrt(n.toDouble()).toLong()) {
            if (n % i == 0L) return false
        }
        return true    // 모두 반복해도 나누어 떨어지지 않으면 소수
    }

    fun solution(n: Int, k: Int): Int {
        val convertedNum = n.toString(k)
        var answer = 0

        convertedNum.split("0")
            .filter { it.isNotEmpty() } // 00의경우 split을 적용하면 ""이 나옴
            .map { it.toLong() }
            .groupingBy { it }
            .eachCount()
            .filter { it.key.isPrime() }
            .onEach { answer += it.value }

        return answer
    }
}

fun main() {


//    println("${Prime().solution(437674, 3)} 답 : 3")
//    println("${Prime().solution(110011, 10)} 답 : 2")
    println("${Prime().solution(4, 7)}")
    println("${Prime().solution(1000000, 4)}")
    println("${Prime().solution(1000000, 5)}")
    println("${Prime().solution(1000000, 10)}")
//    println("${Prime().solution(110011, 10)} 답 : 2")
}