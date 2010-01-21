package org.eclipse.swt
{
public class SWT {
	
	/* Widget Event Constants */
	
	/**
	 * The null event type (value is 0).
	 * 
	 * @since 3.0
	 */
	public static const  None:int = 0;
	
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
	public static const KeyDown:int= 1;
	
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
	
	/* Event Details */

	/**
	 * Indicates that a user-interface component is being dragged,
	 * for example dragging the thumb of a scroll bar (value is 1).
	 */
	public static const DRAG:int= 1;
	
	/**
	 * Event detail field that indicates a user-interface component
	 * state is selected (value is 1&lt;&lt;1).
	 *
	 * @since 3.2
	 */
	public static const SELECTED:int= 1 << 1;
	
	/**
	 * Event detail field that indicates a user-interface component
	 * state is focused (value is 1&lt;&lt;2).
	 *
	 * @since 3.2
	 */	
	public static const FOCUSED:int= 1 << 2;
	
	/**
	 * Event detail field that indicates a user-interface component
	 * draws the background (value is 1&lt;&lt;3).
	 *
	 * @since 3.2
	 */
	public static const BACKGROUND:int= 1 << 3;
	
	/**
	 * Event detail field that indicates a user-interface component
	 * draws the foreground (value is 1&lt;&lt;4).
	 *
	 * @since 3.2
	 */
	public static const FOREGROUND:int= 1 << 4;
	
	/**
	 * Event detail field that indicates a user-interface component
	 * state is hot (value is 1&lt;&lt;5).
	 *
	 * @since 3.3
	 */
	public static const HOT:int= 1 << 5;
	
	/* This code is intentionally commented */
	//public static const PRESSED:int= 1 << 3;
	//public static const ACTIVE:int= 1 << 4;
	//public static const DISABLED:int= 1 << 5;
	//public static const HOT:int= 1 << 6;
	//public static const DEFAULTED:int= 1 << 7;

	/**
	 * Traversal event detail field value indicating that no 
	 * traversal action should be taken
	 * (value is 0).
	 */
	public static const TRAVERSE_NONE:int= 0;
	
	/**
	 * Traversal event detail field value indicating that the 
	 * key which designates that a dialog should be cancelled was
	 * pressed; typically, this is the ESC key
	 * (value is 1&lt;&lt;1).
	 */
	public static const TRAVERSE_ESCAPE:int= 1 << 1;

	/**
	 * Traversal event detail field value indicating that the
	 * key which activates the default button in a dialog was
	 * pressed; typically, this is the ENTER key
	 * (value is 1&lt;&lt;2).
	 */
	public static const TRAVERSE_RETURN:int= 1 << 2;

	/**
	 * Traversal event detail field value indicating that the 
	 * key which designates that focus should be given to the
	 * previous tab group was pressed; typically, this is the
	 * SHIFT-TAB key sequence
	 * (value is 1&lt;&lt;3).
	 */
	public static const TRAVERSE_TAB_PREVIOUS:int= 1 << 3;

	/**
	 * Traversal event detail field value indicating that the 
	 * key which designates that focus should be given to the
	 * next tab group was pressed; typically, this is the
	 * TAB key
	 * (value is 1&lt;&lt;4).
	 */
	public static const TRAVERSE_TAB_NEXT:int= 1 << 4;

	/**
	 * Traversal event detail field value indicating that the 
	 * key which designates that focus should be given to the
	 * previous tab item was pressed; typically, this is either
	 * the LEFT-ARROW or UP-ARROW keys
	 * (value is 1&lt;&lt;5).
	 */
	public static const TRAVERSE_ARROW_PREVIOUS:int= 1 << 5;

	/**
	 * Traversal event detail field value indicating that the 
	 * key which designates that focus should be given to the
	 * previous tab item was pressed; typically, this is either
	 * the RIGHT-ARROW or DOWN-ARROW keys
	 * (value is 1&lt;&lt;6).
	 */
	public static const TRAVERSE_ARROW_NEXT:int= 1 << 6;

	/**
	 * Traversal event detail field value indicating that a 
	 * mnemonic key sequence was pressed
	 * (value is 1&lt;&lt;7).
	 */
	public static const TRAVERSE_MNEMONIC:int= 1 << 7;

	/**
	 * Traversal event detail field value indicating that the 
	 * key which designates that the previous page of a multi-page
	 * window should be shown was pressed; typically, this
	 * is the CTRL-PAGEUP key sequence
	 * (value is 1&lt;&lt;8).
	 */
	public static const TRAVERSE_PAGE_PREVIOUS:int= 1 << 8;
	
	/**
	 * Traversal event detail field value indicating that the 
	 * key which designates that the next page of a multi-page
	 * window should be shown was pressed; typically, this
	 * is the CTRL-PAGEDOWN key sequence
	 * (value is 1&lt;&lt;9).
	 */
	public static const TRAVERSE_PAGE_NEXT:int= 1 << 9;

	/**
	 * A constant known to be zero (0), typically used in operations
	 * which take bit flags to indicate that "no bits are set".
	 */
	public static const NONE:int= 0;
	
	/**
	 * A constant known to be zero (0), used in operations which
	 * take pointers to indicate a null argument.
	 */
	public static const NULL:int= 0;
	
	/**
	 * Indicates that a default should be used (value is -1).
	 */
	public static const DEFAULT:int= -1;

	/**
	 * Indicates that a property is off (value is 0).
	 * 
	 * @since 3.1
	 */
	public static const OFF:int= 0;
	
	/**
	 * Indicates that a property is on (value is 1).
	 * 
	 * @since 3.1
	 */
	public static const ON:int= 1;

	/**
	 * Indicates low quality (value is 1).
	 * 
	 * @since 3.1
	 */
	public static const LOW:int= 1;

	/**
	 * Indicates high quality (value is 2).
	 * 
	 * @since 3.1
	 */
	public static const HIGH:int= 2;

	/**
	 * Style constant for menu bar behavior (value is 1&lt;&lt;1).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Menu</code></li>
	 * </ul></p>
	 */
	public static const BAR:int= 1 << 1;

	/**
	 * Style constant for drop down menu/list behavior (value is 1&lt;&lt;2).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Menu</code></li>
	 * <li><code>ToolItem</code></li>
	 * <li><code>CoolItem</code></li>
	 * <li><code>Combo</code></li>
	 * </ul></p>
	 */
	public static const DROP_DOWN:int= 1 << 2;

	/**
	 * Style constant for pop up menu behavior (value is 1&lt;&lt;3).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Menu</code></li>
	 * </ul></p>
	 */
	public static const POP_UP:int= 1 << 3;

	/**
	 * Style constant for line separator behavior (value is 1&lt;&lt;1).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Label</code></li>
	 * <li><code>MenuItem</code></li>
	 * <li><code>ToolItem</code></li>
	 * </ul></p>
	 */
	public static const SEPARATOR:int= 1 << 1;

	/**
	 * Style constant for toggle button behavior (value is 1&lt;&lt;1).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * </ul></p>
	 */
	public static const TOGGLE:int= 1 << 1;

	/**
	 * Style constant for arrow button behavior (value is 1&lt;&lt;2).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * </ul></p>
	 */
	public static const ARROW:int= 1 << 2;

	/**
	 * Style constant for push button behavior (value is 1&lt;&lt;3).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * <li><code>MenuItem</code></li>
	 * <li><code>ToolItem</code></li>
	 * </ul></p>
	 */
	public static const PUSH:int= 1 << 3;

	/**
	 * Style constant for radio button behavior (value is 1&lt;&lt;4).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * <li><code>MenuItem</code></li>
	 * <li><code>ToolItem</code></li>
	 * </ul></p>
	 */
	public static const RADIO:int= 1 << 4;

	/**
	 * Style constant for check box behavior (value is 1&lt;&lt;5).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * <li><code>MenuItem</code></li>
	 * <li><code>ToolItem</code></li>
	 * <li><code>Table</code></li>
	 * <li><code>Tree</code></li>
	 * </ul></p>
	 */
	public static const CHECK:int= 1 << 5;

	/**
	 * Style constant for cascade behavior (value is 1&lt;&lt;6).
	 * <p><b>Used By:</b><ul>
	 * <li><code>MenuItem</code></li>
	 * </ul></p>
	 */
	public static const CASCADE:int= 1 << 6;

	/**
	 * Style constant for multi-selection behavior in lists
	 * and multiple line support on text fields (value is 1&lt;&lt;1).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Text</code></li>
	 * <li><code>List</code></li>
	 * <li><code>FileDialog</code></li>
	 * </ul></p>
	 */
	public static const MULTI:int= 1 << 1;

	/**
	 * Style constant for single selection behavior in lists
	 * and single line support on text fields (value is 1&lt;&lt;2).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Text</code></li>
	 * <li><code>List</code></li>
	 * <li><code>Table</code></li>
	 * <li><code>Tree</code></li>
	 * </ul></p>
	 */
	public static const SINGLE:int= 1 << 2;

	/**
	 * Style constant for read-only behavior (value is 1&lt;&lt;3).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Combo</code></li>
	 * <li><code>Text</code></li>
	 * </ul></p>
	 */
	public static const READ_ONLY:int= 1 << 3;

	/**
	 * Style constant for automatic line wrap behavior (value is 1&lt;&lt;6).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Label</code></li>
	 * <li><code>Text</code></li>
	 * <li><code>ToolBar</code></li>
	 * <li><code>Spinner</code></li>
	 * </ul></p>
	 */
	public static const WRAP:int= 1 << 6;

	/**
	 * Style constant for search behavior (value is 1&lt;&lt;7).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Text</code></li>
	 * </ul></p>
	 * 
	 * @since 3.3
	 */
	public static const SEARCH:int= 1 << 7;

	/**
	 * Style constant for simple (not drop down) behavior (value is 1&lt;&lt;6).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Combo</code></li>
	 * </ul></p>
	 */
	public static const SIMPLE:int= 1 << 6;

	/**
	 * Style constant for password behavior (value is 1&lt;&lt;22).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Text</code></li>
	 * </ul></p>
	 * 
	 * @since 3.0
	 */
	public static const PASSWORD:int= 1 << 22;
	
	/**
	 * Style constant for shadow in behavior (value is 1&lt;&lt;2).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Label</code></li>
	 * <li><code>Group</code></li>
	 * </ul></p>
	 */
	public static const SHADOW_IN:int= 1 << 2;

	/**
	 * Style constant for shadow out behavior (value is 1&lt;&lt;3).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Label</code></li>
	 * <li><code>Group</code></li>
	 * <li><code>ToolBar</code></li>
	 * </ul></p>
	 */
	public static const SHADOW_OUT:int= 1 << 3;

	/**
	 * Style constant for shadow etched in behavior (value is 1&lt;&lt;4).
	 * <br>Note that this is a <em>HINT</em>. It is ignored on all platforms except Motif.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Group</code></li>
	 * </ul></p>
	 */
	public static const SHADOW_ETCHED_IN:int= 1 << 4;

	/**
	 * Style constant for shadow etched out behavior (value is 1&lt;&lt;6).
	 * <br>Note that this is a <em>HINT</em>. It is ignored on all platforms except Motif.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Group</code></li>
	 * </ul></p>
	 */
	public static const SHADOW_ETCHED_OUT:int= 1 << 6;

	/**
	 * Style constant for no shadow behavior (value is 1&lt;&lt;5).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Label</code></li>
	 * <li><code>Group</code></li>
	 * </ul></p>
	 */
	public static const SHADOW_NONE:int= 1 << 5;

	/**
	 * Style constant for progress bar behavior (value is 1&lt;&lt;1).
	 * <p><b>Used By:</b><ul>
	 * <li><code>ProgressBar</code></li>
	 * </ul></p>
	 */
	public static const INDETERMINATE:int= 1 << 1;
	
	/**
	 * Style constant for tool window behavior (value is 1&lt;&lt;2).
	 * <p>
	 * A tool window is a window intended to be used as a floating toolbar.
	 * It typically has a title bar that is shorter than a normal title bar,
	 * and the window title is typically drawn using a smaller font.
	 * <br>Note that this is a <em>HINT</em>.
	 * </p><p><b>Used By:</b><ul>
	 * <li><code>Decorations</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const TOOL:int= 1 << 2; 

	/**
	 * Style constant to ensure no trimmings are used (value is 1&lt;&lt;3).
	 * <br>Note that this overrides all other trim styles.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Decorations</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const NO_TRIM:int= 1 << 3;
	
	/**
	 * Style constant for resize box trim (value is 1&lt;&lt;4).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Decorations</code> and subclasses</li>
	 * <li><code>Tracker</code></li>
	 * </ul></p>
	 */
	public static const RESIZE:int= 1 << 4;

	/**
	 * Style constant for title area trim (value is 1&lt;&lt;5).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Decorations</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const TITLE:int= 1 << 5;

	/**
	 * Style constant for close box trim (value is 1&lt;&lt;6,
	 * since we do not distinguish between CLOSE style and MENU style).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Decorations</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const CLOSE:int= 1 << 6;

	/**
	 * Style constant for shell menu trim (value is 1&lt;&lt;6,
	 * since we do not distinguish between CLOSE style and MENU style).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Decorations</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const MENU:int= CLOSE;

	/**
	 * Style constant for minimize box trim (value is 1&lt;&lt;7).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Decorations</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const MIN:int= 1 << 7;

	/**
	 * Style constant for maximize box trim (value is 1&lt;&lt;10).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Decorations</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const MAX:int= 1 << 10;

	/**
	 * Style constant for horizontal scrollbar behavior (value is 1&lt;&lt;8).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Scrollable</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const H_SCROLL:int= 1 << 8;

	/**
	 * Style constant for vertical scrollbar behavior (value is 1&lt;&lt;9).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Scrollable</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const V_SCROLL:int= 1 << 9;

	/**
	 * Style constant for bordered behavior (value is 1&lt;&lt;11).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const BORDER:int= 1 << 11;

	/**
	 * Style constant indicating that the window manager should clip
	 * a widget's children with respect to its viewable area. (value is 1&lt;&lt;12).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const CLIP_CHILDREN:int= 1 << 12; 

	/**
	 * Style constant indicating that the window manager should clip
	 * a widget's siblings with respect to its viewable area. (value is 1&lt;&lt;13).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const CLIP_SIBLINGS:int= 1 << 13;

	/**
	 * Style constant for always on top behavior (value is 1&lt;&lt;14).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Shell</code> and subclasses</li>
	 * </ul></p>
	 */
	public static const ON_TOP:int= 1 << 14;

	/**
	 * Trim style convenience constant for the most common top level shell appearance
	 * (value is CLOSE|TITLE|MIN|MAX|RESIZE).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Shell</code></li>
	 * </ul></p>
	 */
	public static const SHELL_TRIM:int= CLOSE | TITLE | MIN | MAX | RESIZE;

	/**
	 * Trim style convenience constant for the most common dialog shell appearance
	 * (value is CLOSE|TITLE|BORDER).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Shell</code></li>
	 * </ul></p>
	 */
	public static const DIALOG_TRIM:int= TITLE | CLOSE | BORDER;

	/**
	 * Style constant for modeless behavior (value is 0).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Dialog</code></li>
	 * <li><code>Shell</code></li>
	 * </ul></p>
	 */
	public static const MODELESS:int= 0;

	/**
	 * Style constant for primary modal behavior (value is 1&lt;&lt;15).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Dialog</code></li>
	 * <li><code>Shell</code></li>
	 * </ul></p>
	 */
	public static const PRIMARY_MODAL:int= 1 << 15;

	/**
	 * Style constant for application modal behavior (value is 1&lt;&lt;16).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Dialog</code></li>
	 * <li><code>Shell</code></li>
	 * </ul></p>
	 */
	public static const APPLICATION_MODAL:int= 1 << 16;

	/**
	 * Style constant for system modal behavior (value is 1&lt;&lt;17).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Dialog</code></li>
	 * <li><code>Shell</code></li>
	 * </ul></p>
	 */
	public static const SYSTEM_MODAL:int= 1 << 17;

	/**
	 * Style constant for selection hiding behavior when the widget loses focus (value is 1&lt;&lt;15).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Table</code></li>
	 * </ul></p>
	 */
	public static const HIDE_SELECTION:int= 1 << 15;

	/**
	 * Style constant for full row selection behavior and 
	 * selection constant indicating that a full line should be 
	 * drawn. (value is 1&lt;&lt;16).
	 * <br>Note that for some widgets this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Table</code></li>
	 * <li><code>Tree</code></li>
	 * <li><code>StyledText</code></li>
	 * <li><code>TextLayout</code></li> 
	 * </ul></p>
	 */
	public static const FULL_SELECTION:int= 1 << 16;

	/**
	 * Style constant for flat appearance. (value is 1&lt;&lt;23).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * <li><code>ToolBar</code></li>
	 * </ul></p>
	 */
	public static const FLAT:int= 1 << 23;

	/**
	 * Style constant for smooth appearance. (value is 1&lt;&lt;16).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>ProgressBar</code></li>
	 * <li><code>Sash</code></li>
	 * </ul></p>
	 */
	public static const SMOOTH:int= 1 << 16;

	/**
	 * Style constant for no background behavior (value is 1&lt;&lt;18).
	 * <p>
	 * By default, before a widget paints, the client area is filled with the current background.
	 * When this style is specified, the background is not filled, and the application is responsible
	 * for filling every pixel of the client area.
	 * This style might be used as an alternative to "double-buffering" in order to reduce flicker.
	 * This style does not mean "transparent" - widgets that are obscured will not draw through.
	 * </p><p><b>Used By:</b><ul>
	 * <li><code>Composite</code></li>
	 * </ul></p>
	 */
	public static const NO_BACKGROUND:int= 1 << 18;

	/**
	 * Style constant for no focus from the mouse behavior (value is 1&lt;&lt;19).
	 * <br>Note that this is a <em>HINT</em>.
	 * <p><b>Used By:</b><ul>
	 * <li><code>Composite</code></li>
	 * </ul></p>
	 */
	public static const NO_FOCUS:int= 1 << 19;

	/**
	 * Style constant for no redraw on resize behavior (value is 1&lt;&lt;20).
	 * <p>
	 * This style stops the entire client area from being invalidated when the size
	 * of the Canvas changes. Specifically, when the size of the Canvas gets smaller,
	 * the SWT.Paint event is not sent. When it gets bigger, an SWT.Paint event is
	 * sent with a GC clipped to only the new areas to be painted. Without this
	 * style, the entire client area will be repainted.
	 * </p><p><b>Used By:</b><ul>
	 * <li><code>Composite</code></li>
	 * </ul></p>
	 */
	public static const NO_REDRAW_RESIZE:int= 1 << 20;

	/**
	 * Style constant for no paint event merging behavior (value is 1&lt;&lt;21).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Composite</code></li>
	 * </ul></p>
	 */
	public static const NO_MERGE_PAINTS:int= 1 << 21;

	/**
	 * Style constant for preventing child radio group behavior (value is 1&lt;&lt;22).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Composite</code></li>
	 * </ul></p>
	 */
	public static const NO_RADIO_GROUP:int= 1 << 22;
	
	/**
	 * Style constant for left to right orientation (value is 1&lt;&lt;25).
	 * <p>
	 * When orientation is not explicitly specified, orientation is
	 * inherited.  This means that children will be assigned the
	 * orientation of their parent.  To override this behavior and
	 * force an orientation for a child, explicitly set the orientation
	 * of the child when that child is created.
	 * <br>Note that this is a <em>HINT</em>.
	 * </p>
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code></li>
	 * <li><code>Menu</code></li>
	 * <li><code>GC</code></li> 
	 * </ul></p>
	 * 
	 * @since 2.1.2
	 */
	public static const LEFT_TO_RIGHT:int= 1 << 25;
	
	/**
	 * Style constant for right to left orientation (value is 1&lt;&lt;26).
	 * <p>
	 * When orientation is not explicitly specified, orientation is
	 * inherited.  This means that children will be assigned the
	 * orientation of their parent.  To override this behavior and
	 * force an orientation for a child, explicitly set the orientation
	 * of the child when that child is created.
	 * <br>Note that this is a <em>HINT</em>.
	 * </p>
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code></li>
	 * <li><code>Menu</code></li>
	 * <li><code>GC</code></li> 
	 * </ul></p>
	 * 
	 * @since 2.1.2
	 */
	public static const RIGHT_TO_LEFT:int= 1 << 26;
	
	/**
	 * Style constant to indicate coordinate mirroring (value is 1&lt;&lt;27).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code></li>
	 * <li><code>Menu</code></li>
	 * </ul></p>
	 * 
	 * @since 2.1.2
	 */
	public static const MIRRORED:int= 1 << 27;
	
	/**
	 * Style constant to allow embedding (value is 1&lt;&lt;24).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Composite</code></li>
	 * </ul></p>
	 * 
	 * @since 3.0
	 */
	public static const EMBEDDED:int= 1 << 24;
	
	/**
	 * Style constant to allow virtual data (value is 1&lt;&lt;28).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Table</code></li>
	 * <li><code>Tree</code></li>
	 * </ul></p>
	 * 
	 * @since 3.0
	 */
	public static const VIRTUAL:int= 1 << 28;

	/**
	 * Style constant to indicate double buffering (value is 1&lt;&lt;29).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code></li>
	 * </ul></p>
	 * 
	 * @since 3.1
	 */
	public static const DOUBLE_BUFFERED:int= 1 << 29;
	
	/**
	 * Style constant for align up behavior (value is 1&lt;&lt;7,
	 * since align UP and align TOP are considered the same).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code> with <code>ARROW</code> style</li>
	 * <li><code>Tracker</code></li>
	 * </ul></p>
	 */
	public static const UP:int= 1 << 7;

	/**
	 * Style constant for align top behavior (value is 1&lt;&lt;7,
	 * since align UP and align TOP are considered the same).
	 * <p><b>Used By:</b><ul>
	 * <li><code>FormAttachment</code> in a <code>FormLayout</code></li>
	 * </ul></p>
	 */
	public static const TOP:int= UP;

	/**
	 * Style constant for align down behavior (value is 1&lt;&lt;10,
	 * since align DOWN and align BOTTOM are considered the same).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code> with <code>ARROW</code> style</li>
	 * <li><code>Tracker</code></li>
	 * </ul></p>
	 */
	public static const DOWN              :int= 1 << 10;

	/**
	 * Style constant for align bottom behavior (value is 1&lt;&lt;10,
	 * since align DOWN and align BOTTOM are considered the same).
	 * <p><b>Used By:</b><ul>
	 * <li><code>FormAttachment</code> in a <code>FormLayout</code></li>
	 * </ul></p>
	 */
	public static const BOTTOM            :int= DOWN;

	/**
	 * Style constant for leading alignment (value is 1&lt;&lt;14).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * <li><code>Label</code></li>
	 * <li><code>TableColumn</code></li>
	 * <li><code>Tracker</code></li>
	 * <li><code>FormAttachment</code> in a <code>FormLayout</code></li>
	 * </ul></p>
	 * 
	 * @since 2.1.2
	 */
	public static const LEAD              :int= 1 << 14;
	
	/**
	 * Style constant for align left behavior (value is 1&lt;&lt;14).
	 * This is a synonym for LEAD (value is 1&lt;&lt;14).  Newer
	 * applications should use LEAD instead of LEFT to make code more
	 * understandable on right-to-left platforms.
	 */
	public static const LEFT              :int= LEAD;

	/**
	 * Style constant for trailing alignment (value is 1&lt;&lt;17).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * <li><code>Label</code></li>
	 * <li><code>TableColumn</code></li>
	 * <li><code>Tracker</code></li>
	 * <li><code>FormAttachment</code> in a <code>FormLayout</code></li>
	 * </ul></p>
	 * 
	 * @since 2.1.2
	 */
	public static const TRAIL             :int= 1 << 17;
		
	/**
	 * Style constant for align right behavior (value is 1&lt;&lt;17).
	 * This is a synonym for TRAIL (value is 1&lt;&lt;17).  Newer
	 * applications should use TRAIL instead of RIGHT to make code more
	 * understandable on right-to-left platforms.
	 */
	public static const RIGHT             :int= TRAIL;

	/**
	 * Style constant for align center behavior (value is 1&lt;&lt;24).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Button</code></li>
	 * <li><code>Label</code></li>
	 * <li><code>TableColumn</code></li>
	 * <li><code>FormAttachment</code> in a <code>FormLayout</code></li>
	 * </ul></p>
	 */
	public static const CENTER:int= 1 << 24;

	/**
	 * Style constant for horizontal alignment or orientation behavior (value is 1&lt;&lt;8).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Label</code></li>
	 * <li><code>ProgressBar</code></li>
	 * <li><code>Sash</code></li>
	 * <li><code>Scale</code></li>
	 * <li><code>ScrollBar</code></li>
	 * <li><code>Slider</code></li>
	 * <li><code>ToolBar</code></li>
	 * <li><code>FillLayout</code> type</li>
	 * <li><code>RowLayout</code> type</li>
	 * </ul></p>
	 */
	public static const HORIZONTAL:int= 1 << 8;

	/**
	 * Style constant for vertical alignment or orientation behavior (value is 1&lt;&lt;9).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Label</code></li>
	 * <li><code>ProgressBar</code></li>
	 * <li><code>Sash</code></li>
	 * <li><code>Scale</code></li>
	 * <li><code>ScrollBar</code></li>
	 * <li><code>Slider</code></li>
	 * <li><code>ToolBar</code></li>
	 * <li><code>CoolBar</code></li>
	 * <li><code>FillLayout</code> type</li>
	 * <li><code>RowLayout</code> type</li>
	 * </ul></p>
	 */
	public static const VERTICAL:int= 1 << 9;

	/**
	 * Style constant for date display (value is 1&lt;&lt;5).
	 * <p><b>Used By:</b><ul>
	 * <li><code>DateTime</code></li>
	 * </ul></p>
	 * 
	 * @since 3.3
	 */
	public static const DATE:int= 1 << 5;

	/**
	 * Style constant for time display (value is 1&lt;&lt;7).
	 * <p><b>Used By:</b><ul>
	 * <li><code>DateTime</code></li>
	 * </ul></p>
	 * 
	 * @since 3.3
	 */
	public static const TIME:int= 1 << 7;
	
	/**
	 * Style constant for calendar display (value is 1&lt;&lt;10).
	 * <p><b>Used By:</b><ul>
	 * <li><code>DateTime</code></li>
	 * </ul></p>
	 * 
	 * @since 3.3
	 */
	public static const CALENDAR:int= 1 << 10;

	/**
	 * Style constant for short date/time format (value is 1&lt;&lt;15).
	 * <p>
	 * A short date displays the month and year.
	 * A short time displays hours and minutes.
	 * <br>Note that this is a <em>HINT</em>.
	 * </p>
	 * <p><b>Used By:</b><ul>
	 * <li><code>DateTime</code></li>
	 * </ul></p>
	 * 
	 * @since 3.3
	 */
	public static const SHORT:int= 1 << 15;

	/**
	 * Style constant for medium date/time format (value is 1&lt;&lt;16).
	 * <p>
	 * A medium date displays the day, month and year.
	 * A medium time displays hours, minutes, and seconds.
	 * <br>Note that this is a <em>HINT</em>.
	 * </p>
	 * <p><b>Used By:</b><ul>
	 * <li><code>DateTime</code></li>
	 * </ul></p>
	 * 
	 * @since 3.3
	 */
	public static const MEDIUM:int= 1 << 16;

	/**
	 * Style constant for long date/time format (value is 1&lt;&lt;28).
	 * <p>
	 * A long date displays the day, month and year.
	 * A long time displays hours, minutes, and seconds.
	 * The day and month names may be displayed.
	 * <br>Note that this is a <em>HINT</em>.
	 * </p>
	 * <p><b>Used By:</b><ul>
	 * <li><code>DateTime</code></li>
	 * </ul></p>
	 * 
	 * @since 3.3
	 */
	public static const LONG:int= 1 << 28;

	/**
	 * Style constant specifying that a Browser should use a Mozilla GRE
	 * for rendering its content (value is 1&lt;&lt;15).
	 * <p>
	 * <p><b>Used By:</b><ul>
	 * <li><code>Browser</code></li>
	 * </ul></p>
	 * 
	 * @since 3.3
	 */
	public static const MOZILLA:int= 1 << 15;

	/**
	 * Style constant for balloon behavior (value is 1&lt;&lt;12).
	 * <p><b>Used By:</b><ul>
	 * <li><code>ToolTip</code></li>
	 * </ul></p>
	 *
	 * @since 3.2
	 */	
	public static const BALLOON:int= 1 << 12;
	
	/**
	 * Style constant for vertical alignment or orientation behavior (value is 1).
	 * <p><b>Used By:</b><ul>
	 * <li><code>GridLayout</code> type</li>
	 * </ul></p>
	 */
	public static const BEGINNING:int= 1;
	
	/**
	 * Style constant for vertical alignment or orientation behavior (value is 4).
	 * <p><b>Used By:</b><ul>
	 * <li><code>GridLayout</code> type</li>
	 * </ul></p>
	 */
	public static const FILL:int= 4;
	
	/**
	 * Input Method Editor style constant for double byte
	 * input behavior (value is 1&lt;&lt;1).
	 */
	public static const DBCS:int= 1 << 1;

	/**
	 * Input Method Editor style constant for alpha
	 * input behavior (value is 1&lt;&lt;2).
	 */
	public static const ALPHA:int= 1 << 2;

	/**
	 * Input Method Editor style constant for native
	 * input behavior (value is 1&lt;&lt;3).
	 */
	public static const NATIVE:int= 1 << 3;

	/**
	 * Input Method Editor style constant for phonetic
	 * input behavior (value is 1&lt;&lt;4).
	 */
	public static const PHONETIC:int= 1 << 4;

	/**
	 * Input Method Editor style constant for romanicized
	 * input behavior (value is 1&lt;&lt;5).
	 */
	public static const ROMAN:int= 1 << 5;

	/**
	 * ASCII character convenience constant for the backspace character
	 * (value is the <code>char</code> '\b').
	 */
	public static const  BS:int= 8;

	/**
	 * ASCII character convenience constant for the carriage return character
	 * (value is the <code>char</code> '\r').
	 */
	public static const CR:int= 13;

	/**
	 * ASCII character convenience constant for the delete character
	 * (value is the <code>char</code> with value 127).
	 */
	public static const DEL:int= 0x7F;
 
	/**
	 * ASCII character convenience constant for the escape character
	 * (value is the <code>char</code> with value 27).
	 */
	public static const ESC:int= 0x1B;

	/**
	 * ASCII character convenience constant for the line feed character
	 * (value is the <code>char</code> '\n').
	 */
	public static const LF:int= 10;

	/**
	 * ASCII character convenience constant for the tab character
	 * (value is the <code>char</code> '\t').
	 * 
	 * @since 2.1
	 */
	public static const TAB:int= 9;
						
	/**
	 * keyboard and/or mouse event mask indicating that the ALT key
	 * was pushed on the keyboard when the event was generated
	 * (value is 1&lt;&lt;16).
	 */
	public static const ALT:int= 1 << 16;
					
	/**
	 * Keyboard and/or mouse event mask indicating that the SHIFT key
	 * was pushed on the keyboard when the event was generated
	 * (value is 1&lt;&lt;17).
	 */
	public static const SHIFT:int= 1 << 17;
					
	/**
	 * Keyboard and/or mouse event mask indicating that the CTRL key
	 * was pushed on the keyboard when the event was generated
	 * (value is 1&lt;&lt;18).
	 */
	public static const CTRL:int= 1 << 18;

	/**
	 * Keyboard and/or mouse event mask indicating that the CTRL key
	 * was pushed on the keyboard when the event was generated. This
	 * is a synonym for CTRL (value is 1&lt;&lt;18).
	 */
	public static const CONTROL:int= CTRL;

	/**
	 * Keyboard and/or mouse event mask indicating that the COMMAND key
	 * was pushed on the keyboard when the event was generated
	 * (value is 1&lt;&lt;22).
	 * 
	 * @since 2.1
	 */
	public static const COMMAND:int= 1 << 22;
	
	/**
	 * Keyboard and/or mouse event mask indicating all possible
	 * keyboard modifiers.
	 * 
	 * To allow for the future, this mask  is intended to be used in 
	 * place of code that references  each individual keyboard mask. 
	 *  For example, the following expression will determine whether 
	 * any modifier is pressed and will continue to work as new modifier 
	 * masks are added.
	 * 
 	 * <code>(stateMask & SWT.MODIFIER_MASK) != 0</code>.
	 * 
	 * @since 2.1
	 */
	public static const MODIFIER_MASK;
	
	/**
	 * Keyboard and/or mouse event mask indicating that mouse button one
	 * was pushed when the event was generated. (value is 1&lt;&lt;19).
	 */
	public static const BUTTON1:int= 1 << 19;

	/**
	 * Keyboard and/or mouse event mask indicating that mouse button two
	 * was pushed when the event was generated. (value is 1&lt;&lt;20).
	 */
	public static const BUTTON2:int= 1 << 20;

	/**
	 * Keyboard and/or mouse event mask indicating that mouse button three
	 * was pushed when the event was generated. (value is 1&lt;&lt;21).
	 */
	public static const BUTTON3:int= 1 << 21;

	/**
	 * Keyboard and/or mouse event mask indicating that mouse button four
	 * was pushed when the event was generated. (value is 1&lt;&lt;23).
	 * 
	 * @since 3.1
	 */
	public static const BUTTON4:int= 1 << 23;

	/**
	 * Keyboard and/or mouse event mask indicating that mouse button five
	 * was pushed when the event was generated. (value is 1&lt;&lt;25).
	 * 
	 * @since 3.1
	 */
	public static const BUTTON5:int= 1 << 25;

	/**
	 * Keyboard and/or mouse event mask indicating all possible
	 * mouse buttons.
	 * 
	 * To allow for the future, this mask  is intended to be used 
	 * in place of code that references each individual button mask.  
	 * For example, the following expression will determine whether
	 * any button is pressed and will continue to work as new button 
	 * masks are added.
	 * 
 	 * <code>(stateMask & SWT.BUTTON_MASK) != 0</code>.
	 * 
	 * @since 2.1
	 */
	public static const BUTTON_MASK;
	
	/**
	 * Keyboard and/or mouse event mask indicating that the MOD1 key
	 * was pushed on the keyboard when the event was generated.
	 * 
	 * This is the primary keyboard modifier for the platform.
	 * 
	 * @since 2.1
	 */
	public static const MOD1;
	
	/**
	 * Keyboard and/or mouse event mask indicating that the MOD2 key
	 * was pushed on the keyboard when the event was generated.
	 * 
	 * This is the secondary keyboard modifier for the platform.
	 * 
	 * @since 2.1
	 */
	public static const MOD2;

	/**
	 * Keyboard and/or mouse event mask indicating that the MOD3 key
	 * was pushed on the keyboard when the event was generated.
	 * 
	 * @since 2.1
	 */
	public static const MOD3;

	/**
	 * Keyboard and/or mouse event mask indicating that the MOD4 key
	 * was pushed on the keyboard when the event was generated.
	 * 
	 * @since 2.1
	 */
	public static const MOD4;
	
	/**
	 * Constants to indicate line scrolling (value is 1).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code></li>
	 * </ul></p>
	 * 
	 * @since 3.1
	 */
	public static const SCROLL_LINE:int= 1;

	/**
	 * Constants to indicate page scrolling (value is 2).
	 * <p><b>Used By:</b><ul>
	 * <li><code>Control</code></li>
	 * </ul></p>
	 * 
	 * @since 3.1
	 */
	public static const SCROLL_PAGE:int= 2;
	
	/**
	 * Accelerator constant used to differentiate a key code from a
	 * unicode character.
	 * 
	 * If this bit is set, then the key stroke
	 * portion of an accelerator represents a key code.  If this bit
	 * is not set, then the key stroke portion of an accelerator is
	 * a unicode character.
	 * 
	 * The following expression is false:
	 * 
	 * <code>((SWT.MOD1 | SWT.MOD2 | 'T') & SWT.KEYCODE_BIT) != 0</code>.
	 * 
	 * The following expression is true:
	 * 
	 * <code>((SWT.MOD3 | SWT.F2) & SWT.KEYCODE_BIT) != 0</code>.
	 * 
	 * (value is (1&lt;&lt;24))
	 * 
	 * @since 2.1
	 */	
	public static const KEYCODE_BIT:int= (1 << 24);

	/**
	 * Accelerator constant used to extract the key stroke portion of
	 * an accelerator.
	 * 
	 * The key stroke may be a key code or a unicode
	 * value.  If the key stroke is a key code <code>KEYCODE_BIT</code>
	 * will be set.
	 * 
	 * @since 2.1
	 */	
	public static const KEY_MASK:int= KEYCODE_BIT + 0xFFFF;
	
	/**
	 * Keyboard event constant representing the UP ARROW key
	 * (value is (1&lt;&lt;24)+1).
	 */
	public static const ARROW_UP:int= KEYCODE_BIT + 1;

	/**
	 * Keyboard event constant representing the DOWN ARROW key
	 * (value is (1&lt;&lt;24)+2).
	 */
	public static const ARROW_DOWN:int= KEYCODE_BIT + 2;

	/**
	 * Keyboard event constant representing the LEFT ARROW key
	 * (value is (1&lt;&lt;24)+3).
	 */
	public static const ARROW_LEFT:int= KEYCODE_BIT + 3;

	/**
	 * Keyboard event constant representing the RIGHT ARROW key
	 * (value is (1&lt;&lt;24)+4).
	 */
	public static const ARROW_RIGHT:int= KEYCODE_BIT + 4;

	/**
	 * Keyboard event constant representing the PAGE UP key
	 * (value is (1&lt;&lt;24)+5).
	 */
	public static const PAGE_UP:int= KEYCODE_BIT + 5;

	/**
	 * Keyboard event constant representing the PAGE DOWN key
	 * (value is (1&lt;&lt;24)+6).
	 */
	public static const PAGE_DOWN:int= KEYCODE_BIT + 6;

	/**
	 * Keyboard event constant representing the HOME key
	 * (value is (1&lt;&lt;24)+7).
	 */
	public static const HOME:int= KEYCODE_BIT + 7;

	/**
	 * Keyboard event constant representing the END key
	 * (value is (1&lt;&lt;24)+8).
	 */
	public static const END:int= KEYCODE_BIT + 8;

	/**
	 * Keyboard event constant representing the INSERT key
	 * (value is (1&lt;&lt;24)+9).
	 */
	public static const INSERT:int= KEYCODE_BIT + 9;

	/**
	 * Keyboard event constant representing the F1 key
	 * (value is (1&lt;&lt;24)+10).
	 */
	public static const F1:int= KEYCODE_BIT + 10;
	
	/**
	 * Keyboard event constant representing the F2 key
	 * (value is (1&lt;&lt;24)+11).
	 */
	public static const F2:int= KEYCODE_BIT + 11;
	
	/**
	 * Keyboard event constant representing the F3 key
	 * (value is (1&lt;&lt;24)+12).
	 */
	public static const F3:int= KEYCODE_BIT + 12;
	
	/**
	 * Keyboard event constant representing the F4 key
	 * (value is (1&lt;&lt;24)+13).
	 */
	public static const F4:int= KEYCODE_BIT + 13;
	
	/**
	 * Keyboard event constant representing the F5 key
	 * (value is (1&lt;&lt;24)+14).
	 */
	public static const F5:int= KEYCODE_BIT + 14;
	
	/**
	 * Keyboard event constant representing the F6 key
	 * (value is (1&lt;&lt;24)+15).
	 */
	public static const F6:int= KEYCODE_BIT + 15;
	
	/**
	 * Keyboard event constant representing the F7 key
	 * (value is (1&lt;&lt;24)+16).
	 */
	public static const F7:int= KEYCODE_BIT + 16;
	
	/**
	 * Keyboard event constant representing the F8 key
	 * (value is (1&lt;&lt;24)+17).
	 */
	public static const F8:int= KEYCODE_BIT + 17;
	
	/**
	 * Keyboard event constant representing the F9 key
	 * (value is (1&lt;&lt;24)+18).
	 */
	public static const F9:int= KEYCODE_BIT + 18;
	
	/**
	 * Keyboard event constant representing the F10 key
	 * (value is (1&lt;&lt;24)+19).
	 */
	public static const F10:int= KEYCODE_BIT + 19;
	
	/**
	 * Keyboard event constant representing the F11 key
	 * (value is (1&lt;&lt;24)+20).
	 */
	public static const F11:int= KEYCODE_BIT + 20;
	
	/**
	 * Keyboard event constant representing the F12 key
	 * (value is (1&lt;&lt;24)+21).
	 */
	public static const F12:int= KEYCODE_BIT + 21;

	/**
	 * Keyboard event constant representing the F13 key
	 * (value is (1&lt;&lt;24)+22).
	 * 
	 * @since 3.0
	 */
	public static const F13:int= KEYCODE_BIT + 22;
	
	/**
	 * Keyboard event constant representing the F14 key
	 * (value is (1&lt;&lt;24)+23).
	 * 
	 * @since 3.0
	 */
	public static const F14:int= KEYCODE_BIT + 23;
	
	/**
	 * Keyboard event constant representing the F15 key
	 * (value is (1&lt;&lt;24)+24).
	 * 
	 * @since 3.0
	 */
	public static const F15:int= KEYCODE_BIT + 24;
	
	/**
	 * Keyboard event constant representing the numeric key
	 * pad multiply key (value is (1&lt;&lt;24)+42).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_MULTIPLY:int= KEYCODE_BIT + 42;
	
	/**
	 * Keyboard event constant representing the numeric key
	 * pad add key (value is (1&lt;&lt;24)+43).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_ADD:int= KEYCODE_BIT + 43;
	
	/**
	 * Keyboard event constant representing the numeric key
	 * pad subtract key (value is (1&lt;&lt;24)+45).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_SUBTRACT:int= KEYCODE_BIT + 45;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad decimal key (value is (1&lt;&lt;24)+46).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_DECIMAL:int= KEYCODE_BIT + 46;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad divide key (value is (1&lt;&lt;24)+47).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_DIVIDE:int= KEYCODE_BIT + 47;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad zero key (value is (1&lt;&lt;24)+48).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_0:int= KEYCODE_BIT + 48;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad one key (value is (1&lt;&lt;24)+49).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_1:int= KEYCODE_BIT + 49;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad two key (value is (1&lt;&lt;24)+50).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_2:int= KEYCODE_BIT + 50;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad three key (value is (1&lt;&lt;24)+51).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_3:int= KEYCODE_BIT + 51;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad four key (value is (1&lt;&lt;24)+52).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_4:int= KEYCODE_BIT + 52;
	
	/**
	 * Keyboard event constant representing the numeric key
	 * pad five key (value is (1&lt;&lt;24)+53).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_5:int= KEYCODE_BIT + 53;
	
	/**
	 * Keyboard event constant representing the numeric key
	 * pad six key (value is (1&lt;&lt;24)+54).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_6:int= KEYCODE_BIT + 54;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad seven key (value is (1&lt;&lt;24)+55).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_7:int= KEYCODE_BIT + 55;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad eight key (value is (1&lt;&lt;24)+56).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_8:int= KEYCODE_BIT + 56;
	
	/**
	 * Keyboard event constant representing the numeric key
	 * pad nine key (value is (1&lt;&lt;24)+57).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_9:int= KEYCODE_BIT + 57;

	/**
	 * Keyboard event constant representing the numeric key
	 * pad equal key (value is (1&lt;&lt;24)+61).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_EQUAL:int= KEYCODE_BIT + 61;
	
	/**
	 * Keyboard event constant representing the numeric key
	 * pad enter key (value is (1&lt;&lt;24)+80).
	 * 
	 * @since 3.0
	 */
	public static const KEYPAD_CR:int= KEYCODE_BIT + 80;
	
	/**
	 * Keyboard event constant representing the help
	 * key (value is (1&lt;&lt;24)+81).
	 * 
	 * NOTE: The HELP key maps to the key labeled "help",
	 * not "F1". If your keyboard does not have a HELP key,
	 * you will never see this key press.  To listen for
	 * help on a control, use SWT.Help.
	 * 
	 * @since 3.0
	 * 
	 * @see SWT#Help
	 */
	public static const HELP:int= KEYCODE_BIT + 81;
	
	/**
	 * Keyboard event constant representing the caps
	 * lock key (value is (1&lt;&lt;24)+82).
	 * 
	 * @since 3.0
	 */
	public static const CAPS_LOCK:int= KEYCODE_BIT + 82;
	
	/**
	 * Keyboard event constant representing the num
	 * lock key (value is (1&lt;&lt;24)+83).
	 * 
	 * @since 3.0
	 */
	public static const NUM_LOCK:int= KEYCODE_BIT + 83;
	
	/**
	 * Keyboard event constant representing the scroll
	 * lock key (value is (1&lt;&lt;24)+84).
	 * 
	 * @since 3.0
	 */
	public static const SCROLL_LOCK:int= KEYCODE_BIT + 84;
	
	/**
	 * Keyboard event constant representing the pause
	 * key (value is (1&lt;&lt;24)+85).
	 * 
	 * @since 3.0
	 */
	public static const PAUSE:int= KEYCODE_BIT + 85;
	
	/**
	 * Keyboard event constant representing the break
	 * key (value is (1&lt;&lt;24)+86).
	 * 
	 * @since 3.0
	 */
	public static const BREAK:int= KEYCODE_BIT + 86;
	
	/**
	 * Keyboard event constant representing the print screen
	 * key (value is (1&lt;&lt;24)+87).
	 * 
	 * @since 3.0
	 */
	public static const PRINT_SCREEN:int= KEYCODE_BIT + 87;
	
	/**
	 * The <code>MessageBox</code> style constant for error icon
	 * behavior (value is 1).
	 */
	public static const ICON_ERROR:int= 1;

	/**
	 * The <code>MessageBox</code> style constant for information icon
	 * behavior (value is 1&lt;&lt;1).
	 */
	public static const ICON_INFORMATION:int= 1 << 1;

	/**
	 * The <code>MessageBox</code> style constant for question icon
	 * behavior (value is 1&lt;&lt;2).
	 */
	public static const ICON_QUESTION:int= 1 << 2;

	/**
	 * The <code>MessageBox</code> style constant for warning icon
	 * behavior (value is 1&lt;&lt;3).
	 */
	public static const ICON_WARNING:int= 1 << 3;

	/**
	 * The <code>MessageBox</code> style constant for "working" icon
	 * behavior (value is 1&lt;&lt;4).
	 */
	public static const ICON_WORKING:int= 1 << 4;

	/**
	 * The <code>MessageBox</code> style constant for an OK button;
	 * valid combinations are OK, OK|CANCEL
	 * (value is 1&lt;&lt;5).
	 */
	public static const OK:int= 1 << 5;

	/**
	 * The <code>MessageBox</code> style constant for YES button;
	 * valid combinations are YES|NO, YES|NO|CANCEL
	 * (value is 1&lt;&lt;6).
	 */
	public static const YES:int= 1 << 6;

	/**
	 * The <code>MessageBox</code> style constant for NO button;
	 * valid combinations are YES|NO, YES|NO|CANCEL
	 * (value is 1&lt;&lt;7).
	 */
	public static const NO:int= 1 << 7;

	/**
	 * The <code>MessageBox</code> style constant for a CANCEL button;
	 * valid combinations are OK|CANCEL, YES|NO|CANCEL, RETRY|CANCEL
	 * (value is 1&lt;&lt;8).  This style constant is also used with 
	 * <code>Text</code> in combination with SEARCH.
	 * 
	 * <p><b>Used By:</b><ul>
	 * <li><code>MessageBox</code></li>
	 * <li><code>Text</code></li>
	 * </ul></p>
	 */
	public static const CANCEL:int= 1 << 8;

	/**
	 * The <code>MessageBox</code> style constant for an ABORT button;
	 * the only valid combination is ABORT|RETRY|IGNORE
	 * (value is 1&lt;&lt;9).
	 */
	public static const ABORT:int= 1 << 9;

	/**
	 * The <code>MessageBox</code> style constant for a RETRY button;
	 *  valid combinations are ABORT|RETRY|IGNORE, RETRY|CANCEL
	 * (value is 1&lt;&lt;10).
	 */
	public static const RETRY:int= 1 << 10;

	/**
	 * The <code>MessageBox</code> style constant for an IGNORE button;
	 * the only valid combination is ABORT|RETRY|IGNORE
	 * (value is 1&lt;&lt;11).
	 */
	public static const	IGNORE:int= 1 << 11;

	/**
	 * The <code>FileDialog</code> style constant for open file dialog behavior
	 * (value is 1&lt;&lt;12).
	 */
	public static const OPEN:int= 1 << 12;

	/**
	 * The <code>FileDialog</code> style constant for save file dialog behavior
	 * (value is 1&lt;&lt;13).
	 */
	public static const SAVE:int= 1 << 13;

	/**
	 * The <code>Composite</code> constant to indicate that
	 * an attribute (such as background) is not inherited
	 * by the children (value is 0).
	 *
	 * @since 3.2
	 */
	public static const INHERIT_NONE:int= 0;
	
	/**
	 * The <code>Composite</code> constant to indicate that
	 * an attribute (such as background) is inherited by
	 * children who choose this value as their "default"
	 * (value is 1).  For example, a label child will
	 * typically choose to inherit the background color
	 * of a composite while a list or table will not.
	 *
	 * @since 3.2
	 */
	public static const INHERIT_DEFAULT:int= 1;
	
	/**
	 * The <code>Composite</code> constant to indicate that
	 * an attribute (such as background) is inherited by
	 * all children.
	 *
	 * @since 3.2
	 */
	public static const INHERIT_FORCE:int= 2;
	
	/**
	 * Default color white (value is 1).
	 */
	public static const COLOR_WHITE:int= 1;

	/**
	 * Default color black (value is 2).
	 */
	public static const COLOR_BLACK:int= 2;

	/**
	 * Default color red (value is 3).
	 */
	public static const COLOR_RED:int= 3;

	/**
	 * Default color dark red (value is 4).
	 */
	public static const COLOR_DARK_RED:int= 4;

	/**
	 * Default color green (value is 5).
	 */
	public static const COLOR_GREEN:int= 5;

	/**
	 * Default color dark green (value is 6).
	 */
	public static const COLOR_DARK_GREEN:int= 6;

	/**
	 * Default color yellow (value is 7).
	 */
	public static const COLOR_YELLOW:int= 7;

	/**
	 * Default color dark yellow (value is 8).
	 */
	public static const COLOR_DARK_YELLOW:int= 8;

	/**
	 * Default color blue (value is 9).
	 */
	public static const COLOR_BLUE:int= 9;

	/**
	 * Default color dark blue (value is 10).
	 */
	public static const COLOR_DARK_BLUE:int= 10;

	/**
	 * Default color magenta (value is 11).
	 */
	public static const COLOR_MAGENTA:int= 11;

	/**
	 * Default color dark magenta (value is 12).
	 */
	public static const COLOR_DARK_MAGENTA:int= 12;

	/**
	 * Default color cyan (value is 13).
	 */
	public static const COLOR_CYAN:int= 13;

	/**
	 * Default color dark cyan (value is 14).
	 */
	public static const COLOR_DARK_CYAN:int= 14;

	/**
	 * Default color gray (value is 15).
	 */
	public static const COLOR_GRAY:int= 15;

	/**
	 * Default color dark gray (value is 16).
	 */
	public static const COLOR_DARK_GRAY:int= 16;
	
	/*
	 * System Colors
	 *
	 * Dealing with system colors is an area where there are
	 * many platform differences.  On some platforms, system
	 * colors can change dynamically while the program is
	 * running.  On other platforms, system colors can be
	 * changed for all instances of a particular widget.
	 * Therefore, the only truly portable method to obtain
	 * a widget color query is to query the color from an
	 * instance of the widget.
	 *
	 *	It is expected that the list of supported colors
	 * will grow over time.
	 */
	
	/**
	 * System color used to paint dark shadow areas (value is 17).
	 */
	public static const COLOR_WIDGET_DARK_SHADOW:int= 17;

	/**
	 * System color used to paint normal shadow areas (value is 18).
	 */
	public static const COLOR_WIDGET_NORMAL_SHADOW:int= 18;

	/**
	 * System color used to paint light shadow areas (value is 19).
	 */
	public static const COLOR_WIDGET_LIGHT_SHADOW:int= 19;

	/**
	 * System color used to paint highlight shadow areas (value is 20).
	 */
	public static const COLOR_WIDGET_HIGHLIGHT_SHADOW:int= 20;

	/**
	 * System color used to paint foreground areas (value is 21).
	 */
	public static const COLOR_WIDGET_FOREGROUND:int= 21;

	/**
	 * System color used to paint background areas (value is 22).
	 */
	public static const COLOR_WIDGET_BACKGROUND:int= 22;

	/**
	 * System color used to paint border areas (value is 23).
	 */
	public static const COLOR_WIDGET_BORDER:int= 23;

	/**
	 * System color used to paint list foreground areas (value is 24).
	 */
	public static const COLOR_LIST_FOREGROUND:int= 24;

	/**
	 * System color used to paint list background areas (value is 25).
	 */
	public static const COLOR_LIST_BACKGROUND:int= 25;

	/**
	 * System color used to paint list selection background areas (value is 26).
	 */
	public static const COLOR_LIST_SELECTION:int= 26;

	/**
	 * System color used to paint list selected text (value is 27).
	 */
	public static const COLOR_LIST_SELECTION_TEXT:int= 27;

	/**
	 * System color used to paint tooltip text (value is 28).
	 */
	public static const COLOR_INFO_FOREGROUND:int= 28;

	/**
	 * System color used to paint tooltip background areas (value is 29).
	 */
	public static const COLOR_INFO_BACKGROUND:int= 29;
	
	/**
	 * System color used to paint title text (value is 30).
	 */
	public static const COLOR_TITLE_FOREGROUND:int= 30;

	/**
	 * System color used to paint title background areas (value is 31).
	 */
	public static const COLOR_TITLE_BACKGROUND:int= 31;

	/**
	 * System color used to paint title background gradient (value is 32).
	 */
	public static const COLOR_TITLE_BACKGROUND_GRADIENT:int= 32;
	
	/**
	 * System color used to paint inactive title text (value is 33).
	 */
	public static const COLOR_TITLE_INACTIVE_FOREGROUND:int= 33;

	/**
	 * System color used to paint inactive title background areas (value is 34).
	 */
	public static const COLOR_TITLE_INACTIVE_BACKGROUND:int= 34;

	/**
	 * System color used to paint inactive title background gradient (value is 35).
	 */
	public static const COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT:int= 35;
	
	/**
	 * Draw constant indicating whether the drawing operation
	 * should fill the background (value is 1&lt;&lt;0).
	 */
	public static const DRAW_TRANSPARENT:int= 1 << 0;

	/**
	 * Draw constant indicating whether the string drawing operation
	 * should handle line-delimiters (value is 1&lt;&lt;1).
	 */
	public static const DRAW_DELIMITER:int= 1 << 1;

	/**
	 * Draw constant indicating whether the string drawing operation
	 * should expand TAB characters (value is 1&lt;&lt;2).
	 */
	public static const DRAW_TAB:int= 1 << 2;

	/**
	 * Draw constant indicating whether the string drawing operation
	 * should handle mnemonics (value is 1&lt;&lt;3).
	 */
	public static const DRAW_MNEMONIC:int= 1 << 3;	

	
	/**
	 * Selection constant indicating that a line delimiter should be 
	 * drawn (value is 1&lt;&lt;17).
	 * 
	 * <p><b>Used By:</b><ul>
	 * <li><code>TextLayout</code></li>
	 * </ul></p>
	 *
	 * @see #FULL_SELECTION
	 * @see #LAST_LINE_SELECTION
	 * 
	 * @since 3.3
	 */
	public static const DELIMITER_SELECTION:int= 1 << 17;
	
	/**
	 * Selection constant indicating that the last line is selected
	 * to the end and should be drawn using either a line delimiter 
	 * or full line selection (value is 1&lt;&lt;20).
	 * 
	 * <p><b>Used By:</b><ul>
	 * <li><code>TextLayout</code></li>
	 * </ul></p>
	 * 
	 * @see #DELIMITER_SELECTION
	 * @see #FULL_SELECTION
	 * 
	 * @since 3.3
	 */
	public static const LAST_LINE_SELECTION:int= 1 << 20;
	
	/** 
	 * SWT error constant indicating that no error number was specified
	 * (value is 1).
	 */
	public static const ERROR_UNSPECIFIED:int= 1;
	
	/** 
	 * SWT error constant indicating that no more handles for an
	 * operating system resource are available
	 * (value is 2).
	 */
	public static const ERROR_NO_HANDLES:int= 2;
	
	/** 
	 * SWT error constant indicating that no more callback resources are available
	 * (value is 3).
	 */
	public static const ERROR_NO_MORE_CALLBACKS:int= 3;
	
	/** 
	 * SWT error constant indicating that a null argument was passed in
	 * (value is 4). 
	 */
	public static const ERROR_NULL_ARGUMENT:int= 4;
	
	/** 
	 * SWT error constant indicating that an invalid argument was passed in
	 * (value is 5).
	 */
	public static const ERROR_INVALID_ARGUMENT:int= 5;
	
	/** 
	 * SWT error constant indicating that a value was found to be
	 * outside the allowable range
	 * (value is 6).
	 */
	public static const ERROR_INVALID_RANGE:int= 6;
	
	/** 
	 * SWT error constant indicating that a value which can not be 
	 * zero was found to be
	 * (value is 7).
	 */
	public static const ERROR_CANNOT_BE_ZERO:int= 7;
	
	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to provide the value of an item
	 * (value is 8).
	 */
	public static const ERROR_CANNOT_GET_ITEM:int= 8;
	
	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to provide the selection
	 * (value is 9).
	 */
	public static const ERROR_CANNOT_GET_SELECTION:int= 9;

	/** 
	 * SWT error constant indicating that the matrix is not invertible
	 * (value is 10).
	 * 
	 * @since 3.1
	 */
	public static const ERROR_CANNOT_INVERT_MATRIX:int= 10;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to provide the height of an item
	 * (value is 11).
	 */
	public static const ERROR_CANNOT_GET_ITEM_HEIGHT:int= 11;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to provide the text of a widget
	 * (value is 12).
	 */
	public static const ERROR_CANNOT_GET_TEXT:int= 12;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to set the text of a widget
	 * (value is 13).
	 */
	public static const ERROR_CANNOT_SET_TEXT:int= 13;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to add an item
	 * (value is 14).
	 */
	public static const ERROR_ITEM_NOT_ADDED:int= 14;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to remove an item
	 * (value is 15).
	 */
	public static const ERROR_ITEM_NOT_REMOVED:int= 15;

	/** 
	 * SWT error constant indicating that the graphics library
	 * is not available
	 * (value is 16).
	 */
	public static const ERROR_NO_GRAPHICS_LIBRARY:int= 16;

	/** 
	 * SWT error constant indicating that a particular feature has
	 * not been implemented on this platform
	 * (value is 20).
	 */
	public static const ERROR_NOT_IMPLEMENTED:int= 20;

	/** 
	 * SWT error constant indicating that a menu which needed
	 * to have the drop down style had some other style instead
	 * (value is 21).
	 */
	public static const ERROR_MENU_NOT_DROP_DOWN:int= 21;

	/** 
	 * SWT error constant indicating that an attempt was made to
	 * invoke an SWT operation which can only be executed by the
	 * user-interface thread from some other thread
	 * (value is 22).
	 */
	public static const ERROR_THREAD_INVALID_ACCESS:int= 22;

	/** 
	 * SWT error constant indicating that an attempt was made to
	 * invoke an SWT operation using a widget which had already
	 * been disposed
	 * (value is 24). 
	 */
	public static const ERROR_WIDGET_DISPOSED:int= 24;

	/** 
	 * SWT error constant indicating that a menu item which needed
	 * to have the cascade style had some other style instead
	 * (value is 27).
	 */
	public static const ERROR_MENUITEM_NOT_CASCADE:int= 27;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to set the selection of a widget
	 * (value is 28).
	 */
	public static const ERROR_CANNOT_SET_SELECTION:int= 28;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to set the menu
	 * (value is 29).
	 */
	public static const ERROR_CANNOT_SET_MENU:int= 29;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to set the enabled state
	 * (value is 30).
	 */
	public static const ERROR_CANNOT_SET_ENABLED:int= 30;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to provide enabled/disabled state information
	 * (value is 31).
	 */
	public static const ERROR_CANNOT_GET_ENABLED:int= 31;

	/** 
	 * SWT error constant indicating that a provided widget can
	 * not be used as a parent in the current operation
	 * (value is 32).
	 */
	public static const ERROR_INVALID_PARENT:int= 32;
	
	/** 
	 * SWT error constant indicating that a menu which needed
	 * to have the menu bar style had some other style instead
	 * (value is 33).
	 */
	public static const ERROR_MENU_NOT_BAR:int= 33;

	/** 
	 * SWT error constant indicating that the underlying operating
	 * system was unable to provide count information
	 * (value is 36).
	 */
	public static const ERROR_CANNOT_GET_COUNT:int= 36;

	/** 
	 * SWT error constant indicating that a menu which needed
	 * to have the pop up menu style had some other style instead
	 * (value is 37).
	 */
	public static const ERROR_MENU_NOT_POP_UP:int= 37;

	/** 
	 * SWT error constant indicating that a graphics operation
	 * was attempted with an image of an unsupported depth
	 * (value is 38).
	 */
	public static const ERROR_UNSUPPORTED_DEPTH:int= 38;

	/** 
	 * SWT error constant indicating that an input/output operation
	 * failed during the execution of an SWT operation
	 * (value is 39).
	 */
	public static const ERROR_IO:int= 39;

	/** 
	 * SWT error constant indicating that a graphics operation
	 * was attempted with an image having an invalid format
	 * (value is 40).
	 */
	public static const ERROR_INVALID_IMAGE:int= 40;

	/** 
	 * SWT error constant indicating that a graphics operation
	 * was attempted with an image having a valid but unsupported
	 * format
	 * (value is 42).
	 */
	public static const ERROR_UNSUPPORTED_FORMAT:int= 42;

	/** 
	 * SWT error constant indicating that an attempt was made
	 * to subclass an SWT widget class without implementing the
	 * <code>checkSubclass()</code> method
	 * (value is 43).
	 * 
	 * For additional information see the comment in 
	 * <code>Widget.checkSubclass()</code>.
	 *
	 * @see org.eclipse.swt.widgets.Widget#checkSubclass
	 */
	public static const ERROR_INVALID_SUBCLASS:int= 43;

	/** 
	 * SWT error constant indicating that an attempt was made to
	 * invoke an SWT operation using a graphics object which had
	 * already been disposed
	 * (value is 44).
	 */
	public static const ERROR_GRAPHIC_DISPOSED:int= 44;
	
	/** 
	 * SWT error constant indicating that an attempt was made to
	 * invoke an SWT operation using a device which had already
	 * been disposed
	 * (value is 45). 
	 */
	public static const ERROR_DEVICE_DISPOSED:int= 45;
	
	/** 
	 * SWT error constant indicating that an exception happened
	 * when executing a runnable
	 * (value is 46).
	 */
	public static const ERROR_FAILED_EXEC:int= 46;
	
	/** 
	 * SWT error constant indicating that an unsatisfied link
	 * error occurred while attempting to load a library
	 * (value is 47).
	 * 
	 * @since 3.1
	 */
	public static const ERROR_FAILED_LOAD_LIBRARY:int= 47;

	/** 
	 * SWT error constant indicating that a font is not valid
	 * (value is 48).
	 * 
	 * @since 3.1
	 */
	public static const ERROR_INVALID_FONT:int= 48;

	/**
	 * Constant indicating that an image or operation is of type bitmap  (value is 0).
	 */	
	public static const BITMAP:int= 0;

	/**
	 * Constant indicating that an image or operation is of type icon  (value is 1).
	 */	
	public static const ICON:int= 1;

	/**
	 * The <code>Image</code> constructor argument indicating that
	 * the new image should be a copy of the image provided as
	 * an argument  (value is 0).
	 */	
	public static const IMAGE_COPY:int= 0;

	/**
	 * The <code>Image</code> constructor argument indicating that
	 * the new image should have the appearance of a "disabled"
	 * (using the platform's rules for how this should look)
	 * copy of the image provided as an argument  (value is 1).
	 */	
	public static const IMAGE_DISABLE:int= 1;
	
	/**
	 * The <code>Image</code> constructor argument indicating that
	 * the new image should have the appearance of a "gray scaled"
	 * copy of the image provided as an argument  (value is 2).
	 */	
	public static const IMAGE_GRAY:int= 2;
	
	/**
	 * The font style constant indicating a normal weight, non-italic font
	 * (value is 0).
	 */
	public static const NORMAL:int= 0;
	
	/**
	 * The font style constant indicating a bold weight font
	 * (value is 1&lt;&lt;0).
	 */
	public static const BOLD:int= 1 << 0;
	
	/**
	 * The font style constant indicating an italic font
	 * (value is 1&lt;&lt;1).
	 */
	public static const ITALIC:int= 1 << 1;
		
	/**
	 * System arrow cursor  (value is 0).
	 */
	public static const CURSOR_ARROW:int= 0;
		
	/**
	 * System wait cursor  (value is 1).
	 */
	public static const CURSOR_WAIT:int= 1;
		
	/**
	 * System cross hair cursor  (value is 2).
	 */
	public static const CURSOR_CROSS:int= 2;
		
	/**
	 * System app startup cursor  (value is 3).
	 */
	public static const CURSOR_APPSTARTING:int= 3;
		
	/**
	 * System help cursor  (value is 4).
	 */
	public static const CURSOR_HELP:int= 4;
		
	/**
	 * System resize all directions cursor (value is 5).
	 */
	public static const CURSOR_SIZEALL:int= 5;
		
	/**
	 * System resize north-east-south-west cursor  (value is 6).
	 */
	public static const CURSOR_SIZENESW:int= 6;
		
	/**
	 * System resize north-south cursor  (value is 7).
	 */
	public static const CURSOR_SIZENS:int= 7;
		
	/**
	 * System resize north-west-south-east cursor  (value is 8).
	 */
	public static const CURSOR_SIZENWSE:int= 8;
		
	/**
	 * System resize west-east cursor  (value is 9).
	 */
	public static const CURSOR_SIZEWE:int= 9;
		
	/**
	 * System resize north cursor  (value is 10).
	 */
	public static const CURSOR_SIZEN:int= 10;
		
	/**
	 * System resize south cursor  (value is 11).
	 */
	public static const CURSOR_SIZES:int= 11;
		
	/**
	 * System resize east cursor  (value is 12).
	 */
	public static const CURSOR_SIZEE:int= 12;
		
	/**
	 * System resize west cursor  (value is 13).
	 */
	public static const CURSOR_SIZEW:int= 13;
		
	/**
	 * System resize north-east cursor (value is 14).
	 */
	public static const CURSOR_SIZENE:int= 14;
		
	/**
	 * System resize south-east cursor (value is 15).
	 */
	public static const CURSOR_SIZESE:int= 15;
		
	/**
	 * System resize south-west cursor (value is 16).
	 */
	public static const CURSOR_SIZESW:int= 16;
		
	/**
	 * System resize north-west cursor (value is 17).
	 */
	public static const CURSOR_SIZENW:int= 17;
		
	/**
	 * System up arrow cursor  (value is 18).
	 */
	public static const CURSOR_UPARROW:int= 18;
		
	/**
	 * System i-beam cursor (value is 19).
	 */
	public static const CURSOR_IBEAM:int= 19;
		
	/**
	 * System "not allowed" cursor (value is 20).
	 */
	public static const CURSOR_NO:int= 20;
		
	/**
	 * System hand cursor (value is 21).
	 */
	public static const CURSOR_HAND:int= 21;
		
	/**
	 * Line drawing style for flat end caps (value is 1).
	 * 
	 * @see org.eclipse.swt.graphics.GC#setLineCap(int)
	 * @see org.eclipse.swt.graphics.GC#getLineCap()
	 * 
	 * @since 3.1
	 */
	public static const CAP_FLAT:int= 1;

	/**
	 * Line drawing style for rounded end caps (value is 2).
	 * 
	 * @see org.eclipse.swt.graphics.GC#setLineCap(int)
	 * @see org.eclipse.swt.graphics.GC#getLineCap()
	 * 
	 * @since 3.1
	 */
	public static const CAP_ROUND:int= 2;

	/**
	 * Line drawing style for square end caps (value is 3).
	 * 
	 * @see org.eclipse.swt.graphics.GC#setLineCap(int)
	 * @see org.eclipse.swt.graphics.GC#getLineCap()
	 * 
	 * @since 3.1
	 */
	public static const CAP_SQUARE:int= 3;

	/**
	 * Line drawing style for miter joins (value is 1).
	 * 
	 * @see org.eclipse.swt.graphics.GC#setLineJoin(int)
	 * @see org.eclipse.swt.graphics.GC#getLineJoin()
	 * 
	 * @since 3.1
	 */
	public static const JOIN_MITER:int= 1;

	/**
	 * Line drawing  style for rounded joins (value is 2).
	 * 
	 * @see org.eclipse.swt.graphics.GC#setLineJoin(int)
	 * @see org.eclipse.swt.graphics.GC#getLineJoin()
	 * 
	 * @since 3.1
	 */
	public static const JOIN_ROUND:int= 2;

	/**
	 * Line drawing style for bevel joins (value is 3).
	 * 
	 * @see org.eclipse.swt.graphics.GC#setLineJoin(int)
	 * @see org.eclipse.swt.graphics.GC#getLineJoin()
	 * 
	 * @since 3.1
	 */
	public static const JOIN_BEVEL:int= 3;

	/**
	 * Line drawing style for solid lines  (value is 1).
	 */
	public static const LINE_SOLID:int= 1;
		
	/**
	 * Line drawing style for dashed lines (value is 2).
	 */
	public static const LINE_DASH:int= 2;
		
	/**
	 * Line drawing style for dotted lines (value is 3).
	 */
	public static const LINE_DOT:int= 3;
		
	/**
	 * Line drawing style for alternating dash-dot lines (value is 4).
	 */
	public static const LINE_DASHDOT:int= 4;
		
	/**
	 * Line drawing style for dash-dot-dot lines (value is 5).
	 */
	public static const LINE_DASHDOTDOT:int= 5;

	/**
	 * Line drawing style for custom dashed lines (value is 6).
	 * 
	 * @see org.eclipse.swt.graphics.GC#setLineDash(int[])
	 * @see org.eclipse.swt.graphics.GC#getLineDash()
	 * 
	 * @since 3.1
	 */
	public static const LINE_CUSTOM:int= 6;
	
	/**
	 * Path constant that represents a "move to" operation (value is 1).
	 * 
	 * @since 3.1
	 */
	public static const PATH_MOVE_TO:int= 1;

	/**
	 * Path constant that represents a "line to" operation (value is 2).
	 * 
	 * @since 3.1
	 */
	public static const PATH_LINE_TO:int= 2;

	/**
	 * Path constant that represents a "quadratic curve to" operation (value is 3).
	 * 
	 * @since 3.1
	 */
	public static const PATH_QUAD_TO:int= 3;

	/**
	 * Path constant that represents a "cubic curve to" operation (value is 4).
	 * 
	 * @since 3.1
	 */
	public static const PATH_CUBIC_TO:int= 4;

	/**
	 * Path constant that represents a "close" operation (value is 5).
	 * 
	 * @since 3.1
	 */
	public static const PATH_CLOSE:int= 5;

	/**
	 * Even odd rule for filling operations (value is 1).
	 * 
	 * @since 3.1
	 */
	public static const FILL_EVEN_ODD:int= 1;

	/**
	 * Winding rule for filling operations (value is 2).
	 * 
	 * @since 3.1
	 */
	public static const FILL_WINDING:int= 2;

	/**
	 * Image format constant indicating an unknown image type (value is -1).
	 */
	public static const IMAGE_UNDEFINED:int= -1;

	/**
	 * Image format constant indicating a Windows BMP format image (value is 0).
	 */
	public static const IMAGE_BMP:int= 0;

	/**
	 * Image format constant indicating a run-length encoded 
	 * Windows BMP format image (value is 1).
	 */
	public static const IMAGE_BMP_RLE:int= 1;

	/**
	 * Image format constant indicating a GIF format image (value is 2).
	 */
	public static const IMAGE_GIF:int= 2;

	/**
	 * Image format constant indicating a ICO format image (value is 3).
	 */
	public static const IMAGE_ICO:int= 3;

	/**
	 * Image format constant indicating a JPEG format image (value is 4).
	 */
	public static const IMAGE_JPEG:int= 4;

	/**
	 * Image format constant indicating a PNG format image (value is 5).
	 */
	public static const IMAGE_PNG:int= 5;

	/**
	 * Image format constant indicating a TIFF format image (value is 6).
	 */
	public static const IMAGE_TIFF:int= 6;

	/**
	 * Image format constant indicating an OS/2 BMP format image (value is 7).
	 */
	public static const IMAGE_OS2_BMP:int= 7;

	/**
	 * GIF image disposal method constants indicating that the
	 * disposal method is unspecified (value is 0).
	 */
	public static const DM_UNSPECIFIED:int= 0x0;

	/**
	 * GIF image disposal method constants indicating that the
	 * disposal method is to do nothing; that is, to leave the 
	 * previous image in place (value is 1).
	 */
	public static const DM_FILL_NONE:int= 0x1;

	/**
	 * GIF image disposal method constants indicating that the
	 * the previous images should be covered with the background
	 * color before displaying the next image (value is 2).
	 */
	public static const DM_FILL_BACKGROUND:int= 0x2;

	/**
	 * GIF image disposal method constants indicating that the
	 * disposal method is to restore the previous picture
	 * (value is 3).
	 */
	public static const DM_FILL_PREVIOUS:int= 0x3;
	
	/**
	 * Image transparency constant indicating that the image
	 * contains no transparency information (value is 0).
	 */
	public static const TRANSPARENCY_NONE:int= 0x0;
	
	/**
	 * Image transparency constant indicating that the image
	 * contains alpha transparency information (value is 1&lt;&lt;0).
	 */
	public static const TRANSPARENCY_ALPHA:int= 1 << 0;
	
	/**
	 * Image transparency constant indicating that the image
	 * contains a transparency mask (value is 1&lt;&lt;1).
	 */
	public static const TRANSPARENCY_MASK:int= 1 << 1;
	
	/**
	 * Image transparency constant indicating that the image
	 * contains a transparent pixel (value is 1&lt;&lt;2).
	 */
	public static const TRANSPARENCY_PIXEL:int= 1 << 2;

	/**
	 * The character movement type (value is 1&lt;&lt;0).
	 * This constant is used to move a text offset over a character.
	 * 
	 * @see org.eclipse.swt.graphics.TextLayout#getNextOffset(int, int)
	 * @see org.eclipse.swt.graphics.TextLayout#getPreviousOffset(int, int)
	 * 
	 * @since 3.0
	 */	
	public static const MOVEMENT_CHAR:int= 1 << 0;

	/**
	 * The cluster movement type (value is 1&lt;&lt;1).
	 * This constant is used to move a text offset over a cluster.
	 * A cluster groups one or more characters. A cluster is 
	 * undivisible, this means that a caret offset can not be placed in the
	 * middle of a cluster.  
	 * 
	 * @see org.eclipse.swt.graphics.TextLayout#getNextOffset(int, int)
	 * @see org.eclipse.swt.graphics.TextLayout#getPreviousOffset(int, int)
	 * 
	 * @since 3.0
	 */
	public static const MOVEMENT_CLUSTER:int= 1 << 1;

	/**
	 * The word movement type (value is 1&lt;&lt;2).
	 * This constant is used to move a text offset over a word.
	 * The behavior of this constant depends on the platform and on the 
	 * direction of the movement. For example, on Windows the stop is 
	 * always at the start of the word. On GTK and Mac the stop is at the end 
	 * of the word if the direction is next and at the start of the word if the 
	 * direction is previous.
	 * 
	 * @see org.eclipse.swt.graphics.TextLayout#getNextOffset(int, int)
	 * @see org.eclipse.swt.graphics.TextLayout#getPreviousOffset(int, int)
	 * 
	 * @since 3.0
	 */	
	public static const MOVEMENT_WORD:int= 1 << 2;

	/**
	 * The word end movement type (value is 1&lt;&lt;3).
	 * This constant is used to move a text offset to the next or previous
	 * word end. The behavior of this constant does not depend on the platform.  
	 * 
	 * 
	 * @see org.eclipse.swt.graphics.TextLayout#getNextOffset(int, int)
	 * @see org.eclipse.swt.graphics.TextLayout#getPreviousOffset(int, int)
	 * 
	 * @since 3.3
	 */	
	public static const MOVEMENT_WORD_END:int= 1 << 3;
	/**
	 * The word start movement type (value is 1&lt;&lt;4).
	 * This constant is used to move a text offset to the next or previous
	 * word start. The behavior of this constant does not depend on the platform.  
	 * 
	 * @see org.eclipse.swt.graphics.TextLayout#getNextOffset(int, int)
	 * @see org.eclipse.swt.graphics.TextLayout#getPreviousOffset(int, int)
	 * 
	 * @since 3.3
	 */	
	public static const MOVEMENT_WORD_START:int= 1 << 4;

}

}