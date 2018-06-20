from __future__ import absolute_import, print_function
from tweepy import Stream
from tweepy.streaming import StreamListener
from tweepy import OAuthHandler

AccessToken = "828931820-IF3FgxtQkiLqmnFeN7IWDhwXQOmPlILSUsjRURkM"
AccessTokenSecret = "xUvPB6NozFpljYrc6C7JMwcGA5oy93BJHplE6e5z7a6OE"
ConsumerKey= "3qDlfSB9BbJK5IzGrVhtvju8V"
ConsumerSecret	=  "EC7Sfoo2G4m5DvnNLnTxd8R6mxt2iRCuBOOUZi3SHbLwcKxZiu"




class Collector(StreamListener):
    
    def on_data(self, info):
        
		print(info)
		newFile = open('tweetsdownloaded.txt','a')
		newFile.write(info)
		newFile.write('\n')
		newFile.close()  
       	return True
	

    def on_error(self, status):
        print(status)

if  __name__ == '__main__':
    tweets = Collector()
    author = OAuthHandler(ConsumerKey, ConsumerSecret)
    author.set_access_token(AccessToken, AccessTokenSecret)

    get = Stream(author, tweets)
    get.filter(track=['sports'])





