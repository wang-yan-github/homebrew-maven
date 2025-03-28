/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.it;

import java.io.File;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is a test set for <a href="https://issues.apache.org/jira/browse/MNG-885">MNG-885</a>.
 *
 * @author John Casey
 *
 */
public class MavenIT0072InterpolationWithDottedPropertyTest extends AbstractMavenIntegrationTestCase {
    public MavenIT0072InterpolationWithDottedPropertyTest() {
        super(ALL_MAVEN_VERSIONS);
    }

    /**
     * Verifies that property references with dotted notation work within
     * POM interpolation.
     *
     * @throws Exception in case of failure
     */
    @Test
    public void testit0072() throws Exception {
        File testDir = extractResources("/it0072");

        Verifier verifier = newVerifier(testDir.getAbsolutePath());
        verifier.setAutoclean(false);
        verifier.deleteDirectory("target");
        verifier.addCliArgument("validate");
        verifier.execute();
        verifier.verifyErrorFreeLog();

        Properties props = verifier.loadProperties("target/pom.properties");
        assertEquals("1.0-SNAPSHOT", props.getProperty("project.version"));
    }
}
