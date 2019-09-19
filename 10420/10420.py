#Autor: Andres Giovanne Florez Perez
import sys
def sol():
    case=int(sys.stdin.readline().strip())
    container=[]
    paises=[]
    val=0
    for i in range(case):
        val=sys.stdin.readline().strip().split()
        container.append(val)
    print(container)
    for i in container:
        if i not in paises:
            paises.append(i[0])
    paises=sorted(set(paises))
    for i in range(len(paises)):
        for j in range(len(container)):
            if paises[i]==container[j]:
                val=container[j]
                val2=val[1:]
                if val2 not in nombres[i]:
                    meter=nombres[i]
                    meter.append(val2)
    print(paises)
    print(nombres)
    for i,j in zip(paises,nombres):
        print(i,len(j))
sol()
        
