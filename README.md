# MassiveMotion
CS 245 Project 02

### Celestial Simulation
Simulation of stars and comets using custom list implementations. The simulation itself can be edited using the property file.


### Performance
Visually all implementations look the same, but when comparing the time complexity 
for accessing indices, the ArrayList will be the most efficient as the runtime for accessing elements is O(1),
where as all the LinkedList variants have O(n) access.
This is important since the window is constantly updating, resulting in the get() method for these lists being called many times.


### Running Implementations
[ArrayList Implementation](https://drive.google.com/file/d/1qjobuT_MkWbObPmStXOfwkspqLme2ysI/view?usp=drive_link)

[Singly Linked List](https://drive.google.com/file/d/1J5LNArqYan3pcDWR7mcQLyjTrRGD0V80/view?usp=drive_link)

[Doubly Linked List](https://drive.google.com/file/d/1nQK7phP2TmOajuNqC7k7iZ0HPoibIibv/view?usp=drive_link)

[Dummy Head Linked List](https://drive.google.com/file/d/1GQj-j14RJxg-VKV54kA84_3OXxOzmgSw/view?usp=drive_link)

### Updates
-Interface methods throw exceptions

-Implemented an Abstract class with shared method for checking lower and upper bounds of a list


-All list implementations now extend the abstract class which has the size variable as well


-Abstract class inherits List interface

