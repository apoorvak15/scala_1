package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int) : String =
    a + " " + b

  println(aFunction("Hello" , 3))

  //Use recursion, when you need loops
  def aRepeatedFunction(aString: String, anInt: Int): String ={
    if(anInt==1) aString
    else
      aString + " " + aRepeatedFunction(aString, anInt-1)
  }
  println(aRepeatedFunction("Hello",3))

  // We can skip specifying return type of a normal function
  // But we must specify return type of a recursive function

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

}