import matplotlib.pyplot as plt

class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f"({self.x},{self.y})"
    
    def getX(self):
        return self.x
    def getY(self):
        return self.y

class Linea:
    def __init__(self, p1:Punto, p2:Punto):
        self.p1 = p1
        self.p2 = p2

    def __str__(self):
        return f"Linea de {self.p1} a {self.p2}"
    
    def dibujaLinea(self):
        x = [self.p1.getX(), self.p2.getX()]
        y = [self.p1.getY(), self.p2.getY()]
        plt.plot(x,y, marker='o', linestyle='-')
        plt.show()

p1 = Punto(1,1)
p2 = Punto(3,3)
linea = Linea(p1, p2)

print(linea)
linea.dibujaLinea()
