runTests: compileTests
	java -jar junit5.jar -cp . -c BackendDeveloperTests -c DataWranglerTests
	$(MAKE) clean

runBackendDeveloperTests: InventoryBackend.java BackendDeveloperTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java
	java -jar junit5.jar -cp . -c BackendDeveloperTests

runDataWranglerTests: Product.java ProductLoader.java DataWranglerTests.java
	javac -cp .:junit5.jar DataWranglerTests.java
	java -jar junit5.jar -cp . -c DataWranglerTests

compileTests: Product.java ProductLoader.java InventoryBackend.java BackendDeveloperTests.java DataWranglerTests.java
	javac -cp .:junit5.jar IProduct.java Product.java IProductLoader.java ProductLoader.java DataWranglerTests.java

clean:
	@rm *.class
