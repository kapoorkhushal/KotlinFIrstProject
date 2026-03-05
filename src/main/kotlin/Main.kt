package org.example

fun main() {
    println("Hello World!");
//    println(arithmetic());
//    readWrite();
//    ifElseCondition();
//    whenExpression();
//    switchFunction();
    exceptionHandling();
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
    // to convert nullable type to non-nullable type, use : !!
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