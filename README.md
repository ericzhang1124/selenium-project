# selenium-project
web自动化项目-以拉勾网为测试网页进行测试

## 项目描述
该项目使用selenium WEBDRIVER技术进行WEB UI自动化测试， 使用PAGE OBJECT思想对代码进行了分层，并通过Maven的pom.xml执行了testng.xml, 还有一个子工程，可以对testNG的测试结果数据进行二次处理生产更友好的测试报告，该子项目执行通过build.xml脚本！ 后期在Jenkins持续化集成测试的时候只需要通过Maven插件和Ant插件执行相应的脚本即可
