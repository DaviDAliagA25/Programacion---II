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
    def __init__(self, titulo, material, artista1_data, artista2_data, anuncio=None):
        self.titulo = titulo
        self.material = material

        self.artista1 = Artista(*artista1_data)
        self.artista2 = Artista(*artista2_data)
        
        self.anuncio = anuncio

class Pintura(Obra):
    def __init__(self, titulo, material, artista1_data, artista2_data, genero, anuncio=None):
        super().__init__(titulo, material, artista1_data, artista2_data, anuncio)
        self.genero = genero

anuncio1 = Anuncio(1, 1500)
anuncio2 = Anuncio(2, 2000)

pintura1 = Pintura(
    titulo="Amanecer",
    material="Óleo",
    artista1_data=("Carlos", "123", 10),
    artista2_data=("Lucía", "456", 12),
    genero="Realismo",
    anuncio=anuncio1
)

pintura2 = Pintura(
    titulo="Nocturno",
    material="Acrílico",
    artista1_data=("María", "789", 8),
    artista2_data=("Carlos", "123", 10),
    genero="Impresionismo",
    anuncio=anuncio2
)

artistas = [pintura1.artista1, pintura1.artista2, pintura2.artista1, pintura2.artista2]

artistas_unicos = {}
for artista in artistas:
    artistas_unicos[artista.ci] = artista 

total_experiencia = sum(a.anios_experiencia for a in artistas_unicos.values())
promedio = total_experiencia / len(artistas_unicos)

print(f"Promedio de años de experiencia: {promedio:.2f}")

def incrementar_precio(pinturas, nombre_x, incremento):
    for pintura in pinturas:
        if pintura.anuncio:
            if pintura.artista1.nombre == nombre_x or pintura.artista2.nombre == nombre_x:
                pintura.anuncio.precio += incremento
                print(f"Precio incrementado para pintura '{pintura.titulo}' -> nuevo precio: {pintura.anuncio.precio}")

incrementar_precio([pintura1, pintura2], nombre_x="Carlos", incremento=500)
