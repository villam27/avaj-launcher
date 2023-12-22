# Avaj Launcher 

## Description

The Avaj Launcher project is a simulation of an aviation scenario. It allows the creation and simulation of different aircraft flying in various weather conditions according to a given class diagram written in UML. The program takes input from a scenario file, simulates the aircraft movements, and produces output detailing their final positions.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
- [Usage](#usage)
- [Diagram](#diagram)
- [Input Format](#input-format)
- [Output Format](#output-format)
- [Example](#example)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed (version 17 or later)
- [Git](https://git-scm.com/) installed

### Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/villam27/avaj-launcher
   ```

2. Run:

   ```bash
   cd avaj-launcher
   sh launch.sh scenario.txt
   ```

## Diagram

![uml](https://github.com/villam27/avaj-launcher/blob/master/uml.jpg)

## Input Format

The scenario file should follow a specific format:

```
<retry>
<aircraft> <name> <latitude> <longitude> <height>
```

- `aircraft`: aircraft type (`Baloon`, `Helicopter`,  or `JetPlane`)
- `name`: Unique name for the aircraft
- `latitude`, `longitude`, `height`: Initial coordinates and height of the aircraft (positive integers)

## Output Format

The program outputs in **simulation.txt** the final state of each aircraft in the following format:

```
<type>#<name>(<id>): <message>
```

## Example

Suppose you have a scenario file named `scenario.txt`:

```text
2
Baloon B1 2 3 5
JetPlane J1 23 44 -32
Helicopter H1 654 33 20
```

Run the simulation:

```bash
sh launch.sh scenario.txt
```

The program will output:

```text
Tower says: Baloon#B1(0) registered from weather tower.
Tower says: JetPlane#J1(1) registered from weather tower.
Tower says: Helicopter#H1(2) registered from weather tower.
Baloon#B1(0): Oh the sun is burning my eyes.
JetPlane#J1(1): Freeeezing!!!
JetPlane#J1(1): landing.
Tower says: JetPlane#J1(1) unregistered from weather tower.
Helicopter#H1(2): Its so cold we are losing height!
Baloon#B1(0): I'm all wet.
Helicopter#H1(2): Its so cold we are losing height!
Helicopter#H1(2): landing.
Tower says: Helicopter#H1(2) unregistered from weather tower.
```
