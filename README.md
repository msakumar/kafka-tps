# kafka-tps

1. nodes# in cluster: 3
		
2. Partitions#: 1 (Challenge: 
		
3. Replication Factor: 3 (proportional to # of nodes/brokers in cluster)
		
4. How to scale consumers?	
  Options:
    1: Multiple Consumers(100), say one for each partition# 
    2: Single Consumer - with multiple threads"
		 (** entire Consumer group processes a given message only once)
