from abc import ABC, abstractmethod
class Laptop(ABC):
    @abstractmethod
    def especificaciones(self):
        pass

class LaptopGamer(Laptop):
    def especificaciones(self):
        return "Laptop Gamer: GPU RTX, 32GB RAM, CPU i9"

class LaptopNegocios(Laptop):
    def especificaciones(self):
        return "Laptop de Negocios: GPU Integrada, 16GB RAM, CPU i5"

class FabricaLaptop(ABC):
    @abstractmethod
    def crear_laptop(self) -> Laptop:
        pass

class FabricaLaptopGamer(FabricaLaptop):
    def crear_laptop(self):
        return LaptopGamer()

class FabricaLaptopNegocios(FabricaLaptop):
    def crear_laptop(self):
        return LaptopNegocios()

def ordenar_laptop(fabrica: FabricaLaptop):
    laptop = fabrica.crear_laptop()
    print(laptop.especificaciones())

ordenar_laptop(FabricaLaptopGamer())
ordenar_laptop(FabricaLaptopNegocios())
