package hyphenated

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.*
import grails.plugin.geb.ContainerGebSpec

@Integration(applicationClass = Application)
@Rollback
class HyphenateControllerSpec extends ContainerGebSpec {

    void "test something"() {
        when:"The home page is visited"
            go '/hyphenate/long-name'

        then:"The title is correct"
        	$().text() == 'good'
    }
}
