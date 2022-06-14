# Assignment

## Technology:
- Tool: Selenium
- Language: Java
- IDE: Intellij IDEA
- Build tool: Maven
- Framework: Cucumber
- Syntax: Gherkin

## Prerequisite:
1. Need to install jdk 11 and configure it into Environment variable
2. Download maven and configure it into Environment variable also

## Run the automation script:
1. Open the project with Intellij IDEA by clicking on pom.xml
2. Let the Intellij IDEA to download the dependicies for the first run
3. After dependicies are downloaded and project loaded successfully, click on Terminal from the bottom bar 
4. Type this command:
```sh
mvn clean install
```
5. Selenium will open the browser and start automation.
6. To view report of the automation execution, expand the target folder and open "cucumber-html-report.html" in a browser
```sh
```
## Report View
![2022-06-09_22-45-09](https://user-images.githubusercontent.com/28926103/172900610-db9597aa-0307-4fc6-bd3b-acd62a41e29d.png)
