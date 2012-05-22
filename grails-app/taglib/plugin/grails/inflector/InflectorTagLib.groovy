package plugin.grails.inflector

import org.modeshape.common.text.Inflector

class InflectorTagLib {

    def ordinalize = { args ->
        def number = args.number as int
        if ( number == 0 || number ) {
            out << Inflector.instance.ordinalize( number )
        } else {
            throw new IllegalArgumentException('Tag ordinalize requires a number')
        }
    }

    def camelCase = { args ->
        if (args.word) {
            out << Inflector.instance.camelCase(args.word)
        } else {
            throw new IllegalArgumentException('Tag camelcase requires a word')
        }
    }

    def singularize = { args ->
        def word = args.word
        if (word) {
            out << Inflector.instance.singularize(word)
        } else {
            throw new IllegalArgumentException('Tag singularize requires a word')
        }
    }

    def pluralize = { args ->
        def word = args.word
        def count = args.'count' as Integer ?: 2

        if (word) {
            out << Inflector.instance.pluralize(word, count)
        } else {
            throw new IllegalArgumentException('Tag pluralize requires a word')
        }
    }

    def humanize = { args ->
        def word = args.word
        if (word) {
            out << Inflector.instance.humanize(word)
        } else {
            throw new IllegalArgumentException('Tag pluralize requires a word')
        }
    }


}