package org.gorendo.designpatternjava.creational.abstractfactory;

public class AbstractFactoryPattern {

    public static void main(String[] args) {
        AbstractFactoryPattern app = new AbstractFactoryPattern();
        app.action();
    }

    private void action() {
        GuiFactory guiFactory = GuiFactory.getFactory(OS.OSX);
        Button button = guiFactory.createButton();
        button.show();
    }
}


abstract class GuiFactory {

    static GuiFactory getFactory(OS typeOS) {
        switch (typeOS) {
            case OSX:
                return new OSXFactory();
            default:
                throw new RuntimeException("Not Implement:" + typeOS);
        }
    }

    public abstract Button createButton();

}

interface Button {

    void show();
}

class OSXButton implements Button {

    public void show() {
        System.out.print("I'm OSXButton");
    }
}

class WinButton implements Button {

    public void show() {
        System.out.print("I'm WinButton");
    }
}


class OSXFactory extends GuiFactory {

    @Override
    public Button createButton() {
        return new OSXButton();
    }
}

enum OS {
    OSX, Win
}
