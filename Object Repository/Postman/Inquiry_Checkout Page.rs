<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Inquiry_Checkout Page</name>
   <tag></tag>
   <elementGuidId>c988d6e3-4720-4ce2-9656-c6cec110dc31</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>{{accessToken}}</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;amount\&quot;:1029,\n    \&quot;currency\&quot;:\&quot;IDR\&quot;,\n    \&quot;customer\&quot;:{\n        \&quot;name\&quot;:\&quot;john doe\&quot;,\n        \&quot;email\&quot;:\&quot;john.doe@test.com\&quot;,\n        \&quot;phoneNumber\&quot;:\&quot;08123456789\&quot;,\n        \&quot;country\&quot;:\&quot;Indonesia\&quot;,\n        \&quot;postalCode\&quot;:\&quot;12345\&quot;,\n        \&quot;locality\&quot;:\&quot;Jakarta\&quot;,\n        \&quot;address\&quot;:\&quot;Jl. Bahagia no. 1\&quot;\n    },\n    \&quot;order\&quot;:{\n        \&quot;id\&quot;:\&quot;LandingPage-${counter}\&quot;,\n        \&quot;items\&quot;:[{\n            \&quot;name\&quot;:\&quot;Pertalite - Subsidi\&quot;,\n            \&quot;quantity\&quot;:1,\n            \&quot;amount\&quot;:1029,\n            \&quot;url\&quot;:\&quot;www.test.com\&quot;,\n            \&quot;type\&quot;:\&quot;BBM\&quot;,\n            \&quot;id\&quot;:\&quot;BBM-Subsidi\&quot;\n        }\n        ],\n        \&quot;tokenOption\&quot;:\&quot;off\&quot;\n    },\n    \&quot;referenceUrl\&quot;:\&quot;https://demoshop.yokke.xyz\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>6811fb43-b430-4815-be24-f36ea70616f8</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Api-Key</name>
      <type>Main</type>
      <value>sFoYKPB7UmkWauLPCoHDzA</value>
      <webElementGuid>6b467b5f-6849-4167-af47-de6645819f3b</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${accessToken}</value>
      <webElementGuid>309e5bee-745c-4f79-94ff-85d20995e066</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>11.0.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://tst.yokke.co.id:7778/gateway/IPGAPI/v1/inquiries</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.base_url_IPGLandingPage</defaultValue>
      <description></description>
      <id>8e5cfc73-1e3a-475c-8311-8cb51f4926fe</id>
      <masked>false</masked>
      <name>base_url_IPGLandingPage</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>339492b0-1abf-4c17-977a-cd2db4b64d0e</id>
      <masked>false</masked>
      <name>counter</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>b6dc8f44-29e4-447b-af30-92cc22bbdad5</id>
      <masked>false</masked>
      <name>accessToken</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
