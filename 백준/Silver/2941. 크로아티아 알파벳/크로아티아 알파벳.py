alpa = list(input())
cnt = 0
i = 0

while i < len(alpa):
    if alpa[i] == '=':
        if i > 1 and alpa[i-1] == 'z' and alpa[i-2] == 'd':
            cnt -= 1  # 'dz=' 처리 시 앞의 'd'를 하나 감소
        elif i > 0 and (alpa[i-1] == 'c' or alpa[i-1] == 's' or alpa[i-1] == 'z'):
            pass  # 'c=', 's=', 'z=' 처리
    elif alpa[i] == '-':
        if i > 0 and (alpa[i-1] == 'c' or alpa[i-1] == 'd'):
            pass  # 'c-', 'd-' 처리
    elif alpa[i] == 'j':
        if i > 0 and (alpa[i-1] == 'l' or alpa[i-1] == 'n'):
            pass  # 'lj', 'nj' 처리
        else:
            cnt += 1  # 'j' 자체는 카운트
    else:
        cnt += 1  # 나머지 문자들 카운트

    i += 1

print(cnt)
