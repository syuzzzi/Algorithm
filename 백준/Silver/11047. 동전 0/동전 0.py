n, k = map(int, input().split()) 
coin = []

#n가지 종류의 동전 입력받기
for i in range(n) :
    coin.append(int(input()))

cnt = 0

for i in range (n - 1, - 1, -1) :
  if coin[i] > k :
    continue
  
  val = k // coin[i]
  cnt += val
  k -= val * coin[i]
  
print(cnt)