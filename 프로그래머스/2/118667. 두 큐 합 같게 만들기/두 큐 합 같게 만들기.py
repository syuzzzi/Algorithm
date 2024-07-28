from collections import deque

def solution(queue1, queue2):
    answer = 0
    half = (sum(queue1) + sum(queue2)) // 2
    sum1 = sum(queue1) # 미리 합을 구해둬 시간 단축
    sum2 = sum(queue2)
    deque1 = deque(queue1) # deque로 변환
    deque2 = deque(queue2)
    limit = len(deque1) * 3 # 최대 횟수 설정
    
    while answer <= limit :
        if sum1 == sum2 : # 각 큐의 합이 같다면 반복 멈추기
            return answer
          
        # 이 부분을 추가하면 시간초과가 뜸. 왜지? 
        # -> 큐의 크기에 비례해서 max()의 시간도 오래 걸리기 때문.
        # elif max(deque1) > half or max(deque2) > half :
        #  return -1
        
        elif sum1 < sum2 : # 큐1의 합보다 큐2의 합이 크다면
            if deque2 :
              popped = deque2.popleft()
              sum2 -= popped
              deque1.append(popped)
              sum1 += popped
              answer += 1
            else : # deque가 비어 있으면 반복 종료
              break
            
        elif sum1 > sum2 : # 큐1의 합보다 큐2의 합이 작다면
            if deque1 :
              popped = deque1.popleft()
              sum1 -= popped
              deque2.append(popped)
              sum2 += popped
              answer += 1
            else : # deque가 비어 있으면 반복 종료
              break
        
    return -1