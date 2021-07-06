1.  clarification
    Will users of our service be able to post tweets and follow other people?
    Should we also design to create and display the user’s timeline?
    Will tweets contain photos and videos?
    Are we focusing on the backend only, or are we developing the front-end too?
    Will users be able to search tweets?
    Do we need to display hot trending topics?
    Will there be any push notification for new (or important) tweets?

2.  Back-of-the-envelope estimation
    estimate the scale of the system
    scale expected
    storage
    bandwidth - > traffic

3.  System interface definition
    Define APIs

4.  Defining data model
    identify various system entities & interact with each othe
    different aspects of data management
    storage, transportation, encryption,
    which db

5.  High-level design
    identify enough components that are needed to solve the actual problem from end to end.

6.  Detailed design
    Dig deeper into two or three major components

         Since we will be storing a massive amount of data, how should we partition our data to distribute it to multiple databases? Should we try to store all the data of a user on the same database? What issue could it cause?

         How will we handle hot users who tweet a lot or follow lots of people?

         Since users’ timeline will contain the most recent (and relevant) tweets, should we try to store our data so that it is optimized for scanning the latest tweets?

         How much and at which layer should we introduce cache to speed things up?
         What components need better load balancing?

7.  Identifying and resolving bottlenecks
    discuss as many bottlenecks as possible
