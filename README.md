# spring-cloud-oauth2

This is a spring-cloud demo with oauth2 SSO using WSO2 IS. 

##Structure
discovery -> Eureka Server
  
config    -> Config Server

person    -> Person Service

some      -> Some Service

ui        -> API Gateway Service

monitor   -> Hystrix Dashboard

##Configuration Tips of WSO2 IS
For the demo, WSO2 IS is run in VM hosted 192.168.56.101, and its token grant type is password.

One Inbound Authentication Configuration > Oauth and OpenID Connect Configuration with grant type of "password" should be configured properly in WSO2 IS, and OAuth Client Key and OAuth Client Secret should be recorded for further using.

WSO2 IS related config locates in application.yml file of "ui". IP address, client-id (which means Oauth Client Key) and client-secret (which means OAuth Client Secret) should be changed according to your case.

##How to get token from WSO2 IS

```
curl -v -X POST --basic \
     -u lNHcryLw3kepLBtjBacGNINIyHQa:yRDa7legBnmDHMejFzIAVudqYBsa \
     -H "Content-Type:application/x-www-form-urlencoded;charset=UTF-8" -k \
     -d "grant_type=password&username=admin&password=admin&scope=openid"  \
     https://192.168.56.101:9443/oauth2/token
```

##How to test the result
Although there are some html resources in ui, the html-browser client doesn't work for the OAuth2 enabled case. Instead of it, some RESTful clients could be used for test.

/getsome -> (GET) return string message 
/dispatch -> (POST) persist data and return result

##Bugs and TODO
Hystrix/Ribbon seems not work properly with WSO2 enabled in the demo, meanwhile Hystrix/Feign works fine.

There's nothing about authorization in the demo.

Angular in ui doesn't work with OAuth2 enabled.

Docker related function has not tested yet.