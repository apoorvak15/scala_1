package lectures.part3FunctionalProgramming

import java.awt.im.InputMethodRequests

object AnonymousFunctions extends App {

  val basicDoubler = new Function1[Int,Int] {
    override def apply(v1: Int): Int = v1 * 2
  }
  //anonymous function (Lambda)
  val anonymousDoubler = (x: Int) => x * 2
  val anonymousDoublerEquivalent : Int => Int = (x : Int) => x * 2

  //multiple parameters
  val anonymousAdder : (Int, Int) => Int = (a: Int, b: Int) => a+ b
  val anonymousAdderEquivalent = (a: Int, b: Int) => a + b

  //no parameters
  val returnInt = () => 3
  println(returnInt) //function itself
  println(returnInt()) //function call

  //curly braces with lambda
  val strToInt = { (str: String) =>
    str.toInt
  }

  //syntactic sugar
  val niceIncrementer : Int => Int = _ + 1 //same as x => x + 1
  val niceAdder : (Int, Int) => Int = _ + _ //same as (a,b) => a + b

}
