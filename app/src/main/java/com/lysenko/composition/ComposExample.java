package com.lysenko.composition;

public class ComposExample {
    public static void main(String[] args) {
        Display redDisplay = new RedDisplay();
        Draw redDraw = new RedDraw();
        DrawAndDisplayFacade drawAndDisplayFacade = new DrawAndDisplayFacade(redDisplay, redDraw);
        drawAndDisplayFacade.run();

    }
}

interface Display {
    void print();
}

interface Draw {
    void draw();
}

class RedDisplay implements Display {
    public void print() {
        System.out.println("print ");// логика печати красным цветом
    }

}

class RedDraw implements Draw {
    public void draw() {
        System.out.println("draw ");// логика рисования красным цветом
    }
}

class DrawAndDisplayFacade {

    private Display display;
    private Draw draw;

    DrawAndDisplayFacade(Display display, Draw draw) {
        this.display = display;
        this.draw = draw;
    }

    void run() {
        display.print();
        draw.draw();
    }
}
