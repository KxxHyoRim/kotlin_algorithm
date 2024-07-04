package programmers.algorith_high_score_kit.dfs_bfs

class WordConverting {

    fun solution(begin: String, target: String, words: Array<String>): Int {

        val visited = HashSet<String>()

        fun dfs(current: String, count: Int): Int {
            if (current == target) return count

            visited.add(current)

            var minCount = Integer.MAX_VALUE
            for (word in words) {
                if (!visited.contains(word) && differsByOne(current, word)) {
                    minCount = minOf(minCount, dfs(word, count + 1))
                }
            }

            return minCount
        }

        var answer = dfs(begin, 0)
        if (answer == Int.MAX_VALUE) answer = 0
        return answer
    }

    private fun differsByOne(a: String, b: String): Boolean {
        var diff = 0
        for (i in a.indices) {
            if (a[i] != b[i]) diff++
        }
        return diff == 1
    }

}