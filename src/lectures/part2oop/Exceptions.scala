package lectures.part2oop

object Exceptions extends App {
  val x : String = null
  //println(x.length) //this will throw a NullPointerException

  //.1 Throw an exception
  //val aWeirdValue = throw new NullPointerException
  // NullPointerException is a throwable class
  //throwable classes extends Throwable class
  //Exceptions and Errors are major Throwable classes

  //2. catch an exception

  def getInt(withExceptions : Boolean) : Int =
    if (withExceptions) throw  new RuntimeException("No Int! Only exception..")
    else 42

  try{
    getInt(true)
  } catch {
    case e: RuntimeException => println(e.getMessage + " Catch")
  } finally {
    //code that always executes
    println("Finally!")
  }

  //3. Define your own exceptions
  class MyExceptionClass extends Exception
  val exception = new MyExceptionClass
  //throw exception
}
