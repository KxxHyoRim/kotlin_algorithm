package programmers.kakao19

class OpenChatRoom {
    fun solution(record: Array<String>): Array<String> {

        val map = mutableMapOf<String, String>() // uid, nickname

        for (r in record) {
            val instruction = r.split(" ")[0]
            val uid = r.split(" ")[1]
            when (instruction) {
                "Enter", "Change" -> {
                    val newNickname = r.split(" ")[2]
                    map[uid] = newNickname
                }
            }
        }

        val answer = mutableListOf<String>()

        for (r in record) {
            val instruction = r.split(" ")[0]
            val uid = r.split(" ")[1]
            val currNickname = map[uid]

            when (instruction) {
                "Enter" -> answer.add("${currNickname}님이 들어왔습니다.")
                "Leave" -> answer.add("${currNickname}님이 나갔습니다.")
            }
        }
        println(answer)
        return answer.toTypedArray()
    }
}

fun main() {

    val array1 = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )

    OpenChatRoom().solution(array1)

}