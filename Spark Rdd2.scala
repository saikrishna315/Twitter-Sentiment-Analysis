import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.util


object sb3 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("query").setMaster("local[2]").set("spark.executor.memory", "1g");
    val sc = new SparkContext(conf) // An existing SparkContext.
    val count = sc.textFile("C:\\Users\\Sai\\Desktop\\tweetsphase2.json");
    val info = count.filter(text => text.contains("cricket")).collect() foreach println
    val info1 = count.filter(text => text.contains("cricket")).count()
    println("tweets on cricket  = %s".format(info1))
  }
}
