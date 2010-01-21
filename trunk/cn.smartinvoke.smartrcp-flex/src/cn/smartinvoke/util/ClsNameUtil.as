
/*******************************************************************************
* Copyright (c) 2009 SmartInvoke.
* 你可以复制或修改此代码，但是必须在源代码和二进制包中添加申明以表示引用或修改了smartinvoke的代码
* 请珍惜作者的劳动成果* 您可以通过 
*  网站:http://smartinvoke.cn/ 
*  邮件:pzxiaoxiao130130@gmail.com
*  QQ：90636900*  联系到作者^_^ 
*******************************************************************************/ 
package cn.smartinvoke.util
{
	public class ClsNameUtil
	{
		public function ClsNameUtil()
		{
		}
        public static function  addRightSpace(str:String, len:int):String {
		    var orgLen:int = str.length;
		    var spaceCount:int = len - orgLen;
		    if (spaceCount > 0) {
			  for (var i:int = 0; i < spaceCount; i++) {
                str+=" ";
			  }
		    } else {
			  str = str.substring(0, len);
		    }
		    return str;
	   }
	   public static function getMiddValClsName(clsName:String):String{
	   	 var middValClsName:String=clsName.replace("::",".");
	   	 return middValClsName;
	   }
	}
}