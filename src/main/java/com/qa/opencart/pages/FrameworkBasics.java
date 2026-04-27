package com.qa.opencart.pages;

public class FrameworkBasics {
/*Framework:
 Hybrid : Libs/utils+generate logs+Reports logs+DD approach (with parameterization and excel sheet)
 Design Pattern: POM(Page object model)+SRP(single responsibility pattern)
 * Q.Tell me about the what are the diferent tools and technologies you are using . Basic feature of your framework
 1.Generic -No hard coded value 
 2.utils/libs:It should support all the utilities
 3.Maintenance of the framework:framework should not be like you are have developed it after 2 months nobody able to maintain it
 bcoz of the complexity of the framework
 4.simple design/easy to understand:unnecessary complex code u should not write but complex logic we can maintain.So the flow &design of the
 framework should easy.
 5.Test logic should be written separate
 6.main Source code logic also should be written separate: the code which we are writting  under src/main java
 7.Framework should support required infrastructure also e.g:if we want to run the testcases on AWS, through docker or jenkins
 
 tools/Technologies:Design point of view
1. Sel+Java
2. TestNG liberary: to write the testcases
3. webdriver manager library
4. Data driver approach:with the help fo Excel(using POI API)+DP data provider+parameter appraoch from the testng xml file
5.log4j API:to generate te logs
6.Extent/Allure report : To generate the report
7.Maven: uild automation tool:help to generate the build and create the jar&we will deploy that build also.
 
 tools/Technologies:infrastructure point of view
 1.Git Repo
 2.Jenkins
 3.Docker
 4.Dockerized Selenium grid:for cross browser testing
 5.AWs-> using Linux EC2 machine-To setup selenium grid over there
 6.Zalenium
 7.Selenoid
 8.NGROK proxy:to run the testcases through proxy
 
 
 */
}
