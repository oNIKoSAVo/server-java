CREATE TABLE IF NOT EXISTS "tweets" (
	"tweet_id"	INTEGER,
	"airline_sentiment"	TEXT,
	"airline_sentiment_confidence"	NUMERIC,
	"negativereason"	TEXT,
	"negativereason_confidence"	NUMERIC,
	"airline"	TEXT,
	"airline_sentiment_gold"	TEXT,
	"name"	TEXT,
	"negativereason_gold"	TEXT,
	"retweet_count"	INTEGER,
	"text"	TEXT,
	"tweet_coord"	TEXT,
	"tweet_created"	TEXT,
	"tweet_location"	TEXT,
	"user_timezone"	TEXT
);