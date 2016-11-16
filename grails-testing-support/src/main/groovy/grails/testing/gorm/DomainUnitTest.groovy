/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package grails.testing.gorm

import org.junit.Before

import java.lang.reflect.ParameterizedType

trait DomainUnitTest<T> implements DataTest {

    private boolean hasBeenMocked = false

    void mockArtefact(Class c) {
        mockDomain c
    }

    @Before
    void mockDomainUnderTest() {
        if(!hasBeenMocked) {
            mockDomain(getDomainUnderTest())
            hasBeenMocked = true
        }
    }

    private Class<T> getDomainUnderTest() {
        ParameterizedType parameterizedType = (ParameterizedType)getClass().genericInterfaces.find { genericInterface ->
            genericInterface instanceof ParameterizedType &&
                    DomainUnitTest.isAssignableFrom((Class)((ParameterizedType)genericInterface).rawType)
        }

        parameterizedType?.actualTypeArguments[0]
    }

}
