# 🎯 Adivina el Número

Juego de consola desarrollado en **Java** en el que el usuario debe adivinar un
número aleatorio generado por el programa, contando con una cantidad limitada
de intentos y recibiendo pistas en cada uno.

Proyecto de la materia **Introducción a la Programación**.

---

## 🎮 ¿Cómo se juega?

1. El programa genera un **número aleatorio** dentro de un rango.
2. El jugador tiene un **número limitado de intentos** para adivinarlo.
3. En cada intento el programa indica si el número secreto es **mayor** o
   **menor** que el valor ingresado.
4. Si lo adivina antes de quedarse sin intentos, **gana**; de lo contrario,
   **pierde** y se revela el número secreto.

### Niveles de dificultad

| Dificultad | Rango        | Intentos |
|------------|--------------|----------|
| Fácil      | 1 a 50       | 10       |
| Medio      | 1 a 100      | 7        |
| Difícil    | 1 a 200      | 8        |

---

## 🧱 Estructura del proyecto

El código está organizado en **paquetes** según su responsabilidad:

```
AdivinaElNumero/
├── src/
│   ├── juego/
│   │   └── JuegoAdivinarNumero.java  → Lógica del juego (número secreto, comparación de intentos)
│   └── app/
│       ├── MenuControlador.java      → Menú, entrada/salida y desarrollo de la partida
│       └── Main.java                 → Clase principal (método main)
├── dist/
│   └── AdivinaElNumero.jar           → Archivo JAR ejecutable
├── .classpath / .project             → Configuración del proyecto Eclipse
└── README.md
```

---

## ☕ Características de Java utilizadas

Tal como pide la consigna, la aplicación demuestra el uso de:

- **Estructuras de control:** `if / else if / else` (pistas), `switch` (menú y
  selección de dificultad), `for` (control de intentos), `while` (bucle del menú
  y validación de entradas).
- **Entrada / salida:** `Scanner` para leer del teclado y `System.out.println`
  para mostrar mensajes.
- **Clases y objetos:** la clase `JuegoAdivinarNumero` encapsula los datos de la
  partida (atributos privados) y expone métodos públicos; `MenuControlador`
  gestiona la interacción y las estadísticas de la sesión.
- **Creación de paquetes:** `juego` (lógica) y `app` (aplicación / interfaz).
- **Validación de entradas:** si el usuario escribe texto donde se espera un
  número, se captura la excepción y se vuelve a pedir el dato sin cerrar el
  programa. Los números fuera de rango tampoco consumen un intento.

---

## ▶️ Cómo ejecutar

### Opción A — Ejecutar el JAR (recomendado)

Requiere **Java 8 o superior**:

```bash
java -jar dist/AdivinaElNumero.jar
```

### Opción B — Compilar y ejecutar desde la línea de comandos

```bash
# Compilar a la carpeta bin/
javac -encoding UTF-8 -d bin src/juego/*.java src/app/*.java

# Ejecutar
java -cp bin app.Main
```

### Opción C — Abrir en Eclipse

1. `File` → `Import...` → `General` → `Existing Projects into Workspace`.
2. Seleccioná la carpeta `AdivinaElNumero`.
3. Clic derecho sobre `Main.java` → `Run As` → `Java Application`.

---

## ☁️ Subir el proyecto a GitHub

El repositorio ya está inicializado localmente con varios commits. Para
publicarlo en GitHub:

```bash
# 1. Crear un repositorio vacío en github.com (por ejemplo: AdivinaElNumero)
# 2. Vincularlo y subir el código:
git remote add origin https://github.com/TU_USUARIO/AdivinaElNumero.git
git branch -M main
git push -u origin main
```

Luego compartí el enlace del repositorio a través del campus virtual.

---

## 👤 Autor

Trabajo realizado para la materia **Introducción a la Programación**.
