#Inflector Plugin for Grails

This plugin provides a set of simple tags to simplify common text inflections. The most common case is the ability to pluralize and singularize words.

The plugin makes it easy to say 'Currently Logged In: 2 Users' vs. 'Currently Logged In: 1 User'.

It uses the Inflector class from the JBoss Modeshape library, which is in turn based on the Ruby Inflector.rb.

##Tags
The tags contained are as follows:

###Pluralize
Gives the plural of words

     <g:pluralize>Chicken</g:pluralize> -> Chickens

Pluralize also takes a count, so 

     <g:pluralize count="1">Chicken</g:pluralize> -> Chicken

###Singularize

The opposite of pluralize.

     <g:singularize>Chickens</g:singularize> -> Chicken

####Providing your own rules

You can provide your own singulars and plurals by adding them to the Inflector singleton. 

For example, adding the following in your bootstrap file:

     Inflector.instance.addPluralize('(heroku)$', '$1Rocks');

would then enable you to call:

     <g:pluralize>heroku</g:pluralize> -> herokuRocks

similarly, you can also add singular matches:

    Inflector.instance.addSingularize("CloudFoundry$", "$1Sucks");

For more examples, look at the Inflector.java file found under the src/java 

##Additional Tags:

The plugin also provides the following additional tags:

###camelcase
Converts strings to lower Camel Case.

###underscore
Makes an underscored form from the expression in the string

###uppercase
Returns a copy of the input with the first character converted to uppercase and the remainder to lowercase.

###humanize
Capitalizes the first word and turns underscores into spaces and strips trailing "_id" and any supplied removable tokens.

###titleCase
Capitalizes all the words and replaces some characters in the string to create a nicer looking title. Underscores are changed to spaces, a trailing "_id" is removed

###ordinalize 
Turns a non-negative number into an ordinal string used to denote the position in an ordered sequence, such as 1st, 2nd,3rd, 4th.

##Using additional tags

To use them, simply call the tag with the string to be transformed in the body.

For example, 

    <g:ordinalize>2</g:ordinalize> => 2nd


