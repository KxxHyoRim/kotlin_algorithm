package programmers.kakao19

class Tuple {
    fun solution(s: String): IntArray {
        return s.substring(2 until s.length - 2)
            .split("},{") // List<String>
            .map { it.split(",").map { num -> num.toInt() } } // List<List<Int>>, 여기까지 list는 immutable type이다
            .sortedBy { it.size } // List<List<Int>>
            .fold(setOf<Int>()) { acc, ints -> println("$acc $ints"); acc.union(ints) } // 빈 set에다가 추가되는걸 하나씩 더해나감
            .toIntArray()
    }
}

fun main() {

    Tuple().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")
    Tuple().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")
    Tuple().solution("{{20,111},{111}}")
    Tuple().solution("{{123}}")
    Tuple().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")

}