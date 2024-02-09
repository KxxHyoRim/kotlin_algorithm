package beakjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.min
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val hashSet = hashSetOf<Char>()
    if (m != 0) {
        br.readLine().split(' ').map {
            hashSet.add(it[0])
        }
    }
    val current = 100

    // 1. +, -눌러서 이동하는 경우
    val diff = if (n > current) n - current else current - n
//    println(diff)

    var goDown = n
    var goUp = n

    if (hashSet.size == 10) {
        println(diff)
        exitProcess(0)
    }

    while (goDown >= 0 && goUp < Int.MAX_VALUE) {


//        println("$goDown $goUp")
        var goDownAvailable = true
        var goUpAvailable = true
        for (char in goDown.toString()) {
            if (hashSet.contains(char)) {
                goDownAvailable = false
                break
            }
        }
        for (char in goUp.toString()) {
            if (hashSet.contains(char)) {
                goUpAvailable = false
                break
            }
        }
        val step: Int? = if (goDownAvailable) {
            goDown.toString().length + n - goDown
        } else if (goUpAvailable) {
            goUp.toString().length + goUp - n
        } else null

        if (step != null) {
            println(min(diff, step))
            break
        }

        if (goDown != 0) goDown--
        if (goUp < Int.MAX_VALUE - 1) goUp++
    }

}

