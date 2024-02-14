package beakjoon.divide_and_conquer

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// bfs말고 분할정복을 써야하는 이유
// size 하나씩 늘려가면서  역 ㄴ자 형태로 검사해나가야함
// 지나간곳은 VISITED로 처리
// 만약 다른색이 나오면
// size -- 하고 VISITED 복구

// 이방식대로 하면 문제가-> 사실상 n이 8이고 size가 3인 정사각형은 탐색할 필요가 없는데 이런걸 일일히 체크해야하고
// VISITED도 기껏 표시 다해뒀다가 다시 복구해야하고, 그런 문제가 있을듯

var white = 0
var blue = 0
lateinit var arr: Array<IntArray>

fun divAndConquer(x: Int, y: Int, n: Int) {
    val color = arr[y][x]
    var isOneColor = true

    // 이중 포문 break 하는 방법이다
    // @ 앞에 어떠한 string을 넣어도 상관 없음
    loop@ for (ny in y until y + n) {
        for (nx in x until x + n) {
            if (arr[ny][nx] != color) {
                isOneColor = false
                break@loop
            }
        }
    }

    if (n == 1 || isOneColor) {
        when (color) {
            0 -> white++
            1 -> blue++
        }
        return
    }

    divAndConquer(x, y, n / 2)
    divAndConquer(x + n / 2, y, n / 2)
    divAndConquer(x, y + n / 2, n / 2)
    divAndConquer(x + n / 2, y + n / 2, n / 2)
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    // 다른 사람 코드 보니까 0, 1을 굳이 Int형으로 안바꾸고 string으로 그대로 쓰면 20ms 정도 빨라지는듯?
    arr = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    divAndConquer(0, 0, n)
    bw.write("$white\n$blue")
    bw.flush()
}