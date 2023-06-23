package com.rockthejvm

object PatternMatching extends App {
  val anInt = 20
  val order = anInt match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInt + "th"
  }
  //Pattern matching is an expression
  println(order)

  //case class decomposition
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 27)

  val greeting = bob match {
    case Person(name, age) => s"Hi my name is $name and I am $age years old"
    case _ => "I am not a person so I cannot greet you :("
  }
  println(greeting)

  //deconstructing tuples
  val favorite = ("Sebastian Vettel", "Ferrari")
  val intro = favorite match {
    case (driver, team) => s"$driver drives for team $team"
    case _ => "I don't know what you're talking about"
  }
  println(intro)

  //deconstructing lists
  val aList = List(1, 2, 4)
  val aMatch = aList match {
    case List(_, 2, _) => "List contains 2 in index 1"
    case _ => "Unknown List"
  }
  println(aMatch)

  //cases are processed in sequence

}
