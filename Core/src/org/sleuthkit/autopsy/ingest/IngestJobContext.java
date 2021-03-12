/*
 * Autopsy Forensic Browser
 *
 * Copyright 2014-2021 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.ingest;

import java.util.ArrayList;
import java.util.List;
import org.sleuthkit.datamodel.AbstractFile;
import org.sleuthkit.datamodel.Content;
import org.sleuthkit.datamodel.DataArtifact;

/**
 * An ingest job context object that provides an ingest module with operations
 * specific to the ingest job of which the module is a part.
 *
 * From a coding perspective, this object provides an abstraction that hides
 * ingest infrastructure details.
 */
public final class IngestJobContext {

    private final IngestJobPipeline ingestPipeline;

    /**
     * Constructs an ingest job context object that provides an ingest module
     * with operations specific to the ingest job of which the module is a part.
     *
     * @param ingestJobPipeline
     */
    IngestJobContext(IngestJobPipeline ingestJobPipeline) {
        this.ingestPipeline = ingestJobPipeline;
    }

    /**
     * Gets the execution context identifier of the ingest job.
     *
     * @return The context string.
     */
    public String getExecutionContext() {
        return ingestPipeline.getExecutionContext();
    }

    /**
     * Gets the data source for the ingest job.
     *
     * @return The data source.
     */
    public Content getDataSource() {
        return ingestPipeline.getDataSource();
    }

    /**
     * Gets the unique identifier for the ingest job.
     *
     * @return The ID.
     */
    public long getJobId() {
        return ingestPipeline.getId();
    }

    /**
     * Checks whether or not cancellation of the currently running data source
     * level ingest module for the ingest job has been requested. Data source
     * level ingest modules should check this periodically and break off
     * processing if the method returns true.
     *
     * @return True or false.
     */
    public boolean dataSourceIngestIsCancelled() {
        return ingestPipeline.currentDataSourceIngestModuleIsCancelled() || ingestPipeline.isCancelled();
    }

    /**
     * Checks whether or not cancellation of the currently running file ingest
     * module for the ingest job has been requested. File ingest modules should
     * check this periodically and break off processing if the method returns
     * true.
     *
     * @return True or false.
     */
    public boolean fileIngestIsCancelled() {
        /*
         * It is not currently possible to cancel individual file ingest
         * modules. File ingest cancellation is equiovalent to ingest job
         * cancellation.
         */
        return ingestPipeline.isCancelled();
    }

    /**
     * Checks whether or not cancellation of the currently running data artifact
     * ingest module for the ingest job has been requested. File ingest modules
     * should check this periodically and break off processing if the method
     * returns true.
     *
     * @return True or false.
     */
    public boolean dataArtifactIngestIsCancelled() {
        /*
         * It is not currently possible to cancel individual file ingest
         * modules. Data artifact ingest cancellation is equivalent to ingest
         * job cancellation.
         */
        return ingestPipeline.isCancelled();
    }

    /**
     * Queries whether or not unallocated space should be processed for the
     * ingest job.
     *
     * @return True or false.
     */
    public boolean processingUnallocatedSpace() {
        return ingestPipeline.shouldProcessUnallocatedSpace();
    }

    /**
     * Adds one or more files, e.g., extracted or carved files, to the ingest
     * job for processing by its file ingest modules.
     *
     * @param files The files.
     */
    public void addFilesToJob(List<AbstractFile> files) {
        ingestPipeline.addFiles(files);
    }

    /**
     * Adds one or more data artifacts to the ingest job for processing by its
     * data artifact ingest modules.
     *
     * @param artifacts The artifacts.
     */
    public void addDataArtifactsToJob(List<DataArtifact> artifacts) {
        ingestPipeline.addDataArtifacts(artifacts);
    }

    /**
     * Adds one or more files, i.e., extracted or carved files, to the ingest
     * job associated with this context.
     *
     * @param files The files to be added.
     *
     * @deprecated use addFilesToJob() instead.
     */
    @Deprecated
    public void scheduleFiles(List<AbstractFile> files) {
        addFilesToJob(files);
    }

    /**
     * Queries whether or not cancellation of the data source ingest part of the
     * ingest job associated with this context has been requested.
     *
     * @return True or false.
     *
     * @deprecated Use dataSourceIngestIsCancelled() or fileIngestIsCancelled()
     * instead.
     */
    @Deprecated
    public boolean isJobCancelled() {
        return dataSourceIngestIsCancelled();
    }

}
