# back-end


本次作业采用idea作为ide。

通过生成spring项目快速搭建。

项目共两个类，其中DemoApplication类是spring入口类，WordLadder类为应用类。

localhost:8081/wordLadder?start={startWord}&end={endWord}可以用来获得相应的wordChain

采用actuator自定义端点author查看作者

添加spring security保证使用wordLadder时需要登陆（用户名：user，密码：password）