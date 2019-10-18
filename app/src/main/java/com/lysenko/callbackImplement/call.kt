package com.lysenko.callbackImplement

fun main() {
    val button2 = Button2(ButtonClickHandler())
    button2.click()
    button2.click()
}

interface EventHandler {
    fun execute()
}

class ButtonClickHandler : EventHandler {
    override fun execute() {
        println("Button pressed")
    }
}


class Button2 {
    private var handler: EventHandler

    constructor(action: EventHandler) {
        this.handler = action
    }

    fun click() {
        handler.execute()
    }
}

