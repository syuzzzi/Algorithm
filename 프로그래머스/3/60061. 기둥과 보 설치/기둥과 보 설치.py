def can_build(x, y, a, structures):
    if a == 0:  # 기둥
        # 바닥에 있거나, 아래에 기둥이 있거나, 보의 왼쪽 끝이거나, 보의 오른쪽 끝인 경우
        return (
            y == 0 or 
            (x, y - 1, 0) in structures or 
            (x, y, 1) in structures or 
            (x - 1, y, 1) in structures
        )
    elif a == 1:  # 보
        # 왼쪽 아래에 기둥이 있거나, 오른쪽 아래에 기둥이 있거나, 양쪽 끝이 다른 보와 연결된 경우
        return (
            (x, y - 1, 0) in structures or 
            (x + 1, y - 1, 0) in structures or 
            ((x - 1, y, 1) in structures and (x + 1, y, 1) in structures)
        )

def is_valid(structures):
    for x, y, a in structures:
        if not can_build(x, y, a, structures):
            return False
    return True

def solution(n, build_frame):
    structures = set()

    for x, y, a, b in build_frame:
        if b == 1:  # 설치
            structures.add((x, y, a))
            if not is_valid(structures):
                structures.remove((x, y, a))
        elif b == 0:  # 삭제
            structures.remove((x, y, a))
            if not is_valid(structures):
                structures.add((x, y, a))

    # 결과를 정렬된 리스트로 변환
    answer = list(map(list, structures))
    answer.sort(key=lambda x: (x[0], x[1], x[2]))
    return answer