import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t) :
    gualho = list(input().strip())

    stack = []
    no = False

    for i in range(len(gualho)) :
        if gualho[i] == '(' :
            stack.append(gualho[i])

        else :
            if stack :
                stack.pop()

            else :
                print("NO")
                no = True
                break

    if no :
        continue

    if stack :
        print("NO")
    else :
        print("YES")