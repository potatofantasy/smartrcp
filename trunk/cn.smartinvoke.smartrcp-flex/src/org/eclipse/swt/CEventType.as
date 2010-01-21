package org.eclipse.swt
{
	public class CEventType
	{
		public function CEventType()
		{
		}
        
	/**
	 * The key down event type (value is 1).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addKeyListener
	 * @see org.eclipse.swt.widgets.Tracker#addKeyListener
	 * @see org.eclipse.swt.events.KeyListener#keyPressed
	 * @see org.eclipse.swt.events.KeyEvent
	 */
	public static const KeyDown:int = 1;
	
	/**
	 * The key up event type (value is 2).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addKeyListener
	 * @see org.eclipse.swt.widgets.Tracker#addKeyListener
	 * @see org.eclipse.swt.events.KeyListener#keyReleased
	 * @see org.eclipse.swt.events.KeyEvent
	 */
	public static const KeyUp:int= 2;
	
	/**
	 * The mouse down event type (value is 3).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addMouseListener
	 * @see org.eclipse.swt.events.MouseListener#mouseDown
	 * @see org.eclipse.swt.events.MouseEvent
	 */
	public static const MouseDown:int= 3;
	
	/**
	 * The mouse up event type (value is 4).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addMouseListener
	 * @see org.eclipse.swt.events.MouseListener#mouseUp
	 * @see org.eclipse.swt.events.MouseEvent
	 */
	public static const MouseUp:int= 4;
	
	/**
	 * The mouse move event type (value is 5).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addMouseMoveListener
	 * @see org.eclipse.swt.events.MouseMoveListener#mouseMove
	 * @see org.eclipse.swt.events.MouseEvent
	 */
	public static const MouseMove:int= 5;
	
	/**
	 * The mouse enter event type (value is 6).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addMouseTrackListener
	 * @see org.eclipse.swt.events.MouseTrackListener#mouseEnter
	 * @see org.eclipse.swt.events.MouseEvent
	 */
	public static const MouseEnter:int= 6;		
	
	/**
	 * The mouse exit event type (value is 7).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addMouseTrackListener
	 * @see org.eclipse.swt.events.MouseTrackListener#mouseExit
	 * @see org.eclipse.swt.events.MouseEvent
	 */
	public static const MouseExit:int= 7;
	
	/**
	 * The mouse double click event type (value is 8).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addMouseListener
	 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick
	 * @see org.eclipse.swt.events.MouseEvent
	 */
	public static const MouseDoubleClick:int= 8;	
	
	/**
	 * The paint event type (value is 9).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addPaintListener
	 * @see org.eclipse.swt.events.PaintListener#paintControl
	 * @see org.eclipse.swt.events.PaintEvent
	 */
	public static const Paint:int= 9;	
	
	/**
	 * The move event type (value is 10).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addControlListener
	 * @see org.eclipse.swt.widgets.TableColumn#addControlListener
	 * @see org.eclipse.swt.widgets.Tracker#addControlListener
	 * @see org.eclipse.swt.widgets.TreeColumn#addControlListener
	 * @see org.eclipse.swt.events.ControlListener#controlMoved
	 * @see org.eclipse.swt.events.ControlEvent
	 */
	public static const Move:int= 10;
	
	/**
	 * The resize event type (value is 11).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addControlListener
	 * @see org.eclipse.swt.widgets.TableColumn#addControlListener
	 * @see org.eclipse.swt.widgets.Tracker#addControlListener
	 * @see org.eclipse.swt.widgets.TreeColumn#addControlListener
	 * @see org.eclipse.swt.events.ControlListener#controlResized
	 * @see org.eclipse.swt.events.ControlEvent
	 */
	public static const Resize:int= 11;
	
	/**
	 * The dispose event type (value is 12).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addDisposeListener
	 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed
	 * @see org.eclipse.swt.events.DisposeEvent
	 */
	public static const Dispose:int= 12;
	
	/**
	 * The selection event type (value is 13).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Button#addSelectionListener
	 * @see org.eclipse.swt.widgets.Combo#addSelectionListener
	 * @see org.eclipse.swt.widgets.CoolItem#addSelectionListener
	 * @see org.eclipse.swt.widgets.Link#addSelectionListener
	 * @see org.eclipse.swt.widgets.List#addSelectionListener
	 * @see org.eclipse.swt.widgets.MenuItem#addSelectionListener
	 * @see org.eclipse.swt.widgets.Sash#addSelectionListener
	 * @see org.eclipse.swt.widgets.Scale#addSelectionListener
	 * @see org.eclipse.swt.widgets.ScrollBar#addSelectionListener
	 * @see org.eclipse.swt.widgets.Slider#addSelectionListener
	 * @see org.eclipse.swt.widgets.TabFolder#addSelectionListener
	 * @see org.eclipse.swt.widgets.Table#addSelectionListener
	 * @see org.eclipse.swt.widgets.TableColumn#addSelectionListener
	 * @see org.eclipse.swt.widgets.ToolItem#addSelectionListener
	 * @see org.eclipse.swt.widgets.TrayItem#addSelectionListener
	 * @see org.eclipse.swt.widgets.Tree#addSelectionListener
	 * @see org.eclipse.swt.widgets.TreeColumn#addSelectionListener
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected
	 * @see org.eclipse.swt.events.SelectionEvent
	 */
	public static const Selection:int= 13;
	
	/**
	 * The default selection event type (value is 14).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Combo#addSelectionListener
	 * @see org.eclipse.swt.widgets.List#addSelectionListener
	 * @see org.eclipse.swt.widgets.Spinner#addSelectionListener
	 * @see org.eclipse.swt.widgets.Table#addSelectionListener
	 * @see org.eclipse.swt.widgets.Text#addSelectionListener
	 * @see org.eclipse.swt.widgets.TrayItem#addSelectionListener
	 * @see org.eclipse.swt.widgets.Tree#addSelectionListener
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected
	 * @see org.eclipse.swt.events.SelectionEvent
	 */
	public static const DefaultSelection:int= 14;
	
	/**
	 * The focus in event type (value is 15).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addFocusListener
	 * @see org.eclipse.swt.events.FocusListener#focusGained
	 * @see org.eclipse.swt.events.FocusEvent
	 */
	public static const FocusIn:int= 15;
	
	/**
	 * The focus out event type (value is 16).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addFocusListener
	 * @see org.eclipse.swt.events.FocusListener#focusLost
	 * @see org.eclipse.swt.events.FocusEvent
	 */
	public static const FocusOut:int= 16;
	
	/**
	 * The expand event type (value is 17).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Tree#addTreeListener
	 * @see org.eclipse.swt.events.TreeListener#treeExpanded
	 * @see org.eclipse.swt.events.TreeEvent
	 */
	public static const Expand:int= 17;
	
	/**
	 * The collapse event type (value is 18).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Tree#addTreeListener
	 * @see org.eclipse.swt.events.TreeListener#treeCollapsed
	 * @see org.eclipse.swt.events.TreeEvent
	 */
	public static const Collapse:int= 18;
	
	/**
	 * The iconify event type (value is 19).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Shell#addShellListener
	 * @see org.eclipse.swt.events.ShellListener#shellIconified
	 * @see org.eclipse.swt.events.ShellEvent
	 */
	public static const Iconify:int= 19;
	
	/**
	 * The de-iconify event type (value is 20).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Shell#addShellListener
	 * @see org.eclipse.swt.events.ShellListener#shellDeiconified
	 * @see org.eclipse.swt.events.ShellEvent
	 */
	public static const Deiconify:int= 20;
	
	/**
	 * The close event type (value is 21).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Shell#addShellListener
	 * @see org.eclipse.swt.events.ShellListener#shellClosed
	 * @see org.eclipse.swt.events.ShellEvent
	 */
	public static const Close:int= 21;
	
	/**
	 * The show event type (value is 22).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Menu#addMenuListener
	 * @see org.eclipse.swt.events.MenuListener#menuShown
	 * @see org.eclipse.swt.events.MenuEvent
	 */
	public static const Show:int= 22;
	
	/**
	 * The hide event type (value is 23).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Menu#addMenuListener
	 * @see org.eclipse.swt.events.MenuListener#menuHidden
	 * @see org.eclipse.swt.events.MenuEvent
	 */
	public static const Hide:int= 23;
	
	/**
	 * The modify event type (value is 24).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Combo#addModifyListener
	 * @see org.eclipse.swt.widgets.Spinner#addModifyListener
	 * @see org.eclipse.swt.widgets.Text#addModifyListener
	 * @see org.eclipse.swt.events.ModifyListener#modifyText
	 * @see org.eclipse.swt.events.ModifyEvent
	 */
	public static const Modify:int= 24;
	
	/**
	 * The verify event type (value is 25).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Combo#addVerifyListener
	 * @see org.eclipse.swt.widgets.Text#addVerifyListener
	 * @see org.eclipse.swt.events.VerifyListener#verifyText
	 * @see org.eclipse.swt.events.VerifyEvent
	 */
	public static const Verify:int= 25;
	
	/**
	 * The activate event type (value is 26).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Shell#addShellListener
	 * @see org.eclipse.swt.events.ShellListener#shellActivated
	 * @see org.eclipse.swt.events.ShellEvent
	 */
	public static const Activate:int= 26;
	
	/**
	 * The deactivate event type (value is 27).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Shell#addShellListener
	 * @see org.eclipse.swt.events.ShellListener#shellDeactivated
	 * @see org.eclipse.swt.events.ShellEvent
	 */
	public static const Deactivate:int= 27;	
	
	/**
	 * The help event type (value is 28).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addHelpListener
	 * @see org.eclipse.swt.widgets.Menu#addHelpListener
	 * @see org.eclipse.swt.widgets.MenuItem#addHelpListener
	 * @see org.eclipse.swt.events.HelpListener#helpRequested
	 * @see org.eclipse.swt.events.HelpEvent
	 */
	public static const Help:int= 28;
	
	/**
	 * The drag detect event type (value is 29).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.dnd.DragSource
	 */
	public static const DragDetect:int= 29;
	
	/**
	 * The arm event type (value is 30).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.MenuItem#addArmListener
	 * @see org.eclipse.swt.events.ArmListener#widgetArmed
	 * @see org.eclipse.swt.events.ArmEvent
	 */
	public static const Arm:int= 30;
	
	/**
	 * The traverse event type (value is 31).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addTraverseListener
	 * @see org.eclipse.swt.events.TraverseListener#keyTraversed
	 * @see org.eclipse.swt.events.TraverseEvent
	 */
	public static const Traverse:int= 31;
	
	/**
	 * The mouse hover event type (value is 32).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Control#addMouseTrackListener
	 * @see org.eclipse.swt.events.MouseTrackListener#mouseHover
	 * @see org.eclipse.swt.events.MouseEvent
	 */
	public static const MouseHover:int= 32;

	/**
	 * The hardware key down event type (value is 33).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 */
	public static const HardKeyDown:int= 33;
	
	/**
	 * The hardware key up event type (value is 34).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 */
	public static const HardKeyUp:int= 34;

	/**
	 * The menu detect event type (value is 35).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @since 3.0
	 */
	public static const MenuDetect:int= 35;
	
	/**
	 * The set data event type (value is 36).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @see org.eclipse.swt.widgets.Table
	 * @see org.eclipse.swt.widgets.Tree
	 * 
	 * @since 3.0
	 */
	public static const SetData:int= 36;

	/**
	 * The mouse wheel event type (value is 37).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @since 3.1
	 */
	public static const MouseWheel:int= 37;

	/**
	 * The settings changed event type (value is 39).
	 * <p>
	 * The settings changed event is sent when an operating system
	 * property, such as a system font or color, has been changed.
	 * The event occurs after the property has been changed, but
	 * before any widget is redrawn.  Applications that cache operating
	 * system properties can use this event to update their caches.
	 * A specific property change can be detected by querying the
	 * new value of a property and comparing it with the equivalent
	 * cached value.  The operating system automatically redraws and
	 * lays out all widgets after this event is sent.
	 * </p>
	 * 
	 * @see org.eclipse.swt.widgets.Display#addListener
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @since 3.2
	 */
	public static const Settings:int= 39;
	
	/**
	 * The erase item event type (value is 40).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @since 3.2
	 */
	public static const EraseItem:int= 40;
	
	/**
	 * The measure item event type (value is 41).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @since 3.2
	 */
	public static const MeasureItem:int= 41;
	
	/**
	 * The paint item event type (value is 42).
	 * 
	 * @see org.eclipse.swt.widgets.Widget#addListener
	 * @see org.eclipse.swt.widgets.Display#addFilter
	 * @see org.eclipse.swt.widgets.Event
	 * 
	 * @since 3.2
	 */
	public static const PaintItem:int= 42;	
	}
}