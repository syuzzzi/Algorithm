from collections import deque

# 서브 트리에 대한 넓이 우선 탐색
def bfs(start, graph, n):
    visited = [False] * (n + 1) # 방문 여부
    visited[start] = True # 시작 노드에 들름 표시
    queue = deque([start]) # 시작 노드를 큐에 넣어줌
    count = 0
    
    # 큐가 빌 때까지 반복
    while queue:
        node = queue.popleft()
        count += 1
        
        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
    
    return count # 서브 트리 노드 개수 반환

def solution(n, wires):
    graph = [[] for _ in range(1, n + 2)]
    
    for u, v in wires: # 인접리스트로 저장
        graph[u].append(v)
        graph[v].append(u)
    
    min_diff = float('inf') # 송전탑 최소 개수 차이를 나타낼 변수 무한대로 초기화
    
    # 각 전선을 하나씩 끊어보면서 송전탑 개수의 차이 알아내기
    for u, v in wires:
        # 전선 끊기
        graph[u].remove(v)
        graph[v].remove(u)
    
        subtree_size = bfs(u, graph, n) # (u, v) 전선을 끊었을 때 생기는 트리 크기
        diff = abs(subtree_size - (n - subtree_size)) # 두 트리의 차이 계산. 절댓값 처리
        
        min_diff = min(min_diff, diff) # 더 작은 값으로 갱신
        
        # 다음 전선을 끊었다고 가정하기 위해 끊었던 전선 복구
        graph[u].append(v)
        graph[v].append(u)
    
    return min_diff