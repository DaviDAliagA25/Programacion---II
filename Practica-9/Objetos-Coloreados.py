import tkinter as tk
from abc import ABC, abstractmethod
import random
import math

class Coloreado(ABC):
    @abstractmethod
    def comoColorear(self):
        pass

class Figura(ABC):
    def __init__(self, color="Sin color"):
        self.color = color

    def setColor(self, color):
        self.color = color

    def getColor(self):
        return self.color

    def __str__(self):
        return f"Figura de color {self.color}"

    @abstractmethod
    def area(self):
        pass

    @abstractmethod
    def perimetro(self):
        pass

class Cuadrado(Figura, Coloreado):
    def __init__(self, lado, color="Sin color"):
        super().__init__(color)
        self.lado = lado

    def area(self):
        return self.lado * self.lado

    def perimetro(self):
        return 4 * self.lado

    def comoColorear(self):
        return "Colorear los cuatro lados"

    def __str__(self):
        return f"Cuadrado de color {self.color}, lado {self.lado}"

class Circulo(Figura):
    def __init__(self, radio, color="Sin color"):
        super().__init__(color)
        self.radio = radio

    def area(self):
        return math.pi * self.radio * self.radio

    def perimetro(self):
        return 2 * math.pi * self.radio

    def __str__(self):
        return f"Circulo de color {self.color}, radio {self.radio}"

def generar_figuras():
    figuras.clear()
    salida_text.delete(1.0, tk.END)
    
    for _ in range(5):
        tipo = random.randint(1, 2) 
        color = random.choice(["Rojo", "Verde", "Azul", "Amarillo", "Negro"])
        
        if tipo == 1:
            lado = random.randint(1, 10)
            figura = Cuadrado(lado, color)
        else:
            radio = random.randint(1, 10)
            figura = Circulo(radio, color)
        
        figuras.append(figura)
    
    mostrar_figuras()

def mostrar_figuras():
    for figura in figuras:
        salida_text.insert(tk.END, f"{figura}\n")
        salida_text.insert(tk.END, f"Área: {figura.area():.2f}\n")
        salida_text.insert(tk.END, f"Perímetro: {figura.perimetro():.2f}\n")
        
        if isinstance(figura, Coloreado):
            salida_text.insert(tk.END, f"Método comoColorear: {figura.comoColorear()}\n")
        
        salida_text.insert(tk.END, "-" * 40 + "\n")

figuras = []

ventana = tk.Tk()
ventana.title("Figuras Coloreadas")
ventana.geometry("500x400")

titulo = tk.Label(ventana, text="Figuras Aleatorias", font=("Arial", 18))
titulo.pack(pady=10)

boton_generar = tk.Button(ventana, text="Generar Figuras", command=generar_figuras)
boton_generar.pack(pady=5)

salida_text = tk.Text(ventana, width=60, height=15)
salida_text.pack(padx=10, pady=10)

ventana.mainloop()
