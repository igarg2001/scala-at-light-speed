package com.rockthejvm

object Basics extends App {
  //defining a value
  val meaningOfLife: Int = 42; //const

  val aBoolean = false; //type mentioning is optional

  val anInterPolatedString = s"The meaning of life is $meaningOfLife"

  val expression = 2 + 3 //structures that can be reduced to values

  val ifExpression = if (meaningOfLife > 42) 56 else 999

  val chainedIfExpression = {
    if (meaningOfLife > 42) 56
    else if (meaningOfLife > 0) 999
    else if (meaningOfLife > -50) -2
    else 0
  }

  //a code block is also an expression
  val aCodeBlock = {
    val aLocalValue = 66

    aLocalValue + 3 //value of the code block is equal to the value of the last expression
  }

  def myFunction(x: Int, y: Int): String = y + " " + x;

  def factorial(n: Int): Int =
    if (n == 1) 1
    else n * factorial(n - 1)

  //Unit type: no meaningful value (equivalent to void)
  // SIDE EFFECTS

  println("I Love Scala")

  val theUnit: Unit = ()

}
