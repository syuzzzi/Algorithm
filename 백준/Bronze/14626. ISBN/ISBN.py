isbn = list(input()) # 입력받기

star_num = -1 # 별표 위치 초기화
total_minus_star = 0

for i in range(len(isbn)):
    if isbn[i] != '*' : # 별이 아니면 int로 형변환
        isbn[i] = int(isbn[i])
        
        if i % 2 == 0 :
            total_minus_star += isbn[i]
        else :
            total_minus_star += isbn[i] * 3

    else : # 별이면 별의 위치 저장
        star_num = i 

if star_num % 2 == 0 : # 짝수 인덱스일 때는 1을 곱해줌
    for i in range(10) :
        if (total_minus_star + i) % 10 == 0 :
            print(i)
else :
    for i in range(10) : # 홀수 인덱스일 때는 3을 곱해줌
        if (total_minus_star + i * 3) % 10 == 0 :
            print(i)