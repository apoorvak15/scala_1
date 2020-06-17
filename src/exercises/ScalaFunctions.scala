package exercises

object ScalaFunctions extends App {
  //Chapter Functions
//1 Greetings
  def greetings(sName : String, iAge : Int): String={
  "Hi, my name is " + sName + ". I am " + iAge + " years old."
  }

  //2 factorial
  def factorial(iNum : Int) : Int ={

    if (iNum <= 0) 1
    else
      iNum * factorial(iNum-1)
  }

  //3 Fibonacci
  def fibonacci(iNum : Int) : Int ={
    if (iNum <= 2 ) 1
    else
      fibonacci(iNum - 1) + fibonacci(iNum - 2)
  }

  //4 Prime number
  def isPrimeNum(iNum : Int) : Boolean ={
    def isPrimeUntil(nHalfOfiNum : Int) : Boolean=
      if (nHalfOfiNum <= 1) true
    else
        iNum % nHalfOfiNum != 0 && isPrimeUntil(nHalfOfiNum-1)

    isPrimeUntil(iNum / 2)
  }

  // Chapter Recursion
  //5 Concat a string n times using tail recursion
  def stringConcat(sString : String, iNumOfTime : Int, accumulator : String) : String = {
    if (iNumOfTime <= 0 ) accumulator
    else stringConcat(sString ,iNumOfTime-1,sString + " " + accumulator)
  }
/*
def concatHelper(iCountHelper : Int , accumulator : String) : String=
      if (iCountHelper <= 1 ) accumulator
      else concatHelper(iCountHelper - 1, sString + " " + accumulator)

 */
  //println(greetings("abc",10))
  //println("Factorial : " + factorial(3))
  //println("Fibonacci : " + fibonacci(4))
  //println("Is Prime No? : " + isPrimeNum(15))
  println("Concatenated string: " + stringConcat("Hello" , 3,""))
}
