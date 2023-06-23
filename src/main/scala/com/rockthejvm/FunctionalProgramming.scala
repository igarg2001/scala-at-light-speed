package com.rockthejvm

import com.rockthejvm.ObjectOrientation.Person

object FunctionalProgramming extends App {
  //Scala is object-oriented
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob(43)

  /*
  Functional programming:
    - Use functions as first class citizens
    - Compose functions
    - Pass functions as args
    - return functions as results

    Conclusion - FunctionX = Function1, Function2, .......,  Function22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  simpleIncrementer(24) // 25

  val concatenater = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  concatenater("I love ", "Scala") // "I love Scala"

  //syntactic sugar
  val doubler: Int => Int = (x: Int) => x * 2 // Int => Int is equivalent to Function1[Int, Int]
  doubler(4) // 8

  /*
  Above syntactic sugar results in:
    val doubler = new Function1[Int,Int] {
      override def apply(v1:Int): Int = v1*2
    }
  */

  //higher-order functions: take functions as arguments or return functions as a result

  val aMappedList = List(1, 2, 3).map(x => x * 2) //map is a higher order function

  println(aMappedList)

  val aFlatMappedList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  }

  println(aFlatMappedList)

  val aFilteredList = List(1, 2, 3, 4, 5).filter(_ <= 3) //equivalent to x => x <=3

  //all pairs between the numbers 1, 2, 3 and a, b, c

  val allPairs = List(1, 2, 3).flatMap(x => List("a", "b", "c").map(y => List(x, y)))

  println(allPairs)

  //for comprehensions
  val altPairs = for {
    x <- List(1, 2, 3)
    y <- List("a", "b", "c")
  } yield List(x, y)

  println(altPairs)

  /* Collections
    * Lists
    *
   */
  val aList = List(1, 2, 3, 4, 5)
  val first = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List (0, 1, 2, 3, 4, 5)
  val anExtendedList = 0 +: aList :+ 6

  //sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3)
  val accessedElement = aSequence(1) //element at index 1 : 2

  //vectors : fast sequence implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  // sets : no duplicate elements
  val aSet = Set(1, 2, 3, 4, 4, 4, 2, 24, 6, 6, 8)
  val setHas9 = aSet.contains(9)
  val anAddedSet = aSet + 9
  val aRemovedSet = aSet - 4
  println(aSet)

  //ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(2 * _).toList //List(2, 4, 6, ..., 2000)

  //tuples
  val aTuple = ("Formula 1", "Ferrari", "Sebastian Vettel", 5)

  //maps
  val aMap: Map[String, Int] = Map(
    ("John", 20202),
    "Priya" -> 8282 // ("Priya", 8282)
  )




}
