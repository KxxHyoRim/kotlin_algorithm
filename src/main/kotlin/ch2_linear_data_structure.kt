import java.util.*

fun main() {

    /* array */
    val array = arrayOf(0, 1, 2, 3)
    array[0] = 100  // 0번째 idx 값 100으로 바꿔라
    // array[4] = 4 // indexOutOfBounds
    for (i in array.indices) { // == ( i in 0 until array.size)
        println("nx = ${array[i]}")
    }

    /* list */

    // 1) 불가변
    val list = listOf(-1, 1, 0, 0)
    list.indexOf(-1) // index 0을 반환 O(n)

    // 2) 가변
    /** mutableList와 arrayList는 기본적으로 유사함
     *
     *  arrayList는 JAVA 라이브러리 소속
     *  mutableList는 kotlin 라이브러리 소속
     *
     *  arrayList가 지원하는 함수 더 많음
     *  ex. 아래의 trimToSize(), ensureCapacity(n)
     *
     *  mutableList에서 위 함수들을 사용하고자 할 경우 타입캐스팅 후 사용가능
     *
     *  주요 연산자 속도
     *      * 조회 by index : O(1)
     *      * add : 주로 O(1) 최대 O(n)
     *      * 삭제, 검색 : O(n)
     * */

    val arrayList = arrayListOf(0, 0, -1, 1)
    arrayList.add(99)                   // 마지막에 값 추가
    arrayList.addAll(setOf(9, 7, 8, 9)) // 마지막에 값 추가 (순서대로)
    arrayList.add(2, 3)   // 2의 위치에 3 추가

    arrayList.remove(10)        // 없는 값 삭제해도 exception 안남
    arrayList.removeAt(4)         // index에 있는 값 삭제
    arrayList.remove(0)         // list에 지우려는 값이 여러개 있을 경우 처음 하나만 삭제됨
    arrayList.removeAll(listOf(0))      // 지우려는 값이 여러개 있을 경우 다 지워짐. 단일 값이 아니라 list목록을 넘겨줘야햠
    arrayList.removeLast()

    arrayList.clear()

    arrayList.trimToSize()              // 메모리 최적화
    arrayList.ensureCapacity(100) // 아래 주석 참고

    val bool: Boolean = arrayList.contains(3) // collection 함수임. 근데 시간복잡도가 O(n)이다
    println(bool)                             // 보완하려면 TreeMap, HashSet 사용하는게 맞음 O(1)
    println(arrayList)


    /** ensureCapacity(n)
     *
     * arrayList는 내부적으로 배열을 사용함.
     * element가 추가 될 때 마다 배열크기가 조정되는데,
     * 배열의 용량이 부족하면 새 배열을 할당하고 기존 요소들을 복사하는 작업이 수행됨
     * 이럴 경우 O(n)이 걸릴 수 있음.
     * 따라서 ensureCapacity 를 활용해 이후에 요소를 추가해도 내부 배열의 재할당을 최소화할 수 있음
     * */


    /** linkedList
     *
     *  주요 함수 속도
     *  - 접근 : O(n)
     *  - remove(), removeLast == 양끝 노드 삭제 : O(1)
     *  - remove(e) == 특정 노드 삭제 : O(n)
     *  - 특정 위치 노드 삽입 : O(n)
     *  - 양끝 노드 삽입 : O(1)
     *
     * */

    val linkedList = LinkedList(listOf(1, 2, 3))
    // add, offer
    linkedList.addFirst(0)    // arrayList와 달리 앞에 추가 가능
    linkedList.add(4)            // 마지막에 추가
    linkedList.addLast(5)     // 마지막에 추가

    linkedList.offer(10)      // capacity관련 excption이 발생안함 (알고리즘 레벨에서는 신경쓰지 않아도 됨)

    // remove, poll
    linkedList.remove()          // 맨 앞의 값 삭제 (add는 끝에 넣고, remove는 앞에 제거)
    linkedList.removeAt(1) // idx 위치의 원소 삭제
    linkedList.removeLast()      // 마지막 값 삭제
    linkedList.remove(3) // 특정 값 삭제 (없는 값을 넣어도 exception 안남)
    linkedList.clear()           // clear
    val nullable = linkedList.poll()            // remove는 값 없을때 exception 발생, poll은 null return
    println(nullable ?: "null returns")


    linkedList.add(99)
    println(linkedList.peek())      // 99
    println(linkedList.element())   // 99

    linkedList.remove()
    println(linkedList.peek() ?: "null returns")  // return null. excpetion 발생 안함
    println(linkedList.element())   // exception 발생


    // 일반적으로 요소의 임의 접근이 많은 경우에는 ArrayList를 사용하고,
    // 삽입 및 삭제가 많은 경우에는 LinkedList를 사용하는 것이 좋습니다.
    // 공통적으로 사용 가능한 함수 및 각각 호출 가능한 함수에 대한 정보는 `arrayList_vs_linkedList.md`에 있습니다.

    // Sequence.joinToString
    val joinToString = arrayList.joinToString(
        separator = ", ",
        prefix = "(",
        postfix = ")",
    ) {
        "${it * it}"
    }
    println(joinToString)
}