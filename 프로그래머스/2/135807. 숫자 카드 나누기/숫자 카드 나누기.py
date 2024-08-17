import math
from functools import reduce

# 배열의 모든 수가 i로 나눠 떨어지는지 확인하는 함수
def all_div(i, nums):
    return all(num % i == 0 for num in nums)

# 배열의 모든 수가 i로 나눠 떨어지지 않는지 확인하는 함수
def all_no_div(i, nums):
    return all(num % i != 0 for num in nums)   
  
# 최대공약수 구하기
def GCD(arr) :
    return reduce(math.gcd, arr)
        
def solution(arrayA, arrayB):
    Anum = GCD(arrayA) # arrayA의 최대공약수
    Bnum = GCD(arrayB) # arrayB의 최대공약수
    
    # 각 배열의 최소공약수가 존재하고 이 수가 다른 배열의 모든 수를 나눌 수 없을 때
    if (Anum != 1 and all_no_div(Anum, arrayB)) and (Bnum != 1 and all_no_div(Bnum, arrayA)) :
      return(max(Anum, Bnum)) # 둘 중에 더 큰 수를 출력
    
    elif Anum != 1 and all_no_div(Anum, arrayB) : # 만약 배열A의 최대공약수가 존재하고 이 수가 배열B의 모든 수를 나누지 못한다면
        return Anum
        
    elif Bnum != 1 and all_no_div(Bnum, arrayA) : # 만약 배열B의 최대공약수가 존재하고 이 수가 배열A의 모든 수를 나누지 못한다면
        return Bnum
    
    else :
        return 0