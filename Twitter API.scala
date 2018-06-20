package com.devdaily.twitterclient
import twitter4j.TwitterFactory
import twitter4j.Twitter
import twitter4j.conf.ConfigurationBuilder

object s_babaapi {

  def main(args: Array[String]) {

    // (1) config work to create a twitter object
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("GBvd8zjjZ1sH1nj32NALWSEAj")
      .setOAuthConsumerSecret("myVqgFV0cq3PE2tnbH4xqWajliglLz2NFObA03Dl9B2dKO6HLD")
      .setOAuthAccessToken("170562861-aLVI4m4v40UvQzl0M7b0N5eriZILJcmG49R4PjXj")
      .setOAuthAccessTokenSecret("kXQdZAz50Zw4y6KNGWpeyryFUXMYjbaD0L4vv3CrrxiNA")
    val tf = new TwitterFactory(cb.build())
    val twitter = tf.getInstance()

    // (2) use the twitter object to get your timeline
    val statuses = twitter.getHomeTimeline()
    System.out.println("Showing my timeline.")
    val it = statuses.iterator()
    while (it.hasNext()) {
      val status = it.next()
      println(status.getUser().getName + ":" +
        status.getText());
    }

  }
}
