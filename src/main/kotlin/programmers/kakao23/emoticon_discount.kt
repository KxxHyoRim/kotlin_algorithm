package programmers.kakao23

class Solution {
    val discountRate = MutableList(7) { 0 }
    var emoNum = 0
    lateinit var users: Array<IntArray>
    lateinit var emoticons: IntArray

    var joinPeople = 0
    var money = 0

    fun combi(idx: Int) {
        if (idx == emoNum) return

        for (i in 1..4) {
            discountRate[idx] = i * 10
            combi(idx + 1)
            if (idx == emoNum - 1) {
                calc()
            }
        }
    }

    fun calc() {

        var tempJoinPeople = 0
        var tempMoney = 0

        for (user in users) {
            val rate = user[0]
            val limit = user[1]
            var sum = 0
            for (i in 0 until emoNum) {
                if (discountRate[i] >= rate) {
                    sum += (emoticons[i] * (100 - discountRate[i]) / 100)
                }
            }
            if (sum >= limit) {
                tempJoinPeople++
                //tempMoney += limit
            } else if (sum < limit) {
                tempMoney += sum
            }
        }

        if (tempJoinPeople > joinPeople) {
            joinPeople = tempJoinPeople
            money = tempMoney
        } else if (tempJoinPeople == joinPeople) {
            money = maxOf(money, tempMoney)
        }

    }

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        emoNum = emoticons.size
        this.users = users
        this.emoticons = emoticons

        combi(0)

        var answer: IntArray = intArrayOf(joinPeople, money)
        return answer
    }
}