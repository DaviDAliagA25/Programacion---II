from abc import ABC, abstractmethod
class EstrategiaCarga(ABC):
    @abstractmethod
    def cargar(self):
        pass

class CargaRapida(EstrategiaCarga):
    def cargar(self):
        return "Cargando rápidamente usando alto voltaje"

class CargaEcologica(EstrategiaCarga):
    def cargar(self):
        return "Cargando lentamente para preservar la salud de la batería"

class CargaNormal(EstrategiaCarga):
    def cargar(self):
        return "Cargando a velocidad normal"

class Laptop:
    def __init__(self, estrategia: EstrategiaCarga):
        self._estrategia = estrategia

    def establecer_estrategia(self, estrategia: EstrategiaCarga):
        self._estrategia = estrategia

    def realizar_carga(self):
        print(self._estrategia.cargar())

laptop = Laptop(CargaNormal())
laptop.realizar_carga()

laptop.establecer_estrategia(CargaRapida())
laptop.realizar_carga()

laptop.establecer_estrategia(CargaEcologica())
laptop.realizar_carga()
