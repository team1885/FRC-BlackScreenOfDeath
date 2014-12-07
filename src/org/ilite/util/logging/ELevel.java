package org.ilite.util.logging;

import java.awt.Color;

public enum ELevel {
	DEBUG(Color.black),
	INFO(Color.black),
	WARN(Color.orange),
	ERROR(Color.red);
	
	public Color color(){ return mColor; }
	private Color mColor;
	private ELevel(Color pColor)
	{
		mColor = pColor;
	}
}
