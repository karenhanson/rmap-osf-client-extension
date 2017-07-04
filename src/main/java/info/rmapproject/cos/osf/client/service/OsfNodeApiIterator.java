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

import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.github.jasminb.jsonapi.ResourceList;

import info.rmapproject.cos.osf.client.model.LightNode;

/**
 * Retrieves and iterates over OSF Node data.
 *
 * @author khanson
 */
public class OsfNodeApiIterator extends OsfApiIterator<LightNode> {
	   

	/** The list of IDs to iterate over. */
	protected ResourceList<LightNode> ids = null;
	
    /**
     * Instantiates a new OSF Node API iterator.
     *
     * @param filters the filters
     * @throws Exception the exception
     */
    public OsfNodeApiIterator(Map<String, String> params) {
    	super(params);
    	loadBatch(); //load first batch
    }    

    /* (non-Javadoc)
     * @see info.rmapproject.transformer.osf.OsfNodeBaseApiIterator#loadBatch()
     */
    @Override
	protected void loadBatch() {
		position = 0;
		try {
			incrementPageNumberParam();
			//need to cast ids as ResourceList in order to access page links
			ids = (ResourceList<LightNode>) osfClient.getNodeIds(params);
			this.recordRetrievedDate=new DateTime(DateTimeZone.UTC);
		} catch(Exception e){
			LOG.error("Could not load list of records to iterate over.");
			throw new RuntimeException(e);
		}	
    }

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public LightNode next() {
		LightNode node = null;
		
		try {			
			while(node==null && hasNext()) {

				if ((ids==null || position==ids.size())){
					loadBatch();
				}
				//load next
				node = ids.get(position);
				position=position+1;
			} 
		} catch (Exception e){
			//load failed
			throw new RuntimeException("Iterator failed to load Record for import",e);
		}

		if (node==null){
			throw new RuntimeException("No more Node records available in this batch");
		}
		
		
		return node;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
    	int size = ids.size();
    	String next = ids.getNext();
    	    	
		return (position<(size) || next!=null);
	}
    	
}
