class Anuncio:
    def __init__(self, numero, precio):
        self.numero = numero
        self.precio = precio


class Artista:
    def __init__(self, nombre, ci, anios_experiencia):
        self.nombre = nombre
        self.ci = ci
        self.anios_experiencia = anios_experiencia


class Obra:
    def __init__(self, titulo, material, datos_artista1, datos_artista2, anuncio=None):
        self.titulo = titulo
        self.material = material
        
        self.artista1 = Artista(*datos_artista1)
        self.artista2 = Artista(*datos_artista2)
        
        self.anuncio = anuncio


class Pintura(Obra):  
    def __init__(self, titulo, material, datos_artista1, datos_artista2, genero, anuncio=None):
        super().__init__(titulo, material, datos_artista1, datos_artista2, anuncio)
        self.genero = genero

anuncio1 = Anuncio(101, 1800)

pintura1 = Pintura(
    titulo="Aurora",
    material="Óleo",
    datos_artista1=("Ana", "123", 5),
    datos_artista2=("Luis", "456", 8),
    genero="Realismo",
    anuncio=anuncio1
)

pintura2 = Pintura(
    titulo="Eclipse",
    material="Acrílico",
    datos_artista1=("Marta", "789", 12),
    datos_artista2=("Luis", "456", 8),
    genero="Abstracto"
)

def artista_mas_experto(pintura):
    return pintura.artista1 if pintura.artista1.anios_experiencia >= pintura.artista2.anios_experiencia else pintura.artista2

artistas = [
    artista_mas_experto(pintura1),
    artista_mas_experto(pintura2)
]

mas_experto = max(artistas, key=lambda a: a.anios_experiencia)
print(f"Artista con más experiencia: {mas_experto.nombre} ({mas_experto.anios_experiencia} años)")

anuncio2 = Anuncio(102, 1400)
pintura2.anuncio = anuncio2

precio_total = 0
for pintura in [pintura1, pintura2]:
    if pintura.anuncio:
        precio_total += pintura.anuncio.precio

print(f"Precio total de venta de ambas pinturas: ${precio_total}")
