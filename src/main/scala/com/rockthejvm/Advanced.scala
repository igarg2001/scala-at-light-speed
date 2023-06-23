package com.rockthejvm

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends App {
  //lazy evaluation
  lazy val lazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am a lazy guy")
    12
  }
  val eagerValue = lazyValueWithSideEffect + 3
  //useful in infinite collections

  // "pseudo-collections" : Option, Try
  def methodThatCanReturnNull(): String = null

  val anOption = Option(methodThatCanReturnNull()) // Some(string) or None
  val aMatch = anOption match {
    case Some(str) => s"I have obtained a string : $str"
    case None => "I have obtained nothing"
  }
  println(aMatch)

  def methodThatCanThrowException(): String = throw new RuntimeException()

  val aTry = Try(methodThatCanThrowException())
  val anotherMatch = aTry match {
    case Success(value) => s"I have obtained a valid value : $value"
    case Failure(exception) => s"I have obtained an exception : $exception"
  }

  println(anotherMatch)

  // asynchronous programming: Future
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have finished computing...")
    67
  }
  Thread.sleep(1500)
  println(aFuture.value)

  //implicits
  def myImplicitMethod(implicit arg: Int): Int = arg + 1

  implicit val anImplicitNumber = 89
  println(myImplicitMethod)

  //implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(278.isEven())


}
