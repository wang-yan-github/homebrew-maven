package org.apache.maven.project.builder;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.model.Model;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuilderConfiguration;
import org.apache.maven.shared.model.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Provides services for building maven projects from models.
 */
public interface ProjectBuilder
{
    public PomClassicDomainModel buildModel( File pom, List<Model> inheritedModels,
                                             Collection<ImportModel> importModels,
                                             Collection<InterpolatorProperty> interpolatorProperties,
                                             PomArtifactResolver resolver, File projectDirectory,                                  
                                             ProjectBuilderConfiguration projectBuilderConfiguration )
        throws IOException;       

    /**
     * Returns a maven project for the specified input stream.
     *
     * @param pom                         input stream of the model
     * @param inheritedModels             list of models containing additional parent models in order from most to least specialized
     * @param interpolatorProperties      properties used for interpolation of properties within the model
     * @param resolver                    artifact resolver used in resolving artifacts
     * @param baseDirectory               the base directory of the model
     * @param projectBuilderConfiguration
     * @return a maven project for the specified input stream
     * @throws IOException if there is a problem in the construction of the maven project
     */
    MavenProject buildFromLocalPath( File pom, List<Model> inheritedModels, Collection<ImportModel> importModels,
                                     Collection<InterpolatorProperty> interpolatorProperties,
                                     PomArtifactResolver resolver, File baseDirectory,
                                     ProjectBuilderConfiguration projectBuilderConfiguration )
        throws IOException;

}
