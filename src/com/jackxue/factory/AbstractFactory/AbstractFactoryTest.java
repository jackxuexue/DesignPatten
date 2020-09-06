package com.jackxue.factory.AbstractFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        DataUtils dataUtils = new OricleUtils();
        Connection connection = dataUtils.getConnection();
        connection.connect();
        Command command = dataUtils.getCommand();
        command.command();
    }
}

interface Connection{
    public abstract void connect();
}

interface Command{
    public abstract void command();
}

interface DataUtils{
    public abstract Connection getConnection();
    public abstract Command getCommand();
}

//mysql
class MysqlConnection implements Connection{

    @Override
    public void connect() {
        System.out.println("mysql connected...");
    }
}

class MysqlCommand implements Command {

    @Override
    public void command() {
        System.out.println("mysql command...");
    }
}

class MysqlDataUtils implements DataUtils{

    @Override
    public Connection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public Command getCommand() {
        return new MysqlCommand();
    }
}


//Oricle
class OricleConnection implements Connection {

    @Override
    public void connect() {
        System.out.println("oricle connected...");
    }
}
class OricleCommand implements Command {

    @Override
    public void command() {
        System.out.println("oricle command....");
    }
}
class OricleUtils implements DataUtils{

    @Override
    public Connection getConnection() {
        return new OricleConnection();
    }

    @Override
    public Command getCommand() {
        return new OricleCommand();
    }
}


