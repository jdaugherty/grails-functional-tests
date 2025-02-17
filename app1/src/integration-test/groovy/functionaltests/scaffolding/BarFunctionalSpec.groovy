package functionaltests.scaffolding

import functionaltests.Application
import grails.gorm.transactions.Rollback
import grails.plugin.geb.ContainerGebSpec
import grails.testing.mixin.integration.Integration

@Integration(applicationClass = Application)
@Rollback
class BarFunctionalSpec extends ContainerGebSpec {

    void "Test that a scaffolded view is resolved correctly"() {
        when:
        go '/bar/index'

        then:
        title == "Bar List"
    }
}