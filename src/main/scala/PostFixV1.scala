import scala.collection.mutable

/**
 * Created by vm033450 on 8/31/15.
 */
object PostFixV1 {
  var stack: mutable.Stack[Int] = new mutable.Stack[Int]()

  def addToStack(number: String): Option[Boolean] =
    try {
      stack.push(number.toInt)
      Some(true)
    } catch {
      case e: NumberFormatException => None
    }

  def pop(count: Int): Option[(Int, Int)] = try {
    Some(stack.pop(), stack.pop())
  } catch {
    case _ => None
  }

  def operate(operator: String): Int = operator match {
    case "+" => {
      val operands = pop(2).get;
      val result = operands._2 + operands._1
      println(operands._2 + "+" + operands._1 + "= " + result)
      result
    }
    case "-" => {
      val operands = pop(2).get;
      val result = operands._2 - operands._1
      println(operands._2 + "-" + operands._1 + "= " + result)
      result
    }
    case "*" => {
      val operands = pop(2).get;
      val result = operands._2 * operands._1
      println(operands._2 + "*" + operands._1 + "= " + result)
      result
    }
    case "/" => {
      val operands = pop(2).get;
      val result = operands._2 / operands._1
      println(operands._2 + "/" + operands._1 + "= " + result)
      result
    }
  }


  def main(args: Array[String]): Unit = {
    args.foreach(value => value match {
      case "+" | "-" | "*" | "/" => addToStack(operate(value).toString)
      case _: String => addToStack(value)
    })
    println(stack.pop())
  }
}
