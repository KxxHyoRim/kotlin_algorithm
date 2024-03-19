package programmers.kakao19

class BadUser {
    private lateinit var userList: Array<String>
    private lateinit var bannedList: Array<String>
    private val result = HashSet<HashSet<String>>()

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        userList = user_id
        bannedList = banned_id

        val isVisited = BooleanArray(userList.size)
        dfs(isVisited, 0)

        return result.size
    }

    private fun dfs(isVisited: BooleanArray, bannedIdx: Int) {

        if (bannedIdx == bannedList.size) {

            val set = HashSet<String>()
            for (i in isVisited.indices) {
                val name = userList[i]
                val isVisit = isVisited[i]
                if (isVisit) {
                    set.add(name)
                }
            }
            result.add(set)
            return
        }
        val bannedId = bannedList[bannedIdx]

        for (idx in userList.indices) {
            if (isVisited[idx]) continue                      //❗️
            val userId = userList[idx]
            if (userId.length == bannedId.length) {
                var isFit = true
                for (i in userId.indices) {
                    // 한 문자씩 검사
                    if (bannedId[i] == '*') continue
                    if (bannedId[i] != userId[i]) {
                        isFit = false
                        break
                    }
                }

                if (isFit) {
                    check(userList[idx] == userId)
                    isVisited[idx] = true
                    dfs(isVisited, bannedIdx + 1)
                    isVisited[idx] = false

                }
            }
        }

    }

}


fun main() {
    BadUser().solution(
        user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        banned_id = arrayOf("fr*d*", "abc1**")
    )
    BadUser().solution(
        user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        banned_id = arrayOf("fr*d*", "abc1**")
    )
}