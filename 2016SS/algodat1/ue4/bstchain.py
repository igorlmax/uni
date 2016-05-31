def validate(liste, target, minimum, maximum):
  for i in liste:
    if (i < minimum or i > maximum):
      return 0
    elif i > target:
      maximum = i
      print(minimum, maximum)
    elif i < target:
      minimum = i
      print(minimum, maximum)
    elif i == target:
      return 1
    else:
      return 0
  return 1