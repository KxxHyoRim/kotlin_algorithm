package programmers

class EngVocab {
    fun solution(s: String): Int {
        val wordToDigitMap = mapOf(
            "zero" to "0",
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )

        var temp = s
        wordToDigitMap.forEach { (word, digit) ->
            temp = temp.replace(word, digit)
        }

        return temp.toInt()
    }
}

// zerozero 도 정상적으로 바뀌는지 확인
fun main() {
    println(EngVocab().solution("zerozero"))
    println(EngVocab().solution("one4seveneight"))
    println(EngVocab().solution("23four5six7"))
    println(EngVocab().solution("2three45sixseven"))
    println(EngVocab().solution("123"))

}