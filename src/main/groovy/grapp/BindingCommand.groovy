package grapp

import grails.databinding.BindUsing
import grails.validation.Validateable

class BindingCommand implements Validateable {

    String unimportant

    @BindUsing({ c, source -> toTypedMapMap(source['important']) })
    Map<Long, BindingResult> important = [:]

    private static Map<Long, BindingResult> toTypedMapMap(Map<String, Object> map) {
        map.findAll { key, value ->
            key.isLong()
        }.collectEntries { key, value ->
            [key.toLong(), new BindingResult(text: value.text, selected: value.selected == "on")]
        } as Map<Long, BindingResult>
    }
}
