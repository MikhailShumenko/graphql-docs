**Used Resources:**

https://github.com/graphql/graphiql
https://pragmaticcoders.com/blog/how-to-use-graphql-in-spring-boot/


**To start service do the following steps:**

- Open terminal and execute `chmod 777 _dc`
- Execute in terminal `./_dc up -d --build`
- Wait few seconds and open `localhost:8383/graphiql` in a browser 
    (NOTE: graphiql uses server.port)

**GraphiQL lib properties:**

```yaml
# GraphiQL lib properties
graphiql:
  enabled: true
  endpoint: graphiql
```

**Demo:**

![image](https://user-images.githubusercontent.com/4786289/72053466-c3093100-32cf-11ea-9c5a-821634f43931.png)

