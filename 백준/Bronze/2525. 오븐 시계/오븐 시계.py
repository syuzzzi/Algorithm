a, b = map(int, input().split())
c = int(input())

d = a
e = b

if c >= 60:
    d += c // 60
    e += c % 60
else:
    e += c

if e >= 60:
    d += 1
    e -= 60

if d >= 24:
    d -= 24

print(d, e)
