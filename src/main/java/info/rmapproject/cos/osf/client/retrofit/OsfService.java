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

package info.rmapproject.cos.osf.client.retrofit;

import java.util.List;
import java.util.Map;

import info.rmapproject.cos.osf.client.model.Institution;
import info.rmapproject.cos.osf.client.model.LightNode;
import info.rmapproject.cos.osf.client.model.LightRegistration;
import info.rmapproject.cos.osf.client.model.LightUser;
import info.rmapproject.cos.osf.client.model.Node;
import info.rmapproject.cos.osf.client.model.Registration;
import info.rmapproject.cos.osf.client.model.User;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * Alternative to org.dataconservancy.cos.osf.client.retrofit.OsfService class 
 * that uses the RMap version of the model.
 * @author Elliot Metsger (emetsger@jhu.edu)
 * @author Karen Hanson (karen.hanson@jhu.edu)
 */
public interface OsfService {
    /**
     *
     * @param nodeId
     * @return
     */
    @GET("institutions/{id}/")
    Call<Institution> getInsitutionById(@Path("id") String institutionId);
    

    /**
     *
     * @param url
     * @return
     */
    @GET
    Call<List<Institution>> getInsitutions(@QueryMap Map<String, String> params);
    
    /**
     *
     * @param nodeId
     * @return
     */
    @GET("nodes/{id}/")
    Call<Node> getNodeById(@Path("id") String nodeId);

    /**
     *
     * @param params
     * @return
     */
    @GET("nodes/")
    Call<List<LightNode>> getNodeIds(@QueryMap Map<String, String> params);

    /**
     *
     * @param id
     * @return
     */
    @GET("registrations/{id}/")
    Call<Registration> getRegistrationById(@Path("id") String id);

    /**
     *
     * @param params
     * @return
     */
    @GET("registrations/")
    Call<List<LightRegistration>> getRegistrationIds(@QueryMap Map<String, String> params);

    /**
     *
     * @param id
     * @return
     */
    @GET("users/{id}/")
    Call<User> getUserById(@Path("id") String id);

    /**
     *
     * @param params
     * @return
     */
    @GET("users/")
    Call<List<LightUser>> getUserIds(@QueryMap Map<String, String> params);

}
