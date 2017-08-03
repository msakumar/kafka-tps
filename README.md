# kafka-tps

Questions:

1. nodes# in cluster: 3
		
2. Partitions#: 1 or more (the more the partitions the system will be more scalable, but will pose seq# consistency challenge for which we need to write a custom partitioner)
		
3. Replication Factor: 3 (proportional to # of nodes/brokers in cluster)
		
4. How to scale consumers?	
  Options:
    1: Multiple Consumers, say one for each partition# 
     (** entire Consumer group processes a given message only once)
    2: Single Consumer - with multiple threads (Need to spend more time exploring the possibilities)
		 
		 
Suggestions from Kalyan:
• Try with 1 partition ✓ (Tried but It will not be a solution for scalability)
• Rep.factor - 3 (3 nodes) ✓
• 250k messages (load) ✓
