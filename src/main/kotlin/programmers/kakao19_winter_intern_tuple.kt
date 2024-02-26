package programmers

class Tuple {
    fun solution(s: String): IntArray {
        val len = s.length
        var str = s.substring(1, len - 1)
        str = str.replace("{", "")
        val list: MutableList<MutableList<Int>> = mutableListOf()

        str.split("}").forEach { tuple ->
            if (tuple.isNotEmpty()) {
                val temp = tuple.split(",").filter { it.isNotEmpty() }.map { it.toInt() }.toMutableList()
                list.add(temp)
            }

        }
        val sortedList = list.sortedBy { it.size }
        println(sortedList)

        val answer = mutableListOf<Int>()

        sortedList.map {
            println("it : $it")
            val set = it.toSet() - answer.toSet()
            println("set : $set")
            answer.add(set.toIntArray()[0])
        }

        println("answer : $answer")
        return answer.toIntArray()
    }
}

fun main() {

    Tuple().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")
    Tuple().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")
    Tuple().solution("{{20,111},{111}}")
    Tuple().solution("{{123}}")
    Tuple().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")

}