package programmers.kakao21_intern

class Solution {
    val mx1 = arrayOf(0, 0, -1, 1) // 상하좌우
    val my1 = arrayOf(-1, 1, 0, 0)

    val mx2 = arrayOf(-1, 1, 1, -1) // 대각선 2
    val my2 = arrayOf(-1, -1, 1, 1)

    val dx = mutableListOf(arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1))
    val dy = mutableListOf(arrayOf(0, -1), arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0))

    val mx3 = arrayOf(0, 0, -2, 2)
    val my3 = arrayOf(-2, 2, 0, 0)

    fun solution(places: Array<Array<String>>): IntArray {

        val answer = mutableListOf<Int>()
        val n = places.size

        for (i in 0 until n) { // 5 x 5 map 하나씩 검사
            println("$i 번쨰 map 검사")
            val map = places[i]
            var isPossible = true

            loop@ for (y in 0 until 5) {
                for (x in 0 until 5) {
                    if (map[y][x] != 'P') continue

                    for (j in 0 until 4) {
                        val nx = x + mx1[j]
                        val ny = y + my1[j]

                        if (nx in 0..4 && ny in 0..4) {
                            val c = map[ny][nx]
                            if (c == 'P') {
                                isPossible = false
                                break@loop
                            }
                        }

                    }
                    for (j in 0 until 4) {
                        val nx = x + mx2[j]
                        val ny = y + my2[j]

                        if (nx in 0..4 && ny in 0..4) {
                            val char = map[ny][nx]
                            if (char == 'P') {
                                val cx1 = x + dx[j][0]
                                val cy1 = y + dy[j][0]

                                val cx2 = x + dx[j][1]
                                val cy2 = y + dy[j][1]

                                if (map[cy1][cx1] != 'X' || map[cy2][cx2] != 'X') {
                                    isPossible = false
                                    break@loop
                                }
                            }
                        }
                    }

                    for (j in 0 until 4) {
                        val nx = x + mx3[j]
                        val ny = y + my3[j]

                        if (nx in 0..4 && ny in 0..4) {
                            val char = map[ny][nx]
                            if (char == 'P') {
                                val cx = x + mx1[j]
                                val cy = y + my1[j]
                                if (map[cy][cx] != 'X') {
                                    isPossible = false
                                    break@loop
                                }
                            }
                        }

                    }
                }
            }
            when (isPossible) {
                true -> answer.add(1)
                false -> answer.add(0)
            }
        }
        println(answer)
        return answer.toIntArray()
    }
}

fun main() {
    val places = arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
    )

    Solution().solution(places)
}