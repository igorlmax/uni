A = [17,24,13,5,9]
count = 0

for i in range(0, len(A)-1):
  smallest = i
  for j in range(i+1, len(A)):
    count += 1
    if A[j] < A[smallest]:
      smallest = j
  A[i], A[smallest] = A[smallest], A[i]
  print(A)

print(count)
