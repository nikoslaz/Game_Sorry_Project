# 🎲 Sorry Board Game - Java Implementation

## 📌 Project Overview
A complete Java implementation of the classic "Sorry!" board game using Model-View-Controller (MVC) architecture. Developed for the Object-Oriented Programming course at University of Crete.

## 🎯 Features

### 🏗️ Core Components
| Component       | Description                                                                 |
|----------------|-----------------------------------------------------------------------------|
| **Game Board** | 16x16 grid with special squares (Start, Home, Safety Zone, Slides)         |
| **Cards**      | Full deck including Number cards (1,2,4,7,10,11) and special Sorry cards    |
| **Players**    | 2-player system with colored pawns and turn management                      |
| **GUI**        | Graphical interface with game controls and visual feedback                  |

### 🕹️ Game Mechanics
- ✔️ Card-based movement system
- ✔️ Slide mechanics (Start/Internal/End slides)
- ✔️ Pawn collision handling
- ✔️ Turn management
- ✔️ Win condition detection

## 🎮 Controller

- Manages game state transitions  
- Validates player moves  
- Handles card effects  
- Controls turn flow  

---

## 🖥️ View Components

| Class       | Purpose                    |
|-------------|----------------------------|
| GraphicUI   | Main game interface        |
| MenuDialog  | Game menu and options      |
| WishDialog  | Special card interactions  |

