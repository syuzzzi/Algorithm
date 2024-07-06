num = []

for i in range(9) :
  num.append(int(input()))

max_num = num[0]
index = 0
  
for i in range(1, 9) :
  if  num[i] > max_num :
    max_num = num[i]
    index = i
    
print(max_num)
print(index + 1)