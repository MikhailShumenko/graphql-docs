**Used Resources:**

- https://github.com/graphql/graphiql
- https://pragmaticcoders.com/blog/how-to-use-graphql-in-spring-boot/


**To start service do the following steps:**

- Open terminal and execute `chmod 777 _dc`
- Execute in terminal `./_dc up -d --build`
- Wait few seconds and open `localhost:8383/graphiql` in a browser 
    (NOTE: graphiql uses server.port)

**Add to existing project**

Add the following dependency to your gradle script

```gradle
    // UI tool for Graph QL: https://pragmaticcoders.com/blog/how-to-use-graphql-in-spring-boot/
	// available on localhost:<server.port>/graphiql
	compile 'com.graphql-java:graphiql-spring-boot-starter:5.0.2'
```

**GraphiQL lib properties:**

```yaml
# GraphiQL lib properties
graphiql:
  enabled: true
  endpoint: graphiql
```

**Demo:**

![image](https://user-images.githubusercontent.com/4786289/72053466-c3093100-32cf-11ea-9c5a-821634f43931.png)

**Secured Calls**

If you need to send secured requests, feel free to use ModHeader to customize Http headers.

Read more: https://github.com/graphql/graphiql/issues/59#issuecomment-254736162

ModHeader: https://chrome.google.com/webstore/detail/modheader/idgpnmonknjnojddfkpgkljpfnnfcklj

![image](https://user-images.githubusercontent.com/4786289/72071634-ea262980-32f4-11ea-8102-94ded2d7ab67.png)
