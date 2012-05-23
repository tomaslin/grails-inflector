package plugin.grails.inflector

import org.modeshape.common.text.Inflector

class InflectorTagLib {

    static namespace ='inf'

    def pluralize = { args, body ->
        def word = body().toString()
        def count = args.'count' as Integer ?: 2

        if (word) {
            out << Inflector.instance.pluralize(word, count)
        } else {
            throw new IllegalArgumentException('Tag pluralize requires a word')
        }
    }

    def ordinalize = { args, body ->
        def number = body().toString() as Integer
        if (number == 0 || number) {
            out << Inflector.instance.ordinalize(number)
        } else {
            throw new IllegalArgumentException('Tag ordinalize requires a number')
        }
    }

    def singularize = { args, body ->
        out << inflect('singularize', body().toString())
    }

    def camelCase = { args, body ->
        out << inflect('lowerCamelCase', body().toString())
    }

    def underscore = { args, body ->
        out << inflect('underscore', body().toString())
    }

    def capitalize = { args, body ->
        out << inflect('capitalize', body().toString())
    }

    def humanize = { args, body ->
        out << inflect('humanize', body().toString())
    }

    def titleCase = { args, body ->
        out << inflect('titleCase', body().toString())
    }

    private def inflect(method, word) {
        if (word) {
            return Inflector.instance."${method}"(word)
        } else {
            throw new IllegalArgumentException("Tag ${method} requires a word")
        }
    }

}