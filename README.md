# Hudl UI Acceptance Tests

Hudl UI Acceptance Test is a [Selenide-based](https://selenide.org/) Java BDD UI
acceptance test framework designed to test [Hudl](https://www.hudl.com/) main website.
The tests emphasises on covering user journeys and behaviour.

## Setting up the project

### Pre-requisites

- [Java 11](https://www.oracle.com/uk/java/technologies/javase/jdk11-archive-downloads.html) installed and environment
  variable `JAVA_HOME` defined
- [Maven 3.8.6](https://maven.apache.org/download.cgi) (minimum) installed and environment variable `M2_HOME` defined

### Building the project

Build the project using `mvn clean compile`.

### Running tests

To run all tests, use `mvn clean test`

#### Environment Properties
Configure the ```environment.properties``` with a valid hudl email and password

```
valid.email = test@email.com
valid.password = password
```

Alternatively, they can be parsed in as an argument. 
```-Dvalid.email=test@email.com -Dvalid.password=password```

#### Browser

To run tests with different browsers, add argument 
`mvn clean verify-Dselenide.browser="firefox"`.

`chrome` is default. Accepted values as of follows:

```
firefox
ie
edge
safari
```

To run tests with headless, add argument `mvn clean verify -Dselenide.headless=true`

#### Tag tests

To run tagged tests, add argument `mvn clean verify -Dcucumber.filter.tags=@test"`

### Report 
To run tests with tests report, using `mvn clean verify`

The test report can be accessed in the following directory:
```
target/cucumber-html-reports/overview-features.html
```

## Built with

- Maven
- Selenide

## TODO:
- explore other reporting tools e.g. allure
- add checkstyle plugin for maintaining coding standard
- pass in env arg to test in different env e.g. ```qa|staging.base.url```

