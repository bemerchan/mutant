# Mutans
## _Programa para verificar cadenas de ADN_

## Caracteristicas

- Verifica cadenas de ADN y determina si es un mutante.
- Lista las cadenas de ADN verificadas.
- Cuenta la cantidad de humanos y mutantes que se han verificado.
- Almacena las cadenas de ADN para su posterior consulta y verificación.

## Problematica

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En
alguno de los siguiente lenguajes:
### Java / Golang / C-C++ / Javascript (node) / Python / Ruby)

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.
###### NO MUTANTE
#
| | | | | | |    
|-|-|-|-|-|-|
|A|T|G|C|G|A|
|C|A|G|T|G|C|
|T|T|A|T|T|T|
|A|G|A|C|G|G|
|G|C|G|T|C|A|
|T|C|A|C|T|G|

###### MUTANTE
#
| | | | | | |
|-|-|-|-|-|-|
|**A**|T|G|C|**G**|A|
|C|**A**|G|T|**G**|C|
|T|T|**A**|T|**G**|T|
|A|G|C|**A**|**G**|G|
|**C**|**C**|**C**|**C**|T|A|
|T|C|A|C|T|G|

## Instalación

Clonar el repositorio
```sh
git clone https://github.com/bemerchan/mutant.git
```
Abrir una terminal en la raiz del repositorio e instalar las dependencias
```sh
mvn clean install
```
Por ultimo abrir el proyecto en el IDE de su preferencia y ejecutar la aplicación el main() de la aplicación que se encuentra en la siguiente ubicación dentro del proyecto:

```sh
src/main/java/co/com/dna/DnaApisApplication.java
```
## Pruebas
Al ejecutar la aplicación se exponen dos servicios, la forma de consumirlos es la siguiente:
````
POST → api/mutant/
{
    “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

Response 200:
is mutant

Response 403:
{
    "timestamp": 1661552401654,
    "status": 403,
    "error": "Forbidden",
    "message": "he is not a mutant",
    "path": "/api/mutant"
}
````

````
GET → apli/stats

Response 200:
{
    "countMutantDna": 3,
    "countHumanDna": 5,
    "ratio": 0.6
}
````

## Licecia

**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[dill]: <https://github.com/joemccann/dillinger>
[git-repo-url]: <https://github.com/joemccann/dillinger.git>
[john gruber]: <http://daringfireball.net>
[df1]: <http://daringfireball.net/projects/markdown/>
[markdown-it]: <https://github.com/markdown-it/markdown-it>
[Ace Editor]: <http://ace.ajax.org>
[node.js]: <http://nodejs.org>
[Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
[jQuery]: <http://jquery.com>
[@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
[express]: <http://expressjs.com>
[AngularJS]: <http://angularjs.org>
[Gulp]: <http://gulpjs.com>

[PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
[PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
[PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
[PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
[PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
[PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
