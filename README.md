# scholarly-communication-services

Research objects released or archived can be assigned a Digital Object Identifier (DOI) that can be used to track research objects in scholarly search services so that citation information can be extracted and added to the research object as a measure of the research object impact in scholarly communications. 

The goal of these services is to harvest research object citation information from Google Scholar and Microsoft Academic, which are specialized sites that gather citation information of research works in scholarly communications. Two different rest web services have been developed, one for each scholar service. 

Note that the DOI functionality is new and currently there are not research objects with DOIs. Therefore, in the current implementation the web services receive as input parameter the title of the research object and return the number of cites for publications with the same title. In a second implementation, a new input parameter for the DOI associated with the research object will be added.  

## Installation
The MS Academics services is implemented in Java 8 and uses maven 3 to manage the libraries dependencies and generate the jar and war files that are going to be deployed. The enrichment service is implemented as a rest api using the framework Jersey 2 that can be deployed on any servlet container supporting Servlet 2.5 and higher, such as Tomcat 8.  

To install the scholarly communications services first clone this following repository using `git clone`

Then use `maven install` to compile the recommender service in the root folder. This command generates different jar files and war files. 

The file `msacademics.war`, that contains the microsoft academics harvester, in the target folder of the module `/everest-github-scholar-msacademics` must be deployed in the servlet container in the path `/Everest-Scholar- MsAcademics`. 

On the other hand, the google scholar service, that is implemented in Python 3.4, is in the folder scholar of the module `/everest-github-scholar-google`. This folder must be copied to server.  The file `server.conf` is an Upstart configuration file that is used to create a daemon to run the web service in the server. This file should be located in `/etc/init/`. Then you can use `service server start` or `service server stop` to start or stop the web service through the linux service. 

## Web APIs

Google scholar and Microsoft academics harvesters of citation information are implemented as rest services. Both services expects the title of the research object as a path parameter and the citation information is provided in the format that the source services, i.e., Google scholar and Microsoft academics, generate it. 

````
http://everest.expertsystemlab.com/scholar/gscholars/<write-title-here>

http://everest.expertsystemlab.com/scholar/msacademics/<write-title-here>
````

One important consideration is that Google Scholar service is limited regarding the number of request per period of time allowed before being banned by the service. Therefore the corresponding service is constrained to a delay of 0.1 second between every request. 

