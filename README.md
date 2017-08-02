# kafka-tps

Questions:

1. nodes# in cluster: 3
		
2. Partitions#: 1 (Challenges: )
		
3. Replication Factor: 3 (proportional to # of nodes/brokers in cluster)
		
4. How to scale consumers?	
  Options:
    1: Multiple Consumers(100), say one for each partition# 
    2: Single Consumer - with multiple threads"
		 (** entire Consumer group processes a given message only once)


Suggestions from Kalyan:
• Try with 1 partition ✓
• Rep.factor - 3 (3 nodes) ✓
• 250k messages (load)
