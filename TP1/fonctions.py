def puissance(a,b):
    #a=int(a)
    #b=int(b)

    if not (type(a) is int and type(b) is int):
        raise TypeError("Only integers are allowed")
    
    expo= a**b
    return expo
    
#puissance(2,6)
    