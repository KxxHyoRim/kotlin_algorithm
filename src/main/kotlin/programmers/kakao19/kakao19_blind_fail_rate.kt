package programmers.kakao19

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {

        val failN = MutableList(N + 1) { 0 }
        val arriveN = MutableList(N + 1) { 0 }

        // 배열에 값 채워넣기
        for (stage in stages) {
            for (i in 1..stage) {
                if (i == N + 1) continue
                arriveN[i]++
            }
            if (stage <= N) failN[stage]++
        }
        val failureAndStage = mutableListOf<Pair<Double, Int>>()
        // 실패율 계산
        for (i in 1..N) {
            val failure: Double = when {
                arriveN[i] == 0 -> 0.0
                else -> failN[i].toDouble() / arriveN[i]
            }
            failureAndStage.add(failure to i)
        }
        failureAndStage.sortWith(compareBy<Pair<Double, Int>> { -it.first }.thenBy { it.second })

        return failureAndStage.map { it.second }.toIntArray()
    }
}

fun main() {

    println(Solution().solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)))
    println(Solution().solution(4, intArrayOf(4, 4, 4, 4, 4)))

}

// 실패율 = 실패한사람 / 도달 명수
// 배열이 2개 필요함 : 실패한 사람 명수, 도달 명수 각각 담을것
// index 주의 0은 안쓰는중
// N이 5인경우 : stage가 면 5번째 단계를 못푼사람, 6이면 다 푼사람
// 주의 : 도달한 사람이 0이면 실패율 0이다

// 정렬 : 실패율이 동일할 경우 stage 번호로 정렬
// list(pair(실패율, stage 번호)
