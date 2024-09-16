**Aplicacion de Escritorio(SISTEMA ACADEMICO) - TUTORIAS SEGUNDO SEMESTRE**

![tutoriasJframeP1](https://github.com/user-attachments/assets/4c9123ed-cd3b-4bfc-82ba-b02d4a857331)
![tutoriasJframeP2](https://github.com/user-attachments/assets/d792e232-50ca-4dfc-88ab-53a32db1d94c)
![tutoriasJframeP3](https://github.com/user-attachments/assets/ba9a3a37-5631-46ec-993f-48a89dfaab9e)
![tutoriasJframeP4](https://github.com/user-attachments/assets/6d5097cc-29ec-4ddd-9ac2-f96841c03465)



<h2 align="left">Herramientas para el Proyecto</h2>
<div align="center">
  <div style="border: 1px solid #4CAF50; border-radius: 5px; padding: 10px; margin-bottom: 10px; width: 80%;">
    <p align="left">
      <strong>Librerias Necesarias</strong><br>
      <a href="https://sites.google.com/view/programacioncmv/principal" target="blank">→ Descargar</a>
    </p>
  </div>

  <div align="center">
  <div style="border: 1px solid #4CAF50; border-radius: 5px; padding: 10px; margin-bottom: 10px; width: 80%;">
    <p align="left">
      <strong>Carpeta de Iconos Miniminalistas</strong><br>
      <a href="https://www.mediafire.com/file/p3zkq9gasghj403/Iconos.zip/file" target="blank">→ Descargar</a>
    </p>
  </div>

  <div align="center">
  <div style="border: 1px solid #4CAF50; border-radius: 5px; padding: 10px; margin-bottom: 10px; width: 80%;">
    <p align="left">
      <strong>Mini proyecto de Login </strong><br>
      <a href="https://www.mediafire.com/file/n3sg1n35rbply7g/loginHospital.zip/file" target="blank">→ Descargar</a>
    </p>
  </div>

<div class="container">
    <h1>Tablas SQL - Plataforma Universitaria</h1>

  <div class="code-block">
        <h3>Crear la tabla de usuarios</h3>
        <div class="code">
            <pre>
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    rol ENUM('estudiante', 'profesor', 'rector') NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE
);
            </pre>
        </div>
    </div>

   <div class="code-block">
        <h3>Crear la tabla de materias</h3>
        <div class="code">
            <pre>
CREATE TABLE materias (
    id_materia INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_profesor INT NOT NULL,
    llave_acceso VARCHAR(10) NOT NULL UNIQUE,
    FOREIGN KEY (id_profesor) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);
            </pre>
        </div>
    </div>

  <div class="code-block">
        <h3>Crear la tabla de estudiantes_materias</h3>
        <div class="code">
            <pre>
CREATE TABLE estudiantes_materias (
    id_estudiante INT NOT NULL,
    id_materia INT NOT NULL,
    fecha_inscripcion DATE NOT NULL,
    PRIMARY KEY (id_estudiante, id_materia),
    FOREIGN KEY (id_estudiante) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_materia) REFERENCES materias(id_materia) ON DELETE CASCADE
);
            </pre>
        </div>
    </div>

  <div class="code-block">
        <h3>Crear la tabla de tareas</h3>
        <div class="code">
            <pre>
CREATE TABLE tareas (
    id_tarea INT AUTO_INCREMENT PRIMARY KEY,
    id_materia INT NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_entrega DATE NOT NULL,
    FOREIGN KEY (id_materia) REFERENCES materias(id_materia) ON DELETE CASCADE
);
            </pre>
        </div>
    </div>

  <div class="code-block">
        <h3>Crear la tabla de notas</h3>
        <div class="code">
            <pre>
CREATE TABLE notas (
    id_nota INT AUTO_INCREMENT PRIMARY KEY,
    id_estudiante INT NOT NULL,
    id_tarea INT NOT NULL,
    nota DECIMAL(5,2) NOT NULL CHECK (nota >= 0 AND nota <= 100),
    comentario TEXT,
    FOREIGN KEY (id_estudiante) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_tarea) REFERENCES tareas(id_tarea) ON DELETE CASCADE
);
            </pre>
        </div>
    </div>

  <div class="code-block">
        <h3>Crear la tabla de asistencia</h3>
        <div class="code">
            <pre>
CREATE TABLE asistencia (
    id_asistencia INT AUTO_INCREMENT PRIMARY KEY,
    id_estudiante INT NOT NULL,
    id_materia INT NOT NULL,
    fecha_clase DATE NOT NULL,
    estado ENUM('presente', 'ausente') NOT NULL,
    FOREIGN KEY (id_estudiante) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_materia) REFERENCES materias(id_materia) ON DELETE CASCADE
);
            </pre>
        </div>
    </div>

  <div class="code-block">
        <h3>Crear la tabla de notificaciones (opcional)</h3>
        <div class="code">
            <pre>
CREATE TABLE notificaciones (
    id_notificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    mensaje TEXT NOT NULL,
    leido BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);
            </pre>
        </div>
    </div>
</div>

</body>
</html>

