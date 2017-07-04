package openie

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mayanka on 27-Jun-16.
  */
object SparkOpenIE {

  def main(args: Array[String]) {
    // Configuration
    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val sc = new SparkContext(sparkConf)


    // Turn off Info Logger for Console
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    val input = sc.textFile("C:\\Users\\user\\Desktop\\KDM\\bbc\\entertainment\\019.txt").map(line => {

      println(CoreNLP.returnTriplets(line))
      //println(t)
    })

    println(CoreNLP.returnTriplets("Slater to star in Broadway play\n\nActor Christian Slater is stepping into the role of Tom in the Broadway revival of The Glass Menagerie.\n\nSlater, 35, is replacing actor Dallas Roberts in the Tennessee Williams drama, which opens next month. No reason was given for Roberts' departure. The role will be played by understudy Joey Collins until Slater joins the show. Slater won rave reviews for his recent performance in One Flew Over the Cuckoo's Nest in London's West End.\n\nHe has also starred in a number of films, including Heathers, Robin Hood: Prince of Thieves and more recently Churchill: The Hollywood Years. Preview performances of The Glass Menagerie will begin at New York's Ethel Barrymore Theatre on Thursday. Philip Rinaldi, a spokesman for the show, said the play's 15 March opening date remains unchanged. The revival, directed by David Leveaux, will also star Jessica Lange as the domineering mother, Amanda Wingfield."))
   // println(input.collect().mkString("\n"))



  }

}
