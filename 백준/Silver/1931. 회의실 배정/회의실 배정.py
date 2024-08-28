# 처음에는 시작 시간으로 정렬 했었는데 종료 시간으로 정렬해야하는 거였음

n = int(input()) # 회의 개수 입력 받기

meeting = []

for i in range(n) :
  start, end = map(int, input().split())
  meeting.append((start, end)) # 회의 시작과 끝 시간 튜플로 추가
  
meeting.sort(key=lambda x: (x[1], x[0])) # 종료 시간으로 오름차순 정렬. 종료 시간이 같다면 시작 시간 오름차순

cnt = 0 # 가능한 회의 개수
end_remember = 0 # 진행 중인 회의의 끝나는 시간 기억해 둘 변수

for i in range(n) :
  if meeting[i][0] >= end_remember : # 현재 회의의 시작 시간이 진행 중인 회의가 끝나고 난 뒤라면
    cnt += 1 # 가능한 회의에 추가
    end_remember = meeting[i][1]
        
print(cnt)