# Distributed Java
Examples of Distributed Java Using RMI and CORBA

# RMI
<b>RMI Server;</b><br />
Run java -jar <path to ChatRMIServer.jar>/ChatRMIServer.jar.<br /><br />
<b>RMI Client;</b><br />
Run java -jar <path to ChatRMIClient.jar>/ChatRMIClient.jar.<br /><br />
![RMI](https://github.com/emafazillah/Distributed-Java/blob/master/RMI/01-RMI.png?raw=true "rmi")<br /><br />

# CORBA
<i>Before run any jar, run start tnameserv -ORBInitialPort 9999</i><br /><br />
<b>CORBA Server;</b><br />
Run java -jar <path to OrbChatAppServer.jar>/OrbChatAppServer.jar -ORBInitialPort 9999 -ORBInitialHost <hostname><br /><br />
<b>CORBA Client;</b><br />
Run java -jar <path to OrbChatAppClient.jar>/OrbChatAppClient.jar -ORBInitialPort 9999 -ORBInitialHost <hostname><br /><br />
![CORBAIDL](https://github.com/emafazillah/Distributed-Java/blob/master/CORBA/01-Java-CORBA-generate-stub-using-idl.png?raw=true "corbaidl")<br /><br />
![CORBA](https://github.com/emafazillah/Distributed-Java/blob/master/CORBA/02-Java-CORBA-result.png?raw=true "corba")<br /><br />
