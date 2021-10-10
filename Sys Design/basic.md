Things to consider
Features
API
Availability
Latency
Scalability
Durability
Class Diagram
Security and Privacy
Cost-effective

Concepts to know
Vertical vs horizontal scaling
CAP theorem
ACID vs BASE
Partitioning/Sharding
Consistent Hashing
Optimistic vs pessimistic locking
Strong vs eventual consistency
RelationalDB vs NoSQL
Types of NoSQL
Key value
Wide column
Document-based
Graph-based
Caching
Data center/racks/hosts
CPU/memory/Hard drives/Network bandwidth
Random vs sequential read/writes to disk
HTTP vs http2 vs WebSocket
TCP/IP model
ipv4 vs ipv6
TCP vs UDP
DNS lookup
Http & TLS
Public key infrastructure and certificate authority(CA)
Symmetric vs asymmetric encryption
Load Balancer
CDNs & Edges
Bloom filters and Count-Min sketch
Paxos
Leader election
Design patterns and Object-oriented design
Virtual machines and containers
Pub-sub architecture
MapReduce
Multithreading, locks, synchronization, CAS(compare and set)

Tools
Cassandra
MongoDB/Couchbase
Mysql
Memcached
Redis
Zookeeper
Kafka
NGINX
HAProxy
Solr, Elastic search
Amazon S3
Docker, Kubernetes, Mesos
Hadoop/Spark and HDFS

load balancer
How does the load balancer choose the backend server?
Load balancers consider two factors before forwarding a request to a backend server. They will first ensure that the server they choose is actually responding appropriately to requests and then use a pre-configured algorithm to select one from the set of healthy servers. We will discuss these algorithms shortly.

Health Checks - Load balancers should only forward traffic to “healthy” backend servers. To monitor the health of a backend server, “health checks” regularly attempt to connect to backend servers to ensure that servers are listening. If a server fails a health check, it is automatically removed from the pool, and traffic will not be forwarded to it until it responds to the health checks again.

There is a variety of load balancing methods, which use different algorithms for different needs.

Least Connection Method — This method directs traffic to the server with the fewest active connections. This approach is quite useful when there are a large number of persistent client connections which are unevenly distributed between the servers.
Least Response Time Method — This algorithm directs traffic to the server with the fewest active connections and the lowest average response time.
Least Bandwidth Method - This method selects the server that is currently serving the least amount of traffic measured in megabits per second (Mbps).
Round Robin Method — This method cycles through a list of servers and sends each new request to the next server. When it reaches the end of the list, it starts over at the beginning. It is most useful when the servers are of equal specification and there are not many persistent connections.
Weighted Round Robin Method — The weighted round-robin scheduling is designed to better handle servers with different processing capacities. Each server is assigned a weight (an integer value that indicates the processing capacity). Servers with higher weights receive new connections before those with less weights and servers with higher weights get more connections than those with less weights.
IP Hash — Under this method, a hash of the IP address of the client is calculated to redirect the request to a server.

Placing a cache directly on a request layer node enables the local storage of response data.

What happens when you expand this to many nodes? If the request layer is expanded to multiple nodes, it’s still quite possible to have each node host its own cache. However, if your load balancer randomly distributes requests across the nodes, the same request will go to different nodes, thus increasing cache misses. Two choices for overcoming this hurdle are global caches and distributed caches.
