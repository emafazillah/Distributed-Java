package OrbChat;

/**
* OrbChat/ChatClientIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OrbChat.idl
* Sunday, May 29, 2016 2:41:30 PM SGT
*/

public final class ChatClientIntHolder implements org.omg.CORBA.portable.Streamable
{
  public OrbChat.ChatClientInt value = null;

  public ChatClientIntHolder ()
  {
  }

  public ChatClientIntHolder (OrbChat.ChatClientInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = OrbChat.ChatClientIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    OrbChat.ChatClientIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return OrbChat.ChatClientIntHelper.type ();
  }

}
