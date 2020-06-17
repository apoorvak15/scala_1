package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 //1+2 is an expression, data type is decided by compiles
  println(x)

  println(2 + 3 * 4)
  //+ - * / & |  ^ << >> >>> (right shift with zero extension: specific to scala)

  println(1 == x)
  //== != < <= > >=

  var aVar = 2
  aVar += 3 // aVar = aVar + 3  , works with -= *= /=
  println(aVar)


  //instructions vs expressions
  //instructions are executed, expressions are evaluated
  val aCondition = true

  //IF expression
  val aConditionedValue = if(aCondition) 3 else 5 // If returns value, so its an expression
  println(aConditionedValue)
  println(if(aCondition) 3 else 5)


  //Loops. But never use again, not a good practice
  //everything in scala is an expression returning data type: Unit === void
  var i = 0
  while(i < 10) {
    println(i)
    i += 1
  }

    //code blocks

    val aCodeBlock = {
      val y = 2
      val z = y + 1
      if(z > 2) "hello" else "bye"
    } // this is a code block, code block is an expression. value of a code block is value of its last expression

}

