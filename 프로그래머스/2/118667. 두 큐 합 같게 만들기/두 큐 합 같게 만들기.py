from collections import deque

def solution(queue1, queue2):
    answer = 0
    half = (sum(queue1) + sum(queue2)) // 2
    
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    
    deque1 = deque(queue1)
    deque2 = deque(queue2)
    
    # 각 큐의 길이의 합의 2배 이상 돌지 않도록 제한
    limit = len(deque1) * 3
    
    while answer <= limit:
        if sum1 == sum2:
            return answer
        
        if sum1 > sum2:
            if deque1:
                popped = deque1.popleft()
                sum1 -= popped
                deque2.append(popped)
                sum2 += popped
                answer += 1
            else:
                break
        else:
            if deque2:
                popped = deque2.popleft()
                sum2 -= popped
                deque1.append(popped)
                sum1 += popped
                answer += 1
            else:
                break
    
    return -1
