package lectures.part1basics

object DefaultArgs extends App {

  def savePicture (sFormat : String = "jpg", iWidth : Int, iHeight : Int) = println("Saving Picture")
  // default argument to "jpg"
  savePicture(sFormat = "bmp" , 800, 1200)
  /*
  Two points to be noted for using default args:
  1. Try defaulting the last argument
  2. We can name the arguments, so the sequence of the arguments does not matter at all
   */
}
