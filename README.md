# Inicialización del proyecto

## 1. Clonar el repositorio

Clonar el repositorio desde GitHub:

Ingresar a la carpeta del repositorio:

## 2. Crear el proyecto en Eclipse

1. Abrir **Eclipse**.
2. Crear un nuevo proyecto de tipo **Java Project**.
3. Una vez creado, ingresar a la carpeta `src` del proyecto clonado.
4. Copiar **todos los archivos y carpetas que se encuentran dentro de `src`**.
5. Reemplazar el contenido de la carpeta `src` del proyecto creado en Eclipse por el contenido copiado.

## 3. Importar las librerías

Agregar las librerías necesarias al **Build Path** del proyecto:

**Click derecho sobre el proyecto → Build Path → Configure Build Path → Libraries → Add External JARs**

Seleccionar los archivos `.jar` correspondientes y agregarlos al proyecto.

## 4. Crear la base de datos

Crear en MySQL una base de datos llamada:

```sql
CREATE DATABASE objetos2;
```

Verificar que la configuración de conexión del proyecto utilice esta base de datos.

## 5. Inicializar la base de datos

Una vez creada la base de datos, ejecutar la clase:

```text
IniciarBD
```

Esta clase se encarga de inicializar la base de datos y cargar los datos necesarios para ejecutar las pruebas.

## 6. Ejecutar los tests

Después de ejecutar `IniciarBD` y verificar que los datos hayan sido cargados correctamente, ejecutar los **tests** del proyecto desde Eclipse.

