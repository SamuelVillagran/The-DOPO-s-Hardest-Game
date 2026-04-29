<div align="center">
██████╗  ██████╗ ██████╗  ██████╗     
██╔══██╗██╔═══██╗██╔══██╗██╔═══██╗    
██║  ██║██║   ██║██████╔╝██║   ██║    
██║  ██║██║   ██║██╔═══╝ ██║   ██║    
██████╔╝╚██████╔╝██║     ╚██████╔╝    
╚═════╝  ╚═════╝ ╚═╝      ╚═════╝
🟥 The DOPO Hardest Game
¿Crees que puedes con él?
[how Image](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
[Show Image](https://img.shields.io/badge/OOP-Design-blue?style=for-the-badge)
[Show Image](https://img.shields.io/badge/Status-En%20Desarrollo-yellow?style=for-the-badge)
[Show Image](https://img.shields.io/badge/License-Acad%C3%A9mico-green?style=for-the-badge)
Escuela Colombiana de Ingeniería Julio Garavito
Desarrollo Orientado por Objetos (POOB) · 2026-1
Propuesta por: Santiago Garcia & Kevin Angel
</div>

📖 ¿Qué es esto?

The DOPO Hardest Game es una reimaginación del clásico The World's Hardest Game, desarrollada en Java como proyecto final del curso POOB. El jugador controla un cuadrado que debe esquivar enemigos en constante movimiento, recolectar monedas y llegar a la zona segura... si puede.

Esta versión introduce nuevas mecánicas, modos de juego y tipos de personajes que llevan la experiencia más allá del original.

🎮 Modos de Juego
ModoDescripción🟥 PlayerModalidad clásica. Un jugador controla el cuadrado rojo.⚔️ Player vs PlayerDos jugadores compiten simultáneamente. Gana quien complete el nivel con menos muertes y en menor tiempo.🤖 Player vs MachineSimilar al PvsP, pero uno de los cuadrados es controlado por la IA.

⏱️ Todas las modalidades tienen un límite de 3 minutos por nivel.


🧍 Personajes (Skins)
  ┌───────┐     ┌───────┐     ┌───────┐
  │       │     │       │     │       │
  │  🟥   │     │  🟦   │     │  🟩   │
  │       │     │       │     │       │
  └───────┘     └───────┘     └───────┘
   ROJO           AZUL           VERDE
  Clásico        Rápido        Resistente
SkinVelocidadTamañoHabilidad especial🟥 Rojo1xNormalNinguna🟦 Azul1.5xIncrementadoMayor velocidad🟩 Verde1x → 0.7xNormalAbsorbe el primer golpe sin morir

🗺️ Elementos del Escenario
🪙 Objetivos

Monedas amarillas — Estáticas. Deben recolectarse todas para completar el nivel.
Zona segura intermedia 🟢 — Guarda un nuevo punto de reaparición al pisarla.
Zona segura final 🟢 — Meta. Solo se puede llegar después de recoger todas las monedas.

👾 Enemigos

Todos eliminan al jugador al contacto.

EnemigoComportamiento🔵 Punto Azul BásicoSe desplaza en líneas rectas (H/V). Rebota en paredes.🔵 Punto Azul PatrulleroSigue rutas circulares o figuras geométricas predefinidas.🔵 Punto Azul RápidoMovimiento lineal a 2x la velocidad normal.
🧱 Obstáculos

Paredes sólidas — Ninguna entidad puede atravesarlas.


📋 Reglas del Juego
1. Recolecta TODAS las monedas → llega a la zona segura → ¡nivel completado!
2. Si un enemigo te toca → reinicio en el nivel actual + (+1 muerte)
3. Pisar una zona segura intermedia → nuevo punto de reaparición guardado
4. Tiempo agotado → derrota

⚙️ Configuración de Niveles
El juego maneja mínimo 3 niveles. Cada nivel puede configurarse con:

📍 Número y posición de monedas
👾 Tipos de enemigos y cantidad
🧱 Tipos de obstáculos y disposición
🟢 Zona de inicio y zona(s) segura(s)


🖥️ Requisitos Funcionales

 Modificar la configuración de los niveles
 Seleccionar modalidad, nombre y color del jugador
 Movimiento de cada jugador
 Mostrar estado del juego (muertes y tiempo restante)
 Pausar el juego momentáneamente
 Terminar el juego en cualquier momento
 Mostrar mensaje de victoria con puntaje
 Guardar y cargar partidas


🎨 Requisitos de Diseño
Extensibilidad

Nuevos niveles con diferentes mapas
Nuevos tipos de jugadores, enemigos y obstáculos

Visualización
┌─────────────────────────────────────────────────┐
│  ⏱ Tiempo: 02:47   💀 Muertes: 3   🪙 0/5       │
├─────────────────────────────────────────────────┤
│                                                 │
│   🟢[INICIO]    ···🪙···🪙···   🔵  🔵          │
│                                                 │
│       🟥  →          🪙              🔵          │
│                                                 │
│                  🪙        🪙   🟢[META]         │
│                                                 │
└─────────────────────────────────────────────────┘

Representación gráfica completa del escenario
Cada entidad tiene una representación visual única
HUD visible: tiempo restante, puntaje, muertes y monedas recolectadas

Manejo de Excepciones

Clase de excepción propia del proyecto
Log de errores integrado


🖼️ Anexo Visual
  JUGADORES          ENEMIGOS          MONEDAS

 ┌─────────┐
 │ ██████  │
 │ ██████  │        ╭───────╮         ╭───────╮
 │ ██████  │       ╱  ╭───╮  ╲       ╱  ╭───╮  ╲
 └─────────┘      │  │ ● │  │       │  │ ● │  │
   (Rojo)          ╲  ╰───╯  ╱       ╲  ╰───╯  ╱
                    ╰───────╯         ╰───────╯
 ┌─────────┐        (azul/azul)       (negro/amarillo)
 │ ██████  │
 │ ██████  │
 │ ██████  │
 └─────────┘
   (Azul)

 ┌─────────┐
 │ ██████  │
 │ ██████  │
 │ ██████  │
 └─────────┘
   (Verde)

🛠️ Tecnologías
TecnologíaUsoJavaLenguaje principalOOP / POOBParadigma de diseñoSwing / JavaFXInterfaz gráficaSerialización JavaGuardado de partidas

👥 Quienes propusieron los requisitos son:
<table>
  <tr>
    <td align="center">👨‍💻 <b>Santiago Garcia</b></td>
    <td align="center">👨‍💻 <b>Kevin Angel</b></td>
  </tr>
  <tr>
    <td align="center">Escuela Colombiana de Ingeniería</td>
    <td align="center">Escuela Colombiana de Ingeniería</td>
  </tr>
</table>

<div align="center">
Autores del repositorio: Hernan David Sanchéz - Samuel Steveen Villagran

📝 Este README fue creado con ayuda de Claude (Anthropic) — claude.ai
Escuela Colombiana de Ingeniería Julio Garavito · DOPO 2026-1
</div>
