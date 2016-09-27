package OrbChat;


/**
* OrbChat/ChatServerIntPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OrbChat.idl
* Sunday, May 29, 2016 2:41:30 PM SGT
*/

public abstract class ChatServerIntPOA extends org.omg.PortableServer.Servant
 implements OrbChat.ChatServerIntOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("login", new java.lang.Integer (0));
    _methods.put ("publish", new java.lang.Integer (1));
    _methods.put ("_get_getConnected", new java.lang.Integer (2));
    _methods.put ("_set_getConnected", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // OrbChat/ChatServerInt/login
       {
         OrbChat.ChatClientInt a = OrbChat.ChatClientIntHelper.read (in);
         boolean $result = false;
         $result = this.login (a);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // OrbChat/ChatServerInt/publish
       {
         String s = in.read_string ();
         this.publish (s);
         out = $rh.createReply();
         break;
       }

       case 2:  // OrbChat/ChatServerInt/_get_getConnected
       {
         String $result = null;
         $result = this.getConnected ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // OrbChat/ChatServerInt/_set_getConnected
       {
         String newGetConnected = in.read_string ();
         this.getConnected (newGetConnected);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:OrbChat/ChatServerInt:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ChatServerInt _this() 
  {
    return ChatServerIntHelper.narrow(
    super._this_object());
  }

  public ChatServerInt _this(org.omg.CORBA.ORB orb) 
  {
    return ChatServerIntHelper.narrow(
    super._this_object(orb));
  }


} // class ChatServerIntPOA
