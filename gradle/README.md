# Gradle

## Some Commands
- To create Gradle project
    ```
    gradle init
    ```

- To download and use gradle specific to project
    ```
    ./gradlew 
    ```

- To build faster
    ```
    gradle build --daemon
    ```

- To build without using daemon
    ```
    gradle build --no-daemon
    ```
  
## plugins
Defines plugins that can be used in gradlew.
- application - plugin for java application

## 	dependencies
- 3 parts: `groupId`, `artifactId` and `version` (separated by colon)
  - Example: `com.google.guava:guava:30.1.1-jre`
  - `groupId`: `com.google.guava`
  - `artifactId`: `guava`
  - `version`: `30.1.1-jre`
  
- scopes/configurations (configurations are coming from java plugin)
  - implementation - dependencies needed for classes to be compiled and ran.
  - api - "leaky" (compile). Use implementation to prevent leak.
  - testImplementation - compiling and running only the tests.
  - compileOnly - dependencies will be available only during compile time and not during runtime. (Dozer, Lombok, JMapper)
  - runtimeOnly - The implementation of an API can come at runtime (logging-api, logging-impl)
  - testCompileOnly - (Junit, Jasmine, Mockito)
  - testRuntimeOnly - dependencies not required during compilation time (Jupiter, Jasmine Runtime)

## repositories
Where the dependencies are coming from.

---

## Gradle phases
- Initialization  - Create object for each project that represent the build.gradle. (modules)
- Configuration☺ - Go through all the tasks that are required to run the current build and creates DAG (Direct Acyclic Graph).
- Execution - Where gradle runs the tasks. (compile, test, etc.)
  - doFirst()
  - doLast()

---

## Project object
- project.name - read-only
- project.description
- project.version
- project.ext - adding custom project property

## Task object
- task1.dependsOn task2
- task1.finalizedBy task2
- defaultTasks "defaultTask"

---

## Creating Web App
```gradle
plugins {
  id 'war'
  id 'org.gretty' version '4.0.0'
}

repositories {
  // Use Maven Central for resolving dependencies.
  mavenCentral()
}

dependencies {
  compileOnly 'jakarta.servlet:jakarta.servlet-api:5.0.0-M2'
}
```

- gradle war
- gradle appRun

---

## Multi-module or multi project
- :subproject:task - targeting task of subproject from root project
- allprojects - can execute task in subproject
- subprojects - execute task only in subproject