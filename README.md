# GUI-Calculator
Basic calculator with a GUI, in Java

### Functionality
I wanted this to be a quick, 3-4 hour project, so it isn't too copmlicated. No decimals, 7 digit input limit, and 17 digit output limit. There are 5 operands, add (```+```), subtract (```-```), multiply (```*```), divide (```/```), and modulus (```%```). You can do successive operations, example: 
1. ```2```
2. ```+```
3. ```6```
4. ```/``` *(displays 8)*
5. ```2```
6. ```=``` *(displays 2)*

When you press the button for the succesive operation (like in step 4 above), it will display the answer to the last operation as though you had pressed ```=```, ```Ans```, and then the operator you wanted to perform next (which is what happens in the code)

The ```Ans``` will just fill the text field with the answer from the previous operation. If you have selected an operator before pressing the ans button, the ans will fill the second value's spot, instead of the first. Example:
1. ```2```
2. ```+```
3. ```2```
4. ```=``` *(displays 4)*
5. ```1```
6. ```+```
7. ```Ans```
8. ```=``` *(displays 5)*

All of the buttons also print the command to the console, so you can see a basic history of commands (not answers though)

If there are any questions, comments, or constructive criticism feel free to reach out :)
