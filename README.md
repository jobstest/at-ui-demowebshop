TODO: Проект будет развиваться, дополняться, усложняться.
## Проект по тестированию демонстрационного интернет-магазина "Tricentis"
> <a target="_blank" href="https://demowebshop.tricentis.com/">Ссылка на интернет-магазин</a>

![Интернет-магазин](./design/images/demowebshop.tricentis.com.jpg "tricentis")

## Проект реализован с использованием
Java11, Gradle, IntelliJ IDEA, Selenide, Selenoid, JUnit5, Jenkins, Allure Report, Allure TestOps, Jira

![This is an image](./design/icons/Java.png)![This is an image](./design/icons/Gradle.png)![This is an image](./design/icons/Intelij_IDEA.png)![This is an image](./design/icons/Selenide.png)![This is an image](./design/icons/Selenoid.png)![This is an image](./design/icons/JUnit5.png)![This is an image](./design/icons/Jenkins.png)![This is an image](./design/icons/Allure_Report.png)![This is an image](./design/icons/AllureTestOps.png)![This is an image](./design/icons/Telegram.png)![This is an image](./design/icons/Jira.png)

## Запуск автотестов выполняется на локальном сервере Jenkins
![Jenkins](./design/images/Jenkins.jpg "Jenkins")

### Параметры сборки
#### Конфиденциальные данные размещены в файлах properties и вызываются в настройках Jenkins
####Локальный запуск: gradle clean test -DlocalOrRemote=local
####Удаленный запуск: gradle clean test -DlocalOrRemote=remote
![Confidential_data1](./design/images/Confidential_data.jpg)

## Настроена интеграция с Allure Report
![Allure_Report](./design/images/Allure_Report.jpg)

### Пример видеозаписи прохождения теста
![Video_Auth](./design/images/Video_Auth.gif)

## Настроена интеграция с Allure TestOps
![Allure_testops1](./design/images/Allure_testops1.jpg)
![Allure_testops2](./design/images/Allure_testops2.jpg)

## Результаты выполнения тестов интегрированы с Atlassian Jira
![Jira](./design/images/Jira.jpg)

## Откорректированный тест, сгенерированный ChatGpt
TODO: эксперимент считаю удачным, необходимы дальнейшие исследования.
![ChatGpt](./design/images/ChatGpt.jpg)

