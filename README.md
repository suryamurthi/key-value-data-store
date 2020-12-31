Java Project:
	Data store application for creating, reading and deleting key value in datastore 

Requirements: 
	JDK 1.8

Files:
	1. DataStore.java - used for create, read and delete in datastore
	2. Input.java - Input for performing CRD operation in datastore
	3. Output.txt - Sample output for given input

Create:
	We can add new key value pair in datastore where key is a 32 bit string and value is json object of maximum 16KB. If the key already exsists it throws error message. Every value has optional time to live property.

Read:
	It retrives corresponding value for given key. If respective value has time to live property then it checks for expiration and throws error if expired orelse it shows value in JSON format

Delete:
	It delete the key value pair of given key in datastore. If respective value has time to live property then it checks for expiration and throws error if expired orelse it delete
