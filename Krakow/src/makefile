all:
	javac *java

test:
	@echo "=========== Test Queue.class  ==========="
	java QueueTest
	@echo "=========== Test PQueue.class ==========="
	java -Xmx32m PQueueTest
	@echo "=========== Test Krakow.class ==========="
	java KrakowTest
	@echo "=========== Monster Test ================"
	java MonsterTest

clean:
	rm *class