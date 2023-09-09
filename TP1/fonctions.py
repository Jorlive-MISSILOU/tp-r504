def puissance(a,b):
    #a=int(a)
    #b=int(b)

    if not (type(a) is int and type(b) is int):
        raise TypeError("Only integers are allowed")
    if a == 0 and b == 0:
        raise ValueError("0 exposant 0 n'est pas définie.")
    if b < 0:
        raise ValueError("L'exposant ne doit pas etre negatif.")
    
    return a ** b
    
#puissance(2,6)
    