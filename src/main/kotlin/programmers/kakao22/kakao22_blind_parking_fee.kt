package programmers.kakao22

import kotlin.math.ceil

// 주차 요금 계산

// 출차 내역 없을 시-> 23:59 출차
// fees : 기본시간, 기본 요금, 단위시간, 단위 요금
// records :  "05:34 5961 IN" 시간, 차번호, 입출차

// map 2개 만들어서 IN, OUT 정보 저장
// map 하나 더 만듦 key: 차량번호, value : 주차 요금
// 주차 시간 계산
// 만약 주차 시간이 기본시간 이하면 기본 요금
// 초과 : 기본요금 + 초과시간 * 초과요금


class ParkingFee {

    private fun calcStayingTime(enter: String, out: String): Int {
        val (h1, m1) = enter.split(":").map { it.toInt() }
        val (h2, m2) = out.split(":").map { it.toInt() }
        val hour = h2 - h1
        val min = m2 - m1
        return hour * 60 + min
    }

    fun solution(fees: IntArray, records: Array<String>): IntArray {

        val recordsIn = mutableMapOf<Int, String>() // (차번호 : 입차시간)
        val recordsTime = mutableMapOf<Int, Int>()// (차번호 : 주차 분)
        val baseTime = fees[0]
        val baseFee = fees[1]
        val unitTime = fees[2]
        val unitFee = fees[3]

        for (record in records) {
            val (time, carNum, info) = record.split(" ")
            when (info) {
                "IN" -> recordsIn[carNum.toInt()] = time
                "OUT" -> {
                    val enterTime = recordsIn[carNum.toInt()]!!
                    val outTime = time
                    val stayTime = calcStayingTime(enterTime, outTime)
                    val carN = carNum.toInt()
                    recordsIn.remove(carN)
                    recordsTime[carN] = (recordsTime[carN] ?: 0) + stayTime
                }
            }
        }

        for (record in recordsIn) {
            val outTime = "23:59"
            val carNum = record.key
            val enterTime = record.value
            val stayTime = calcStayingTime(enterTime, outTime)

            recordsTime[carNum] = (recordsTime[carNum] ?: 0) + stayTime
        }


        for (record in recordsTime) {
            val stayTime = record.value
            val carNum = record.key

            val addedFee = ceil((stayTime - baseTime).toDouble() / unitTime).toInt() * unitFee

            recordsTime[carNum] = when {
                stayTime <= baseTime -> baseFee
                else -> baseFee + addedFee
            }
        }

        return recordsTime.map { (it.key to it.value) }
            .sortedWith(compareBy { it.first })
            .map { it.second }
            .toIntArray()
    }
}

fun main() {


    ParkingFee().solution(
        fees = intArrayOf(180, 5000, 10, 600),
        records = arrayOf(
            "05:34 5961 IN",
            "06:00 0000 IN",
            "06:34 0000 OUT",
            "07:59 5961 OUT",
            "07:59 0148 IN",
            "18:59 0000 IN",
            "19:09 0148 OUT",
            "22:59 5961 IN",
            "23:00 5961 OUT"
        )
    )
}
