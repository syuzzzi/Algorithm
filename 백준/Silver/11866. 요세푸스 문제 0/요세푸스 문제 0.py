n, k = map(int, input().split())

lst = [i for i in range(1, n + 1)]
pop_list = []
now = 0

while lst:
    now = (now + k - 1) % len(lst)  # 현재 인덱스 갱신 (리스트 길이를 고려)
    pop_list.append(lst.pop(now))   # 해당 인덱스 요소 제거 및 추가

print("<" + ", ".join(map(str, pop_list)) + ">")
