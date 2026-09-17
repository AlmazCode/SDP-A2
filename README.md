# Game World Kit — Assignment 2: Factory Method & Abstract Factory

**Theme:** Game World Kit — a console application that creates themed game worlds with enemies, terrains, and soundtracks.

**Author:** AlmazCode

---

## Project Structure

```
SDP-A2/
├── src/
│   ├── GameWorldKit.java            # Entry point — runs both demos
│   ├── factorymethod/               # Part A: Factory Method
│   │   ├── Enemy.java               # Product interface
│   │   ├── Goblin.java              # Concrete product
│   │   ├── Skeleton.java            # Concrete product
│   │   ├── Slime.java               # Concrete product
│   │   ├── EnemySpawner.java        # Abstract Creator (factory method + business logic)
│   │   ├── GoblinSpawner.java       # Concrete Creator
│   │   ├── SkeletonSpawner.java     # Concrete Creator
│   │   ├── SlimeSpawner.java        # Concrete Creator
│   │   └── Main.java                # Demo
│   └── abstractfactory/             # Part B: Abstract Factory
│       ├── WorldEnemy.java          # Abstract product 1
│       ├── Terrain.java             # Abstract product 2
│       ├── Soundtrack.java          # Abstract product 3
│       ├── WorldFactory.java        # Abstract Factory interface
│       ├── ForestEnemy.java         # Forest family
│       ├── ForestTerrain.java
│       ├── ForestSoundtrack.java
│       ├── IceEnemy.java            # Ice family
│       ├── IceTerrain.java
│       ├── IceSoundtrack.java
│       ├── DesertEnemy.java         # Desert family
│       ├── DesertTerrain.java
│       ├── DesertSoundtrack.java
│       ├── ForestWorldFactory.java  # Concrete Factory
│       ├── IceWorldFactory.java     # Concrete Factory
│       ├── DesertWorldFactory.java  # Concrete Factory
│       ├── World.java               # Result object (built via factory)
│       ├── WorldGenerator.java      # Client helper
│       └── Main.java                # Demo
└── README.md
```

---

## How to Run

```bash
# Compile
javac -d out src/factorymethod/*.java src/abstractfactory/*.java

# Run Part A (Factory Method)
java -cp out factorymethod.Main

# Run Part B (Abstract Factory)
java -cp out abstractfactory.Main

# Run both
java -cp out GameWorldKit
```

---

## Part A — Factory Method

### What it does
Creates different enemies (Goblin, Skeleton, Slime) without hard-coding `new Goblin()` in client code. Each spawner subclass decides which enemy to create.

### Key classes

| Role | Class | Purpose |
|------|-------|---------|
| Product | `Enemy` (interface) | Defines `getName()`, `getDamage()`, `attack()` |
| Concrete Products | `Goblin`, `Skeleton`, `Slime` | Each implements `Enemy` with unique behavior |
| Abstract Creator | `EnemySpawner` | Declares `createEnemy()` (factory method) + `spawnAndAttack()` (business logic) |
| Concrete Creators | `GoblinSpawner`, `SkeletonSpawner`, `SlimeSpawner` | Override `createEnemy()` to return their specific enemy |

### Design decisions
- `EnemySpawner.spawnAndAttack()` is the **business method** that uses the product through the `Enemy` interface — the creator never knows which concrete enemy it gets.
- Client code iterates over an array of `EnemySpawner` references. It never calls `new Goblin()` etc. directly.

### SOLID connection
- **OCP (Open/Closed):** Adding a new enemy type (e.g., `Dragon`) requires only a new `Dragon implements Enemy` + `DragonSpawner extends EnemySpawner`. No existing code changes.
- **SRP (Single Responsibility):** Each spawner has one job — create one specific enemy type.

---

## Part B — Abstract Factory

### What it does
Creates a **complete themed world** — a family of 3 products (enemy + terrain + soundtrack) that must be consistent. Switching from Forest to Ice changes ALL products at once.

### Key classes

| Role | Class | Purpose |
|------|-------|---------|
| Abstract Products | `WorldEnemy`, `Terrain`, `Soundtrack` | Interfaces for the 3 product types |
| Abstract Factory | `WorldFactory` | Declares `createEnemy()`, `createTerrain()`, `createSoundtrack()` |
| Concrete Factories | `ForestWorldFactory`, `IceWorldFactory`, `DesertWorldFactory` | Each returns a fully consistent family |
| Client | `World` + `WorldGenerator` | Receives factory by composition, uses only interfaces |

### Why this is Abstract Factory (not just Factory Methods)
1. **Guaranteed compatibility:** `ForestWorldFactory` always returns Forest-themed enemy + terrain + soundtrack together. You cannot accidentally mix Forest terrain with Ice enemy.
2. **Family selection in one place:** `WorldGenerator.createWorld(factory)` — the client passes ONE factory, and the entire family is consistent.
3. **Composition over inheritance:** The `World` class receives the factory through its constructor, not through subclassing.

### Design decisions
- `World` object encapsulates the entire result — it's constructed via a `WorldFactory`, so it's always internally consistent.
- The client (`Main`) maps string names to factories in a single `Map`. This is the ONE place where the family is selected.
- Products have meaningful methods (not just markers) — `attack()`, `getDescription()`, `getMood()`.

### SOLID connection
- **OCP:** Adding a new world (e.g., `Volcano`) requires a new factory + new product classes. No changes to `WorldFactory` interface or `WorldGenerator`.
- **SRP:** Each factory creates one family. Each product type has its own interface.

---

## Factory Method vs Abstract Factory — Summary

| Aspect | Factory Method (Part A) | Abstract Factory (Part B) |
|--------|------------------------|--------------------------|
| Number of product types | 1 (`Enemy`) | 3 (`WorldEnemy` + `Terrain` + `Soundtrack`) |
| How new variants are added | New subclass of `EnemySpawner` | New factory class + all its products |
| Relies on | **Inheritance** (subclass overrides factory method) | **Composition** (client receives factory) |
| Key benefit | Decouple creation from usage | Guarantee family consistency |
| Weak spot | Adding a new product type requires changing the Creator | Adding a new product type requires changing the Factory interface + ALL factories |

---

## Potential Drawbacks

1. **Over-engineering for simple cases:** If you only ever need one enemy type, Factory Method adds unnecessary class hierarchy.
2. **Abstract Factory explosion:** Adding a 4th product type (e.g., `Weather`) to Part B means adding a method to `WorldFactory` AND updating all 3 concrete factories — violates OCP in that direction.
3. **Hard to test in isolation:** Factory classes create concrete objects internally, so unit testing the client requires mocking the factory interface.

---

## What to Say in Defense

**Q: Why is Part A Factory Method?**
A: Because `EnemySpawner` is the abstract creator with a factory method `createEnemy()`. Each concrete spawner overrides it. The business method `spawnAndAttack()` uses the product through the `Enemy` interface — it doesn't know which enemy it gets.

**Q: Why is Part B Abstract Factory?**
A: Because `WorldFactory` creates a FAMILY of 3 related products. Client code (`World`) receives the factory by composition and only uses the interfaces. Switching the factory switches the entire world consistently.

**Q: How does this connect to SOLID?**
A: OCP — adding a new enemy/world doesn't modify existing classes. SRP — each class has one reason to change (one spawner per enemy type, one factory per world).

**Q: What's the difference between the two patterns?**
A: Factory Method uses inheritance to decide which single product to create. Abstract Factory uses composition to create a whole family of compatible products at once.
