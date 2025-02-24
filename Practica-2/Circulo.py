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

class Circulo:
    def __init__(self, centro:Punto, radio):
        self.centro = centro
        self.radio = radio

    def __str__(self):
        return f"Circulo con centro {self.centro} y radio {self.radio}"
    
    def dibujaCirculo(self):
        centro = (self.centro.getX(), self.centro.getY())
        radio = self.radio      
        fig, ax = plt.subplots()  
        circulo = plt.Circle(centro, radio, color='b', fill=False)    
        ax.add_patch(circulo)
        ax.set_xlim(centro[0] - radio - 1, centro[0] + radio + 1)
        ax.set_ylim(centro[1] - radio - 1, centro[1] + radio + 1)
   
        ax.set_aspect('equal')
        plt.show()
p = Punto(4,4)
circulo = Circulo(p, 3)
print(circulo)
circulo.dibujaCirculo()    
