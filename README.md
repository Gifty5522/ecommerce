# E-Commerce Shopping Site
Here we are not only doing the user registration but also allowing user can buy the product online.
And User registration happens through random user details generator via API. 

# Prerequisites
Below are the few packages/ software should install in you system before running the scenarios.
- Chrome browser.
- CMD/Eclipse or any IDE.
- Java.
- Maven and TestNg Plugin.

# Installation
Below are the steps that we need to follow in order to run the project
 - [Clone](https://github.com/Gifty5522/ecommerce.git) the project into you local system (i.e. into your eclipse IDE or any other IDE)
 - Navigate to **testng.xml** file and Right click on **testng.xml** file then Select **Run as TestNG Suite** or Right click on **pom.xml** file then select **maven test** or via **cmd** type **mvn test**
 
# Report
Report can be found under **luma\test-output\index.html**

# Limitation or Furure Enhancement
- Currently supports only Chrome browser.
- Currently used TestNG parameters to pass few mandatory data.
- Test data can be pass from excel file or using dataprovider as well instead of passing via Constant file.
- Does not implement any mechanism for taking screenshot.
- Selecting a menu can be customizable.
- Used Thread.sleep() method but this can be removed
- Here only keeping in my to register and buy a product [exclude any validation like matching a title of product, number of items added or not, amount calculation as per product etc.]

# Authors
  - Gifty Chhabra: **[GitHub profile](https://github.com/Gifty5522)** || **[LinkedIn profile](https://www.linkedin.com/in/gchhabra6/)**
  
# License
No License is require.