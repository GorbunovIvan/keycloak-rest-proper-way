This app has two microservices:<br/>
- <b>Protected-service</b> - a RESTful microservice protected with the Keycloak (with Spring Security)<br/>
- <b>Client-service</b> - a RESTful microservice that interacts with the “Protected-service” via FeignClient with all authentication configured using Spring Security<br/>

<hr/>
In Keycloak:<br/>

- <b>realm</b> is called "keycloak-rest-proper-way";<br/>
- <b>client</b> is called "protected-service";<br/>

<hr/>

<p>If everything works fine, then the “Client-Service” should work fine only with this:</p>
<pre>
GET http://localhost:8082/api/hello?name=denis
</pre>

<hr/>

<p>Please note that here Keycloak is configured to use "client_credentials" grant_type.</p>
<p>Your client ("protected-service" in Keycloak web-console) must have "Client authentication" and "Service accounts role" enabled.</p>

<p>To check if Keycloak works fine you can send this to get an <b>access-token</b>:</p>
<pre>
POST http://localhost:8080/realms/keycloak-rest-proper-way/protocol/openid-connect/token
Content-Type: application/x-www-form-urlencoded

client_id = protected-service &
client_secret = s1Sw8hTMY2z0x17yeoX2ALLJs4LF0LxF &
grant_type = client_credentials
</pre>

<hr/>

<p>It will return an <b>access-token</b> (if the client_secret is correct and the Keycloak server is running).</p>
<p>To check if "Protected-service" works fine you should take this <b>access-token</b> and add it to your request to "Protected-service" endpoints as an authorization bearer.<br/>For example:</p>
<pre>
GET http://localhost:8081/api/hello?name=denis
Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJVMWkyVjlCNU1yOHNoU3JjaEhWSWY1SThzaEh..
</pre>