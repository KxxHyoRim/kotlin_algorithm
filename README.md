# Kotlin Cheat Sheet for Algorithm



### Queue(Linked List)

1. **추가**
   - `add()` : Capacity 인한 오류 발생 시 Exception이 발생
   - `offer()` : exception 발생 **X**
     - cf) LinkedList의 경우 capacity제한이 발생하기 어렵기 때문에 어떤것을 써도 상관 없음

2. **queue front값 조회**
   - `element()` : 값이 없으면 <u>NoSuchElementException</u> 발생
   - `peek()` : null 리턴

3. **삭제**
   - `removeFirst()` : BFS에서 while문 내부에서 자주 사용할 수 있음
   - `remove()` : 더이상 빼낼 데이터가 없을 경우 <u>NoSuchElementException</u>을 발생
   - `poll()` : 더이상 빼낼 데이터가 없을 경우 null 리턴

4. **예제 코드**

```kotlin
val queue = LinkedList<Pair<Int, Int>>()
queue.add(sx to sy)
dist[sy][sx] = 0

while (queue.isNotEmpty()) {
    val x = queue.peek().first
    val y = queue.peek().second
    queue.removeFirst() // remove랑 같은듯


    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue

        if (map[ny][nx] != 0 && dist[ny][nx] == -1) {
            queue.add(nx to ny)
            dist[ny][nx] = dist[y][x] + 1
        }
    }
}
```
