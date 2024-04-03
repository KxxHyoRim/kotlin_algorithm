package programmers.kakao22

class Reported {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

        val map = hashMapOf<String, HashSet<String>>()

        for (r in report) {
            val (good, bad) = r.split(" ")
            map.getOrPut(bad) { hashSetOf() }.add(good)
        }

        val reported = map.filter { it.value.size >= k }
//        val reported = map.filterValues { it.size >= k }
        val idIndexMap = id_list.withIndex().associate { (index, id) -> id to index }

        val answer = IntArray(id_list.size)

        reported.forEach {
            it.value.forEach {
                val idx = idIndexMap.getOrDefault(it, -1)
                answer[idx]++
            }
        }
        return answer
    }
}

fun main() {

    val id_list1 = arrayOf("muzi", "frodo", "apeach", "neo")
    val report1 = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
    val k1 = 2

    Reported().solution(id_list1, report1, k1)

    val id_list2 = arrayOf("con", "ryan")
    val report2 = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
    val k2 = 3

    Reported().solution(id_list2, report2, k2)

}