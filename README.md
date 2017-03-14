# RMap OSF Client Extension
This project extends the [Data Conservancy OSF client](https://github.com/DataConservancy/osf-client) tool to support a customized model that auto-retrieves less data on each API call. The original model, for example, retrieves all file and wiki content.  This data is not currently needed for the RMap data harvest.   To support these cusomizations, an alternative Retrofit OSFService class using the alternative model classes was also required.

## Getting started
Build via 
```
mvn clean install
