from turtle import *


def rectangulo(largo, ancho):
    forward(largo)
    left(90)
    forward(ancho)
    left(90)
    forward(largo)
    home()


def triangulo(lado, base):
    forward(lado)
    left(90)
    forward(base)
    home()


def espiralTri(angle, ladoTri, baseTri):

    numero = 1

    while ladoTri > 0:
        triangulo(ladoTri, baseTri)
        left(angle)
        if numero % 2 == 0:
            pencolor("blue")
        else:
            pencolor("red")
        angle += 2
        ladoTri -= 0.5
        numero += 1

    done()


def espiralRec(angle, largo, ancho):

    num = 1

    while largo > 0:
        left(angle)
        rectangulo(largo, ancho)
        if num % 2 == 0:
            pencolor("blue")
        else:
            pencolor("red")
        angle += 2
        largo -= 1
        num += 1

    done()


def main():

    pen(pencolor="red", fillcolor="orange", pensize=2, speed=100)
    begin_fill()
    espiralRec(0, 300, 10)
    # espiralTri(0, 300, 50)
    end_fill()


if __name__ == "__main__":
    main()
