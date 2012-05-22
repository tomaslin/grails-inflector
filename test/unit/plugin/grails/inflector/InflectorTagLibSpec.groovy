package plugin.grails.inflector

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(InflectorTagLib)
class InflectorTagLibSpec extends Specification {

    @Unroll("#number ordinalized is #expected ")
    def "ordinalize works correctly"() {
        expect:
        applyTemplate("<g:ordinalize number='${ number }' />") == expected

        where:
        number | expected
        1      | '1st'
        2      | '2nd'
        3      | '3rd'
        4      | '4th'
        5      | '5th'
        0      | '0th'
        -49    | '-49th'
    }

    @Unroll("#singular ordinalized is #plural ")
    def "singularize works correctly"() {
        expect:
        applyTemplate("<g:singularize word='${ plural }'/>") == singular

        where:
        plural        | singular
        "rabbits"     | "rabbit"
        "octopi"      | "octopus"
        "news"        | "news"
        "parentheses" | "parenthesis"
    }

    @Unroll("#singular pluralized is #plural ")
    def "pluralize works correctly"() {
        expect:
        applyTemplate("<g:pluralize word='${ singular }'/>") == plural

        where:
        plural        | singular
        "rabbits"     | "rabbit"
        "octopi"      | "octopus"
        "news"        | "news"
        "parentheses" | "parenthesis"
    }

    def "pluralize with a count works correctly"() {
        expect:
        applyTemplate("<g:pluralize word='rabbit' count='${ count }'/>") == plural

        where:
        count | plural
        -399  | 'rabbits'
        -1    | 'rabbit'
        0     | 'rabbits'
        1     | 'rabbit'
        2     | 'rabbits'
        400   | 'rabbits'
    }

    def "humanize"() {
        expect:
        applyTemplate("<g:humanize word='apple_id' />") == 'Apple'
        applyTemplate("<g:humanize word='apple_and_bananas'/>") == 'Apple and bananas'
    }


}