def solution(sizes):
  big = []
  small = []
  
  
  for i in range(len(sizes)) :
    a, b = sizes[i]
    
    if a < b :
      small.append(a)
      big.append(b)
    elif a > b :
      small.append(b)
      big.append(a)
    else :
      small.append(a)
      big.append(b)
      
  MAX = max(big)
  MIN = max(small)

  answer = MAX * MIN
  return answer

sizes = [[60, 50], [30, 70], [60, 30], [80, 40]]

print(solution(sizes))