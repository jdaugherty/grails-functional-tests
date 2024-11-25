# Functional tests for Grails Core

[![Java CI](https://github.com/grails/grails-functional-tests/actions/workflows/gradle.yml/badge.svg)](https://github.com/grails/grails-functional-tests/actions/workflows/gradle.yml)


A Suite of functional tests for Grails

To change the Geb driver used to run the functional tests supply the geb.env system property.

    ./gradlew -Dgeb.env=chromeHeadless iT   

### Usage
To test a PR in grails/grails-core with grails-functional-tests before merging:
1. Publish the PR branch to Maven Local:
   Run this in grails/grails-core:
```
./gradlew pTML
```
2. Checkout the relevant branch (e.g. 7.0.x) in grails/grails-functional-tests
3. Add `mavenLocal()` at the top of the repositories block in the root `build.gradle` of `grails/grails-functional-tests`.
https://github.com/grails/grails-functional-tests/blob/2df395bf60d42c4d596837453dc717e8c3d638e4/build.gradle#L26-L35
4. Run the Functional Tests:
   In grails/grails-functional-tests, run:
```
./gradlew build
```
5. Check the Results:
   Verify that the build completes successfully.
```console
BUILD SUCCESSFUL in 4m 20s
139 actionable tasks: 124 executed, 15 up-to-date
```
