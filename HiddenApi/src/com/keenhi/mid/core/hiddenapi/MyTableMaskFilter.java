package com.keenhi.mid.core.hiddenapi;

import android.graphics.MaskFilter;
import android.graphics.TableMaskFilter;

public class MyTableMaskFilter extends TableMaskFilter {

	public MyTableMaskFilter(byte[] table) {
		super(table);
		// TODO Auto-generated constructor stub
	}
	
	public static MaskFilter Hidden_CreateClipTable(int min, int max){
		return CreateClipTable(min, max);
	}

}
