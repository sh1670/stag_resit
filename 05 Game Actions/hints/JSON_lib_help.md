# JSON Simple | How to read and write JSON files

#### Download
[[maven](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple) | [.jar(direct)](http://central.maven.org/maven2/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar) | [.jar](https://code.google.com/archive/p/json-simple/downloads)]

### Read from file
```java
// JSON Simple imports
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
```
```java
File jsonFile = new File("/hello.json"); // Do with as you please

/*
* Simple key value pairs
*/
JSONParser parser = new JSONParser();
try{
	JSONObject jObj = (JSONObject) parser.parse(new FileReader(jsonFile));
} catch (IOException | ParseException e) {
	e.printStackTrace();
}

String value = (String) jObj.get("world");
long delay = (Long) jObj.get("delay");
boolean debug = (Boolean) jObj.get("debug");

/*
 * JSONArray
 */
JSONArray array = (JSONArray) jObj.get("array");

/*
* JSONObject inside JSONObject
*/
try{
	JSONObject user = (JSONObject) parser.parse(jObj.get("user").toString());
} catch (IOException | ParseException e) {
	e.printStackTrace();
}
String username = (String) user.get("username");

```

### Write to file
```java
// JSON Simple imports
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
```
```java
File jsonFile = new File("/hello.json"); // Do with as you please

/*
 * Simple key value pairs
 */
JSONObject jObj = new JSONObject();
jObj.put("world", "Sw4p"); // String
jObj.put("delay", 600); // Long/Integer
jObj.put("debug", true); // Boolean

/*
 * JSONArray
 */
JSONArray array = new JSONArray(); // List/Array
array.add("value1");
array.add("value2");
jObj.put("array", array);

/*
 * JSONObject inside JSONObject
 */
JSONObject user = new JSONObject();
user.put("username", "Sw4p");
jObj.put("user", user);

// Write 
try (FileWriter fileWriter = new FileWriter(jsonFile)) {
	fileWriter.write(jObj.toJSONString());
	fileWriter.flush();
} catch (IOException e) {
	e.printStackTrace();
}

```