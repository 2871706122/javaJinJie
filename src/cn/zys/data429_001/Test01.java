package cn.zys.data429_001;
//构建一个标准类
//1.成员变量用private修饰
//2.为成员变量设置一组getter和setter
//3.设置一个无参数的构造函数
//4.设置一个全参数的构造函数
public class Test01 {
    private String name;
    private char sex;
    private int age;

    public Test01() {
    }

    public Test01(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("yes");
    }
}
