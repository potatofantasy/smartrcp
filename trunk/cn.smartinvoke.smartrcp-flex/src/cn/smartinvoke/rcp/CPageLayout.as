package cn.smartinvoke.rcp
{
	import mx.collections.ArrayCollection;
	
	/**
	 *页布局
	 */
	 [Bindable]
	[RemoteClass(alias="cn.smartinvoke.rcp.CPageLayout")]
	public class CPageLayout extends CFolderLayout implements ICFolderLayout
	{ 
	    public static const  LEFT:int = 1;
        public static const  RIGHT:int = 2;
        public static const  TOP:int = 3;
        public static const  BOTTOM:int = 4;
        public static const  RATIO_MIN:Number = 0.05;
        public static const  RATIO_MAX:Number = 0.95;
        public static const  DEFAULT_FASTVIEW_RATIO:Number = 0.3;
        public static const  DEFAULT_VIEW_RATIO:Number = 0.5;
       
        
        public var layouts:ArrayCollection=null;//new ArrayCollection();
        //public var standaloneLayouts:ArrayCollection=null;//new ArrayCollection();
        
         [Inspectable(type="Boolean")]
        public var editorAreaVisible:Boolean=false;
        [Inspectable(type="Boolean")]
        public var fixed:Boolean=false;
        
		public function CPageLayout()
		{
			
		}
        public function addLayout(layout:ICFolderLayout):void{
           if(layout!=null){
        	this.layouts.addItem(layout);
           }
        }
	}
}