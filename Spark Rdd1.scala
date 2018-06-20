import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.util

object sb5 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("query").setMaster("local[2]").set("spark.executor.memory", "1g")
    val sc = new SparkContext("local[2]", "PbSpark")
    val sqlcontext = new SQLContext(sc)
    val RDD = sc.textFile("C:\\Users\\Sai\\Desktop\\tweetsphase2.json")
    val RDDq = sc.textFile("C:\\Users\\Sai\\Desktop\\tweetsphase2.json").map(_.split(","))
    RDDq.take(100).foreach(println)
  }
}
