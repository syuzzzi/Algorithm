isbn = list(input()) # 입력받기

star_num = -1 # 별표 위치 초기화

for i in range(len(isbn)):
    if isbn[i] != '*' : # 별이 아니면 int로 형변환
        isbn[i] = int(isbn[i])
    else : # 별이면 별의 위치 저장
        star_num = i 
    
sum = 0 

for i in range(len(isbn)): # 별을 제외한 합 구하기
    if i != star_num :
        if i % 2 == 0 :
            sum += isbn[i] 
        else :
            sum += isbn[i] * 3

if star_num % 2 == 0 :
    for i in range(10) :
        if (sum + i) % 10 == 0 :
            print(i)
            break
else :
    for i in range(10) :
        if (sum + i * 3) % 10 == 0 :
            print(i)
            break