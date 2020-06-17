package lectures.part2oop

class PackagingAndExports extends App{

  //package object
  //right click on package -> New -> Package Object
  // this creates package object with same name as package
  // we can create global variables and methods in this, and use it anywhere in package

  //default imports
  //java.lang  - String, Object, Exception
  //scala  - Int, Nothing, Function
  //scala.Predef  - println, ???

  //Name aliasing at imports
  import java.sql. {Date => SqlDate}
  import java.util.{Date => JavaDate}
}
