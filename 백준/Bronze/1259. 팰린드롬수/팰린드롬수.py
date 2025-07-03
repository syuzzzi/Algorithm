nums = []

while True :
    num = input()

    if num == "0" :
        break

    nums.append(num)

for num in nums :
    if num == num[::-1] : # 문자열 뒤집은 것과 비교
        print("yes")
    else :
        print("no")