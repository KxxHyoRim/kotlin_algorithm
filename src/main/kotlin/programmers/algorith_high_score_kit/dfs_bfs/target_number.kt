package programmers.algorith_high_score_kit.dfs_bfs

class TargetNumber {
    private var target = -1
    private var numbers = intArrayOf()
    private var n = -1
    var answer = 0


    fun dfs(size: Int, op: MutableList<Char>) {
        if (size == n) { // 종료 조건
            var sum = 0
//            print(numbers[0])
            op.withIndex().forEach {
                val idx = it.index
                when (it.value) {
                    '+' -> {
//                        print("+${numbers[idx]}")
                        sum += numbers[idx]
                    }

                    '-' -> {
//                        print("-${numbers[idx]}")
                        sum -= numbers[idx]
                    }
                }
            }
//            println("=$sum")
            if (sum == target) {
                answer++
            }
            return
        }

        try {
            op[size] = '+'
        } catch (e: Exception) {
            op.add(size, '+')
        }
        dfs(size + 1, op)
        op[size] = '-'
        dfs(size + 1, op)
    }


    fun solution(numbers: IntArray, target: Int): Int {
        this.target = target
        this.numbers = numbers
        this.n = numbers.size
        dfs(0, mutableListOf())
//        println(answer)
        return answer
    }
}