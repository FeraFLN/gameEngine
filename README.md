# GameEngine Project

Welcome to the GameEngine project! This project was created as a personal learning endeavor to deepen my understanding of threading in Java and to practice implementing the SOLID principles for the first time. It serves as a demonstration of my growth as a software developer and is intended to showcase my portfolio.

## Project Overview

The GameEngine project is a lightweight game engine designed to provide a foundational understanding of key software engineering concepts, including multithreading and clean code architecture. By integrating threading and adhering to the SOLID principles, this project reflects my commitment to writing scalable, maintainable, and efficient code.

## Features

- **Multithreading**: Efficiently manages concurrent tasks to optimize performance.
- **SOLID Principles**: Implements Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion principles.
- **Core Game Functionality**:
  - Basic 2D rendering capabilities.
  - Input handling for keyboard and mouse interactions.
  - Simple game loop implementation to manage updates and rendering.
- **Modular Design**: Built with extensibility in mind, allowing for easy addition of new features.

## Purpose

This project serves as:
- **A Learning Experience**: To explore advanced Java concepts such as threading and clean code architecture.
- **A Portfolio Piece**: To demonstrate my ability to design and implement foundational systems with a focus on best practices.
- **A Foundation for Growth**: A starting point for future enhancements, such as advanced rendering techniques, physics simulations, or networked gameplay.

## Requirements

To run or explore the GameEngine, ensure your system meets the following requirements:

- **Programming Language**: Java 11 or higher.
- **Build Tool**: Maven.
- **Dependencies**:
  - Java Standard Libraries (for threading and core functionality).
  - Optional: JUnit for testing.

## Installation

Follow these steps to set up and run the GameEngine on your system:

1. **Clone the Repository**:
   ```bash
   git clone <repository_url>
   cd gameEngine
   ```

2. **Build the Project**:
   - Using Maven:
     ```bash
     mvn clean install
     ```
  
3. **Run the Engine**:
   ```bash
   java -jar target/gameEngine.jar
   ```

## Usage

### Exploring the Code

- **Threading**: Check the `engine.threading` package to see how multithreading is implemented for tasks like game loops and resource loading.
- **SOLID Principles**: Review the architecture to observe how SOLID principles are applied in class design and module separation.

### Running Examples

The `examples` directory includes simple demonstration games built with the GameEngine to showcase its functionality and potential.

1. **Mario Demo**

![This is an image](https://github.com/FeraFLN/gameEngine/blob/master/MM/mario/demo_mario.gif)

2. **Space B**

![This is an image](https://github.com/FeraFLN/gameEngine/blob/master/MM/spaceB/demo.gif)

3. **Pong**

![This is an image](https://github.com/FeraFLN/gameEngine/blob/master/MM/pong/demo.gif)

### Extending the Engine

You can extend the GameEngine by adding new modules or features. For example:
- Add support for new input devices.
- Implement advanced rendering techniques.
- Introduce networked multiplayer capabilities.

## Contributing

As this project is primarily a personal learning initiative, contributions are welcome but not expected. If you have suggestions or improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact

If you have any questions about this project or would like to discuss collaboration opportunities, feel free to reach out:
- **Email**: fernando.limeira.n@gmail.com

---

Thank you for taking the time to explore the GameEngine project. I hope it provides insight into my skills and dedication to learning and applying software development best practices.

