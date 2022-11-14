runTests: compileTests
	java -jar junit5.jar -cp . -c BackendDeveloperTests -c DataWranglerTests -c GSTMapperFrontendTests
	$(MAKE) clean

runBackendDeveloperTests: InventoryBackend.java BackendDeveloperTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java
	java -jar junit5.jar -cp . -c BackendDeveloperTests

runDataWranglerTests: Product.java ProductLoader.java DataWranglerTests.java
	javac -cp .:junit5.jar DataWranglerTests.java
	java -jar junit5.jar -cp . -c DataWranglerTests

runFrontendDeveloperTests: GSTMapperFrontend.java GSTMapperFrontendTests.java
	javac -cp .:junit5.jar GSTMapperFrontendTests.java
	java -jar junit5.jar -cp . -c GSTMapperFrontendTests

compileTests: Product.java ProductLoader.java InventoryBackend.java BackendDeveloperTests.java DataWranglerTests.java GSTMapperFrontend.java GSTMapperFrontendTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java DataWranglerTests.java GSTMapperFrontendTests.java

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
	@rm *.class
