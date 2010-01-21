package cn.smartinvoke.util
{
	
	import mx.utils.Base64Decoder;
	import mx.utils.Base64Encoder;
	
	import flash.utils.*;
	
	public class ProtocolBuilder
	{
		public function ProtocolBuilder()
		{
		}
		private static var base64Dec:Base64Decoder= new Base64Decoder();
		private static var base64Enc:Base64Encoder=new Base64Encoder();
        public static function getObject(str:String):Object{
        	var ret:Object=null;
        	
            base64Dec.decode(str);
            var byteArr:ByteArray=base64Dec.toByteArray(); 
                
            ret=byteArr.readObject();
            //转换为初始状态
            base64Dec.reset();
        	return ret;
        }
        public static function getProtocolStr(obj:Object):String{
        	var ret:String=null;
        	base64Enc.insertNewLines=false;
        	var byteArr:ByteArray=new ByteArray();
		    byteArr.writeObject(obj);
		    
		    base64Enc.encodeBytes(byteArr,0,byteArr.length);
			ret=base64Enc.toString();
			
			base64Enc.reset();
			
        	return ret;
        }
	}
}