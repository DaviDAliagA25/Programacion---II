import tkinter as tk
from tkinter import messagebox

class Boleto:
    def __init__(self, numero):
        self.numero = numero

    def info(self):
        return f"Número: {self.numero}, Precio: -"

class Palco(Boleto):
    def __init__(self, numero):
        super().__init__(numero)
        self.precio = 100.0

    def info(self):
        return f"Número: {self.numero}, Precio: {self.precio}"

class Platea(Boleto):
    def __init__(self, numero, dias_anticipacion):
        super().__init__(numero)
        if dias_anticipacion >= 10:
            self.precio = 50.0
        else:
            self.precio = 60.0

    def info(self):
        return f"Número: {self.numero}, Precio: {self.precio}"

class Galeria(Boleto):
    def __init__(self, numero, dias_anticipacion):
        super().__init__(numero)
        if dias_anticipacion >= 10:
            self.precio = 25.0
        else:
            self.precio = 30.0

    def info(self):
        return f"Número: {self.numero}, Precio: {self.precio}"

def vender():
    tipo = tipo_boleto.get()
    numero = numero_entry.get()
    dias = dias_entry.get()

    if not numero.isdigit():
        messagebox.showerror("Error", "Ingrese un número de boleto válido.")
        return

    if tipo != "Palco" and not dias.isdigit():
        messagebox.showerror("Error", "Ingrese los días de anticipación.")
        return

    numero = int(numero)
    dias = int(dias) if dias else 0

    if tipo == "Palco":
        boleto = Palco(numero)
    elif tipo == "Platea":
        boleto = Platea(numero, dias)
    elif tipo == "Galeria":
        boleto = Galeria(numero, dias)
    else:
        boleto = None

    if boleto:
        info_label.config(text=boleto.info())

def salir():
    ventana.destroy()

ventana = tk.Tk()
ventana.title("Teatro Municipal")
ventana.geometry("400x400")

titulo = tk.Label(ventana, text="Teatro Municipal", font=("Arial", 20))
titulo.pack(pady=10)

datos_frame = tk.LabelFrame(ventana, text="Datos del Boleto")
datos_frame.pack(padx=10, pady=5, fill="both", expand=True)

tipo_boleto = tk.StringVar(value="Palco")
palco_rb = tk.Radiobutton(datos_frame, text="Palco", variable=tipo_boleto, value="Palco")
platea_rb = tk.Radiobutton(datos_frame, text="Platea", variable=tipo_boleto, value="Platea")
galeria_rb = tk.Radiobutton(datos_frame, text="Galeria", variable=tipo_boleto, value="Galeria")
palco_rb.grid(row=0, column=0, padx=5, pady=5)
platea_rb.grid(row=0, column=1, padx=5, pady=5)
galeria_rb.grid(row=0, column=2, padx=5, pady=5)

numero_label = tk.Label(datos_frame, text="Número:")
numero_label.grid(row=1, column=0, padx=5, pady=5, sticky="e")
numero_entry = tk.Entry(datos_frame)
numero_entry.grid(row=1, column=1, padx=5, pady=5)

dias_label = tk.Label(datos_frame, text="Días Anticipación:")
dias_label.grid(row=2, column=0, padx=5, pady=5, sticky="e")
dias_entry = tk.Entry(datos_frame)
dias_entry.grid(row=2, column=1, padx=5, pady=5)

vende_btn = tk.Button(datos_frame, text="Vender", command=vender)
vende_btn.grid(row=3, column=0, padx=10, pady=10)

salir_btn = tk.Button(datos_frame, text="Salir", command=salir)
salir_btn.grid(row=3, column=1, padx=10, pady=10)

info_frame = tk.Frame(ventana)
info_frame.pack(padx=10, pady=5)

info_label = tk.Label(info_frame, text="Número: -, Precio: -", font=("Arial", 16), fg="blue")
info_label.pack()

ventana.mainloop()
