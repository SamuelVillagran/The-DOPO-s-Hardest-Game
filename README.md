<div align="center">

<pre>
██████╗  ██████╗ ██████╗  ██████╗     
██╔══██╗██╔═══██╗██╔══██╗██╔═══██╗    
██║  ██║██║   ██║██████╔╝██║   ██║    
██║  ██║██║   ██║██╔═══╝ ██║   ██║    
██████╔╝╚██████╔╝██║     ╚██████╔╝    
╚═════╝  ╚═════╝ ╚═╝      ╚═════╝     
</pre>

# 🟥 The DOPO Hardest Game

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Design-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-En%20Desarrollo-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/License-Académico-green?style=for-the-badge)

**Escuela Colombiana de Ingeniería Julio Garavito**  
Desarrollo Orientado por Objetos (POOB) · 2026-1  
*Propuesta por:* **Santiago Garcia** & **Kevin Angel**

</div>

---

## 📖 ¿Qué es esto?

> **The DOPO Hardest Game** es una reimaginación del clásico *The World's Hardest Game*, desarrollada en Java como proyecto final del curso POOB. El jugador controla un cuadrado que debe esquivar enemigos en constante movimiento, recolectar monedas y llegar a la zona segura... si puede.

Esta versión introduce **nuevas mecánicas, modos de juego y tipos de personajes** que llevan la experiencia más allá del original.

---

## 🎮 Modos de Juego

| Modo | Descripción |
|------|-------------|
| 🟥 **Player** | Modalidad clásica. Un jugador controla el cuadrado rojo. |
| ⚔️ **Player vs Player** | Dos jugadores compiten simultáneamente. Gana quien complete el nivel con **menos muertes** y en **menor tiempo**. |
| 🤖 **Player vs Machine** | Similar al PvsP, pero uno de los cuadrados es controlado por la **IA**. |

> ⏱️ **Todas las modalidades tienen un límite de 3 minutos por nivel.**

---

## 🧍 Personajes (Skins)

```
  ┌───────┐     ┌───────┐     ┌───────┐
  │       │     │       │     │       │
  │  🟥  │     │   🟦  │     │  🟩   │
  │       │     │       │     │       │
  └───────┘     └───────┘     └───────┘
   ROJO           AZUL           VERDE
  Clásico        Rápido        Resistente
```

| Skin | Velocidad | Tamaño | Habilidad especial |
|------|-----------|--------|--------------------|
| 🟥 **Rojo** | 1x | Normal | Ninguna |
| 🟦 **Azul** | 1.5x | Incrementado | Mayor velocidad |
| 🟩 **Verde** | 1x → 0.7x | Normal | Absorbe el **primer golpe** sin morir |

---

## 🗺️ Elementos del Escenario

### 🪙 Objetivos
- **Monedas amarillas** — Estáticas. Deben recolectarse **todas** para completar el nivel.
- **Zona segura intermedia** 🟢 — Guarda un nuevo punto de reaparición al pisarla.
- **Zona segura final** 🟢 — Meta. Solo se puede llegar después de recoger todas las monedas.

### 👾 Enemigos
> *Todos eliminan al jugador al contacto.*

| Enemigo | Comportamiento |
|---------|----------------|
| 🔵 **Punto Azul Básico** | Se desplaza en líneas rectas (H/V). Rebota en paredes. |
| 🔵 **Punto Azul Patrullero** | Sigue rutas circulares o figuras geométricas predefinidas. |
| 🔵 **Punto Azul Rápido** | Movimiento lineal a **2x** la velocidad normal. |

### 🧱 Obstáculos
- **Paredes sólidas** — Ninguna entidad puede atravesarlas.

---

## 📋 Reglas del Juego

```
1. Recolecta TODAS las monedas → llega a la zona segura → ¡nivel completado!
2. Si un enemigo te toca      → reinicio en el nivel actual + (+1 muerte)
3. Zona segura intermedia     → nuevo punto de reaparición guardado
4. Tiempo agotado             → derrota
```

---

## ⚙️ Configuración de Niveles

El juego maneja **mínimo 3 niveles**. Cada nivel puede configurarse con:

- 📍 Número y posición de monedas
- 👾 Tipos de enemigos y cantidad
- 🧱 Tipos de obstáculos y disposición
- 🟢 Zona de inicio y zona(s) segura(s)

---

## 🖥️ Requisitos Funcionales

- [x] Modificar la configuración de los niveles
- [x] Seleccionar modalidad, nombre y color del jugador
- [x] Movimiento de cada jugador
- [x] Mostrar estado del juego (muertes y tiempo restante)
- [x] Pausar el juego momentáneamente
- [x] Terminar el juego en cualquier momento
- [x] Mostrar mensaje de victoria con puntaje
- [x] Guardar y cargar partidas

---

## 🎨 Requisitos de Diseño

### Extensibilidad
- Nuevos niveles con diferentes mapas
- Nuevos tipos de jugadores, enemigos y obstáculos

### Visualización

```
┌─────────────────────────────────────────────────┐
│  ⏱ Tiempo: 02:47   💀 Muertes: 3   🪙 0/5       │
├─────────────────────────────────────────────────┤
│                                                 │
│   🟢[INICIO]   ···🪙···🪙···   🔵   🔵          │
│                                                 │
│       🟥  →         🪙              🔵           │
│                                                 │
│                 🪙        🪙   🟢[META]          │
│                                                 │
└─────────────────────────────────────────────────┘
```

- Representación gráfica completa del escenario
- Cada entidad tiene una representación visual única
- HUD visible: tiempo restante, puntaje, muertes y monedas recolectadas

### Manejo de Excepciones
- Clase de excepción propia del proyecto
- Log de errores integrado

---

## 🖼️ Anexo Visual
 
| Jugadores | Enemigos | Monedas |
|:---------:|:--------:|:-------:|
| 🟥 Rojo | 🔵 Punto Azul | 🟡 Moneda |
| 🟦 Azul | | |
| 🟩 Verde | | |
 
| Entidad | Color exterior | Color interior | Forma |
|---------|---------------|----------------|-------|
| Jugador Rojo | — | 🔴 Rojo | Cuadrado |
| Jugador Azul | — | 🔵 Azul | Cuadrado (más pequeño) |
| Jugador Verde | — | 🟢 Verde | Cuadrado |
| Enemigo | ⚫ Negro | 🔵 Azul | Círculo |
| Moneda | ⚫ Negro | 🟡 Amarillo | Círculo |
 
---

## 🛠️ Tecnologías

| Tecnología | Uso |
|------------|-----|
| **Java** | Lenguaje principal |
| **OOP / POOB** | Paradigma de diseño |
| **Swing / JavaFX** | Interfaz gráfica |
| **Serialización Java** | Guardado de partidas |

---

## 👥 Autores

<table>
  <tr>
    <td align="center">👨‍💻 <b>Santiago Garcia</b></td>
    <td align="center">👨‍💻 <b>Kevin Angel</b></td>
  </tr>
  <tr>
    <td align="center"><i>Propuesta</i></td>
    <td align="center"><i>Propuesta</i></td>
  </tr>
  <tr>
    <td align="center">👨‍💻 <b>Hernan David Sánchez</b></td>
    <td align="center">👨‍💻 <b>Samuel Steveen Villagrán</b></td>
  </tr>
  <tr>
    <td align="center"><i>Desarrollo</i></td>
    <td align="center"><i>Desarrollo</i></td>
  </tr>
</table>

---

<div align="center">


*📝 Este README fue generado con ayuda de **[Claude](https://claude.ai)** (Anthropic)*  
*Escuela Colombiana de Ingeniería Julio Garavito · POOB 2026-1*

</div>
