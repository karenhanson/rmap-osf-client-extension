/*******************************************************************************
 * Copyright 2017 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This software was produced as part of the RMap Project (http://rmap-project.info),
 * The RMap Project was funded by the Alfred P. Sloan Foundation and is a 
 * collaboration between Data Conservancy, Portico, and IEEE.
 *******************************************************************************/
package info.rmapproject.cos.osf.client.service;

import java.util.Iterator;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An abstract iterator class to iterate over a list of OSF Nodes. 
 * This can be used with both OSF Nodes and OSF Registrations which share a lot of fields
 * @param <LightOsfObject>
 */
public abstract class OsfApiIterator<T> implements Iterator<T>{
	/** The log. */
    protected static final Logger LOG = LoggerFactory.getLogger(OsfApiIterator.class);  
    
    /** The params. */
    protected Map<String, String> params = null;
	
	/** The position of the iterator. */
	protected int position = -1;
	
	/** The OSF client, used to retrieve data from API. */
	protected OsfClientService osfClient = null;
		
	/** retrieval date **/
	protected DateTime recordRetrievedDate;
	
	/**
	 * Instantiates a new OSF Node base API iterator.
	 */
	protected OsfApiIterator(Map<String, String> params) {
		this.params=params;
		this.osfClient = new OsfClientService();
	}

	/**
	 * Collect OSF data from API using parameters defined.
	 */
	protected abstract void loadBatch();
	
	/**
	 * Using params list, retrieves current page number and increments by one
	 * @return
	 */
	protected void incrementPageNumberParam() {
		Integer page = 0;
		String pageval = params.get("page");
		if (pageval!=null && !pageval.isEmpty()){
			page = Integer.parseInt(pageval);
		}
		page=page+1;
		params.put("page", page.toString());
		LOG.info("Page number set to " + page);		
	}
	
	/**
	 * Returns retrieved date of current record loaded
	 * @return
	 */
	public DateTime getRecordRetrievedDate(){
		return recordRetrievedDate;
	}
	
	
	
}