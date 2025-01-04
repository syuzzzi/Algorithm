import sys
input = sys.stdin.readline

while True :
    three_num = list(map(int, input().split()))
    
    if sum(three_num) == 0 :
        break

    MAX = max(three_num)
    three_num.remove(MAX)
    small_1, small_2 = three_num

    if MAX ** 2 == small_1 ** 2 + small_2 ** 2 :
        print("right")
        
    else :
        print("wrong")
