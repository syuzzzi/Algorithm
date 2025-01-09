import sys
input = sys.stdin.readline

a, b = map(int, input().split())

MAX = min(a, b)

while 1 :
  if a % MAX == 0 and b % MAX == 0 :
    print(MAX)
    break
  
  else :
    MAX -= 1
    
MIN = (a * b) // MAX
print(MIN)