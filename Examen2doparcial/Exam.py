# -*- coding: utf-8 -*-
"""
Created on Mon May  3 19:55:14 2021

@author: Hola
"""

import pandas as pd
import tkinter
import sys
import matplotlib.pyplot as plt


datos = pd.read_csv("Examen.csv")

'''

mywindow = Tk()
mywindow.geometry("300x350")
mywindow.title("Registration Form - Python + Tkinter")
mywindow.resizable(False,False)
mywindow.config(background = "#213141")
main_title = Label(text = "Examen | SAINZ ", font = ("Cambria", 14), bg = "#56CD63", fg = "black", width = "300", height = "2")

'''

ventana = tkinter.Tk()
ventana.title("Inicio")
ventana.geometry("300x330")
ventana.resizable(False,False)
ventana.config(bg = "#213144")
ventana.label(text = "Examen | SAINZ ", font = ("Cambria", 9), bg = "#56CD63", fg = "black", width = "200", height = "2")
ventana   .pack()



def frecAbs():
    
    frecAbsMenu = tkinter.Tk()
    frecAbsMenu.title("Frecuencias Absolutas")
    frecAbsMenu.geometry("300x350")
    frecAbsMenu.config(bg = "#213141")
        

    def velocidad():        
    
        frecVelocidad = pd.value_counts(datos["velocidad"])
        
        frecVelocidad_df = pd.DataFrame(frecVelocidad)
        
        frecVelocidad_df.columns = ["Velocidad"]        
        
        frecVelocidad_df.plot(kind='barh', legend="Reverse")
        plt.xlabel("Frecuencia Absoluta")
            
    def peso():

        frecPeso = pd.value_counts(datos["peso"])    
        
        df = pd.DataFrame(frecPeso)
        
        df.columns = ["Peso"]
        
        df.plot(kind = 'barh', legend = 'Reverse')
        plt.xlabel("Frecuencia Absoluta")
    
    def altura():
        frecAltura = pd.value_counts(datos["altura"])
        
        df = pd.DataFrame(frecAltura)
        
        df.columns = ["Altura"]
        
        df.plot(kind = 'barh', legend = 'Reverse')
        plt.xlabel("Frecuencia Absoluta")
        
    def cerrar():
        frecAbsMenu.destroy()
     
     
    btnVel = tkinter.Button(frecAbsMenu, text = "Velocidad", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = velocidad)
    btnVel.pack(pady = 10)
    
    btnPeso = tkinter.Button(frecAbsMenu, text = "Peso", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = peso)
    btnPeso.pack(pady = 10)
    
    btnAlt = tkinter.Button(frecAbsMenu, text = "Altura", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = altura)
    btnAlt.pack(pady = 10)
    
    btnCerrar = tkinter.Button(frecAbsMenu, text = "Cerrar", bg = "#C299FF", font = "Arial 10", fg = "#2d3436", command = cerrar)
    btnCerrar.pack(pady = 10)
    


def frecRel():
    frecRelMenu = tkinter.Tk()
    frecRelMenu.title("Frecuencias Relativas")
    frecRelMenu.geometry("300x350")
    frecRelMenu.config(bg = "#213141")
    
    
    
    def velocidad():
        df = pd.DataFrame(datos)
        df.groupby('velocidad')['velocidad'].mean().plot(kind = 'pie')
        plt.xlabel('Velocidad')
        plt.ylabel('Frecuencia de Velocidades')
        plt.title('Frecuencia Relativa')
    
    
    def peso():
        df = pd.DataFrame(datos)
        df.groupby('peso')['peso'].mean().plot(kind = 'pie')
        plt.xlabel('Peso')
        plt.ylabel('Frecuencia de Pesos')
        plt.title('Frecuencia Relativa')
    
    
    def altura():
        df = pd.DataFrame(datos)
        df.groupby('altura')['altura'].mean().plot(kind = 'pie')
        plt.xlabel('Altura')
        plt.ylabel('Frecuencia de Alturas')
        plt.title('Frecuencia Relativa')
        
    def cerrar():
        frecRelMenu.destroy()
    
     
    btnVel = tkinter.Button(frecRelMenu, text = "Velocidad", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = velocidad)
    btnVel.pack(pady = 10)
    
    btnPeso = tkinter.Button(frecRelMenu, text = "Peso", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = peso)
    btnPeso.pack(pady = 10)
    
    btnAlt = tkinter.Button(frecRelMenu, text = "Altura", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = altura)
    btnAlt.pack(pady = 10)
    
    btnCerrar = tkinter.Button(frecRelMenu, text = "Cerrar", bg = "#C299FF", font = "Arial 10", fg = "#2d3436", command = cerrar)
    btnCerrar.pack(pady = 10)    

def frecAcum():
    
    frecAcumMenu = tkinter.Tk()
    frecAcumMenu.title("Frecuencias Relativas")
    frecAcumMenu.geometry("300x350")
    frecAcumMenu.config(bg = "#213141")
    

    def velocidad():
        df = pd.DataFrame(datos)
        df.groupby('velocidad')['velocidad'].mean().plot()
        plt.xlabel('Velocidad')
        plt.ylabel('Frecuencia  acumulada de Velocidades')
        plt.title('Frecuencia Acumulada')

    def peso():
        df = pd.DataFrame(datos)
        df.groupby('peso')['peso'].mean().plot()
        plt.xlabel('Peso')
        plt.ylabel('Frecuencia Acumulada de Pesos')
        plt.title('Frecuencia Acumulada')
    
    def altura():
        df = pd.DataFrame(datos)
        df.groupby('altura')['altura'].mean().plot()
        plt.xlabel('Altura')
        plt.ylabel('Frecuencia Acumulada de Alturas')
        plt.title('Frecuencia Acumulada')
    
    def cerrar():
        frecAcumMenu.destroy()
    
    btnVel = tkinter.Button(frecAcumMenu, text = "Velocidad", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = velocidad)
    btnVel.pack(pady = 10)
 
    btnPeso = tkinter.Button(frecAcumMenu, text = "Peso", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = peso)
    btnPeso.pack(pady = 10)

    btnAlt = tkinter.Button(frecAcumMenu, text = "Altura", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = altura)
    btnAlt.pack(pady = 10)

    btnCerrar = tkinter.Button(frecAcumMenu, text = "Cerrar", bg = "#C299FF", font = "Arial 10", fg = "#2d3436", command = cerrar)
    btnCerrar.pack(pady = 10)

def poligonoFrec():
    poligonoFrecMenu = tkinter.Tk()
    poligonoFrecMenu.title("Polígono de frecuencias")
    poligonoFrecMenu.geometry("300x350")
    poligonoFrecMenu.config(bg = "#213141")
    

    def velocidad():
        df = pd.DataFrame(datos)        
        df.groupby('velocidad')['velocidad'].mean().plot(kind = 'hist')
        plt.xlabel('Velocidad')
        plt.ylabel('Polígono de Frecuecnias - Velocidades')
        plt.title('Polígono de Frecuencias')

    def peso():
        df = pd.DataFrame(datos)
        df.groupby('peso')['peso'].mean().plot(kind = 'hist')
        plt.xlabel('Peso')
        plt.ylabel('Polígono de Frecuencias - Pesos')
        plt.title('Polígono de Frecuencias')
    
    def altura():
        df = pd.DataFrame(datos)
        df.groupby('altura')['altura'].mean().plot(kind = 'hist')
        plt.xlabel('Altura')
        plt.ylabel('Polígono de Frecuencias - Alturas')
        plt.title('Polígono de Frecuencias')
    
    def cerrar():
        poligonoFrecMenu.destroy()
    
    
    btnVel = tkinter.Button(poligonoFrecMenu, text = "Velocidad", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = velocidad)
    btnVel.pack(pady = 10)

    btnPeso = tkinter.Button(poligonoFrecMenu, text = "Peso", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = peso)
    btnPeso.pack(pady = 10)
   
    btnAlt = tkinter.Button(poligonoFrecMenu, text = "Altura", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = altura)
    btnAlt.pack(pady = 10)
    
    btnCerrar = tkinter.Button(poligonoFrecMenu, text = "Cerrar", bg = "#C299FF", font = "Arial 10", fg = "#2d3436", command = cerrar)
    btnCerrar.pack(pady = 10)
    

def salir():
    ventana.destroy()
    sys.exit()    


btn1 = tkinter.Button(ventana, text = "Frecuencias Absolutas", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = frecAbs)
btn1.pack(pady = 10)

btn2 = tkinter.Button(ventana, text = "Frecuencias Relativas", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = frecRel)
btn2.pack(pady = 10)

btn3 = tkinter.Button(ventana, text = "Frecuencias Acumuladas", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = frecAcum)
btn3.pack(pady = 10)

btn4 = tkinter.Button(ventana, text = "Polígono de Frecuencias", bg = "#C299FF", font = "Arial 10", fg = "#1e272e", command = poligonoFrec)
btn4.pack(pady = 10)


btnSalida = tkinter.Button(ventana, text = "Salir", bg = "#C299FF", font = "Arial 10", fg = "#2d3436", command = salir)
btnSalida.pack(pady = 5)

ventana.mainloop()





