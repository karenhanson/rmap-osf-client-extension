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
package info.rmapproject.cos.osf.client.model;

/**
 * OSF Record types
 * @author khanson
 */
public enum RecordType {
	/** OSF Registrations API. */
	OSF_REGISTRATION ("registration"),
	
	/** OSF Users API. */
	OSF_USER ("user"),
	
	/** OSF Nodes API. */
	OSF_NODE ("node");
	
	/** type as string, for OSF this corresponds to API path */
	private String typeString;
	
	/**
	 * Instantiates a new transform type.
	 *
	 * @param value the Record Type 
	 * @param source the source (api or local)
	 */
	private RecordType(String typeString){
		this.typeString = typeString;
	}
	
	/**
	 * Record type.
	 *
	 * @return the record type
	 */
	public String getTypeString(){
		return this.typeString;
	}

	
	/**
	 * Gets the Harvester type based on string content type passed on 
	 *
	 * @param contentType the content type as String
	 * @return the transform type
	 */
	public static RecordType getType(String typeString) {
        if (typeString != null) {
            for (RecordType type : RecordType.values()) {
                if (type.getTypeString().equals(typeString)) {                	
                    return type;
                }
            }
        }
        return null;
    }
	
	
}
