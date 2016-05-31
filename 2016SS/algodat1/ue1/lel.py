import time

def mystery(n):
    r = 0
    for i in range(1, n):
        for j in range(i+1, n+1):
            for k in range(1,j+1):
                r += 1

    return r

for i in range(1, 20):
  print(i, mystery(i))
