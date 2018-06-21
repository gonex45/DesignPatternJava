package org.gorendo.designpatternjava.creational.abstractfactory;

public class AbstractFactoryPattern {

    public static void main(String[] args) {
        AbstractFactoryPattern app = new AbstractFactoryPattern();
        app.action();
    }

    private void action() {
        GuiFactory guiFactory = GuiFactory.getFactory(Os.OSX);
        Button button = guiFactory.createButton();
        button.show();
    }
}


abstract class GuiFactory {

    static GuiFactory getFactory(Os typeOs) {
        switch (typeOs) {
            case OSX:
                return new OsxFactory();
            default:
                throw new RuntimeException("Not Implement:" + typeOs);
        }
    }

    public abstract Button createButton();

}

interface Button {

    void show();
}

class OsxButton implements Button {

    public void show() {
        System.out.print("I'm OsxButton");
    }
}

class WinButton implements Button {

    public void show() {
        System.out.print("I'm WinButton");
    }
}


class OsxFactory extends GuiFactory {

    @Override
    public Button createButton() {
        return new OsxButton();
    }
}

enum Os {
    OSX, Win
}
