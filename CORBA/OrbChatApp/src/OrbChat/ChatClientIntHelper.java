package OrbChat;


/**
* OrbChat/ChatClientIntHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OrbChat.idl
* Sunday, May 29, 2016 2:41:30 PM SGT
*/

abstract public class ChatClientIntHelper
{
  private static String  _id = "IDL:OrbChat/ChatClientInt:1.0";

  public static void insert (org.omg.CORBA.Any a, OrbChat.ChatClientInt that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static OrbChat.ChatClientInt extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (OrbChat.ChatClientIntHelper.id (), "ChatClientInt");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static OrbChat.ChatClientInt read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ChatClientIntStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, OrbChat.ChatClientInt value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static OrbChat.ChatClientInt narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof OrbChat.ChatClientInt)
      return (OrbChat.ChatClientInt)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      OrbChat._ChatClientIntStub stub = new OrbChat._ChatClientIntStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static OrbChat.ChatClientInt unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof OrbChat.ChatClientInt)
      return (OrbChat.ChatClientInt)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      OrbChat._ChatClientIntStub stub = new OrbChat._ChatClientIntStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
