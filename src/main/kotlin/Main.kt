package org.example

import kotlin.math.PI

fun main() {
    println("Hello World!");
//    println(arithmetic());
//    readWrite();
//    ifElseCondition();
//    whenExpression();
//    switchFunction();
//    exceptionHandling();
//    arrayOperations();
//    loopOperations();
//    reverseString();
//    classOperations();
//    interfaceAndAbstractClassImplementation();
    classInheritanceImplementation();
}

/**
 * Arithmetic operation & Comparison operations
 */
public fun arithmetic(): Double {
    val x: Int = 10;
    var y: Double = 100.0;

//    Cannot do this operation bcz val is constant
//    x = 20;

//    this is achievable bcz var is variable
    y = 50.0;

//    To print content on console
    println("value of x is $x , y is $y");
//    To compare an expression on print content in console
    println("Is x > y: ${x > y}");
    return x * y;
}

/**
 * To perform read write operation in console
 */
public fun readWrite() {
    // Simple read write
    println("Enter a Name: ");
    val input = readln();
    println("Name entered is: $input");

    println("Enter a Number: ");
    // to have null value assigned if not integer
    // to convert nullable type to non-nullable type, use: !!
    // ?: Also known as elvis operator in kotlin, similar to null-collision operator
    val number = readln().toIntOrNull() ?: 0;
    println("Number entered is: $number");
}

/**
 * To perform if-else condition
 */
public fun ifElseCondition() {
    println("Enter a Number: ");
    val number = readln().toIntOrNull();

    if(number != null){
        println("Number entered is: $number");

        val output = if(number%2 == 0) {
            "number is Even!";
        } else {
            "number is Odd!";
        }

        println("Output is: $output");
    } else {
        println("Number entered is not valid!");
    }
}

/**
 * To perform when expression
 */
public fun whenExpression() {
    println("Enter a Number: ");
    val number = readln().toIntOrNull() ?: 0;

    val output = when  {
        number < 10 -> "number is less than 10!";
        number in 10..100 -> "number is between 10 and 100!";
        else -> "number is greater than 100!";
    }

    println("Output is: $output");
}

/**
 * To perform switch function
 */
public fun switchFunction() {
    println("Enter a Number: ");
    val number = readln().toIntOrNull();

    val output = when(number)  {
        null -> "Invalid number!";
        10 -> "number entered is 10!";
        100 -> "number entered is 100!";
        in 10..100 -> "number is between 10 and 100!";
        else -> "Any other number!";
    }

    println("Output is: $output");
}

/**
 * To perform Exception Handling
 */
public fun exceptionHandling() {
    println("Enter a Number: ");
    val number = try {
        readln().toInt();
    } catch (e: NumberFormatException) {
        println(e.message);
        println("Invalid number!");
        0;
    } finally {
        println("Finally block is called");
    }

    println("Number entered is: $number");
}

/**
 * To perform Array operations
 */
public fun arrayOperations() {
    // Array index starts from 0
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    println("Array length is: ${intArray.size}");
    println("Array first element is: ${intArray.first()}");
    println("Array last element is: ${intArray.last()}");
    println("Array last index is: ${intArray.lastIndex}");

    // Equivalent of ArrayList in C#
    var array = arrayOf(-1 ,1, "one", "two", 3.0, 4.123, true, "six") + false;
    array += 'u';
    println("Array length is: ${array.size}");
    println("Array first element is: ${array.first()}");
    println("Array last element is: ${array.last()}");
    println("Array last index is: ${array.lastIndex}");
}

/**
 * To perform loop operations
 */
public fun loopOperations() {
    println("How many numbers you want to enter: ");
    var input = readln().toIntOrNull() ?: 0;

    var index = 0;
    var list = mutableListOf<Int>();
    while (index < input) {
        println("Enter the number #${index+1}");
        val number = readln().toIntOrNull() ?: continue;
        list.add(number);
        index++;
    }
    println("Number entered are: $list");

    var sum = 0;
    // just like foreach
    for (number in list) {
        sum += number;
    }
    println("Total sum of numbers: $sum");

    // use step to increment as per specified incremental value
    for(idx in 0 until list.size step 2) {
        println("number at #${idx+1}: ${list[idx]}");
    }
}

/**
 * Reverse a string using for loop
 * Example of Extension method
 * Example of Lambda functions
 */
public fun reverseString() {
    println("Enter a string:");
    val input = readln();
    println(getReverseString(input));
    //    example of using named parameters
    //    println(getReverseString(input = input));

    println(input.getAlternateLetters());

    // Approach-1 Lambda function
    println(input.myLambdaFunction {
            ch -> ch.isDigit();
    });

    // Approach-2 Lambda function
    println(input.myLambdaFunction_Approach2 {
        // cannot write like this
        // ch -> ch.isLetter();
        isLetter();
    })
}

/**
 * function getReverseString has default value parameter
 */
private fun getReverseString(input: String = "Default Value"): String {
    val result = buildString {
        for(i in input.lastIndex downTo 0) {
            append(input[i]);
        }
    }

    return result;
}

/**
 * Example of extension method
 */
private fun String.getAlternateLetters(): String {
    val result = buildString {
        for(i in this@getAlternateLetters.indices step 2) {
            append(this@getAlternateLetters[i]);
        }
    }

    return  result;
}

/**
 * Custom Lambda Function
 */
private fun String.myLambdaFunction(predicate: (Char) -> Boolean): String {
    return buildString {
        for(ch in this@myLambdaFunction) {
            if(predicate(ch)) {
                append(ch);
            }
        }
    }
}

/**
 * Custom Lambda Function
 */
private fun String.myLambdaFunction_Approach2(predicate: Char.() -> Boolean): String {
    return buildString {
        for(ch in this@myLambdaFunction_Approach2) {
            if(ch.predicate()) {
                append(ch);
            }
        }
    }
}

/**
 * class & data class operation
 */
public fun classOperations() {
    // creating class object
    val sampleClassObject = SampleClass(10, 20);
    val sampleDataClassObject = SampleDataClass(10, 20);

    // basic operations
    println("Sample Class: object1: ${sampleClassObject.object1} | object2: ${sampleClassObject.object2}");
    println("Sample Class: Sum of Objects: ${sampleClassObject.Sum} | Product of Objects: ${sampleClassObject.multiply()}");

    println("Sample Data Class: object1: ${sampleDataClassObject.object1} | object2: ${sampleDataClassObject.object2}");
    println("Sample Data Class: Sum of Objects: ${sampleDataClassObject.Sum} | Product of Objects: ${sampleDataClassObject.multiply()}");

    // check equivalent
    val sampleClassObject_twin = SampleClass(10, 20);
    val sampleDataClassObject_twin = SampleDataClass(10, 20);

    println("sampleClassObject == sampleClassObject_twin: ${sampleClassObject == sampleClassObject_twin}");
    println("sampleClassObject === sampleClassObject_twin: ${sampleClassObject === sampleClassObject_twin}");
    println("sampleDataClassObject == sampleDataClassObject_twin: ${sampleDataClassObject == sampleDataClassObject_twin}");
    println("sampleDataClassObject === sampleDataClassObject_twin: ${sampleDataClassObject === sampleDataClassObject_twin}");
}

class SampleClass(val object1: Int, val object2: Int) {
    val Sum = object1 + object2;

    public fun multiply(): Int {
        return object1 * object2;
    }
}

data class SampleDataClass(val object1: Int, val object2: Int) {
    val Sum = object1 + object2;

    public fun multiply(): Int {
        return object1 * object2;
    }
}

/**
 * To demonstrate interface & abstract class implementation
 */
public fun interfaceAndAbstractClassImplementation() {

    val circle = Circle(5.0);
    val square = Square(5.0);

    println("Sum of Areas:" + sumOfAreas(circle, square));
    println("Sum of Parameters: ${sumOfParameters(circle, square)}");

    circle.unImplementedFunction();
    circle.implementedFunction();

    square.unImplementedFunction();
    square.implementedFunction();
}

private fun sumOfAreas(vararg shapes: Shape): Double {
    return shapes.sumOf {
        shape -> shape.area();
    };
}

private fun sumOfParameters(vararg shapes: Shape): Double {
    return shapes.sumOf {
            shape -> shape.parameter;
    };
}

interface Shape {
    val parameter: Double;
    fun area(): Double;
}

abstract class SampleAbstractClass {
    abstract fun unImplementedFunction(): Unit;

    fun implementedFunction(): Unit {
        println("This is an Implemented function from Abstract Class");
    }
}

class Circle(private val radius: Double) : Shape, SampleAbstractClass() {
    override val parameter: Double
        get() = 2 * PI * radius;

    override fun area(): Double {
        return PI * Math.pow(radius, 2.0);
    }

    override fun unImplementedFunction(): Unit {
        println("This is a non-Implemented function from Circle Class");
    }
}

class Square(private val side: Double) : Shape, SampleAbstractClass() {
    override val parameter: Double
        get() = 4 * side;

    override fun area(): Double {
        return Math.pow(side, 2.0);
    }

    override fun unImplementedFunction(): Unit {
        println("This is a non-Implemented function from Square Class");
    }
}

/**
 * to demonstrate class inheritance
 */
public fun classInheritanceImplementation(): Unit {
    val firstClass = FirstClass();
    val separateClass = SeparateClass();

    firstClass.openFunctionToBeModified();
    firstClass.openFunctionToBeUnmodified();

    separateClass.normalFunction();
    separateClass.openFunctionToBeModified();
    separateClass.openFunctionToBeUnmodified();
}

class FirstClass : SeparateClass() {
    override fun openFunctionToBeModified() {
        println("This is a open function from FirstClass that has been modified");
    }
}

// class can only be inherited if marked as open
open class SeparateClass {
    fun normalFunction(): Unit {
        println("This is a normal function from separate open class");
    }

    // methods can only be override if marked as open
    open fun openFunctionToBeUnmodified(): Unit {
        println("This is a open function from separate open class that remain unmodified");
    }

    open fun openFunctionToBeModified(): Unit {
        println("This is a open function from separate open class that can be modified");
    }
}