# WordLadder #
本项目用java重写了wordladder。

## 打包工具 ##

maven

教程参考：https://www.yiibai.com/maven/

目前知道了maven的打包方法。将写的代码替换了app.java和appTest.java。

## ide ##

idea

idea对java有很好的支持，可以轻松完成junit的配置和maven的打包。较vscode更为友好。

## 测试工具 ##

junit4

参考文档：https://www.w3cschool.cn/junit/fegu1hv3.html


## 代码 ##

在wordladder类中有成员：

* public static String dictPath = "./dictionary.txt";
    * 储存字典位置。
* public static String[] getWords()
    * 获取输入单词并保存于数组里
* private static void printWord(String[] words)
    * 将所获得的单词变化路径打印出来
* private static HashSet<String> getWordList()
    * 将字典的单词读入set中
* private static String[] searchWord(String[] words,HashSet<String> wordList)
    * 用bfs算法搜索单词变化的最短路径
* public static void main(String[] args)
    * 主函数

## 问题 ##

* java的数据结构较为复杂，难以拷贝。String的操作较c++等复杂。需要多加熟悉java的语法。

* mvn的功能十分强大，目前还需要多加了解。

* 测试难以上手，代码不易测试，对测试工具较为生疏。