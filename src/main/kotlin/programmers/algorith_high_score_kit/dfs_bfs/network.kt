package programmers.algorith_high_score_kit.dfs_bfs

class Network {
    var isVisited = mutableListOf<Boolean>()
    var size = -1
    lateinit var computers: Array<IntArray>
    var answer = 0

    fun initIsVisited(size: Int) {
        isVisited = MutableList(size) { false }
    }

    fun bfs(idx: Int) {
        isVisited[idx] = true
        for (i in 0 until size) {
            if (i == idx) continue
            if (!isVisited[i] && computers[idx][i] == 1) {
                bfs(i)
            }
        }
    }


    fun solution(n: Int, computers: Array<IntArray>): Int {
        size = computers.size
        this.computers = computers

        initIsVisited(size)

        for (i in 0 until size) {
            if (!isVisited[i]) {
                bfs(i)
                answer++
            }
        }
        println(answer)
        return answer
    }
}