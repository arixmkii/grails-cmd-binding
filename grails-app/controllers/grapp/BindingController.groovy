package grapp

import grails.converters.JSON

class BindingController {

    static allowedMethods = [post: "POST"]

    def post(BindingCommand command){
        println(command.unimportant)
        println(command as JSON)
        render(command.important as JSON)
    }

}
