<h3>Heartbeat</h3>
Each server periodically sends a heartbeat message to a central monitoring server or other servers in the system to show that it is still alive and functioning.

<h3>Checksum</h3>

In a distributed system, while moving data between components, it is possible that the data fetched from a node may arrive corrupted. This corruption can occur because of faults in a storage device, network, software, etc. How can a distributed system ensure data integrity, so that the client receives an error instead of corrupt data?

Calculate a checksum and store it with data.

To calculate a checksum, a cryptographic hash function like MD5, SHA-1, SHA-256, or SHA-512 is used. The hash function takes the input data and produces a string (containing letters and numbers) of fixed length; this string is called the checksum.

When a system is storing some data, it computes a checksum of the data and stores the checksum with the data. When a client retrieves data, it verifies that the data it received from the server matches the checksum stored. If not, then the client can opt to retrieve that data from another replica.

<h3>Bloom Filters</h3>
If we have a large set of structured data (identified by record IDs) stored in a set of data files, what is the most efficient way to know which file might contain our required data? 
We don’t want to read each file, as that would be slow, and we have to read a lot of data from the dis. one solution is index, if we want to search an ID in this index, the best we can do is a Binary Search. Can we do better than that?

Use Bloom filters to quickly find if an element might be present in a set.

he Bloom filter data structure tells whether an element may be in a set, or definitely is not. The only possible errors are false positives, i.e., a search for a nonexistent element might give an incorrect answer. With more elements in the filter, the error rate increases. An empty Bloom filter is a bit-array of m bits, all set to 0. There are also k different hash functions, each of which maps a set element to one of the m bit positions.

To add an element, feed it to the hash functions to get k bit positions, and set the bits at these positions to 1.
To test if an element is in the set, feed it to the hash functions to get k bit positions.
If any of the bits at these positions is 0, the element is definitely not in the set.
If all are 1, then the element may be in the set.

For a fixed error rate, adding a new element and testing for membership are both constant time operations, and a filter with room for ‘n’ elements requires O(n)O(n) space.
