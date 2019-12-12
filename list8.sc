import java.lang.reflect.Field

import scala.collection.mutable.ListBuffer

trait Debug{
  def debugName = println("Klasa: " + getClass.getName)  //getSimpleName, jeśli chceym poprawny output, ale nie dziala w tej wersji Javy
  def debugVars ={
    val fields: Array[Field] = getClass.getDeclaredFields
    for (i <- fields.indices ){
      fields(i).setAccessible(true)
      println("Pole: " + fields(i).getName + " => " + fields(i).getType + ", " + fields(i).get(this))
    }
  }

  def debugNameReturn = "Klasa: " + getClass.getName
  def debugVarsReturn: List[String] ={
    val fields: Array[Field] = getClass.getDeclaredFields
    var fieldsData = new ListBuffer[String]()
    for (i <- fields.indices ){
      fields(i).setAccessible(true)
      fieldsData += ("Pole: " + fields(i).getName + " => " + fields(i).getType + ", " + fields(i).get(this))
    }
    fieldsData.toList
  }
}

class Point(xv: Int, yv: Int) extends Debug {
  var x: Int = xv
  var y: Int = yv
  var a: String = "test"
}

var p : Point = new Point(3,4)



p.debugName

p.debugVars

var pointClassName = p.debugNameReturn
var pointClassData = p.debugVarsReturn


for(i <- pointClassData.indices){
  println(pointClassData(i))
}