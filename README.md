# ENSF480

must change the following variables for your systems SQL workbench:  
String host = "localhost:3306";   ------ most likely will be the same if no changes were made to port  
String user = "root";             ------ same again, as long as you creating the table within the root and not another user  
String password = "bio";          ------ change for you specified mysql workbench password  
String database = "Flights";      ------ leave the same  

To Run:

javac SQLConnector.java  
java -cp "mysql-connector-j-8.2.0.jar;." SQLConnector  

Going to need to package final project so that the project can automatically read/figure out where the driver .jar is  
