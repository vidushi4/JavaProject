# Creative visualisation of Water Jug algorithm
This project is aimed to graphically and creatively visualize the famous waterjug problem. Concept of Java Swing is used to achieve the purpose. Java swing is a set of classes that provides the powerful and flexible Graphical User Interface components which provide the look and feel of modern Java GUI. Java Swing is used to provide the best user interface.

## Problem statement
The problem statement of water-jug problem states that- We are given a m litre jug and a n litre jug where 0 < m < n. Both the jugs are initially empty. The jugs don’t have markings to allow measuring smaller quantities. We have to use the jugs to measure d litres of water. There is an infinite supply of water. Now, we need to determine the minimum no of operations to be performed to obtain d litres of water in one of jugs.

### Technology used
This project mainly involved the use of following concepts of Java:
Java Swings
AWT
Multithreading
Control statements
Classes

### Algorithm
Suppose the two jugs are A and B with m and n capacities respectively. The operations we can perform are:
• Empty a Jug <br>
• Fill a Jug <br>
• Pour water from one jug to the other until one of the jugs is either empty or full. <br>
Thus the possible algorithm for the problem is as follows: <br>
o Fill the n litre jug and empty it into m litre jug. <br>
o Whenever the n litre jug becomes empty fill it. <br>
o Whenever the m litre jug becomes full empty it.<br>
o Repeat steps 1, 2 and 3 till either n litre jug or the m litre jug contains d litres of water.

### Components used for visualization
• Text fields for taking user input for the jugs’ capacities and the required amount. <br>
• Button for submitting the values.<br>
• Text area for displaying the instructions.<br>
• Graphics class methods to visualize the jugs and water movement.<br>
