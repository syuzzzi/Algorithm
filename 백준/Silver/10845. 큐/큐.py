n = int(input())

q = []

for _ in range(n) :
    mr = input().split()

    if mr[0] == "push" :
        q.append(mr[1])

    elif mr[0] == "pop" :
        if q :
            print(q.pop(0))
        else :
            print(-1)

    elif mr[0] == "size" :
        print(len(q))

    elif mr[0] == "empty" :
        if not q :
            print(1)
        else :
            print(0)

    elif mr[0] == "front" :
        if q :
            print(q[0])
        else :
            print(-1)

    elif mr[0] == "back" :
        if q :
            print(q[-1])
        else :
            print(-1)