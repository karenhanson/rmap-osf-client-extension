/*
 * Copyright 2017 Johns Hopkins University
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

package info.rmapproject.cos.osf.client.model;

import org.dataconservancy.cos.osf.client.support.JodaSupport;
import org.dataconservancy.cos.osf.client.support.UrlToIdTransform;
import org.dataconservancy.cos.rdf.annotations.OwlProperty;
import org.dataconservancy.cos.rdf.support.OwlProperties;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jasminb.jsonapi.RelType;
import com.github.jasminb.jsonapi.ResolutionStrategy;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Model exposes Node ID and pagination links only, so that expensive full model call is not necessary
 * includes parent since having accessible parent is exclusion criteria
 *
 * @author khanson
 */
@Type("nodes")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightNode {

    /**
     * node id
     */
    @Id
    private String id;

    /**
     * timestamp that the node was created
     */
    private DateTime date_created;

    /**
     * timestamp when the node was last updated
     */
    private DateTime date_modified;

    /**If this node is a child node of another node, the parent's canonical endpoint will
     * be available in the /parent/links/related/href key. Otherwise, it will be null.*/
    @Relationship(value = "parent", resolve = true, relType = RelType.RELATED, strategy = ResolutionStrategy.REF)
    @OwlProperty(value = OwlProperties.OSF_HAS_PARENT, transform = UrlToIdTransform.class)
    private String parent;
    
    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return
     */
    public DateTime getDate_created() {
        return date_created;
    }

    /**
     * @param date_created
     */
    public void setDate_created(final String date_created) {
        if (date_created != null) {
            this.date_created = JodaSupport.parseDateTime(date_created);
        }
    }

    /**
     * @return
     */
    public DateTime getDate_modified() {
        return date_modified;
    }

    /**
     * @param date_modified
     */
    public void setDate_modified(final String date_modified) {
        if (date_modified != null) {
            this.date_modified = JodaSupport.parseDateTime(date_modified);
        }
    }

    /**
     *
     * @return
     */
    public String getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     */
    public void setParent(final String parent) {
        this.parent = parent;
    }
}
