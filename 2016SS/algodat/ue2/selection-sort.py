A = [17,24,13,5,9]

for i in range(0, len(A)-1):
  smallest = i
  for j in range(i+1, len(A)):
    if A[j] < A[smallest]:
      smallest = j
  A[i], A[smallest] = A[smallest], A[i]
  print(A)