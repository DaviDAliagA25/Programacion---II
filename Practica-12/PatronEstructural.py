from abc import ABC, abstractmethod
class Laptop(ABC):
    @abstractmethod
    def obtener_descripcion(self):
        pass

class LaptopBasica(Laptop):
    def obtener_descripcion(self):
        return "Laptop Básica"

class DecoradorLaptop(Laptop):
    def __init__(self, laptop: Laptop):
        self._laptop = laptop

    @abstractmethod
    def obtener_descripcion(self):
        pass

class TecladoRetroiluminado(DecoradorLaptop):
    def obtener_descripcion(self):
        return f"{self._laptop.obtener_descripcion()} + Teclado Retroiluminado"

class BateriaExtendida(DecoradorLaptop):
    def obtener_descripcion(self):
        return f"{self._laptop.obtener_descripcion()} + Batería Extendida"

laptop = LaptopBasica()
laptop = TecladoRetroiluminado(laptop)
laptop = BateriaExtendida(laptop)
print(laptop.obtener_descripcion())
