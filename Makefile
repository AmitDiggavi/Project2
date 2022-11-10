runTests: InventoryBackend.java BackendDeveloperTests.java
	javac -cp .:junit5.jar InventoryBackend.java BackendDeveloperTests.java
	java -jar junit5.jar --class-path=. --include-classname=".*" --select-class=BackendDeveloperTests

clean:
	rm *.class
