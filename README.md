# 🛠️ Sistema de Gestión de Productos y Pedidos - Backend Java Spring Boot

Este proyecto es una API RESTful desarrollada con **Java + Spring Boot** como parte del curso de Backend Developer. El sistema gestiona productos, usuarios, carritos de compra y pedidos, con control de acceso mediante roles y autenticación JWT.

## 📌 Descripción general

El sistema permite:

- Registrar y autenticar usuarios con roles (`CLIENTE`, `ADMIN`).
- Administrar productos (crear, listar, actualizar, eliminar).
- Permitir a los usuarios armar un carrito con distintos productos.
- Generar un pedido a partir del carrito.
- Consultar el historial de pedidos.

## 🎯 Objetivo

Simular un flujo de compra digital, en el que los usuarios puedan:
1. Navegar productos disponibles.
2. Agregar ítems a su carrito.
3. Confirmar su compra generando un `Pedido`.
4. Visualizar sus pedidos.

---

## 🧩 Modelo de Dominio (UML)

Entidades principales:

- **Usuario**
    - `id`, `nombre`, `email`, `password`, `rol`
    - Relación: 1-N con `Pedido`

- **Producto**
    - `id`, `nombre`, `descripcion`, `precio`, `stockDisponible`

- **Carrito**
    - `id`, `usuario`
    - Relación: 1-N con `ItemPedido`

- **ItemPedido**
    - `id`, `producto`, `cantidad`, `subtotal`
    - Relación: N-1 con `Carrito` o `Pedido`

- **Pedido**
    - `id`, `usuario`, `fecha`, `total`, `estado`
    - Relación: 1-N con `ItemPedido`

---

## 📦 Tecnologías

- Java 17
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Jakarta Validation

---

## 📂 Estructura del proyecto
```bash
src/
├── config/ # Configuraciones de seguridad, JWT, CORS
├── controller/ # Endpoints REST
├── dto/ # Clases para transporte de datos
├── model/ # Entidades JPA (Producto, Usuario, Pedido, etc.)
├── repository/ # Interfaces JpaRepository
├── service/ # Lógica de negocio
├── exception/ # Manejo global de errores
└── security/ # Filtros y utilidades JWT
```
## 🛠️ Cómo correr el proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/tuusuario/nombre-proyecto.git
cd nombre-proyecto
``` 
2. Crear la base de datos: CREATE DATABASE gestion_pedidos;
3. Configurar application.properties con tus datos de MySQL.
4. Ejecutar: ./mvnw spring-boot:run
## 👨‍🎓 Sobre el desarrollador

**Yamil Daza**  
🎓 Estudiante de la Facultad de Informática  
📧 [dazayamil07@gmail.com](mailto:dazayamil07@gmail.com)  
🔗 [LinkedIn](https://www.linkedin.com/in/yamil-daza/)  
💻 [GitHub](https://github.com/dazayamil)
