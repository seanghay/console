## Console
A simple yet concise `console.log` for Android

[ ![Build Status](https://travis-ci.org/seanghay/studio.svg?branch=master)](https://travis-ci.org/seanghay/console)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[ ![Bintray](https://api.bintray.com/packages/seanghay/maven/console/images/download.svg) ](https://bintray.com/seanghay/maven/console/_latestVersion)

------------

## Usage
It uses the default tag which is `Console` to print to `logcat`


```kotlin
fun main() {
  console.log("message1", "message2", obj)
  console.info("message1", "message2")
  console.error("message1", "message2")
  console.warn("message1", "message2")
  
  // Console: message1, message2, Object(...).toString()
}
```

------------


### Customize Tag
It can be useful when you want to have different tags for different logs.

```kotlin
fun main() {
  console.tag("myTag") {
    log("hello", "world")
    error("oh no!")
  }
  
    // myTag: hello, world
    // myTag: oh no!
}
```
It's the same as

```kotlin
fun main() {
  console.tag("myTag")
  
  log("hello", "world")
  error("oh no!")
  
  console.tagReset()
}
```
------------

### Log Count
Count every time it has been called

```kotlin
fun main() {
   
   repeat(100) {
     console.count("myCount")
     // myCount: 1
     // myCount: 2
     // myCount: ..
     // myCount: 100
   }
   
   
   console.countReset("myCount")
   // myCount: 100
}
```

------------


### Time Measurement
Useful for profiling your code

```kotlin
fun main() {
   console.time("profile")
   
   Thread.sleep(1_000L)
   
   console.timeReset("profile")
   
   // profile: 1001 millis
}
```

--------

### Installation

```groovy
implementation('com.seanghay.console:console:1.0.0-alpha01')
```

