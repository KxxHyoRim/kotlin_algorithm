package programmers.kakao20

class LockAndKey {


    fun rotate(key: Array<IntArray>): Array<IntArray> {
        val n = key.size
        val newKey: Array<IntArray> = Array(n) { IntArray(n) }
        for (y in 0 until n) {
            for (x in 0 until n) {
                val value = key[y][x]
                newKey[x][n - 1 - y] = value
            }
        }
        return newKey
    }

    fun getPaddingLock(lock: Array<IntArray>, n: Int, m: Int): Array<IntArray> {
        val newLockSize = n + (m - 1) * 2
        val newLock: Array<IntArray> = Array(newLockSize) { IntArray(newLockSize) }
        val start = m - 1
        val end = (m - 1) + (n - 1)

        for (y in start..end) {
            for (x in start..end) {
                newLock[y][x] = lock[y - m + 1][x - m + 1]
            }
        }
        return newLock
    }

    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val m = key.size
        val n = lock.size

        // 키 회전시킨거 조합 구하기
        val keys = mutableListOf<Array<IntArray>>()
        keys.add(key)
        var prev = key
        for (i in 0 until 3) {
            val newKey = rotate(prev)
            keys.add(newKey)
            prev = newKey
        }

        // paddingLock 적용된거 구하기
        val paddingLock = getPaddingLock(lock, n, m)
        val newN = n + (m - 1) * 2

        // key 이동하면서 검사
        val move = n + (m - 1) - 1

        for (key in keys) {
            for (dy in 0..move) {
                for (dx in 0..move) {
                    // case
                    val dolgis = hashSetOf<Pair<Int, Int>>()

                    // key의 돌기부분 추출
                    for (y in 0 until m) {
                        for (x in 0 until m) {
                            val nx = x + dx
                            val ny = y + dy
                            if (key[y][x] == 1) dolgis.add(nx to ny)
                        }
                    }

                    var isFit = true

                    outer@ for (y in m - 1..(n - 1) + (m - 1)) {
                        for (x in m - 1..(n - 1) + (m - 1)) {
                            if (paddingLock[y][x] == 1) { // 둘다 돌기이면 안됨
                                if (dolgis.contains(x to y)) {
                                    isFit = false
                                    break@outer
                                }
                            } else { // 0인경우 무조건 키가 있어야함
                                if (!dolgis.contains(x to y)) {
                                    isFit = false
                                    break@outer
                                }
                            }
                        }
                    }
                    if (isFit) return true
                }
            }

        }


        return false
    }
}

fun main() {
    val key = arrayOf(intArrayOf(0, 0, 1), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
    val lock = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    println(LockAndKey().solution(key, lock))
}