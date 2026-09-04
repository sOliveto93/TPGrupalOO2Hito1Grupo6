# Inicialización del proyecto

## 1. Clonar el repositorio

Clonar el repositorio desde GitHub.

Ingresar a la carpeta del repositorio.

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

## 5. Configurar Hibernate

Antes de inicializar la base de datos, revisar en la configuración de Hibernate la propiedad:

```xml
<property name="hibernate.hbm2ddl.auto">
    update
</property>
```

La configuración recomendada para el funcionamiento normal del proyecto es:

```xml
<property name="hibernate.hbm2ddl.auto">
    update
</property>
```

Si al inicializar el proyecto se presentan problemas relacionados con las tablas o el mapeo de Hibernate, cambiar temporalmente la propiedad a:

```xml
<property name="hibernate.hbm2ddl.auto">
    create-drop
</property>
```

Esto permite que Hibernate cree nuevamente las tablas desde cero.

## 6. Inicializar la base de datos

Una vez creada la base de datos, ejecutar la clase:

```text
IniciarBD
```

Esta clase se encarga de inicializar la base de datos y cargar los datos necesarios para ejecutar las pruebas.

Si se utilizó:

```xml
<property name="hibernate.hbm2ddl.auto">
    create-drop
</property>
```

una vez ejecutado `IniciarBD`, **volver a cambiar la propiedad a `update`**:

```xml
<property name="hibernate.hbm2ddl.auto">
    update
</property>
```

## 7. Ejecutar los tests

Después de ejecutar `IniciarBD`, verificar que los datos hayan sido cargados correctamente y ejecutar los **tests** del proyecto desde Eclipse.

### Orden de inicialización

```text
1. Clonar el repositorio
        ↓
2. Crear un Java Project en Eclipse
        ↓
3. Reemplazar el contenido de ./src
        ↓
4. Importar las librerías al Build Path
        ↓
5. Crear la base de datos "objetos2"
        ↓
6. Revisar la configuración de Hibernate
        ↓
7. Ejecutar IniciarBD
        ↓
8. Si fue necesario utilizar create-drop,
   volver a colocar update
        ↓
9. Ejecutar los tests
```
