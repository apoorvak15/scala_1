package lectures.part1basics

object CBNvsCBV extends App {
  def callByValue(iTime : Long) : Unit ={
    println("By Value: " + iTime)
    println("By Value: " + iTime)
  }

  def callByName(iTime : => Long) : Unit = {
    println("By Name: " + iTime)
    println("By Name: " + iTime)
  }
  println(callByValue(System.nanoTime()))
  println(callByName(System.nanoTime()))

  def infinite() : Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(30,infinite()) //this call works, as infinite() is never calculated, as it is never used
  printFirst(infinite(),30) //this call does not work, as infinite() is calculated at the beginning and it fails

  //cllByName is calculated in lazy manner
  // in above example, "y" is call by value and is never calculated, because it is never used in the function
}
