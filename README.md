# practice-java-selenium-testng
A basic test automation framework using Java, Selenium, and TestNG

The sample tests in this framework use 
[Parabank](https://parabank.parasoft.com/parabank/index.htm) 
as a test environment

Each test class can contain one or more tests
* Tests in the same class will reuse the same browser to save time

To run tests:
1. label tests with "group" annotation:
   1. such as "@Test(groups={'smoke'})"
2. in Terminal, run the following commands:
   1. mvn clean test -Dgroups=group_name
   2. mvn clean test -Dtest=class_name
   3. mvn clean test -Dtest=class_name#testMethod
3. optional Maven command-line parameters:
   1. -DtestBrowser=browser_name
      1. currently 'Chrome' or 'Edge'