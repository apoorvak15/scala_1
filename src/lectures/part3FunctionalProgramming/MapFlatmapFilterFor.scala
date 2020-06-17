package lectures.part3FunctionalProgramming

object MapFlatmapFilterFor extends App{

  val list = List(1,2,3)
  println(list.head)

  //map
  println(list.map(_ + 1 + ": plus one"))

  val toPair = (x : Int) => List(x , x + 1)
  println(list.flatMap(toPair))

  //print all combinations between two lists
 // iterations
  val numbers = List(1,2,3,4)
  val characters = List('a', 'b' , 'c' ,'d')
  val colors = List("Black" , "White")

  println(numbers.flatMap(n => characters.map(c => c + "" + n)))
  println(numbers.flatMap(n => characters.flatMap(c => colors.map(colors => c  + "" + n + "" + colors))))

  //foreach
  list.foreach(println)

  //for-comprehensions
  val forComprehensions = for {
    n <- numbers
    c <- characters
    colors <- colors
  } yield c  + "" + n + "" + colors
  println(forComprehensions) //this is same as printing line 21 in this code

  println(numbers.filter(_ % 2 ==0 ).flatMap(n => characters.flatMap(c => colors.map(colors => c  + "" + n + "" + colors))))
  val forComprehensionsWithFilter = for {
    n <- numbers if n % 2 ==0
    c <- characters
    colors <- colors
  } yield c  + "" + n + "" + colors

  //syntax overload
  list.map { x =>
    x * 2
  }

}
