package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  /*
  Tail Recursion
   */
  def factorial(iNum : Int) : Int ={

    if (iNum <= 0) 1
    else {
      println("Before call to recrsive function, value of iNum is: " + iNum)
      val iResult = iNum * factorial(iNum-1)
      println("After call, value of iNum is: " + iNum)

      iResult
    }
  }

  println("Final :: " + factorial(2))
  //this code works fine with small number, if we try to find fact(5000), this code will throw StackOverflow exception
  //to solve this problem, use following method


  def anotherFactorial(iNum: Int) : BigInt = {
    //below annotation makes sure that the function is tail recursive
    @tailrec
    def factHelper(iFactNum : Int, accumulator: BigInt) : BigInt =
      if(iFactNum <= 1 ) accumulator
      else factHelper(iFactNum-1, iFactNum * accumulator) // this is tail recursive: use recursive call as the last expression

    factHelper(iNum,1)
  }
  println("Another fact :: " + anotherFactorial(5000))

  /*
  Explanation :
  anotherFactorial (10) = factHelper(10,  1)
  = factHelper (9, 10 * 1)
  = factHelper (8, 9 * 10 * 1)....
    .
    .
  = factHelper (1, 2 * 3* ...* 10 * 1)
  */

  // When you need loop, use tail recursion

}
