package programmers.kakao24_intern

import java.lang.Integer.max

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val n = friends.size

        val board = MutableList(n) { MutableList(n) { 0 } }

        val hashMap = mutableMapOf<String, Int>()
        for ((idx, f) in friends.withIndex()) {
            hashMap[f] = idx
        }

        for (gift in gifts) {
            val (from, to) = gift.split(" ")
            val fromIdx = hashMap[from]!!
            val toIdx = hashMap[to]!!
            board[fromIdx][toIdx]++
        }

        // 선물 지수 구하기
        val points = MutableList(n) { 0 }

        for (i in 0 until n) {
            var give = 0
            for (x in 0 until n) {
                give += board[i][x]
            }
            var get = 0
            for (y in 0 until n) {
                get += board[y][i]
            }
            points[i] = give - get;
        }

        // 계산하기
        val giftNum = MutableList(n) { 0 }
        for (y in 0 until n) {
            for (x in y until n) {
                if (x == y) continue
                val n1 = board[y][x] // 준선물
                val n2 = board[x][y] // 받은선물

                if ((n1 == 0 && n2 == 0) || (n1 == n2)) { // 기록이 없거나 횟수가 같다면
                    val p1 = points[y]
                    val p2 = points[x]
                    if (p1 > p2) {
                        giftNum[y]++
                    } else if (p1 < p2) {
                        giftNum[x]++
                    } else {
                        // 같다면 아무밍ㄹ도 안일어남
                    }
                } else { // 선물 주고받은 기록 있음
                    if (n1 > n2) {
                        giftNum[y]++
                    } else if (n1 < n2) {
                        giftNum[x]++
                    } else {
                        println("이건 없는일 ")
                    }
                }
            }
        }

        var maxGift = 0;
        for (g in giftNum) {
            maxGift = max(maxGift, g)
        }
        println(maxGift)

        return maxGift
    }
}

fun main() {
    val friends1 = arrayOf("muzi", "ryan", "frodo", "neo")
    val gifts1 = arrayOf(
        "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi",
        "frodo ryan", "neo muzi"
    )

    val friends2 = arrayOf("joy", "brad", "alessandro", "conan", "david")
    val gifts2 =
        arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david")

    val friends3 = arrayOf("a", "b", "c")
    val gifts3 = arrayOf("a b", "b a", "c a", "a c", "a c", "c a")

    Solution().solution(friends1, gifts1)
    Solution().solution(friends2, gifts2)
    Solution().solution(friends3, gifts3)

}