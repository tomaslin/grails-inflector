package plugin.grails.inflector

import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.modeshape.common.text.Inflector
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(InflectorTagLib)
class InflectorTagLibSpec extends Specification {


    @Unroll("#singular pluralized is #plural ")
    def "pluralize works correctly"() {
        expect:
        applyTemplate("<inf:pluralize>${ singular }</inf:pluralize>") == plural

        where:
        plural        | singular
        "rabbits"     | "rabbit"
        "octopi"      | "octopus"
        "news"        | "news"
        "parentheses" | "parenthesis"
    }

    def "pluralize with a count works correctly"() {
        expect:
        applyTemplate("<inf:pluralize count='${ count }'>rabbit</inf:pluralize>") == plural

        where:
        count | plural
        -399  | 'rabbits'
        -1    | 'rabbit'
        0     | 'rabbits'
        1     | 'rabbit'
        2     | 'rabbits'
        400   | 'rabbits'
    }

    @Unroll("#number ordinalized is #expected ")
    def "ordinalize works correctly"() {
        expect:
        applyTemplate("<inf:ordinalize>${ number }</inf:ordinalize>") == expected

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
        applyTemplate("<inf:singularize>${ plural }</inf:singularize>") == singular

        where:
        plural        | singular
        "rabbits"     | "rabbit"
        "octopi"      | "octopus"
        "news"        | "news"
        "parentheses" | "parenthesis"
    }

    @Unroll('#tag')
    def 'additional tags'() {
        expect:
        applyTemplate("<inf:$tag>$word</inf:$tag>") == result

        where:
        tag          | word                     | result
        'camelCase'  | 'active_record'          | 'activeRecord'
        'camelCase'  | 'first_name'             | 'firstName'
        'underscore' | 'activeRecord'           | 'active_record'
        'underscore' | 'ActiveRecord'           | 'active_record'
        'capitalize' | 'sound and the fury'     | 'Sound and the fury'
        'humanize'   | 'employee_salary'        | 'Employee salary'
        'humanize'   | 'author_id'              | 'Author'
        'titleCase'  | 'man from the boondocks' | 'Man From The Boondocks'
        'titleCase'  | 'x-men: the last stand'  | 'X-Men: The Last Stand'
    }

    def 'errors'() {
        when:
        applyTemplate("<inf:$tag/>")

        then:
        thrown GrailsTagException

        where:
        tag << ['camelCase', 'undescore', 'humanize', 'titleCase']
    }

    def 'default pluralizer'() {
        given:
        Inflector.instance.addPluralize('(heroku)$', '$1Rocks');
        expect:
        applyTemplate( '<inf:pluralize>heroku</inf:pluralize>' ) == 'herokuRocks'
    }

}