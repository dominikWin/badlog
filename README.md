# badlog
A data logging system for FRC Robots. Pairs with [badlogvis](https://github.com/dominikWin/badlogvis), a visualization tool.

## Setup

### Manual
Place `badlog.jar` (found on GitHub release page) into a lib folder with [`json-simple-1.1.1.jar`](http://central.maven.org/maven2/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar).

### Gradle
Add
```java
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    compile "com.github.dominikWin:badlog:v0.1.1"
}
```
to the build.gradle file.

## Example
```java
public class Main {
	public static void main(String[] args) {
	
		// Init
		BadLog log = BadLog.init("test.bag");
		{
			BadLog.createValue("Example Value", System.getProperty("os.version"));
			
			BadLog.createTopic("Example Topic", "Bytes", () -> (double) Runtime.getRuntime().freeMemory());
			
			BadLog.createTopic("Topic with attributes", BadLog.UNITLESS, () -> 3.2, "attr1", "attr2");
			
			BadLog.createTopicSubscriber("Subscribed topic", "s", DataInferMode.DEFAULT);
		}
		log.finishInitialization();
		
		// Execution
		
		for (int i = 0; i < 10; i++) {
			
			// Publish to subscribed topic
			BadLog.publish("Subscribed topic", (double) System.nanoTime());
			
			
			log.updateTopics();
			log.log();
		}
	}
}
```

## Whitepaper
[Link](https://www.chiefdelphi.com/media/papers/3505)
