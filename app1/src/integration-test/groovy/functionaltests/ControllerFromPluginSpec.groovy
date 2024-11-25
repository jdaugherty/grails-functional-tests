package functionaltests

import grails.testing.mixin.integration.Integration
import grails.plugin.geb.ContainerGebSpec

@Integration(applicationClass = Application)
class ControllerFromPluginSpec extends ContainerGebSpec {

    void 'test invoking a controller provided by a plugin'() {
        when:
        go '/alpha'

        then:
        $('h2',0).text() == 'This is views/alpha/index.gsp'
    }
}
