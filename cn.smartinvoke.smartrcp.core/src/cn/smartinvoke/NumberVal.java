package cn.smartinvoke;

 class NumberVal {
public int  value;
	
	public NumberVal (int  value) {
		this.value = value;
	}
	public boolean equals (Object object) {
		if (object == this) return true;
		if (!(object instanceof NumberVal)) return false;
		NumberVal obj = (NumberVal)object;
		return obj.value == this.value;
	}

	public int hashCode () {
		return (int)value;
	}

}
