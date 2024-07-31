import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1 # 더 이상 먹을 음식이 없으므로 -1 반환

    q = []
    
    # 튜플을 우선순위 큐에 저장
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i + 1))

    sum_value = 0  # 먹기 위해 사용한 총 시간
    previous = 0  # 직전에 다 먹은 음식의 시간
    length = len(food_times)  # 남은 음식의 수

    # 현재 음식의 시간을 구함
    while sum_value + ((q[0][0] - previous) * length) <= k:
        now = heapq.heappop(q)[0] # 가장 적은 양의 음식을 꺼냄
        sum_value += (now - previous) * length # 현재 음식을 다 먹는 데 걸리는 시간을 더함
        length -= 1  # 다 먹은 음식은 제외
        previous = now  # 현재 음식으로 업데이트

    # 남은 음식들 중에서 시간을 구해야 할 음식의 인덱스를 정렬
    result = sorted(q, key=lambda x: x[1])
  
    return result[(k - sum_value) % length][1]
