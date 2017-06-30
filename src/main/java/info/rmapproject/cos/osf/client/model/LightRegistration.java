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

import org.dataconservancy.cos.rdf.annotations.OwlProperty;
import org.dataconservancy.cos.rdf.support.OwlProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jasminb.jsonapi.annotations.Type;

/**
 * Model exposes Registration ID only and some key fields for filtering, so that expensive full model call is not necessary
 * @author khanson
 */
@Type("registrations")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightRegistration extends LightNode {


    /**Has this registration been withdrawn?**/
    @OwlProperty(OwlProperties.OSF_IS_WITHDRAWN)
    private Boolean isWithdrawn;

    /** Is this registration pending withdrawal?*/
    @OwlProperty(OwlProperties.OSF_IS_PENDINGWITHDRAWL)
    private Boolean isPending_withdrawal;

    /**Is this registration pending approval?*/
    @OwlProperty(OwlProperties.OSF_IS_PENDINGREGISTRATIONAPPROVAL)
    private Boolean isPending_registration_approval;

    /** Is the associated Embargo awaiting approval by project admins? */
    @OwlProperty(OwlProperties.OSF_IS_PENDINGEMBARGOAPPROVAL)
    private Boolean isPending_embargo_approval;


    /**
     *
     * @return
     */
    public Boolean isWithdrawn() {
        return isWithdrawn;
    }

    /**
     *
     * @param isWithdrawn
     */
    public void setWithdrawn(final Boolean isWithdrawn) {
        this.isWithdrawn = isWithdrawn;
    }


    /**
     *
     * @return
     */
    public Boolean isPending_withdrawal() {
        return isPending_withdrawal;
    }

    /**
     *
     * @param isPending_withdrawal
     */
    public void setPending_withdrawal(final Boolean isPending_withdrawal) {
        this.isPending_withdrawal = isPending_withdrawal;
    }
	
	/**
	 *
	 * @return
	 */
	public Boolean isPending_registration_approval() {
	    return isPending_registration_approval;
	}
	
	/**
	 *
	 * @param isPending_registration_approval
	 */
	public void setPending_registration_approval(final Boolean isPending_registration_approval) {
	    this.isPending_registration_approval = isPending_registration_approval;
	}
	
	/**
	 *
	 * @return
	 */
	public Boolean isPending_embargo_approval() {
	    return isPending_embargo_approval;
	}
	
	/**
	 *
	 * @param isPending_embargo_approval
	 */
	public void setPending_embargo_approval(final Boolean isPending_embargo_approval) {
	    this.isPending_embargo_approval = isPending_embargo_approval;

	}
}
