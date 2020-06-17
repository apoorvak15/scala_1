package lectures.part3FunctionalProgramming

import scala.util.Random

object Sequence extends App {
  //Seq
  val aSequence = Seq(3,2,1)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(4,5,6))
  println(aSequence.sorted)

  //Ranges
  val aRange : Seq[Int] = 1 to 5
  aRange.foreach(println)
  (1 until 5).foreach(x => println("Until range: " + x))

  //Lists : immutable and extends linear sequence
  //head, tail, isEmpty methods are fast : O(1)
  //length, reverse and most other operations are not very fast:  O(n)
  //List is a Sealed class
  //it has 2 subtypes: Nil(EmptyList) and ::(NonEmptyList)

  val aList = List(1,2,3)
  val prepended = 4 :: aList
  val prependAndAppend = 87 +: aList :+ 98
  println(prepended)
  println(prependAndAppend)

  val apples5 = List.fill(5)("apples") //fill = curried function
  println(apples5)
  println(aList.mkString("@!"))

  //arrays : predefined length, mutable, indexing is fast
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println) //for [int] or other primitive (double, bool) value will be 0, for
  //[String] or other reference-type(persons) will be Null

  //mutation
  numbers(2) = 0 //syntax sugar for numbers.update(2, 0) - update is also special method like apply
  println(numbers.mkString(" "))

  //arrays and sequences
  val numSeq : Seq[Int] = numbers //implicit conversion
  println(numSeq)

  //vectors
  //default implementation for immutable sequences
  //effectively constant indexed read-write = O(log to the base 32 (n))
  //fast element addition : append/prepend
  //branch factor 32 : holds 32 elements at any one level
  //good performance for large sizes
  val vector : Vector[Int] = Vector(1,2,3)
  println(vector)
  //same functionality as other collections

  //vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection : Seq [Int]) : Double ={
    val r = new Random

    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity),r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numberLists = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector
  //adv : keeps reference to tail
  //dis-adv : updating an element in the middle takes long
  println(getWriteTime(numberLists))
  //adv : depth of the tree is small
  //dis-adv: needs to replace an entire 32-element chunk
  println(getWriteTime(numberVector))

}
