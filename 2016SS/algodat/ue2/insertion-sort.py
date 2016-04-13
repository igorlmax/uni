A = [17,24,13,5,9]
count = 0

for i in range(1, len(A)):
  key, j = A[i], i-1
  while j >= 0 and A[j] > key:
    A[j+1] = A[j]
    j -= 1
    count += 1
  A[j+1] = key
  print(A)

print(count)
