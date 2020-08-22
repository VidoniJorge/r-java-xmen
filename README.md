# Consigna

Magneto quiere reclutr la mayor cantidad de mutantes para poder luchar contra los X-Men

Te han contratado a ti para que desarrolles un proyecto que detecte si un humano es 
mutante basádo en su secuencia de ADN.

Para eso te ha pedido crear un programa con un método o función con la
siguiente firma

> boolean isMutant(String[] dna);

En donde recibirás como parámetro un array de Strings que representan cada fila
de una tabla de (NxN) con la secuencia del ADN.

Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada
base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro
letras iguales, de forma oblicua, horizaontales o vertical.

Ejmplo (Caso Mutante):
String[] dna = {"ATGCGAS,"CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

En esta case el llamdo a la función isMutant(dna) devuelve "true".

Desarrolla **el algoritmo de la manera más eficiente posible**.