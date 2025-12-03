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

### Abstract Class Design
The abstract class CheckBounds allows for methods that can be reused across
all list implementations. Index bounds checking was made to handle
any out of bounds exceptions and that operations are performed within valid
indices. Size tracking is also included as it is needed in order to 
determine the size for the upper limit in checking bounds. the size method allows
for all implementations to access the list size. This prevents
repetitive code in every individual class. 

Regarding how
this affects the rest of the code, the CheckBounds class implements the List interface
and all the list variants extend this abstract class. As a result, all list varaints
don't need their own size variable since it's inherited.
