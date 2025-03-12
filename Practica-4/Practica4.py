import math

class Practica4:

    def calcular_area(self, radio=None, base=None, altura=None, tipo=None):
        if radio is not None:
            return math.pi * radio * radio
        elif base is not None and altura is not None and tipo is None:
            return base * altura
        elif base is not None and altura is not None and tipo == "triangulo":
            return (base * altura) / 2
        elif base is not None and altura is not None:
            return ((base + altura) * altura) / 2
        elif base is not None and altura is not None:
            return (5 * base * altura) / 2
        else:
            return 0

if __name__ == "__main__":
    f = Practica4()

    print("Círculo: ", f.calcular_area(radio=1))
    print("Rectángulo: ", f.calcular_area(base=2, altura=3))
    print("Triángulo Rectángulo: ", f.calcular_area(base=3, altura=5, tipo="triangulo"))
    print("Trapecio: ", f.calcular_area(base=2, altura=3))
    print("Pentágono: ", f.calcular_area(base=2, altura=4))
