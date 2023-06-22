package com.rockthejvm

object ObjectOrientation extends App {
  //extends App: exposes the main method implementation
  //since this is an object, main can be called in a static way -> public static void main (String[] args)
  //class and instance
  class Animal {
    val age: Int = 0

    def eat() = println("I am eating")
  }

  val anAnimal = new Animal()

  //inheritance
  class Dog(val name: String) extends Animal {
    override def eat() = println(s"$name is eating")
  }

  val aDog = new Dog("Tommy")

  val name = aDog.name

  //subtype polymorphism

  val anotherAnimal: Animal = new Dog("Hachi")

  anotherAnimal.eat() //Hachi is eating

  abstract class WalkingAnimal {
    protected val hasLegs = true //by default public, can restrict access using private and protected

    def walk(): Unit
  }

  //interface -> ultimate abstract type -> leave everything un-implemented

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philospoher {
    def ?!(thought: String): Unit
  }

  //single class inheritance, multi trait "mixing"
  class Crocodile extends Animal with Carnivore with Philospoher {
    override def eat(animal: Animal): Unit = println(s"I am eating you, animal!")

    override def ?!(thought: String): Unit = println(s"I was thinking $thought")

    override def eat() = super.eat()
  }

  val aCroc = new Crocodile()
  aCroc.eat(aDog)
  aCroc eat aDog //infix notation, same as above, format: object method argument
  aCroc ?! "What if we could fly!"

  //operators are methods

  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = "I am a dinosaur so I can eat everything in the world"
  }

  /*
  What you tell the compiler:
    class Carnivore_Anonymous_84830 {
      override def eat(animal: Animal): Unit = "I am a dinosaur so I can eat everything in the world"
    }
    val dinosaur = new Carnivore_Anonymous_84830()
   */

  //singleton object
  object MySingleton {
    val aSpecialValue: Int = 47732

    def aSpecialMethod(): Int = 2921

    def apply(x: Int): Int = x + 1
  }

  val aSpecialValue = MySingleton.aSpecialMethod()

  MySingleton.apply(65)
  MySingleton(65) // equivalent to above stmt

  object Animal { //companion to class Animal
    //companions can access each other's private fields/methods
    //singleton Animal and instances of Animal are different things

    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely //static fields/methods

  //case classes
  /* A lightweight data structure providing the following implementations:
  - Sensible equals and hashcode methods
  - Serialization
  - apply method
  - pattern matching
   */
  case class Person(name: String, age: Int)

  val tom = new Person("Tom", 22)
  val john = Person("John", 34) //static

  //exceptions
  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some error has occurred"
  } finally {
    //execute some code no matter what
    println("I am great")
  }

  //generics
  abstract class MyList[T] {
    def head: T

    def tail: MyList[T]
  }

  val aList: List[Int] = List(1, 2, 3) //List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail

  val aStringList = List("hello", "world")
  val firstString = aStringList.head
  /*
  Point #1: objects in Scala are immutable, modifications to a scala object should result in another object
  Benefits:
    a) Works well with distributed systems
    b) Helps "reason about" the code.
  Point #2: Scala is closest to the OO ideal. Everything you run in scala is part of an object instance
   */
  val reversedList = aList.reverse

}
