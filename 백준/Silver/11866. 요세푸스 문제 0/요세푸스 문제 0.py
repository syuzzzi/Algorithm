n, k = map(int, input().split())

lst = [i for i in range(1, n + 1)]

pop_list = []
now = 0

while lst :
    now = (now + k - 1) % len(lst)

    pop_list.append(lst.pop(now))

print("<" + ", " .join(map(str, pop_list)) + ">")