import fonctions as f
res= f.puissance(2,4)

print("Hello, world !")

while True:
    entree= int(input("Veuillez entrer un nombre: "))
    #entree=int(entree)
    print("Son carré est: ", entree**2)
    
    v1=int(input("Veuillez entrer la valeur de v1: "))
    v2=int(input("Veuillez maintenant entrer la valeur de v2: "))
    print(f.puissance(v1,v2))
    
