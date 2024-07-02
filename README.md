# Instrucciones para Inicializar el Proyecto

## Frontend

Para iniciar el frontend, sigue estos pasos:

1. **Instalación de Dependencias:**
   ```bash
   npm install
   npm start

## Backend
   LAS TABLAS SE GENERAN AL INICIAR EL API PERO DEBERA CREAR ANTES LA BASE DE DATOS futbol 
   
1. **Configuracion de credenciales:**
   ```
   ESTA CONFIGRACION ESTA EN EL ARCHIVO src/main/resources/application.properties
   
   spring.datasource.url=jdbc:mysql://localhost:3306/futbol
   spring.datasource.username=usuario
   spring.datasource.password=contraseña

2. **Datos de ejemplo:**
     Con este script creara ejemplos de datos de posiciones y jugadores
   -- Insertar posiciones
   ```
      INSERT INTO posicion (nombre) VALUES
      ('Portero'),
      ('Defensa'),
      ('Centrocampista'),
      ('Delantero'),
      ('Volante');
   ```
   -- Insertar jugadores
   ```
      INSERT INTO jugador (nombre, apellido, caracteristicas, fecha_nacimiento, id_posicion) VALUES
      ('Lionel', 'Messi', 'Rápido y hábil con el balón', '1987-06-24', 4), -- Delantero
      ('Cristiano', 'Ronaldo', 'Potente remate y velocidad', '1985-02-05', 4), -- Delantero
      ('Sergio', 'Ramos', 'Fuerte en defensa y juego aéreo', '1986-03-30', 2), -- Defensa
      ('Luka', 'Modric', 'Visión de juego y precisión en pases', '1985-09-09', 3), -- Centrocampista
      ('Manuel', 'Neuer', 'Excelente en paradas y juego con los pies', '1986-03-27', 1); -- Portero

3. **Documentacion del api**
   ```
   http://127.0.0.1:8001/swagger-ui.html
