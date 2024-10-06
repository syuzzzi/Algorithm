import sys
input = sys.stdin.readline

def find(parent, x) : # 부모 찾는 함수
  if parent[x] != x :
    parent[x] = find(parent, parent[x])
    
  return parent[x]

def union(parent, rank, a, b) : # 합치는 함수
  rootA = find(parent, a)
  rootB = find(parent, b)
  
  if rootA != rootB :
    if rank[rootA] > rank[rootB] : # a의 깊이가 더 깊다면
      parent[rootB] = rootA # b의 부모를 a로
      
    elif rank[rootA] < rank[rootB] :
      parent[rootA] = rootB
    
    else :
      parent[rootB] = rootA
      rank[rootA] += 1

n = int(input()) # 행성 개수

planets = []
edges = []

for i in range(n) :
  x, y, z = map(int, input().split())
  
  planets.append((x, y, z, i)) # 행성의 인덱스 추가해서 튜플로!
  
for i in range(3) : 
  planets.sort(key=lambda x: x[i]) # x, y, z 각각으로 정렬
  
  for j in range(1, n) :
    dist = abs(planets[j - 1][i] - planets[j][i]) # 인덱스 번호가 가까운 행성끼리 거리 구해주기
    edges.append((dist, planets[j - 1][3], planets[j][3])) # (거리, j-1번째 행성, j번째 행성) 튜플 추가

edges.sort() # 거리의 오름차순으로 정렬

parent = [i for i in range(n)] # 초기에는 자기 자신이 부모
rank = [0] * n # 깊이 저장 배열

result = 0

for edge in edges :
  cost, a, b = edge
  
  if find(parent, a) != find(parent, b) : # 부모가 다르면 
    union(parent, rank, a, b) # 합쳐줌
    result += cost
    
print(result)