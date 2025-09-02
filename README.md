The main code is contained in SRC.
The csv files are data from the given years for flights.
The queries folder has some examples of what is expected from running the code.

The code needs external libraries to run, which I may link in the future.

Queries:

Query 1
How many flights out of Cedar Rapids (CID) were there in total? Return your result as a single integer.
This is the only query you’ll write that does not require at least one Set or Map. All other queries will.

Query 2
What are the distinct destinations that can be reached directly (taking a single flight) from Cedar
Rapids (CID)? Return each result as a String with the format “DEST, DEST_STATE_ABR”, for
example, “HPN, NY”. Note that there is a single space after “,” and none before.

Query 3
How many distinct destinations can be reached directly from Cedar Rapids (CID)? Return your result
as a single integer.

Query 4
How many flights out of Cedar Rapids (CID) were there for each destination? You only need to include
destinations for which there was at least 1 flight from CID. Return each result as a String with the
format “DEST=number of flights”. For example, if there were 10 flights from CID to LAX, then the string
should be “LAX = 10”. Note that there are no space characters on either side of “=”.

Query 5
What month had the most flights and how many flights was that? Return your result as a String of
the form “MONTH had NUM flights”. For example, if the month with the most flights was 7 and there
were 500 flights then return “7 had 500 flights”.

Query 6
What pair of states has the most flights between them in either direction? Return your result as a
single String with the two states in alphabetical order. For example, if the two states are IA and IL,
then return “(IA,IL)”. Note there are no space characters around “,”.

Query 7
What distinct states can you not get to from an Iowa (IA) airport in one (direct) flight? Only include
states that are present somewhere in the dataset, whether as an origin or destination. Return an
Iterable<String> containing those states.

Query 8
An intra-state flight is a flight that stays within the same state. For example, a flight from CID to DSM
stays within Iowa. For each state, what is the percentage of instrastate flights with respect to the total
number of flights? Return each result as a String of the form “STATE=PERCENT”. Round and display
the percentage with three decimal digits and omit the 0 before the decimal point. For example, if the
percentage of intra-state flights in Florida is 5%, then the result should be “FL=.050”. Here is example
code to produce the desired number format.
float y = 0.1234567
DecimalFormat df = new DecimalFormat("#.000");
String withThreeDigits = df.format(y);
The value of withThreeDigits is ”0.123”.

Query 9
For each state, what is the airline (UNIQUE_CARRIER_NAME) with the most flights into that state?
Return each result as “STATE,AIRLINE”. For example, if the airline most flying to Kentucky is United
Parcel Service, then “KY,United Parcel Service”.

Query 10
What distinct routes are there from CID to LAX that consist of exactly two flights (i.e., have a
“layover”)? Such a route exists if the destination of the first flight is the origin of the second flight.
Return each result as a String with the format “ORIGIN1->DEST1->DEST2”. For example, if there is a
flight from CID to ALB and a flight from ALB to LAX, then the result should be “CID->ALB->LAX”. Note
that we don’t include ORIGIN2 in the output because it is the same as DEST1.
