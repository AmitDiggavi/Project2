runTests: InventoryBackend.java BackendDeveloperTests.java
	javac -cp .:junit5.jar InventoryBackend.java BackendDeveloperTests.java
	java -jar junit5.jar --class-path=. --include-classname=".*" --select-class=BackendDeveloperTests

run: 
	javac IGSTMapperFrontend.java
	javac IProduct.java
	javac IProductLoader.java
	javac ITreeMap.java
	javac IUPCChecker.java
	javac MapADT.java
	javac Product.java
	javac ProductLoader.java
	javac RedBlackTree.java
	javac TreeMap.java
	javac UPCChecker.java
runAlgoTests:
	javac -cp .:junit5.jar TreeMap.java  AlgorithmEngineerTests.java
	java -jar junit5.jar --class-path=. --include-classname=".*" --select-class=AlgorithmEngineerTests


clean:
	rm *.class
