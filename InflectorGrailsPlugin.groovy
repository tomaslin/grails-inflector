class InflectorGrailsPlugin {
    // the plugin version
    def version = "0.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.7 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Inflector Plugin" // Headline display name of the plugin
    def author = "Tomas Lin"
    def authorEmail = "tomaslin@gmail.com"
    def description = '''Brings the wonderful world of rails helpers into the dark, grey madness of Grails.

Now you can pluralize, singularize and even ordinalize your words without depending on trivial JavaScript libraries. Yay!
'''

    // URL to the plugin's documentation
    def documentation = "https://github.com/tomaslin/grails-inflector/"

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/tomaslin/grails-inflector/" ]

    def doWithWebDescriptor = { xml ->
    }

    def doWithSpring = {
    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { applicationContext ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }

    def onShutdown = { event ->
    }
}
