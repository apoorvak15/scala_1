package exercises

object ExceptionExc extends App {

  //1. Crash a program with OutOfMemory Exception
  //val array = Array.ofDim(Int.MaxValue)  //this will crash

  //2. crash a program with StackOverflow Exception
  //def infiniteNo : Int = 1 + infiniteNo
  //val noLimit = infiniteNo

  //3. Pocket Calculator

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class DivideByZeroException extends RuntimeException

  object PocketCalculator {
    //throw OverflowException if X + Y exceeds Int.MaxValue
    def add(x: Int, y:Int) : Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw  new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract (x: Int, y : Int) = {
      val result = x -y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide (x : Int, y : Int) = {
      if ( y == 0 ) throw new DivideByZeroException
      else x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue,10))
  println(PocketCalculator.divide(5,0))
}
