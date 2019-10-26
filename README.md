TP Grupo 13 2019
=

El trabajo practico fue realizado en base al proyecto de [UTgeNes](https://github.com/gooznt/utgenes/wiki).

La resolucion nuestra se encuentra en la carpeta TP_Grupo13_2019 dentro del código de la aplicación.

Como correr la aplicación
=

Debe instalar en un principio [Docker](docker.com/products/docker-desktop)

Luego correr los siguientes comandos;

Crear imagen con la versión de java, esto nos evita tener problemas según versión instalada
```bash
docker build -f Dockerfile -t ia-genetic-algorithm-image .
```
Compilamos el proyecto en un contenedor temporal

```bash
docker run --rm -v "$PWD"/build/classes:/usr/src/ia-genetic-algorithm  --name ia-runner  ia-genetic-algorithm-image:latest javac main.java.TP_Grupo13_2019.CorrerAlgoritmo
```

Ejecutamos el proyecto una vez que tenemos la compilación

```bash
docker run --rm --name ia-runner  ia-genetic-algorithm-image:latest java main.java.TP_Grupo13_2019.CorrerAlgoritmo > `date +"%d-%m-%Y_%H:%M:%S"`".out"
```