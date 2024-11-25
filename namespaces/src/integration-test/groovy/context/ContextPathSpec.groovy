package context

import grails.plugin.geb.ContainerGebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import namespaces.Application

@Integration(applicationClass = Application)
@Rollback
class ContextPathSpec extends ContainerGebSpec {

    void "test the context path defined in the environment overrides the standard one"() {
        when:
        go '/myAppTest'

        then:
        title == "Welcome to Grails"

        when:
        go '/myApp'

        then:
        title == "HTTP Status 404 – Not Found"
    }
}
