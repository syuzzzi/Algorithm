import sys

for i in range(3) :
  num = sys.stdin.readline().strip()
  
  if num == 'Fizz' or num == 'Buzz' or num == 'FizzBuzz':
    continue
  
  else :
    NUM = int(num)
    
    if i == 0 :
      plus = 3
      PRINT = NUM + plus
    
    elif i == 1 :
      plus = 2
      PRINT = NUM + plus
    
    elif i == 2 :
      plus = 1
      PRINT = NUM + plus
  

if PRINT % 3 == 0 and PRINT % 5 == 0 :
  print('FizzBuzz')

elif PRINT % 3 == 0 :
  print('Fizz')
  
elif PRINT % 5 == 0 :
  print('Buzz')

else :
  print(PRINT)