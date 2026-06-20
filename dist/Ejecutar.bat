@echo off
REM Lanzador del juego "Adivina el Numero".
REM Ejecuta el JAR en una ventana de consola y la mantiene abierta al finalizar.
cd /d "%~dp0"
java -jar AdivinaElNumero.jar
echo.
pause
