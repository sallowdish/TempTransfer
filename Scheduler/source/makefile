all:
	mkdir out
	javac -d out -classpath src:base  test/*java

run:
	@echo "=========== Test Batch.class  ==========="
	java -classpath out BatchTest
	@echo "=========== Test RR.class ==========="
	java -classpath out RRTest
	@echo "=========== Test EDF.class ==========="
	java -classpath out EDFTest
	@echo "=========== Test EDFS Test ================"
	java -classpath out EDFSTest
	@echo "=========== Test EDFNLC Test ================"
	java -classpath out EDFNLCTest

clean:
	rm -r out