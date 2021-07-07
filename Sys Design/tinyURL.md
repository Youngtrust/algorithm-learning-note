<h2>TinyURL</h2>

Design a URL shortening service like TinyURL. This service will provide short aliases redirecting to long URLs.
Similar services: bit.ly, ow.ly, short.io
Difficulty Level: Easy

<h3>Back-of-the-envelope estimation</h3>
There will be lots of redirection requests compared to new URL shortenings. Let’s assume a 100:1 ratio between read and write.

Traffic estimates: QPS
Storage estimates: DB sizing
Bandwidth estimates: total outgoing data for our service
Memory estimates: cache some of the hot URLs that are frequently accessed(20-80)(duplicate).

<h3>APIs</h3>
createURL(api_dev_key, original_url, custom_alias=None, user_name=None, expire_date=None)

How do we detect and prevent abuse? A malicious user can put us out of business by consuming all URL keys in the current design. To prevent abuse, we can limit users via their api_dev_key.
Each api_dev_key can be limited to a certain number of URL creations and redirections per some time period (which may be set to a different duration per developer key).

params,
returns

<h3>Database Design</h3>

<h3>Basic System Design and Algorithm</h3>
a.Encoding actual URL
Using base64 encoding, a 6 letters long key would result in 64^6 = ~68.7 billion possible strings.
Using base64 encoding, an 8 letters long key would result in 64^8 = ~281 trillion possible strings.

If multiple users enter the same URL, they can get the same shortened URL, which is not acceptable.
What if parts of the URL are URL-encoded? e.g., http://www.educative.io/distributed.php?id=design, and http://www.educative.io/distributed.php%3Fid%3Ddesign are identical except for the URL encoding.

b.Generating keys offline
a standalone Key Generation Service (KGS)
As soon as a key is used, it should be marked in the databas -> Servers can use KGS to read/mark keys in the database.

What would be the key-DB size?
Isn’t KGS a single point of failure? -> yes, a standby replica of KGS
Can each app server cache some keys from key-DB? yes,
How would we perform a key lookup? in database

<h3>Data Partitioning and Replication</h3>
a. Range Based Partitioning
b. Hash-Based Partitioning - overloaded -> Consistent Hashing.

<h3>Cache</h3>
<h3>Load Balancer (LB)</h3>
Round Robin approach -> dont consider server load, overloaded or slow

<h3>Purging or DB cleanup</h3>

<h3>Telemetry</h3>
Some statistics worth tracking

<h3>Security and Permissions</h3>

