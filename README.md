# Entrega del Proyecto Final

El proyecto consiste en desarrollar una aplicación que nos permita administrar las ventas de un comercio.
Para ello necesitamos centrarnos en 3 actores, el cliente quién es el que compra los productos que son los elementos que forman las ventas del comercio.


## Objetivos generales:

- Integrar los conocimientos vistos hasta ahora
- Poder diseñar una solución


## Consigna:

Tomando como referencia lo solicitado en la segunda pre-entrega:

Se debe poder:
- Crear Cliente
- Eliminar Cliente
- Crear Producto
- Eliminar Producto
- Crear Venta

Opcional:
- Validaciones varias
- Implementación de Swagger


## Instrucciones para clonar el proyecto en Windows:

- Abrir una carpeta donde quiero clonar el proyecto:
  Ej: JavaProjects

- Abrir terminal de Git Bash:
  Boton derecho adentro de la carpeta "JavaProjects" -> Git Bash Here

- Clonar el proyecto:
```
git clone https://github.com/mmunarriz/Java_EntregaProyectoFinal
```
##  Ejecutar el proyecto:
```
src/main/java/com/example/entregafinal/EntregafinalApplication.java
```

##  Documentacion del proyecto - Swagger:
```
http://localhost:8080/swagger-ui/index.html
```

##  Validaciones:
Productos:
- Al eliminar un Producto, si ocurre una excepción (por ejemplo, si el Producto no existe), el servidor responde con un código de estado 404 y un mensaje descriptivo.
En caso de éxito, el servidor devuelve un estado 200 (OK) con el mensaje "Producto eliminado con éxito".

Clientes:
- Al eliminar un Cliente, si ocurre una excepción (por ejemplo, si el Cliente no existe), el servidor responde con un código de estado 404 y un mensaje descriptivo.
  En caso de éxito, el servidor devuelve un estado 200 (OK) con el mensaje "Cliente eliminado con éxito".

Ventas:
- Al crear una venta, primero se verifica si el Cliente que intenta realizar la compra existe en la base de datos. 
  Luego se verifica que cada uno de los Productos exista en la base de datos. Si el cliente o alguno de los Productos no existen, el servidor responde con un código de estado 404 y un mensaje descriptivo.
  En caso de éxito, el servidor devuelve un estado 200 (OK) con el mensaje "Venta creada con éxito".


Disfruta el proyecto :)